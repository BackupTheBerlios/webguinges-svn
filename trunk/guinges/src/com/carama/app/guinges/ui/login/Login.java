/**
 * Login.java
 * */
package com.carama.app.guinges.ui.login;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.borland.jbcl.layout.VerticalFlowLayout;
import com.carama.app.guinges.ui.mdi.Guinges;
import com.carama.app.guinges.utils.EscribeLogs;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;

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
public class Login extends JFrame
{
  /**
   * Clase EscribeError para escribir el fichero logs
   * */

  private JPanel panelnorte = new JPanel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel panelcentro = new JPanel();
  private JPanel panelcentrosur = new JPanel();
  private JPanel panelcentronorte = new JPanel();
  private JPanel panelcentrocentro = new JPanel();
  private JLabel lblUser = new JLabel();
  private JTextField txtUser = new JTextField();
  private JLabel lblPassword = new JLabel();
  private JPasswordField txtPassword = new JPasswordField();
  private JButton btonEntrar = new JButton();
  private JButton btonSalir = new JButton();
  private JPanel panelLogin = new JPanel();
  private BorderLayout borderLayout3 = new BorderLayout();
  private VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();

  private static EscribeLogs logs = new EscribeLogs();
  private TitledBorder border = new TitledBorder("");
  private JPanel paneldb = new JPanel();
  private JLabel lbldatabase = new JLabel();
  private JComboBox cmbdb = new JComboBox();
  private JLabel iconoGuinges = new JLabel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private Border border1 = BorderFactory.createLineBorder(SystemColor.activeCaption, 1);

  /**
  * Constructor de la clase
  * */
 public Login()
 {
   try
   {
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     jbInit();
   }
   catch (Exception exception)
   {
     exception.printStackTrace();
   }
 }

  /**
   * Component initialization.
   *
   * @throws java.lang.Exception
   */
  private void jbInit() throws Exception
  {
    border = new TitledBorder(BorderFactory.createLineBorder(Color.orange, 1), "");
    basedatos();
    this.setResizable(false);
    this.setIconImage(Toolkit.getDefaultToolkit().getImage("iconos/icon.png"));
    setSize(new Dimension(330, 320));
    setTitle("Identificación de usuarios");
    this.setUndecorated(true);
    this.getContentPane().setLayout(borderLayout1);
    panelnorte.setBorder(border);
    panelnorte.setPreferredSize(new Dimension(300, 115));
    panelnorte.setLayout(borderLayout2);
    panelcentro.setLayout(borderLayout3);
    lblUser.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblUser.setPreferredSize(new Dimension(86, 20));
    lblUser.setText("Usuario");
    panelcentro.setPreferredSize(new Dimension(112, 10));
    lblPassword.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblPassword.setPreferredSize(new Dimension(86, 20));
    lblPassword.setText("Contraseña");
    txtUser.setBackground(new Color(255, 205, 105));
    txtUser.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtUser.setBorder(BorderFactory.createLineBorder(Color.black));
    txtUser.setPreferredSize(new Dimension(150, 20));
    txtUser.setMargin(new Insets(10, 0, 0, 0));
    txtUser.addFocusListener(new TxtUser(this));
    txtPassword.setBackground(new Color(255, 205, 105));
    txtPassword.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtPassword.setBorder(BorderFactory.createLineBorder(Color.black));
    txtPassword.setPreferredSize(new Dimension(150, 20));
    txtPassword.setMargin(new Insets(5, 0, 0, 0));
    txtPassword.addKeyListener(new TxtPassword_keyAdapter(this));
    txtPassword.addFocusListener(new TxtPassword(this));
    panelcentrocentro.setBorder(border1);
    panelcentrocentro.setPreferredSize(new Dimension(280, 40));
    panelcentronorte.setBorder(border1);
    panelcentronorte.setPreferredSize(new Dimension(280, 40));
    panelcentrosur.setBorder(border1);
    panelcentrosur.setPreferredSize(new Dimension(280, 55));
    btonEntrar.setPreferredSize(new Dimension(120, 35));
    btonEntrar.setActionCommand("btnEntrar");
    btonEntrar.setHorizontalAlignment(SwingConstants.LEFT);
    btonEntrar.setIcon(new ImageIcon(com.carama.app.guinges.ui.login.Login.class.getResource(
        "../img/connect.png")));
    btonEntrar.setText("Conectar");
    btonEntrar.addActionListener(new BtonEntrar(this));
    btonSalir.setPreferredSize(new Dimension(120, 35));
    btonSalir.setHorizontalAlignment(SwingConstants.LEFT);
    btonSalir.setIcon(new ImageIcon(com.carama.app.guinges.ui.login.Login.class.getResource(
        "../img/cancel.png")));
    btonSalir.setText("Cancelar");
    btonSalir.addActionListener(new BtnSalir(this));
    panelLogin.setLayout(verticalFlowLayout1);
    paneldb.setBorder(border1);
    paneldb.setPreferredSize(new Dimension(280, 40));
    lbldatabase.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lbldatabase.setPreferredSize(new Dimension(86, 20));
    lbldatabase.setText("Base de datos");
    cmbdb.setPreferredSize(new Dimension(150, 20));
    iconoGuinges.setBorder(null);
    iconoGuinges.setHorizontalAlignment(SwingConstants.CENTER);
    iconoGuinges.setHorizontalTextPosition(SwingConstants.CENTER);
    iconoGuinges.setIcon(new ImageIcon(com.carama.app.guinges.ui.login.Login.class.getResource(
        "../img/GuingesLogin.png")));
    getContentPane().add(panelcentro, java.awt.BorderLayout.CENTER);
    panelcentronorte.add(lblUser);
    panelcentronorte.add(txtUser);
    panelcentrocentro.add(lblPassword);
    panelcentrocentro.add(txtPassword);
    panelcentrosur.add(btonEntrar);
    panelcentrosur.add(btonSalir);
    panelcentro.add(panelLogin, java.awt.BorderLayout.CENTER);
    panelLogin.add(panelnorte);
    panelLogin.add(paneldb);
    paneldb.add(lbldatabase);
    paneldb.add(cmbdb);
    panelLogin.add(panelcentronorte);
    panelLogin.add(panelcentrocentro);
    panelLogin.add(panelcentrosur);
    panelnorte.add(iconoGuinges, java.awt.BorderLayout.CENTER);
    //basedatos();
    /*try
         {
      Image image = ImageIO.read(getClass().getResource("GuingesLogin.png"));
      icono.setImage(image);
         }
         catch (IOException ex)
         {
      logs.escribeError(ex.getLocalizedMessage(), false);
         }*/
  }

