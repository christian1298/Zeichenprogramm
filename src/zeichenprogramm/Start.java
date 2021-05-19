/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import zeichenprogramm.controller.ViewController;
import zeichenprogramm.model.ViewModel;
import zeichenprogramm.view.Ansicht;
import zeichenprogramm.view.View;

/**
 *
 * @author Christian
 */
public class Start 
{
  public Start()
  {
    Ansicht window = new Ansicht();
    //View view = new View();
    View view = window.getView1();
    ViewModel model = new ViewModel();
    
    view.setModel(model);
    ViewController controller = new ViewController(view, model, window);
    controller.registerEvents();
    
//    JFrame frm = new JFrame();
//    frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    frm.setContentPane(view);
//    frm.setSize(800,600);
//    frm.setVisible(true);
    
    
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //window.getContentPane().add(view);
    window.setSize(800,600);
    window.setVisible(true);
    
    
  }

  public static void main(String[] args) 
  {
    new Start();
  }

}
