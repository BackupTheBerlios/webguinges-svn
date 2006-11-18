/**
 * ConfigInicial.java
 * */

package com.carama.app.guinges.ui.config;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;

import com.borland.jbcl.layout.*;
import com.carama.app.guinges.utils.*;
import org.jdesktop.swingx.JXPanel;

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
public class ConfigInicial extends JDialog
{
  private EscribeLogs logs = new EscribeLogs();

  /**
   * Atributos
   *
   * */
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel panelcodigo = new JPanel();
  private JLabel lblnombre = new JLabel();
  private JTextField txtnombre = new JTextField();
  private JLabel lblrazonsocial = new JLabel();
  private JPanel paneltitulo = new JPanel();
  private JTextField txtrazonsocial = new JTextField();
  private JXPanel panelMain = new JXPanel();
  private XYLayout xYLayout1 = new XYLayout();
  private JPanel panelnorte = new JPanel();
  private BorderLayout borderLayout3 = new BorderLayout();
  private JPanel panelempresa = new JPanel();
  private BorderLayout borderLayout4 = new BorderLayout();
  private BorderLayout borderLayout5 = new BorderLayout();
  private JLabel lbltitulo = new JLabel();
  private Border bordeAzul;
  private TitledBorder titledborder = new TitledBorder("");
  private JPanel datosEmpresa = new JPanel();
  private JTabbedPane tabbedpane = new JTabbedPane();
  private JPanel datosBancarios = new JPanel();
  private JPanel panelSur = new JPanel();
  private JPanel panelGuardar = new JPanel();
  private JButton botonGuardar = new JButton();
  private JButton botonCancelar = new JButton();
  private JPanel panelInternet = new JPanel();
  private JPanel panelConfig = new JPanel();
  private JLabel lblDescripcion = new JLabel();
  private JTextField txtDescripcion = new JTextField();
  private JLabel lblCif = new JLabel();
  private JFormattedTextField txtCif;
  private JPanel panelLogo = new JPanel();
  private JPanel paneltelefono = new JPanel();
  private JPanel panelDireccion = new JPanel();
  private JPanel panelEjercicio = new JPanel();
  private JPanel paneldireccion = new JPanel();
  private JPanel direccion = new JPanel();
  private JTextField txtDireccion = new JTextField();
  private JLabel lbldireccion = new JLabel();
  private JFormattedTextField txtcodpoblacion;
  private JLabel lblpoblacion = new JLabel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private XYLayout xYLayout3 = new XYLayout();
  private JButton botonBuscarPoblacion = new JButton();
  private JLabel lblZipCode = new JLabel();
  private JFormattedTextField txtCodPostal;
  private JTextField txtpoblacion = new JTextField();
  private FlowLayout flowLayout2 = new FlowLayout();
  private JPanel paneltfno = new JPanel();
  private JPanel telefono = new JPanel();
  private JLabel lbltelefono2 = new JLabel();
  private JLabel lblfax = new JLabel();
  private JLabel lbltelefono1 = new JLabel();
  private JFormattedTextField txttelefono1;
  private JFormattedTextField txttelefono2;
  private JFormattedTextField txtfax;
  private JPanel panelinternet = new JPanel();
  private JPanel internet = new JPanel();
  private JLabel lblwww = new JLabel();
  private JLabel lblemail = new JLabel();
  private JTextField txtemail = new JTextField();
  private JTextField txtwww = new JTextField();
  private JPanel panelbancos = new JPanel();
  private JPanel bancos = new JPanel();
  private JLabel lblentidad = new JLabel();
  private JLabel lblsucursal = new JLabel();
  private JLabel lbldc = new JLabel();
  private JFormattedTextField txtentidad;
  private JFormattedTextField txtsucursal;
  private JFormattedTextField txtdc;
  private JFormattedTextField txtcuenta;
  private JPanel panelejercicio = new JPanel();
  private JPanel ejercicio = new JPanel();
  private JLabel lblejercicio = new JLabel();
  private JTextField txtejercicio = new JTextField();
  private JPanel panellogo = new JPanel();
  private JPanel logo = new JPanel();
  private JPanel panelconfig = new JPanel();
  private JPanel configuracion = new JPanel();
  private XYLayout xYLayout4 = new XYLayout();
  private BorderLayout borderLayout6 = new BorderLayout();
  private BorderLayout borderLayout7 = new BorderLayout();
  private XYLayout xYLayout5 = new XYLayout();
  private JFormattedTextField txttelefonoasistencia;
  private JLabel lblasistencia = new JLabel("Teléfono asistencia");
  private BorderLayout borderLayout8 = new BorderLayout();
  private XYLayout xYLayout6 = new XYLayout();
  private JLabel lblcuenta = new JLabel();
  private JFormattedTextField txtccc;
  private JLabel lblccc = new JLabel();
  private XYLayout xYLayout7 = new XYLayout();
  private BorderLayout borderLayout9 = new BorderLayout();
  private JButton botonExplorar = new JButton();
  private BorderLayout borderLayout10 = new BorderLayout();
  private XYLayout xYLayout8 = new XYLayout();
  private XYLayout xYLayout9 = new XYLayout();
  private BorderLayout borderLayout11 = new BorderLayout();
  private JEditorPane editlogo = new JEditorPane();
  private FlowLayout flowLayout3 = new FlowLayout();
  private static final Color ANTESFOCO = (new Color(206, 248, 255));
  private static final Color DESPUESFOCO = (new Color(255, 255, 255));
  private JLabel lbltelefono = new JLabel();
  private JTextField txtformattfno = new JTextField();
  private JLabel lblformatofecha = new JLabel();
  private JTextField txtformatofecha = new JTextField();
  private JPanel panelformato = new JPanel();
  private TitledBorder titledBorder1 = new TitledBorder("");
  private FlowLayout flowLayout1 = new FlowLayout();
  private XYLayout xYLayout2 = new XYLayout();
  private JLabel lblcodpais = new JLabel();
  private JTextField txtcodpais = new JTextField();
  private JTextField txtcodidioma = new JTextField();
  private JLabel lblsepdecimal = new JLabel();
  private JTextField txtnumdecimales = new JTextField();
  private JLabel lblidioma = new JLabel();
  private JTextField txtformatnif = new JTextField();
  private JLabel lblnif = new JLabel();
  private JLabel lblformatcif = new JLabel();
  private JTextField txtformatcif = new JTextField();
  private JLabel lblformatocp = new JLabel();
  private JTextField txtformatocp = new JTextField();
  private JTextField txtformatnass = new JTextField();
  private JLabel lblformatonass = new JLabel();