  private void basedatos()
  {
    ArrayList<String> dbname = new ArrayList<String>();
    dbname.add("GUINGES S.L");
    dbname.add("CARAMA S.L");
    for (String str : dbname)
    {
      cmbdb.addItem(str);
    }
  }

  /**
   * Metodo para iniciar para llamar a la clase Guinges.java
   * */
  public static void init()
  {
    //Splash.getInstance().openSplash();
    try
    {
      Guinges frm = new Guinges();
      frm.user.setText("Carlos");
      frm.setVisible(true);
      logs.escribeError("Se ha entrado en la aplicacion con exito", false);
    }

    catch (Exception ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }

  }

  /**
   *
   * @param e ActionEvent
   */
  public void btnAceptar_actionPerformed(ActionEvent e)
  {
    this.setVisible(false);
    // run();
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtUser_focusGained(FocusEvent e)
  {
    txtUser.setBackground(new Color(255, 255, 105));
    txtUser.selectAll();
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtUser_focusLost(FocusEvent e)
  {
    txtUser.setBackground(new Color(255, 205, 105));
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtPassword_focusGained(FocusEvent e)
  {
    txtPassword.setBackground(new Color(255, 255, 105));
    txtPassword.selectAll();
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtPassword_focusLost(FocusEvent e)
  {
    txtPassword.setBackground(new Color(255, 205, 105));
  }

  /**
   *
   * @param e ActionEvent
   */
  public void btonSalir(ActionEvent e)
  {
    this.dispose();
    System.exit(0);
  }

  /**
   *
   * @param e ActionEvent
   */
  public void jButton1_actionPerformed(ActionEvent e)
  {
    init();
    this.setVisible(false);
    this.dispose();
  }

  /**
   *
   * @param e KeyEvent
   */
  public void txtPassword_keyPressed(KeyEvent e)
  {

    if (e.getKeyCode() == 13)
    {
      //validarusuario();
    }
  }
}

class BtonEntrar implements ActionListener
{
  private Login adaptee;
  BtonEntrar(Login adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.jButton1_actionPerformed(e);
  }
}

class TxtUser extends FocusAdapter
{
  private Login adaptee;
  TxtUser(Login adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txtUser_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txtUser_focusLost(e);
  }
}

class BtnSalir implements ActionListener
{
  private Login adaptee;
  BtnSalir(Login adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btonSalir(e);
  }
}

class TxtPassword extends FocusAdapter
{
  private Login adaptee;
  TxtPassword(Login adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txtPassword_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txtPassword_focusLost(e);
  }
}

class TxtPassword_keyAdapter extends KeyAdapter
{
  private Login adaptee;
  TxtPassword_keyAdapter(Login adaptee)
  {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e)
  {
    adaptee.txtPassword_keyPressed(e);
  }
}
