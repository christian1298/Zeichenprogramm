/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import zeichenprogramm.model.ViewModel;
import zeichenprogramm.view.Ansicht;
import zeichenprogramm.view.View;

/**
 *
 * @author Christian
 */
public class ViewController extends MouseAdapter implements MouseMotionListener, ActionListener
{
  private View view;
  private ViewModel model;
  private Ansicht window;
  
  public ViewController(View view, ViewModel model, Ansicht window)
  {
    this.view = view;
    this.model = model;
    this.window = window;
  }
  
  public void registerEvents()
  {
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
    
    window.getBtnLoad().addActionListener(this);
    window.getBtnSave().addActionListener(this);
    window.getBtnPrint().addActionListener(this);
  }
  
  public void mouseReleased(MouseEvent e)
  {
//    if(e.getButton() == MouseEvent.BUTTON3)
//    {
//      view.doPrint();
//    }
    
    if(e.getButton() == MouseEvent.BUTTON1)
    {
      model.addFigure();
    }
  }

  @Override
  public void mouseDragged(MouseEvent e)
  {
    Point p = e.getPoint();
    //model.addPoint(p);
    //Point k = model.getFigure().getLastPoint();
    view.drawPoint(p);
  }

  @Override
  public void mouseMoved(MouseEvent e)
  {
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == window.getBtnLoad())
    {
        JFileChooser fc = window.getFC();
        int choice = fc.showOpenDialog(window);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
          File f = fc.getSelectedFile();
          try
          {
            model.loadPoints(f.getAbsolutePath());
            view.repaint();
          }
          catch (IOException ex)
          {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
          catch (ClassNotFoundException ex)
          {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    if(e.getSource() == window.getBtnSave())
    {
        JFileChooser fc = window.getFC();
        int choice = fc.showSaveDialog(window);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
          File f = fc.getSelectedFile();
          try
          {
            model.savePoints(f.getAbsolutePath());
          }
          catch (IOException ex)
          {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    if(e.getSource() == window.getBtnPrint())
    {
      view.doPrint();
    }
    
    
  
  }
}
