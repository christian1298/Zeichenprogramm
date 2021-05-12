/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import zeichenprogramm.model.Figur;
import zeichenprogramm.model.ViewModel;

/**
 *
 * @author Christian
 */
public class View extends JComponent implements Printable
{
  //private final static Dimension DIM_ONE = new Dimension(1,1);
  private Point lastPoint = new Point();
  private Line2D.Float line = new Line2D.Float();
  private ViewModel model;
  
  public View()
  {
  }
  
  public void setModel(ViewModel model)
  {
    this.model = model;
  }
  
  public void drawPoint(Point p, Point k)
  {
    Graphics2D g2 = (Graphics2D)this.getGraphics();
    
    line.setLine(k, p);
    g2.draw(line);
    //lastPoint = p;
    
    g2.dispose();
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    model.getFigures().forEach(p->
    {
      p.getPoints().forEach(k->{
        
        line.setLine(lastPoint, k);
        g2.draw(line);
        //lastPoint = k;
      });
    });
  }

  @Override
  public int print(Graphics gp, PageFormat pf, int pageIndex) throws PrinterException
  {
    Graphics2D g2p = (Graphics2D)gp;
    if(pageIndex == 0)
    {
      g2p.translate(pf.getImageableX(),pf.getImageableY());
      g2p.scale(pf.getImageableWidth()/this.getWidth(),
              pf.getImageableHeight()/this.getHeight());
      super.print(g2p);
      return Printable.PAGE_EXISTS;
    }
    else
    {
      return Printable.NO_SUCH_PAGE;
    }
  }
  
  public void doPrint()
  {
    HashPrintRequestAttributeSet printSet = new HashPrintRequestAttributeSet();
    printSet.add(DialogTypeSelection.NATIVE);
    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(this);
    if(pj.printDialog(printSet))
    {
      try
      {
        pj.print(printSet);
      }
      catch (PrinterException ex)
      {
        JOptionPane.showMessageDialog(this, ex.toString());
      }
    }
  }
}
