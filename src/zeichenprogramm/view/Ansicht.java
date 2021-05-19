/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeichenprogramm.view;

/**
 *
 * @author Christian
 */
public class Ansicht extends javax.swing.JFrame
{

  /**
   * @return the FC
   */
  public javax.swing.JFileChooser getFC()
  {
    return FC;
  }

  /**
   * @return the BtnLoad
   */
  public javax.swing.JButton getBtnLoad()
  {
    return BtnLoad;
  }

  /**
   * @return the BtnPrint
   */
  public javax.swing.JButton getBtnPrint()
  {
    return BtnPrint;
  }

  /**
   * @return the BtnSave
   */
  public javax.swing.JButton getBtnSave()
  {
    return BtnSave;
  }

  /**
   * Creates new form Ansicht
   */
  public Ansicht()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    FC = new javax.swing.JFileChooser();
    jToolBar1 = new javax.swing.JToolBar();
    BtnSave = new javax.swing.JButton();
    BtnLoad = new javax.swing.JButton();
    BtnPrint = new javax.swing.JButton();
    view1 = new zeichenprogramm.view.View();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jToolBar1.setRollover(true);

    BtnSave.setMnemonic('S');
    BtnSave.setText("Save");
    BtnSave.setFocusable(false);
    BtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    BtnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    BtnSave.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        BtnSaveActionPerformed(evt);
      }
    });
    jToolBar1.add(BtnSave);

    BtnLoad.setMnemonic('L');
    BtnLoad.setText("Load");
    BtnLoad.setFocusable(false);
    BtnLoad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    BtnLoad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(BtnLoad);

    BtnPrint.setMnemonic('P');
    BtnPrint.setText("Print");
    BtnPrint.setFocusable(false);
    BtnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    BtnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(BtnPrint);

    getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
    getContentPane().add(view1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnSaveActionPerformed
  {//GEN-HEADEREND:event_BtnSaveActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_BtnSaveActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(Ansicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(Ansicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(Ansicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(Ansicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Ansicht().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton BtnLoad;
  private javax.swing.JButton BtnPrint;
  private javax.swing.JButton BtnSave;
  private javax.swing.JFileChooser FC;
  private javax.swing.JToolBar jToolBar1;
  private zeichenprogramm.view.View view1;
  // End of variables declaration//GEN-END:variables

  /**
   * @return the view1
   */
  public zeichenprogramm.view.View getView1()
  {
    return view1;
  }
}
