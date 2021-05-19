/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm.model;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ViewModel 
{
  private ArrayList<Figur> figures;
  private Figur figur;
  
  public ViewModel()
  {
    figures = new ArrayList<>();
    figur = new Figur();
    figures.add(figur);
  }
  
  public void addPoint(Point p)
  {
    figur.addPoint(p);
  }
  
  public Point getPoint()
  {
    return figur.getlP();
  }
  
  public void setPoint(Point p)
  {
    figur.setlP(p);
  }
  
  public void addFigure()
  {
    figur = new Figur();
    figures.add(figur);
  }
  
  public Figur getFigure()
  {
    return figur;
  }
  
  public List<Figur> getFigures()
  {
    return Collections.unmodifiableList(figures);
  }
  
  
  public void savePoints(String filename) throws FileNotFoundException, IOException
  {
    FileOutputStream fos = new FileOutputStream(filename);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(figures);
    oos.flush();
    oos.close();
  }
  
  public void loadPoints(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
  {
    FileInputStream fis = new FileInputStream(filename);
    BufferedInputStream bis = new BufferedInputStream(fis);
    ObjectInputStream ois = new ObjectInputStream(bis);
    Object obj = ois.readObject();
    if(obj instanceof ArrayList)
    {
      figures = (ArrayList<Figur>)obj;
    }
    ois.close();
  }
}