  private ConfigIni conf = new ConfigIni();

  private PathDirAndFiles files = new PathDirAndFiles();

  private String maskcif = conf.obtenerValorIni(files.iniFileName(), "formato.cif");

  private String nif = conf.obtenerValorIni(files.iniFileName(), "formato.nif");

  private String lang = conf.obtenerValorIni(files.iniFileName(), "user.language");

  private String digits = conf.obtenerValorIni(files.iniFileName(), "user.fractional.digits");

  private String masktfno = conf.obtenerValorIni(files.iniFileName(), "formato.tfno");

  private String maskcp = conf.obtenerValorIni(files.iniFileName(), "formato.cp");

  /**
   * Constructor de la clase
   *
   * @param frame JFrame
   * @param title String
   * @param modal boolean
   */
  public ConfigInicial(JFrame frame, String title, boolean modal)
  {
    super(frame, title, modal);
    try
    {
      this.setModal(modal);
      lbltitulo.setText(title.toUpperCase());
      jbInit();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1),
                                     "Patrones de formato");
    titledborder = new TitledBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1), "");
    MaskFormatter cif = new MaskFormatter(maskcif);
    MaskFormatter ccc = new MaskFormatter("##/#######/##");
    MaskFormatter entidad = new MaskFormatter("####");
    MaskFormatter oficina = new MaskFormatter("####");
    MaskFormatter dc = new MaskFormatter("##");
    MaskFormatter cuenta = new MaskFormatter("##########");
    MaskFormatter tfno = new MaskFormatter(masktfno);
    MaskFormatter codpoblacion = new MaskFormatter("**#");
    MaskFormatter codpostal = new MaskFormatter(maskcp);
    txtCodPostal = new JFormattedTextField(codpostal);
    txtCif = new JFormattedTextField(cif);
    txttelefono1 = new JFormattedTextField(tfno);
    txttelefono2 = new JFormattedTextField(tfno);
    txttelefonoasistencia = new JFormattedTextField(tfno);
    txtsucursal = new JFormattedTextField(oficina);
    txtentidad = new JFormattedTextField(entidad);
    txtccc = new JFormattedTextField(ccc);
    txtdc = new JFormattedTextField(dc);
    txtcuenta = new JFormattedTextField(cuenta);
    txtfax = new JFormattedTextField(tfno);
    txtcodpoblacion = new JFormattedTextField(codpoblacion);
    this.setSize(590, 490);
    bordeAzul = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue, 1),
                                                   BorderFactory.createEmptyBorder(0, 5, 0, 3));
    getContentPane().setLayout(borderLayout1);
    txtnombre.setBorder(bordeAzul);
    panelcodigo.setBorder(null);
    panelcodigo.setMinimumSize(new Dimension(441, 122));
    panelcodigo.setPreferredSize(new Dimension(550, 240));
    panelMain.setBorder(null);
    datosEmpresa.setLayout(flowLayout1);
    panelnorte.setBorder(null);
    panelempresa.setBorder(titledborder);
    panelempresa.setPreferredSize(new Dimension(550, 250));
    datosEmpresa.setMinimumSize(new Dimension(460, 142));
    datosEmpresa.setPreferredSize(new Dimension(560, 240));
    this.setResizable(true);
    this.addWindowListener(new ConfigInicial_this_windowAdapter(this));
    this.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    lblnombre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblnombre.setText("Nombre");
    txtnombre.setBackground(new Color(206, 248, 255));
    txtnombre.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtnombre.setPreferredSize(new Dimension(40, 18));
    txtnombre.addFocusListener(new TxtRazonSocial(this));
    lblrazonsocial.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblrazonsocial.setText("Razón social");
    txtrazonsocial.setBackground(new Color(206, 248, 255));
    txtrazonsocial.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtrazonsocial.setBorder(bordeAzul);
    txtrazonsocial.setPreferredSize(new Dimension(40, 18));
    txtrazonsocial.addFocusListener(new TxtGrupo(this));
    paneltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    paneltitulo.setBorder(null);
    paneltitulo.setMinimumSize(new Dimension(209, 50));
    paneltitulo.setPreferredSize(new Dimension(209, 80));
    paneltitulo.setLayout(flowLayout3);
    panelcodigo.setLayout(xYLayout1);
    panelnorte.setLayout(borderLayout3);
    panelempresa.setLayout(borderLayout4);
    panelMain.setLayout(borderLayout5);
    lbltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    lbltitulo.setIcon(new ImageIcon(com.carama.app.guinges.ui.config.ConfigInicial.class.getResource(
        "../img/advancedsettings.png")));
    botonGuardar.setIcon(new ImageIcon(com.carama.app.guinges.ui.config.ConfigInicial.class.getResource(
        "../img/saveconfig.png")));
    botonGuardar.setText("Guardar cambios");
    botonCancelar.setIcon(new ImageIcon(com.carama.app.guinges.ui.config.ConfigInicial.class.getResource(
        "../img/volver.png")));
    botonCancelar.setText("Cancelar");
    lblDescripcion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblDescripcion.setText("Descripción");
    txtDescripcion.setBackground(ANTESFOCO);
    txtDescripcion.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtDescripcion.setBorder(bordeAzul);

    txtDescripcion.setPreferredSize(new Dimension(40, 18));
    txtDescripcion.setToolTipText("Introduzca en este campo la descripción de su empresa");
    lblCif.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblCif.setText("C.I.F");
    txtCif.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtCif.setBackground(new Color(206, 248, 255));
    txtCif.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtCif.setBorder(bordeAzul);
    txtCif.setPreferredSize(new Dimension(40, 18));
    txtCif.setSelectionEnd(1);
    panelDireccion.setLayout(flowLayout2);
    paneldireccion.setBorder(titledborder);
    paneldireccion.setMinimumSize(new Dimension(450, 132));
    paneldireccion.setPreferredSize(new Dimension(550, 250));
    paneldireccion.setLayout(borderLayout2);
    direccion.setPreferredSize(new Dimension(450, 190));
    direccion.setLayout(xYLayout3);
    txtDireccion.setBackground(new Color(206, 248, 255));
    txtDireccion.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtDireccion.setBorder(bordeAzul);
    txtDireccion.setPreferredSize(new Dimension(40, 18));
    lbldireccion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lbldireccion.setText("Dirección");
    txtcodpoblacion.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtcodpoblacion.setBackground(new Color(206, 248, 255));
    txtcodpoblacion.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtcodpoblacion.setBorder(bordeAzul);
    txtcodpoblacion.setPreferredSize(new Dimension(40, 18));
    lblpoblacion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblpoblacion.setText("Población");
    botonBuscarPoblacion.setPreferredSize(new Dimension(105, 22));
    botonBuscarPoblacion.setHorizontalAlignment(SwingConstants.LEFT);
    botonBuscarPoblacion.setIcon(new ImageIcon(new java.net.URL(
        "file:///C:/GUINGES/iconos/kfilereplace.png")));
    botonBuscarPoblacion.setText("Poblaciones");
    lblZipCode.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblZipCode.setText("Cód. Postal");
    txtCodPostal.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtCodPostal.setBackground(new Color(206, 248, 255));
    txtCodPostal.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtCodPostal.setBorder(bordeAzul);
    txtCodPostal.setPreferredSize(new Dimension(40, 18));
    txtpoblacion.setBackground(new Color(206, 248, 255));
    txtpoblacion.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtpoblacion.setBorder(bordeAzul);
    txtpoblacion.setPreferredSize(new Dimension(40, 18));
    txtpoblacion.setEditable(false);
    panelDireccion.setBorder(null);
    paneltfno.setBorder(titledborder);
    paneltfno.setMinimumSize(new Dimension(450, 132));
    paneltfno.setPreferredSize(new Dimension(550, 250));
    paneltfno.setLayout(borderLayout6);
    telefono.setMinimumSize(new Dimension(441, 122));
    telefono.setPreferredSize(new Dimension(450, 190));
    telefono.setLayout(xYLayout4);
    lbltelefono2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lbltelefono2.setText("Teléfono 2");
    lblfax.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblfax.setText("Fax");
    lbltelefono1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lbltelefono1.setText("Teléfono 1");
    txttelefono1.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txttelefono1.setBackground(new Color(206, 248, 255));
    txttelefono1.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txttelefono1.setBorder(bordeAzul);
    txttelefono1.setPreferredSize(new Dimension(40, 18));
    txttelefono2.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txttelefono2.setBackground(new Color(206, 248, 255));
    txttelefono2.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txttelefono2.setBorder(bordeAzul);
    txttelefono2.setPreferredSize(new Dimension(40, 18));
    txtfax.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtfax.setBackground(new Color(206, 248, 255));
    txtfax.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtfax.setBorder(bordeAzul);
    txtfax.setPreferredSize(new Dimension(40, 18));
    panelinternet.setMinimumSize(new Dimension(450, 132));
    panelinternet.setPreferredSize(new Dimension(550, 250));
    panelinternet.setLayout(borderLayout7);
    internet.setBorder(titledborder);
    internet.setPreferredSize(new Dimension(450, 190));
    internet.setLayout(xYLayout5);
    lblwww.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblwww.setText("Página web");
    lblemail.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblemail.setText("Correo electrónico");
    txtemail.setBackground(new Color(206, 248, 255));
    txtemail.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtemail.setBorder(bordeAzul);
    txtemail.setPreferredSize(new Dimension(40, 18));
    txtwww.setBackground(new Color(206, 248, 255));
    txtwww.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtwww.setBorder(bordeAzul);
    txtwww.setPreferredSize(new Dimension(40, 18));
    panelbancos.setBorder(titledborder);
    panelbancos.setMinimumSize(new Dimension(450, 132));
    panelbancos.setPreferredSize(new Dimension(550, 250));
    panelbancos.setLayout(borderLayout8);
    bancos.setPreferredSize(new Dimension(450, 190));
    bancos.setLayout(xYLayout6);
    lblentidad.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblentidad.setText("Entidad");
    lblsucursal.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblsucursal.setText("Oficina");
    lbldc.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lbldc.setText("DC");
    txtentidad.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtentidad.setBackground(new Color(206, 248, 255));
    txtentidad.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtentidad.setBorder(bordeAzul);
    txtentidad.setPreferredSize(new Dimension(40, 18));
    txtsucursal.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtsucursal.setBackground(new Color(206, 248, 255));
    txtsucursal.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtsucursal.setBorder(bordeAzul);
    txtsucursal.setPreferredSize(new Dimension(40, 18));
    txtdc.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtdc.setBackground(new Color(206, 248, 255));
    txtdc.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtdc.setBorder(bordeAzul);
    txtdc.setPreferredSize(new Dimension(40, 18));
    txtcuenta.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtcuenta.setBackground(new Color(206, 248, 255));
    txtcuenta.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtcuenta.setBorder(bordeAzul);
    txtcuenta.setPreferredSize(new Dimension(40, 18));
    panelejercicio.setBorder(titledborder);
    panelejercicio.setMinimumSize(new Dimension(450, 132));
    panelejercicio.setPreferredSize(new Dimension(550, 250));
    panelejercicio.setLayout(borderLayout10);
    ejercicio.setPreferredSize(new Dimension(450, 190));
    ejercicio.setLayout(xYLayout8);
    lblejercicio.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblejercicio.setText("Ejercicio");
    txtejercicio.setBackground(new Color(206, 248, 255));
    txtejercicio.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtejercicio.setBorder(bordeAzul);
    txtejercicio.setPreferredSize(new Dimension(40, 18));
    panellogo.setBorder(titledborder);
    panellogo.setMinimumSize(new Dimension(450, 132));
    panellogo.setPreferredSize(new Dimension(550, 250));
    panellogo.setLayout(borderLayout9);
    logo.setPreferredSize(new Dimension(450, 190));
    logo.setLayout(xYLayout7);
    panelconfig.setBorder(titledborder);
    panelconfig.setMinimumSize(new Dimension(450, 132));
    panelconfig.setPreferredSize(new Dimension(550, 250));
    panelconfig.setLayout(borderLayout11);
    configuracion.setPreferredSize(new Dimension(450, 200));
    configuracion.setLayout(xYLayout9);
    txttelefonoasistencia.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txttelefonoasistencia.setBackground(new Color(206, 248, 255));
    txttelefonoasistencia.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txttelefonoasistencia.setBorder(bordeAzul);
    txttelefonoasistencia.setPreferredSize(new Dimension(40, 18));
    lblasistencia.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblcuenta.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblcuenta.setText("Cuenta");
    txtccc.setFocusLostBehavior(JFormattedTextField.PERSIST);
    txtccc.setBackground(new Color(206, 248, 255));
    txtccc.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtccc.setBorder(bordeAzul);
    txtccc.setPreferredSize(new Dimension(40, 18));
    lblccc.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblccc.setText("CCC");
    botonExplorar.setHorizontalAlignment(SwingConstants.LEFT);
    /*botonExplorar.setIcon(new ImageIcon(new java.net.URL(
        "file:///C:/GUINGES/iconos/kfilereplace.png")));*/
    botonExplorar.setIcon(new ImageIcon(com.carama.app.guinges.ui.config.ConfigInicial.class.getResource(
        "../img/kfilereplace.png")));
    botonExplorar.setText("Explorar...");
    lbltelefono.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lbltelefono.setText("Formato teléfono");
    txtformattfno.setBackground(new Color(206, 248, 255));
    txtformattfno.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtformattfno.setBorder(bordeAzul);
    txtformattfno.setPreferredSize(new Dimension(40, 18));
    txtformattfno.setEditable(true);
    txtformattfno.setText(masktfno);
    lblformatofecha.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblformatofecha.setText("Formato fecha");
    txtformatofecha.setBackground(new Color(206, 248, 255));
    txtformatofecha.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtformatofecha.setBorder(bordeAzul);

    txtformatofecha.setPreferredSize(new Dimension(40, 18));
    txtformatofecha.setEditable(true);
    txtformatofecha.setText("## / ## / ##");
    panelformato.setBorder(titledBorder1);
    panelformato.setLayout(xYLayout2);
    editlogo.setBorder(bordeAzul);
    lblcodpais.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblcodpais.setText("Cód. Pais");
    txtcodpais.setBackground(new Color(206, 248, 255));
    txtcodpais.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtcodpais.setBorder(bordeAzul);
    txtcodpais.setPreferredSize(new Dimension(40, 18));
    txtcodidioma.setBackground(new Color(206, 248, 255));
    txtcodidioma.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtcodidioma.setBorder(bordeAzul);
    txtcodidioma.setPreferredSize(new Dimension(40, 18));
    txtcodidioma.setText(lang);
    lblsepdecimal.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblsepdecimal.setText("Núm. de decimales");
    txtnumdecimales.setBackground(new Color(206, 248, 255));
    txtnumdecimales.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtnumdecimales.setBorder(bordeAzul);
    txtnumdecimales.setPreferredSize(new Dimension(40, 18));
    txtnumdecimales.setText(digits);
    lblidioma.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblidioma.setText("Cód. Idioma");
    txtformatnif.setBackground(new Color(206, 248, 255));
    txtformatnif.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtformatnif.setBorder(bordeAzul);
    txtformatnif.setPreferredSize(new Dimension(40, 18));
    txtformatnif.setText(nif);
    lblnif.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblnif.setText("Formato N.I.F");
    lblformatcif.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblformatcif.setText("Formato C.I.F");
    txtformatcif.setBackground(new Color(206, 248, 255));
    txtformatcif.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtformatcif.setBorder(bordeAzul);
    txtformatcif.setPreferredSize(new Dimension(40, 18));
    txtformatcif.setText(maskcif);
    lblformatocp.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblformatocp.setText("Formato Cód. Postal");
    txtformatocp.setBackground(new Color(206, 248, 255));
    txtformatocp.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtformatocp.setBorder(bordeAzul);
    txtformatocp.setPreferredSize(new Dimension(40, 18));
    txtformatocp.setText(maskcp);
    txtformatnass.setBackground(new Color(206, 248, 255));
    txtformatnass.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
    txtformatnass.setBorder(bordeAzul);
    txtformatnass.setPreferredSize(new Dimension(40, 18));
    txtformatnass.setText("## / ######## / ##");
    lblformatonass.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
    lblformatonass.setText("Formato N.A.S.S");
    this.getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);
    panelMain.add(panelnorte, java.awt.BorderLayout.SOUTH);
    panelMain.add(paneltitulo, java.awt.BorderLayout.NORTH);
    panelMain.add(tabbedpane, java.awt.BorderLayout.CENTER);
    this.getContentPane().add(panelSur, java.awt.BorderLayout.SOUTH);
    panelSur.add(panelGuardar);
    panelGuardar.add(botonGuardar);
    panelGuardar.add(botonCancelar);
    tabbedpane.add(datosEmpresa, "Empresa");
    panelempresa.add(panelcodigo, java.awt.BorderLayout.NORTH);
    tabbedpane.add(panelDireccion, "Dirección");
    tabbedpane.add(paneltelefono, "Teléfono/Fax");
    paneltelefono.add(paneltfno);
    tabbedpane.add(panelInternet, "Internet");
    panelInternet.add(panelinternet);
    tabbedpane.add(datosBancarios, "Banco");
    datosBancarios.add(panelbancos);
    panelbancos.add(bancos, java.awt.BorderLayout.CENTER);
    tabbedpane.add(panelEjercicio, "Ejercicio");
    panelEjercicio.add(panelejercicio);
    tabbedpane.add(panelLogo, "Logo");
    panelLogo.add(panellogo);
    tabbedpane.add(panelConfig, "Configuraración");
    panelConfig.add(panelconfig);
    panelDireccion.add(paneldireccion, null);
    paneldireccion.add(direccion, null);
    paneltfno.add(telefono, null);
    panelconfig.add(configuracion, null);
    panelinternet.add(internet, null);
    panelejercicio.add(ejercicio, null);
    panellogo.add(logo, null);
    direccion.add(lblpoblacion, new XYConstraints(65, 76, 74, -1));
    direccion.add(lbldireccion, new XYConstraints(65, 47, -1, -1));
    direccion.add(txtDireccion, new XYConstraints(154, 47, 318, -1));
    direccion.add(txtpoblacion, new XYConstraints(194, 76, 139, 20));
    direccion.add(botonBuscarPoblacion, new XYConstraints(341, 72, 128, 27));
    direccion.add(lblZipCode, new XYConstraints(65, 105, -1, -1));
    panelcodigo.add(lblDescripcion, new XYConstraints(65, 47, -1, -1));
    panelcodigo.add(txtDescripcion, new XYConstraints(160, 47, 311, -1));
    panelcodigo.add(lblCif, new XYConstraints(65, 76, -1, -1));
    panelcodigo.add(txtnombre, new XYConstraints(160, 105, 311, -1));
    panelcodigo.add(lblnombre, new XYConstraints(65, 105, 87, -1));
    panelcodigo.add(txtrazonsocial, new XYConstraints(160, 135, 193, -1));
    panelcodigo.add(lblrazonsocial, new XYConstraints(65, 135, 101, -1));
    telefono.add(txttelefono1, new XYConstraints(188, 46, 194, -1));
    telefono.add(lbltelefono1, new XYConstraints(65, 47, -1, -1));
    telefono.add(lbltelefono2, new XYConstraints(65, 76, -1, -1));
    telefono.add(txttelefono2, new XYConstraints(188, 76, 194, -1));
    telefono.add(lblfax, new XYConstraints(65, 105, 28, 19));
    telefono.add(lblasistencia, new XYConstraints(65, 134, -1, -1));
    telefono.add(txttelefonoasistencia, new XYConstraints(187, 134, 194, -1));
    telefono.add(txtfax, new XYConstraints(188, 105, 194, -1));
    internet.add(lblemail, new XYConstraints(65, 47, -1, -1));
    internet.add(txtemail, new XYConstraints(194, 47, 249, -1));
    internet.add(lblwww, new XYConstraints(65, 76, -1, -1));
    internet.add(txtwww, new XYConstraints(194, 76, 249, -1));
    bancos.add(lblentidad, new XYConstraints(65, 47, -1, -1));
    bancos.add(lblccc, new XYConstraints(65, 105, -1, -1));
    bancos.add(lblsucursal, new XYConstraints(237, 47, -1, -1));
    bancos.add(txtsucursal, new XYConstraints(286, 47, 85, -1));
    logo.add(botonExplorar, new XYConstraints(371, 47, 120, -1));
    ejercicio.add(lblejercicio, new XYConstraints(65, 47, -1, -1));
    ejercicio.add(txtejercicio, new XYConstraints(128, 47, 201, -1));
    logo.add(editlogo, new XYConstraints(65, 47, 299, 106));
    paneltitulo.add(lbltitulo, null);
    panelcodigo.add(txtCif, new XYConstraints(160, 76, 122, -1));
    direccion.add(txtcodpoblacion, new XYConstraints(154, 76, 32, 20));
    direccion.add(txtCodPostal, new XYConstraints(153, 105, 86, -1));
    bancos.add(lbldc, new XYConstraints(65, 76, -1, -1));
    bancos.add(txtentidad, new XYConstraints(125, 47, 85, -1));
    bancos.add(txtdc, new XYConstraints(125, 76, 33, -1));
    bancos.add(lblcuenta, new XYConstraints(232, 76, -1, -1));
    bancos.add(txtccc, new XYConstraints(125, 106, 146, -1));
    bancos.add(txtcuenta, new XYConstraints(286, 76, 145, -1));
    datosEmpresa.add(panelempresa, null);
    configuracion.add(panelformato, new XYConstraints(0, 2, 539, 234));
    panelformato.add(txtformatnass, new XYConstraints(394, 148, 105, -1));
    panelformato.add(lblformatocp, new XYConstraints(30, 148, -1, -1));
    panelformato.add(txtformatofecha, new XYConstraints(149, 61, 113, -1));
    panelformato.add(lblformatofecha, new XYConstraints(31, 61, 105, -1));
    panelformato.add(txtformattfno, new XYConstraints(149, 32, 113, -1));
    panelformato.add(lblsepdecimal, new XYConstraints(31, 90, -1, -1));
    panelformato.add(txtnumdecimales, new XYConstraints(149, 90, -1, -1));
    panelformato.add(txtformatnif, new XYConstraints(148, 119, 72, -1));
    panelformato.add(lblnif, new XYConstraints(30, 119, -1, -1));
    panelformato.add(lbltelefono, new XYConstraints(31, 32, -1, -1));
    panelformato.add(lblformatonass, new XYConstraints(277, 150, -1, -1));
    panelformato.add(lblformatcif, new XYConstraints(277, 119, -1, -1));
    panelformato.add(lblidioma, new XYConstraints(278, 61, -1, -1));
    panelformato.add(lblcodpais, new XYConstraints(278, 32, -1, -1));
    panelformato.add(txtcodpais, new XYConstraints(395, 32, 34, -1));
    panelformato.add(txtcodidioma, new XYConstraints(394, 61, 34, -1));
    panelformato.add(txtformatcif, new XYConstraints(393, 119, 72, -1));
    panelformato.add(txtformatocp, new XYConstraints(149, 145, 55, -1));
  }

  /**
   * Boton salir
   *
   * @param e ActionEvent
   */
  public void btnSalir_actionPerformed(ActionEvent e)
  {
    try
    {
      this.setVisible(false);
      this.dispose();
      this.finalize();
    }
    catch (Throwable ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Caja de texto codigo gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcodigo_focusGained(FocusEvent e)
  {
  }

  /**
   * Caja de texto codigo pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcodigo_focusLost(FocusEvent e)
  {
  }

  /**
   * Caja de texto descripcion gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtdescripcion_focusGained(FocusEvent e)
  {
  }

  /**
   * Caja de texto descripcion pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtdescripcion_focusLost(FocusEvent e)
  {
  }

  /**
   * Caja de texto razonsocial gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtrazonsocial_focusGained(FocusEvent e)
  {
    txtnombre.setBackground(new Color(255, 255, 255));
    txtnombre.selectAll();
  }

  /**
   * Caja de texto telefono gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txttelefono_focusGained(FocusEvent e)
  {
    txtrazonsocial.setBackground(new Color(255, 255, 255));
    txtrazonsocial.selectAll();
  }

  /**
   * Caja de texto contacto gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcontacto_focusGained(FocusEvent e)
  {
  }

  /**
   * Caja de texto razonsocial pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtrazonsocial_focusLost(FocusEvent e)
  {
    txtnombre.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto telefono pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txttelefono_focusLost(FocusEvent e)
  {
    txtrazonsocial.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto contacto pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcontacto_focusLost(FocusEvent e)
  {
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txttelefono2_focusGained(FocusEvent e)
  {
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txttelefono2_focusLost(FocusEvent e)
  {
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtarea_focusLost(FocusEvent e)
  {
  }

  public void this_windowClosing(WindowEvent e)
  {
    this.dispose();
  }

  class TxtGrupo extends FocusAdapter
  {
    private ConfigInicial adaptee;
    TxtGrupo(ConfigInicial adaptee)
    {
      this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e)
    {
      adaptee.txttelefono_focusGained(e);
    }

    public void focusLost(FocusEvent e)
    {
      adaptee.txttelefono_focusLost(e);
    }
  }

  class TxtRazonSocial extends FocusAdapter
  {
    private ConfigInicial adaptee;
    TxtRazonSocial(ConfigInicial adaptee)
    {
      this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e)
    {
      adaptee.txtrazonsocial_focusGained(e);
    }

    public void focusLost(FocusEvent e)
    {
      adaptee.txtrazonsocial_focusLost(e);
    }
  }
}

class ConfigInicial_this_windowAdapter extends WindowAdapter
{
  private ConfigInicial adaptee;
  ConfigInicial_this_windowAdapter(ConfigInicial adaptee)
  {
    this.adaptee = adaptee;
  }

  public void windowClosing(WindowEvent e)
  {
    adaptee.this_windowClosing(e);
  }
}
