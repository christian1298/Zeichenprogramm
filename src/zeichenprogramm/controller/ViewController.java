/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import zeichenprogramm.model.ViewModel;
import zeichenprogramm.view.View;

/**
 *
 * @author Christian
 */
public class ViewController extends MouseAdapter implements MouseMotionListener
{
  private View view;
  private ViewModel model;
  
  public ViewController(View view, ViewModel model)
  {
    this.view = view;
    this.model = model;
  }
  
  public void registerEvents()
  {
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
  }
  
  public void mouseReleased(MouseEvent e)
  {
    if(e.getButton() == MouseEvent.BUTTON3)
    {
      view.doPrint();
    }
    
    if(e.getButton() == MouseEvent.BUTTON1)
    {
      model.addFigure();
    }
  }

  @Override
  public void mouseDragged(MouseEvent e)
  {
    Point p = e.getPoint();
    model.addPoint(p);
    Point k = model.getFigure().getLastPoint();
    view.drawPoint(p, k);
  }

  @Override
  public void mouseMoved(MouseEvent e)
  {
  }
  
  
}
