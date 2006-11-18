package com.carama.app.guinges.ui.config;

import java.awt.*;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.InsetsUIResource;

public class MainPanel extends JPanel
{
  private final JTextField field00 = new JTextField(32);
  private final JTextField field01 = new JTextField(32);
  private final JTextField field02 = new JTextField(32);

  public MainPanel()
  {
    Insets m = field01.getMargin();
    Logger.global.info(m.toString());
    Insets margin = new Insets(m.top, m.left + 10, m.bottom, m.right);
    field01.setMargin(margin);

    Border b1 = BorderFactory.createEmptyBorder(0, 20, 0, 0);
    Border b2 = BorderFactory.createCompoundBorder(field02.getBorder(), b1);
    field02.setBorder(b2);

    field00.setText("\u5DE6\u4F59\u767D:" + getLeftMargin(field00));
    field01.setText("\u5DE6\u4F59\u767D:" + getLeftMargin(field01));
    field02.setText("\u5DE6\u4F59\u767D:" + getLeftMargin(field02));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(field00);
    add(Box.createVerticalStrut(5));
    add(field01);
    add(Box.createVerticalStrut(5));
    add(field02);
    add(Box.createRigidArea(new Dimension(320, 5)));
    setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
  }

  private static int getLeftMargin(JTextField c)
  {
    //	int i = c.getBorder().getBorderInsets(c).left;
    //	int j = c.getMargin().left;
    //	Logger.global.info(""+i);
    //	Logger.global.info(""+j);
    return c.getBorder().getBorderInsets(c).left; //c.getMargin().left;
  }

  public static void main(String[] args)
  {
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        createAndShowGUI();
      }
    });
  }

  public static void createAndShowGUI()
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      Insets m = (Insets)UIManager.get("TextField.margin");
      UIManager.put("TextField.margin", new InsetsUIResource(m.top, m.left + 5, m.bottom, m.right));
    }
    catch (Exception e)
    {
      throw new InternalError(e.toString());
    }
    MainPanel panel = new MainPanel();
    JFrame frame = new JFrame("@title@");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.pack();
    //frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
