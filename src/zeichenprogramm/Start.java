/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenprogramm;

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import zeichenprogramm.controller.ViewController;
import zeichenprogramm.model.ViewModel;
import zeichenprogramm.view.View;

/**
 *
 * @author Christian
 */
public class Start 
{
  public Start()
  {
    View view = new View();
    ViewModel model = new ViewModel();
    view.setModel(model);
    ViewController controller = new ViewController(view, model);
    controller.registerEvents();
    
    JFrame frm = new JFrame();
    frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frm.setContentPane(view);
    frm.setSize(800,600);
    frm.setVisible(true);
  }

  public static void main(String[] args) 
  {
    new Start();
  }

}
