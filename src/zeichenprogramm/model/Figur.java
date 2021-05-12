/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Christian
 */
public class Figur implements Serializable
{
  private ArrayList<Point> points;
  
  public Figur()
  {
    points = new ArrayList<>();
  }
    
  public void addPoint(Point p)
  {
    points.add(p);
  }
  
  public List<Point> getPoints()
  {
    return Collections.unmodifiableList(points);
  }
  
  public Point getLastPoint()
  {
    if(points.size() >= 2)
    {
      return points.get(points.size()-2);
    }
    else
    {
      return points.get(0);
    }
  }
}
