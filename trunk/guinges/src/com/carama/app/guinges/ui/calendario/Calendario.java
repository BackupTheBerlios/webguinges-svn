/**
 * Calendario.java
 * */
package com.carama.app.guinges.ui.calendario;

import java.awt.*;

import javax.swing.*;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.calendar.JXMonthView;

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
public class Calendario extends JDialog
{
  private JXMonthView monthView = new JXMonthView(System.currentTimeMillis());
  private JPanel panelcalendario = new JXPanel();
  private BorderLayout borderLayout = new BorderLayout();
  /**
   *
   * @param owner Frame
   * @param title String
   * @param modal boolean
   */
  public Calendario(JFrame owner, String title, boolean modal)
  {
    super(owner, title, modal);
    try
    {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      jbInit();
      pack();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }

  private static void calendarMode(JXMonthView monthView)
  {
    monthView.setTraversable(true);
    monthView.setAntialiased(true);
    monthView.setDayForeground(1, Color.RED);
    monthView.setSelectionMode(1);

  }

  private void jbInit() throws Exception
  {
    calendarMode(monthView);
    panelcalendario.setLayout(borderLayout);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    getContentPane().add(panelcalendario);
    panelcalendario.add(monthView, BorderLayout.CENTER);
  }
}
