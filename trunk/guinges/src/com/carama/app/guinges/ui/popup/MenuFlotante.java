/**
 * MenuFlotante.java
 * */
package com.carama.app.guinges.ui.popup;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.borland.jbcl.layout.VerticalFlowLayout;
import org.jdesktop.swingx.JXTitledPanel;
import org.jdesktop.swingx.JXPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import org.jdesktop.swingx.JXTable;

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
public class MenuFlotante extends JDialog implements ActionListener
{
  private BorderLayout borderLayout1 = new BorderLayout();
  private JXTitledPanel panelMenu = new JXTitledPanel();
  private JXPanel panel1 = new JXPanel();
  private JXPanel panel2 = new JXPanel();
  public JButton BotonSalir = new JButton();
  public JComboBox cmbFiltro = new JComboBox();
  public JTextField txtBuscar = new JTextField();
  public JButton BotonXML = new JButton();
  public JButton BotonCVS = new JButton();
  public JButton BotonPDF = new JButton();
  public JButton BotonPreview = new JButton();
  public JButton BotonImprimir = new JButton();
  public FlowLayout flowLayout1 = new FlowLayout();
  public VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
  public VerticalFlowLayout verticalFlowLayout2 = new VerticalFlowLayout();
  public JButton BotonPegar = new JButton();
  public JButton BotonCopiar = new JButton();
  public JButton BotonCortar = new JButton();
  private String titulo;
  public MenuFlotante(JFrame owner, String title, boolean modal)
  {
    super(owner, title, modal);
    this.titulo = title;
    try
    {
      jbInit();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
    this.pack();
    this.setVisible(true);
  }

  /**
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
  }

  private void jbInit() throws Exception
  {
    llenarfiltro();
    this.setSize(300, 390);
    getContentPane().setLayout(borderLayout1);
    panelMenu.setBorder(null);
    panelMenu.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    panelMenu.setPreferredSize(new Dimension(300, 360));
    panelMenu.setTitle(titulo);
    panelMenu.setTitleFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    panelMenu.setTitleForeground(UIManager.getColor("window"));

    BotonSalir.setText("Salir");
    BotonSalir.addActionListener(new PopupMenu_BotonSalir_actionAdapter(this));
    cmbFiltro.setPreferredSize(new Dimension(150, 20));
    txtBuscar.setPreferredSize(new Dimension(100, 20));
    BotonXML.setText("Exportar xml");
    BotonCVS.setText("Exportar cvs");
    BotonPDF.setText("Exportar pdf");
    BotonPreview.setText("Vista preliminar");
    BotonImprimir.setText("Imprimir");
    panel1.setOpaque(false);
    panel1.setLayout(flowLayout1);
    panel2.setLayout(verticalFlowLayout2);
    BotonPegar.setText("Pegar");
    BotonCopiar.setText("Copiar");
    BotonCortar.setText("Cortar");
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setUndecorated(true);
    panel1.add(cmbFiltro);
    panel1.add(txtBuscar);
    this.getContentPane().add(panelMenu, java.awt.BorderLayout.WEST);
    panelMenu.add(panel1);
    panelMenu.add(panel2);
    panel2.add(BotonCortar);
    panel2.add(BotonCopiar);
    panel2.add(BotonPegar);
    panel2.add(BotonCVS);
    panel2.add(BotonXML);
    panel2.add(BotonPDF);
    panel2.add(BotonPreview);
    panel2.add(BotonImprimir);
    panel2.add(BotonSalir);
    panelMenu.setLayout(verticalFlowLayout1);
  }

  private void llenarfiltro()
  {
    ArrayList<String> filtro = new ArrayList<String>();
    filtro.add("=");
    filtro.add("<");
    filtro.add("<=");
    filtro.add(">");
    filtro.add(">=");
    filtro.add("<>");
    filtro.add("COMIENZA");
    filtro.add("NO COMIENZA");
    filtro.add("CONTIENE");
    filtro.add("NO CONTIENE");
    filtro.add("TERMINA");
    for (String str : filtro)
    {
      cmbFiltro.addItem(str);
    }
    cmbFiltro.setAutoscrolls(true);
    cmbFiltro.setLightWeightPopupEnabled(true);
    cmbFiltro.setSelectedIndex(8);
  }

  public void BotonSalir_actionPerformed(ActionEvent e)
  {
    System.exit(0);
  }

  /*public static void main(String[] args)
     {
    new PopupMenu();
     }*/
}

class PopupMenu_BotonSalir_actionAdapter implements ActionListener
{
  private MenuFlotante adaptee;
  PopupMenu_BotonSalir_actionAdapter(MenuFlotante adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.BotonSalir_actionPerformed(e);
  }
}
