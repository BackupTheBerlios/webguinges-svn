/**
 * AcercaDe.java
 * */
package com.carama.app.guinges.ui.about;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * <p>Title: Guinges</p>
 *
 * <p>Description: Aplicacion de gestion para proposito general</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: Carama S.L.L</p>
 *
 * @author Carlos & Amador
 * @version 0.0.1
 */
public class AcercaDe extends JDialog implements ActionListener
{
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel panelPrincipal = new JPanel();
  private JTabbedPane tabbetPane = new JTabbedPane();
  private JPanel jPanel1 = new JPanel();
  private JPanel panelCentro = new JPanel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private JButton btnAceptar = new JButton();
  private JEditorPane jEditorPane1 = new JEditorPane();
  private BorderLayout borderLayout3 = new BorderLayout();
  private JPanel jPanel2 = new JPanel();
  private JPanel jPanel3 = new JPanel();
  /**
   * Constructor de la clase
   * @param parent Frame
   */
  public AcercaDe(Frame parent)
  {
    super(parent);
    try
    {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      jbInit();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    getContentPane().setLayout(borderLayout1);
    panelCentro.setBackground(SystemColor.activeCaptionBorder);
    panelCentro.setLayout(borderLayout2);
    btnAceptar.setText("Aceptar");
    btnAceptar.addActionListener(new AcercaDe_btnAceptar_actionAdapter(this));
    jEditorPane1.setMinimumSize(new Dimension(395, 200));
    jEditorPane1.setPreferredSize(new Dimension(395, 200));
    jEditorPane1.setEditable(false);
    jEditorPane1.setText("Acerca de guinges...");
    jPanel1.setLayout(borderLayout3);
    this.setTitle("A cerca de...");
    this.getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);
    tabbetPane.add(jPanel1, "jPanel1");
    panelCentro.add(tabbetPane, java.awt.BorderLayout.CENTER);
    this.getContentPane().add(panelPrincipal, java.awt.BorderLayout.NORTH);
    jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);
    jPanel3.add(jEditorPane1);
    jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);
    jPanel2.add(btnAceptar);
  }

  /**
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
  }

  /**
   *
   * @param e ActionEvent
   */
  public void btnAceptar_actionPerformed(ActionEvent e)
  {
    this.dispose();
  }
}

class AcercaDe_btnAceptar_actionAdapter implements ActionListener
{
  private AcercaDe adaptee;
  AcercaDe_btnAceptar_actionAdapter(AcercaDe adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnAceptar_actionPerformed(e);
  }
}
