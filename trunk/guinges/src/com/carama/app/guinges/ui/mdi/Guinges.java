/**
 * Guinges.java
 * */
package com.carama.app.guinges.ui.mdi;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.borland.jbcl.layout.VerticalFlowLayout;
import com.carama.app.guinges.ui.bancos.FrmBancos;
import com.carama.app.guinges.ui.calendario.Calendario;
import com.carama.app.guinges.ui.config.ConfigInicial;
import com.carama.app.guinges.ui.poplacion.FrmPoblacion;
import com.carama.app.guinges.ui.provincia.FrmProvincia;
import com.carama.app.guinges.utils.*;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.aqua.AquaLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsClassicLookAndFeelAddons;
import com.pagosoft.plaf.PlafOptions;
import org.jdesktop.swingx.*;
import org.jdesktop.swingx.border.DropShadowBorder;
import org.jdesktop.swingx.tips.*;

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
public class Guinges extends JXFrame implements ActionListener
{
  /**
   * Clase para mostrar la fecha
   * */
  private FechaHora fechaHora = new FechaHora();

  /**
   * Clase para acceder al fichero ini
   * */
  private ConfigIni config = new ConfigIni();

  /**
   * Clase para acceder a los ficheros de la aplicacion
   * */
  private PathDirAndFiles files = new PathDirAndFiles();

  /**
   * Clase para escribir los errores en el fichero logs
   * */
  private static EscribeLogs error = new EscribeLogs();

  /**
   * Atributos
   * */
  private JPanel panelPrincipal;
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel panelCentro = new JPanel();
  private JPanel panelSur = new JPanel();
  private JSplitPane splitPanel = new JSplitPane();
  private JPanel panelIzquierdo = new JPanel();
  private JXImagePanel panelDerecho = new JXImagePanel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private JMenuBar menu = new JMenuBar();
  private JMenu mnuFile = new JMenu();
  private JMenuItem mnuFileExit = new JMenuItem();
  private JMenu mnuHelp = new JMenu();

  /**
   * Ficha de bancos
   * */
  private FrmBancos frmbancos = null;

  /**
   * Ficha de poblaciones
   * */
  private FrmPoblacion frmpoblacion = null;

  /**
   * Ficha de provincias
   * */
  private FrmProvincia frmprovincia = null;

  /**
   * Ficha de configuracion inicial
   * */
  private static ConfigInicial configinicial;

  /**
   * Ficha de Calendario
   * */
  private static Calendario calendario;

  /**
   * Timer
   * */
  private javax.swing.Timer timer;
  private BorderLayout borderLayout7 = new BorderLayout();
  private JMenu mnuConf = new JMenu();
  private JMenuItem mnuUsuarios = new JMenuItem();
  private JMenuItem mnuGrupos = new JMenuItem();
  private JMenuItem mnuPantallas = new JMenuItem();
  private JMenuItem mnuEnlacePantallas = new JMenuItem();
  private JMenuItem mnuEnlaceUsuarioGrupos = new JMenuItem();
  private JMenuItem mnuHelpTopics = new JMenuItem();
  private JMenu mnuHowto = new JMenu();
  private JMenuItem mnuIntro = new JMenuItem();
  private JMenuItem mnuWhatsNew = new JMenuItem();
  private JMenuItem mnuQuickTips = new JMenuItem();
  private JMenuItem mnuSamples = new JMenuItem();
  private JMenuItem mnuGuingesWeb = new JMenuItem();
  private JMenuItem mnuAbout = new JMenuItem();
  private JMenuItem mnuLicense = new JMenuItem();

  private JMenu mnuMant = new JMenu();
  private JMenu mnuInFin = new JMenu();
  private JMenuItem mnuInEcon = new JMenuItem();
  private JMenuItem mnuMantPlazas = new JMenuItem();
  private JMenuItem mnuMantClientes = new JMenuItem();
  private JMenuItem mnuMantClinica = new JMenuItem();
  private JMenu smnuMantUser = new JMenu();
  private JMenuItem mnuDatos = new JMenuItem();
  private JMenuItem mnuEnlace = new JMenuItem();
  private JMenu mnuOpciones = new JMenu();
  private JMenu smnuLaf = new JMenu();
  private JMenu smnuLang = new JMenu();
  private JMenuItem mnuConfIni = new JMenuItem();
  private JMenuItem mnuHerramientas = new JMenuItem();
  private JMenuItem mnuSystemProp = new JMenuItem();
  private JMenu mnuLogs = new JMenu();
  private JMenuItem mnuLeerLogs = new JMenuItem();
  private JMenuItem mnuLimpiarLogs = new JMenuItem();
  private JMenu mnuExportLogs = new JMenu();
  private JMenuItem mnuPrintLogs = new JMenuItem();
  private JMenuItem mnuEnviarLogs = new JMenuItem();
  private JMenuItem mnuPdfLogs = new JMenuItem();
  private JLabel ficha = new JLabel();
  /**
   * Variable publica
   * */
  public JLabel user = new JLabel();
  private JLabel progress = new JLabel();
  private JXTaskPaneContainer panelmenu = new JXTaskPaneContainer();
  private BorderLayout borderLayout3 = new BorderLayout();
  private JTaskPaneGroup panelayuda = new JTaskPaneGroup();
  private VerticalFlowLayout verticalFlowLayout2 = new VerticalFlowLayout();
  private JTaskPaneGroup empleados = new JTaskPaneGroup();
  private JTaskPaneGroup panelinformacion = new JTaskPaneGroup();
  private JTaskPaneGroup panelmantenimiento = new JTaskPaneGroup();
  private JTaskPaneGroup panelconfiguracion = new JTaskPaneGroup();
  private JXHyperlink linkpantallas = new JXHyperlink();
  private VerticalFlowLayout verticalFlowLayout3 = new VerticalFlowLayout();
  private JXHyperlink linkUsuarios = new JXHyperlink();
  private JXHyperlink linkGrupos = new JXHyperlink();
  private JXHyperlink linktopantallas = new JXHyperlink();
  private JPanel panelpantalla = new JPanel();
  private JLabel iconopantalla = new JLabel();
  private BorderLayout borderLayout4 = new BorderLayout();
  private JPanel panelusuarios = new JPanel();
  private JPanel panelgrupos = new JPanel();
  private JPanel panellinkpantallausers = new JPanel();
  private JLabel iconousuarios = new JLabel();
  private BorderLayout borderLayout8 = new BorderLayout();
  private JLabel iconogrupos = new JLabel();
  private BorderLayout borderLayout9 = new BorderLayout();
  private JLabel iconolinkpantallas = new JLabel();
  private BorderLayout borderLayout10 = new BorderLayout();
  private JPanel panelplazas = new JPanel();
  private JXHyperlink linkplazas = new JXHyperlink();
  private JLabel iconoplazas = new JLabel();
  private BorderLayout borderLayout11 = new BorderLayout();
  private JPanel panelbancos = new JPanel();
  private VerticalFlowLayout verticalFlowLayout4 = new VerticalFlowLayout();
  private JXHyperlink linkbancos = new JXHyperlink();
  private JLabel iconobancos = new JLabel();
  private BorderLayout borderLayout12 = new BorderLayout();
  private JPanel paneltrucos = new JPanel();
  private JPanel panelweb = new JPanel();
  private JXHyperlink linktrucos = new JXHyperlink();
  private BorderLayout borderLayout13 = new BorderLayout();
  private BorderLayout borderLayout14 = new BorderLayout();
  private JLabel iconotruco = new JLabel();
  private JPanel panelFichas = new JPanel();
  private BorderLayout borderLayout15 = new BorderLayout();
  private JPanel paneluser = new JPanel();
  private BorderLayout borderLayout16 = new BorderLayout();
  private JPanel panelfecha = new JPanel();
  private GridLayout gridLayout1 = new GridLayout();
  private JPanel panelprogress = new JPanel();
  private JLabel hora = new JLabel();
  private JPanel panelhora = new JPanel();
  private BorderLayout borderLayout5 = new BorderLayout();
  private BorderLayout borderLayout6 = new BorderLayout();
  private ButtonGroup group = new ButtonGroup();
  private JCheckBoxMenuItem cboxRedmond = new JCheckBoxMenuItem("Redmond");
  private JCheckBoxMenuItem cboxLafMetal = new JCheckBoxMenuItem();
  private JCheckBoxMenuItem cboxNimrod = new JCheckBoxMenuItem("Nimrod");
  private JCheckBoxMenuItem cboxTonic = new JCheckBoxMenuItem("Tonic");
  private JCheckBoxMenuItem cboxTiny = new JCheckBoxMenuItem("Tiny");
  private JCheckBoxMenuItem cboxAqua = new JCheckBoxMenuItem("Aqua");
  private JCheckBoxMenuItem jchbJGoodie = new JCheckBoxMenuItem("JGoodies");
  private JCheckBoxMenuItem cboxPagosoft = new JCheckBoxMenuItem("Pagosoft");
  private JCheckBoxMenuItem jchbLangSpanish = new JCheckBoxMenuItem();
  private JCheckBoxMenuItem jchbLangIngles = new JCheckBoxMenuItem();
  private JCheckBoxMenuItem jchbLangFrances = new JCheckBoxMenuItem();
  private JPanel panelpoblacion = new JPanel();
  private JLabel iconopoblacion = new JLabel();
  private JXHyperlink linkpoblacion = new JXHyperlink();
  private BorderLayout borderLayout17 = new BorderLayout();
  private JPanel panelprovincia = new JPanel();
  private JLabel iconoprovincia = new JLabel();
  private JXHyperlink linkprovincia = new JXHyperlink();
  private BorderLayout borderLayout18 = new BorderLayout();
  private JPanel panelpersonal = new JPanel();
  private JLabel iconopersonal = new JLabel();
  private JXHyperlink linkpersonal = new JXHyperlink();
  private BorderLayout borderLayout19 = new BorderLayout();
  private static JLayeredPane layeredpane = new JLayeredPane();
  private BorderLayout borderLayout20 = new BorderLayout();

  /**
   * Constructor de la clase
   */
  public Guinges()
  {
    try
    {
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      jbInit();
      timer = new javax.swing.Timer(1000, this);
      timer.start();
    }
    catch (Exception exception)
    {
      error.escribeError(exception.getLocalizedMessage(), false);
    }
  }

  /**
   * Metodo para activar el timer para mostrar la hora
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
    onTimer();
  }

  /**
   * Component initialization.
   *
   * @throws java.lang.Exception
   */
  private void jbInit() throws Exception
  {
    maximizeWindow();
    setExtendedState(this.getExtendedState());
    setExtendedState(10);
    addMouseListener(new GuingesFrame_this_mouseAdapter(this));
    addWindowListener(new GuingesFrame_this_windowAdapter(this));
    setSize(980, 700);
    panelPrincipal = (JPanel)getContentPane();
    panelPrincipal.setLayout(borderLayout1);
    getContentPane().setBackground(Color.gray);
    setForeground(Color.lightGray);
    setJMenuBar(menu);
    setIconImage(Toolkit.getDefaultToolkit().getImage(
        "iconos/icon.png"));
    centerMe();
    setTitle("GUINGES v.0.0.1 -Aplicacion de gestión-");
    splitPanel.setBackground(SystemColor.textHighlight);
    splitPanel.setBorder(null);
    splitPanel.setOpaque(false);
    splitPanel.setPreferredSize(new Dimension(120, 150));
    splitPanel.setDividerSize(0);
    splitPanel.setLastDividerLocation(245);
    splitPanel.setTopComponent(null);
    panelCentro.setLayout(borderLayout2);
    panelIzquierdo.setLayout(borderLayout3);
    mnuFile.setText("Archivo");
    mnuFileExit.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/exit.png")));
    mnuFileExit.setText("Salir");
    mnuFileExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q,
                                                                  java.awt.event.KeyEvent.
                                                                  CTRL_MASK, false));
    mnuFileExit.addActionListener(new MenuFileExit(this));
    mnuHelp.setIcon(null);
    mnuHelp.setText("Ayuda");
    panelDerecho.setLayout(borderLayout7);

    panelPrincipal.setBorder(null);
    panelPrincipal.setOpaque(false);
    panelIzquierdo.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
    panelIzquierdo.setOpaque(false);
    mnuConf.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/imac.png")));
    mnuConf.setText("Configuración");
    mnuUsuarios.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/user.png")));
    mnuUsuarios.setText("Usuarios");
    mnuGrupos.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/userConf.png")));
    mnuGrupos.setText("Grupos");
    mnuPantallas.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/pantallas.png")));
    mnuPantallas.setText("Pantallas");
    mnuEnlacePantallas.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/userpantalla.png")));
    mnuEnlacePantallas.setText("Enlace pantallas usuario");
    mnuEnlaceUsuarioGrupos.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/groupantalla.png")));
    mnuEnlaceUsuarioGrupos.setText("Enlace usuaro grupos");
    mnuHelpTopics.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/help.png")));
    mnuHelpTopics.setText("Trucos");
    mnuHowto.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/comHelp.png")));
    mnuHowto.setText("Aprender a manejar guinges");
    mnuIntro.setText("Introduccion");
    mnuWhatsNew.setText("Novedades");
    mnuQuickTips.setText("Quick Tips...");
    mnuSamples.setText("Ejemplos");
    mnuGuingesWeb.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/mozilla.png")));
    mnuGuingesWeb.setText("Guinges en la web...");
    mnuAbout.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/project_open.png")));
    mnuAbout.setText("Acerca de guinges...");
    mnuLicense.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/groupantalla.png")));
    mnuLicense.setText("Licencia...");
    mnuMant.setText("Mantenimiento");
    mnuInFin.setText("Información");
    mnuInEcon.setText("Economía");
    mnuMantPlazas.setText("Plazas");
    mnuMantClientes.setText("Clientes");
    mnuMantClinica.setText("Clinica");
    smnuMantUser.setText("Empleados");
    mnuDatos.setText("Datos");
    mnuEnlace.setText("Enlace empleados usuarios");
    mnuOpciones.setText("Opciones");
    smnuLaf.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/looknfeel.png")));
    smnuLaf.setText("Look & Feel");
    cboxLafMetal.setText("Metal");
    cboxLafMetal.addActionListener(new Guinges_cboxLafMetal_actionAdapter(this));
    smnuLang.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/locale.png")));
    smnuLang.setText("Idioma");
    jchbLangSpanish.setText("Español");
    jchbLangIngles.setText("Ingles");
    jchbLangFrances.setText("Frances");
    menu.setToolTipText("Menu");
    mnuConfIni.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/config.png")));
    mnuConfIni.setText("Configuración inicial");
    mnuConfIni.addActionListener(new Guinges_mnuConfIni_actionAdapter(this));
    mnuHerramientas.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/tools.png")));
    mnuHerramientas.setText("Herramientas");
    mnuSystemProp.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/os.png")));
    mnuSystemProp.setText("Propiedades del sistema operativo");
    mnuLogs.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/logs.png")));
    mnuLogs.setText("Logs");
    mnuLeerLogs.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/kfind.png")));
    mnuLeerLogs.setText("Leer fichero logs");
    mnuLimpiarLogs.setText("Limpiar fichero logs");
    mnuExportLogs.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/export.png")));
    mnuExportLogs.setText("Exportar logs");
    mnuPrintLogs.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/postscript.png")));
    mnuPrintLogs.setText("imprimir");
    mnuEnviarLogs.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/email.png")));
    mnuEnviarLogs.setText("Enviar email");
    mnuPdfLogs.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/pdf.png")));
    mnuPdfLogs.setText("Pdf");
    panelDerecho.setBackground(new Color(255, 210, 110));
    panelSur.setLayout(gridLayout1);
    user.setBorder(null);
    user.setMaximumSize(new Dimension(38, 20));
    user.setMinimumSize(new Dimension(38, 20));
    user.setPreferredSize(new Dimension(100, 20));
    user.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/windows_users.png")));
    user.setText("Administrador");
    ficha.setBorder(null);
    ficha.setPreferredSize(new Dimension(100, 20));
    ficha.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/document.png")));
    ficha.setText("Listo");
    progress.setBorder(null);
    progress.setHorizontalAlignment(SwingConstants.RIGHT);
    panelmenu.setBorder(new DropShadowBorder());
    panelmenu.setMaximumSize(new Dimension(234, 300));
    panelmenu.setMinimumSize(new Dimension(234, 300));
    panelmenu.setPreferredSize(new Dimension(234, 300));
    panelmenu.setBackground(new Color(100, 149, 255));
    panelmenu.setBorder(null);
    panelmenu.setOpaque(true);
    panelmenu.setLayout(verticalFlowLayout2);
    panelinformacion.setTitle("Información");
    panelinformacion.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/note.png")));
    panelconfiguracion.setTitle("Configuración");
    panelconfiguracion.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/config.png")));
    panelconfiguracion.setSpecial(true);
    panelconfiguracion.getContentPane().setLayout(verticalFlowLayout3);
    panelmantenimiento.setTitle("Mantenimiento");
    panelmantenimiento.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/window_list.png")));
    panelmantenimiento.getContentPane().setLayout(verticalFlowLayout4);
    empleados.setTitle("Empleados");
    empleados.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/user.png")));
    empleados.setExpanded(false);
    panelayuda.setTitle("Ayuda");
    panelayuda.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/help.png")));
    panelayuda.setExpanded(false);
    linkpantallas.setClickedColor(new Color(0, 51, 255));
    linkpantallas.setFocusPainted(false);
    linkpantallas.setIcon(null);
    linkpantallas.setSelectedIcon(null);
    linkpantallas.setText("Pantallas");
    linkUsuarios.setClickedColor(new Color(0, 51, 255));
    linkUsuarios.setFocusPainted(false);
    linkUsuarios.setText("Usuarios");
    linkGrupos.setClickedColor(new Color(0, 51, 255));
    linkGrupos.setFocusPainted(false);
    linkGrupos.setText("Grupos");
    linktopantallas.setClickedColor(new Color(0, 51, 255));
    linktopantallas.setContentAreaFilled(false);
    linktopantallas.setFocusPainted(false);
    linktopantallas.setText("Enlace pantallas usuarios");
    linktopantallas.setToolTipText("");
    iconopantalla.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/icon.png")));
    panelpantalla.setLayout(borderLayout4);
    panelpantalla.setOpaque(false);
    iconousuarios.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/userConf.png")));
    panelusuarios.setLayout(borderLayout8);
    iconogrupos.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/user.png")));
    panelgrupos.setLayout(borderLayout9);
    iconolinkpantallas.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/groupantalla.png")));
    panellinkpantallausers.setOpaque(false);
    panellinkpantallausers.setPreferredSize(new Dimension(56, 26));
    panellinkpantallausers.setLayout(borderLayout10);
    panelgrupos.setOpaque(false);
    panelusuarios.setOpaque(false);
    linkplazas.setClickedColor(new Color(0, 51, 255));
    linkplazas.setFocusPainted(false);
    linkplazas.setText(" Plazas");
    iconoplazas.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/db.png")));
    panelplazas.setLayout(borderLayout11);
    panelplazas.setOpaque(false);
    linkbancos.setClickedColor(new Color(0, 51, 255));
    linkbancos.setFocusPainted(false);
    linkbancos.setText(" Bancos");
    linkbancos.addActionListener(new LinkBancos(this));
    iconobancos.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/colorman.png")));
    panelbancos.setLayout(borderLayout12);
    panelbancos.setOpaque(false);
    linktrucos.setClickedColor(new Color(0, 51, 255));
    linktrucos.setFocusPainted(false);
    linktrucos.setText("Trucos");
    linktrucos.addActionListener(new LinkTrucos(this));
    paneltrucos.setLayout(borderLayout13);
    panelweb.setLayout(borderLayout14);
    panelweb.setOpaque(false);
    paneltrucos.setOpaque(false);
    iconotruco.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/comHelp.png")));
    panelFichas.setLayout(borderLayout15);
    panelFichas.setBorder(BorderFactory.createLoweredBevelBorder());
    panelFichas.setPreferredSize(new Dimension(120, 20));
    paneluser.setLayout(borderLayout16);
    paneluser.setBorder(BorderFactory.createLoweredBevelBorder());
    paneluser.setPreferredSize(new Dimension(120, 20));
    panelfecha.setBorder(BorderFactory.createLoweredBevelBorder());
    panelfecha.setPreferredSize(new Dimension(120, 20));
    panelfecha.setLayout(borderLayout6);
    panelprogress.setBorder(BorderFactory.createLoweredBevelBorder());
    panelprogress.setPreferredSize(new Dimension(14, 20));
    panelSur.setBorder(BorderFactory.createRaisedBevelBorder());
    hora.setPreferredSize(new Dimension(120, 20));
    hora.setHorizontalAlignment(SwingConstants.RIGHT);
    hora.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/date.png")));
    hora.addMouseListener(new Guinges_hora_mouseAdapter(this));
    panelhora.setBorder(BorderFactory.createLoweredBevelBorder());
    panelhora.setPreferredSize(new Dimension(41, 20));
    panelhora.setLayout(borderLayout5);
    cboxRedmond.addActionListener(new Guinges_cboxDefault_actionAdapter(this));
    cboxNimrod.addActionListener(new Guinges_cboxNimrod_actionAdapter(this));
    cboxTonic.addActionListener(new Guinges_cboxTonic_actionAdapter(this));
    cboxTiny.addActionListener(new Guinges_cboxTiny_actionAdapter(this));
    jchbJGoodie.addActionListener(new Guinges_jchbJGoodie_actionAdapter(this));
    cboxAqua.addActionListener(new Guinges_cboxAqua_actionAdapter(this));
    cboxPagosoft.addActionListener(new Guinges_cboxPagosoft_actionAdapter(this));
    panelpoblacion.setOpaque(false);
    panelpoblacion.setLayout(borderLayout17);
    iconopoblacion.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/konqueror5.png")));
    linkpoblacion.setClickedColor(new Color(0, 51, 255));
    linkpoblacion.setFocusPainted(false);
    linkpoblacion.setText(" Población");
    linkpoblacion.addActionListener(new Guinges_linkpoblacion_actionAdapter(this));
    panelprovincia.setOpaque(false);
    panelprovincia.setLayout(borderLayout18);
    iconoprovincia.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/address.png")));
    linkprovincia.setClickedColor(new Color(0, 51, 255));
    linkprovincia.setFocusPainted(false);
    linkprovincia.setText(" Provincias");
    linkprovincia.addActionListener(new Guinges_linkprovincia_actionAdapter(this));
    panelpersonal.setOpaque(false);
    panelpersonal.setLayout(borderLayout19);
    iconopersonal.setIcon(new ImageIcon(com.carama.app.guinges.ui.mdi.Guinges.class.getResource(
        "../img/ipersonal.png")));
    linkpersonal.setClickedColor(new Color(0, 51, 255));
    linkpersonal.setFocusPainted(false);
    linkpersonal.setText(" Personal");
    splitPanel.setLastDividerLocation(225);
    layeredpane.setOpaque(false);
    layeredpane.setLayout(borderLayout20);
    menu.add(mnuFile);
    menu.add(mnuMant);
    menu.add(mnuInFin);
    menu.add(mnuOpciones);
    menu.add(mnuHelp);
    mnuFile.add(mnuConf);
    mnuFile.add(mnuHerramientas);
    mnuFile.addSeparator();
    mnuFile.add(mnuLogs);
    mnuFile.addSeparator();
    mnuFile.add(mnuFileExit);
    mnuConf.add(mnuUsuarios);
    mnuConf.add(mnuGrupos);
    mnuConf.add(mnuPantallas);
    mnuConf.add(mnuEnlacePantallas);
    mnuConf.add(mnuEnlaceUsuarioGrupos);
    mnuConf.addSeparator();
    mnuConf.add(mnuConfIni);
    mnuHelp.add(mnuHelpTopics);
    mnuHelp.add(mnuHowto);
    mnuHelp.addSeparator();
    mnuHelp.add(mnuGuingesWeb);
    mnuHelp.add(mnuSystemProp);
    mnuHelp.addSeparator();
    mnuHelp.add(mnuLicense);
    mnuHelp.add(mnuAbout);
    mnuHowto.add(mnuIntro);
    mnuHowto.add(mnuWhatsNew);
    mnuHowto.add(mnuQuickTips);
    mnuHowto.add(mnuSamples);
    mnuInFin.add(mnuInEcon);
    mnuMant.add(mnuMantPlazas);
    mnuMant.add(mnuMantClientes);
    mnuMant.add(mnuMantClinica);
    mnuMant.addSeparator();
    mnuMant.add(smnuMantUser);
    smnuMantUser.add(mnuDatos);
    smnuMantUser.add(mnuEnlace);
    mnuOpciones.add(smnuLaf);
    mnuOpciones.add(smnuLang);
    group.add(cboxRedmond);

    /**
     * Leemos el archivo de configuracion
     * para seleccionar las opciones del laf
     **/
    switch (Integer.parseInt(config.obtenerValorIni(files.iniFileName(), "app.laf")))
    {
      case 1:
        cboxRedmond.setSelected(true);
        break;
      case 2:
        cboxLafMetal.setSelected(true);
        break;
      case 3:
        cboxNimrod.setSelected(true);
        break;
      case 4:
        cboxTonic.setSelected(true);
        break;
      case 5:
        cboxTiny.setSelected(true);
        break;
      case 6:
        jchbJGoodie.setSelected(true);
        break;
      case 7:
        cboxAqua.setSelected(true);
        break;
      case 8:
        cboxPagosoft.setSelected(true);
        break;

    }
    /**
     * Si el s.o es Linux no tiene sentido mostrar
     * este lookAndFeel ya que es que usa por defecto
     * */
    if (!System.getProperty("os.name").startsWith("Linux"))
    {
      group.add(cboxLafMetal);
      smnuLaf.add(cboxLafMetal);
    }
    group.add(cboxNimrod);
    group.add(cboxTonic);
    group.add(cboxTiny);
    group.add(jchbJGoodie);
    group.add(cboxAqua);
    group.add(cboxPagosoft);
    smnuLaf.add(cboxRedmond);
    smnuLaf.add(cboxNimrod);
    smnuLaf.add(cboxTonic);
    smnuLaf.add(cboxTiny);
    smnuLaf.add(cboxAqua);
    smnuLaf.add(cboxPagosoft);
    smnuLaf.add(jchbJGoodie);
    smnuLang.add(jchbLangSpanish);
    smnuLang.add(jchbLangIngles);
    smnuLang.add(jchbLangFrances);
    panelPrincipal.add(panelSur, java.awt.BorderLayout.SOUTH);
    panelPrincipal.add(panelCentro, java.awt.BorderLayout.CENTER);
    splitPanel.add(panelDerecho, JSplitPane.RIGHT);
    splitPanel.add(panelIzquierdo, JSplitPane.LEFT);
    panelCentro.add(splitPanel, java.awt.BorderLayout.CENTER);
    mnuLogs.add(mnuLeerLogs);
    mnuLogs.add(mnuLimpiarLogs);
    mnuLogs.add(mnuExportLogs);
    mnuExportLogs.add(mnuPrintLogs);
    mnuExportLogs.add(mnuEnviarLogs);
    mnuExportLogs.add(mnuPdfLogs);
    panelIzquierdo.add(panelmenu, java.awt.BorderLayout.CENTER);
    panelmenu.add(panelconfiguracion);
    panelmenu.add(empleados);
    panelmenu.add(panelmantenimiento);
    panelmenu.add(panelayuda);
    panelayuda.getContentPane().add(paneltrucos);
    panelayuda.getContentPane().add(panelweb);
    panelmenu.add(panelinformacion);
    panelpantalla.add(iconopantalla, java.awt.BorderLayout.WEST);
    panelpantalla.add(linkpantallas, java.awt.BorderLayout.CENTER);
    panelconfiguracion.getContentPane().add(panelgrupos);
    panelusuarios.add(iconousuarios, java.awt.BorderLayout.WEST);
    panelusuarios.add(linkUsuarios, java.awt.BorderLayout.CENTER);
    panelconfiguracion.getContentPane().add(panelpantalla);
    panelconfiguracion.getContentPane().add(panelusuarios);
    panelgrupos.add(iconogrupos, java.awt.BorderLayout.WEST);
    panelgrupos.add(linkGrupos, java.awt.BorderLayout.CENTER);
    panelconfiguracion.getContentPane().add(panellinkpantallausers);
    panellinkpantallausers.add(iconolinkpantallas, java.awt.BorderLayout.WEST);
    panellinkpantallausers.add(linktopantallas, java.awt.BorderLayout.CENTER);
    panelplazas.add(iconoplazas, java.awt.BorderLayout.WEST);
    panelplazas.add(linkplazas, java.awt.BorderLayout.CENTER);
    panelmantenimiento.getContentPane().add(panelpersonal);
    panelmantenimiento.getContentPane().add(panelprovincia);
    panelmantenimiento.getContentPane().add(panelpoblacion);
    panelmantenimiento.getContentPane().add(panelbancos);
    panelmantenimiento.getContentPane().add(panelplazas);
    panelbancos.add(iconobancos, java.awt.BorderLayout.WEST);
    panelbancos.add(linkbancos, java.awt.BorderLayout.CENTER);
    paneltrucos.add(linktrucos, java.awt.BorderLayout.CENTER);
    paneltrucos.add(iconotruco, java.awt.BorderLayout.WEST);
    panelSur.add(panelFichas);
    panelFichas.add(ficha, java.awt.BorderLayout.CENTER);
    panelSur.add(paneluser);
    paneluser.add(user, java.awt.BorderLayout.CENTER);
    panelSur.add(panelprogress);
    panelprogress.add(progress);
    panelSur.add(panelfecha);
    panelDerecho.add(layeredpane, java.awt.BorderLayout.CENTER);
    panelpersonal.add(iconopersonal, java.awt.BorderLayout.WEST);
    panelpersonal.add(linkpersonal, java.awt.BorderLayout.CENTER);
    panelprovincia.add(iconoprovincia, java.awt.BorderLayout.WEST);
    panelprovincia.add(linkprovincia, java.awt.BorderLayout.CENTER);
    panelpoblacion.add(iconopoblacion, java.awt.BorderLayout.WEST);
    panelpoblacion.add(linkpoblacion, java.awt.BorderLayout.CENTER);
    panelfecha.add(hora, java.awt.BorderLayout.CENTER);
    panelSur.add(panelhora);
    panelSur.add(panelfecha);
    splitPanel.setDividerLocation(225);

    /**
     * Cargamos la imagen del panel de la derecha
     * */
    try
    {
      Image image = ImageIO.read(
          getClass().getResource("imagen_panel.png"));
      panelDerecho.setImage(image);
    }
    catch (IOException ex)
    {
      error.escribeError(ex.getLocalizedMessage(), false);
    }

  }

  /**
   * Lista de clases que vamos a utilizar
   */
  enum ClassFrm
  {
    BANCOS, POBLACIONES, PROVINCIAS, CALENDARIO, CONFIGINI
  }

  private void onTimer()
  {
    Date horaActual = new Date();
    String patron = "H:mm:ss";
    String fechaActual = fechaHora.mostrarFecha(1);
    SimpleDateFormat formato = new SimpleDateFormat(patron);
    hora.setText(fechaActual + " " + formato.format(horaActual));
  }

  /**
   * Metodo para cerrar la ventana
   *
   * @param e WindowEvent
   */
  public void this_windowClosing(WindowEvent e)
  {
    cerrarVentana();
  }

  /**
   * Metodo para cargar los formularios jinternalframe
   *
   * @param frame JInternalFrame
   * @param frm ClassFrm
   * @param title String
   * @param label JLabel
   * @since 21/08/2006
   */
  private void motrarFicha(JInternalFrame frame, ClassFrm frm, String title,
                           JLabel label)
  {
    //if ((frame == null) || (frame.isClosed()))
    //{
    try
    {
      switch (frm)
      {
        case BANCOS:
          frame = new FrmBancos(title, label);
          break;
        case POBLACIONES:
          frame = new FrmPoblacion(title, label);
          break;
        case PROVINCIAS:
          frame = new FrmProvincia(title, label);
          break;
      }
    }
    catch (Exception ex)
    {
      error.escribeError(ex.getLocalizedMessage(), false);
    }
    frame.setVisible(true);
    try
    {
      frame.setSelected(true);
    }
    catch (PropertyVetoException ex)
    {
      error.escribeError(ex.getLocalizedMessage(), false);
    }
    layeredpane.add(frame);
    frame.moveToFront();
    //}
    if (!frame.isClosed())
    {
      frame.moveToFront();
    }
  }

  /**
   * Metodo para mostrar el mensaje cuando cerramos la aplicacion
   *
   * @param e ActionEvent
   */
  public void mnuFileExit_actionPerformed(ActionEvent e)
  {
    cerrarVentana();
  }

  private void cerrarVentana()
  {
    if (JOptionPane.showConfirmDialog(null,
                                      "¿Está seguro que desea abandonar la aplicación?") ==
        JOptionPane.YES_OPTION)
    {
      error.escribeError("Se ha abandonado la aplicacion con exito", false);
      setVisible(false);
      dispose();
      System.exit(0);
    }
  }

  /**
   * Una funcion util para centrar la ventana de la aplicacion
   */
  private void centerMe()
  {
    // Centrar la ventana
    Toolkit tk = this.getToolkit();
    Dimension d = this.getSize();
    int x = (tk.getScreenSize().width - d.width) / 2;
    int y = (tk.getScreenSize().height - d.height) / 2;
    this.setLocation(x, y);
  }

  /**
   * Metodo para mostrar el truco del dia
   *
   * @param e ActionEvent
   */
  public void linktrucos_actionPerformed(ActionEvent e)
  {
    JXTipOfTheDay tipOfTheDay = null;
    try
    {
      tipOfTheDay = new JXTipOfTheDay(loadModel());
    }
    catch (Exception ex)
    {
      error.escribeError(ex.getLocalizedMessage(), true);
    }
    tipOfTheDay.showDialog(null, new JXTipOfTheDay.ShowOnStartupChoice()
    {
      public boolean isShowingOnStartup()
      {
        return isStartupChoiceOption();
      }

      public void setShowingOnStartup(boolean showOnStartup)
      {
        setStartupChoiceOption(showOnStartup);
      }
    });
    //panelayuda.setExpanded(false);
  }

  private static TipOfTheDayModel loadModel() throws Exception
  {
    Properties properties = new Properties();
    InputStream propertiesIn = Guinges.class.getResourceAsStream("tips.properties");
    properties.load(propertiesIn);
    return TipLoader.load(properties);
  }

  private static boolean isStartupChoiceOption()
  {
    // get value from application settings.
    return true;
  }

  private void maximizeWindow()
  {
    setExtendedState(MAXIMIZED_BOTH);
  }

  private static void setStartupChoiceOption(boolean val)
  {
    System.out.println("Show Tips on Startup: " + val);
    // Set the value in application settings here.
  }

  /**
   * Metodo para cambiar el look and feel de la aplicacion
   * @param laf String
   * @param numlaf String
   * @since 22/08/2006
   */
  private void cambiarLookAndFeel(String laf, String numlaf)
  {
    try
    {
      if (laf.equals("aqua"))
      {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        LookAndFeelAddons.setAddon(AquaLookAndFeelAddons.class);
      }
      else if (laf.equals("default"))
      {
        if (!System.getProperty("os.name").startsWith("Windows"))
        {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        else
        {
          UIManager.setLookAndFeel("smooth.windows.SmoothLookAndFeel");
        }
        LookAndFeelAddons.setAddon(WindowsClassicLookAndFeelAddons.class);
      }
      else
      {
        UIManager.setLookAndFeel(laf);
      }
      SwingUtilities.updateComponentTreeUI(this);
      /**
       * actualizamos el valor laf del fichero ini
       */
      config.actualizarValorIni(files.iniFileName(), "app.laf", numlaf);

    }
    catch (Exception ex)
    {
      error.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxDefault(ActionEvent e)
  {
    cambiarLookAndFeel("default", "1");
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxLafMetal(ActionEvent e)
  {
    cambiarLookAndFeel("smooth.metal.SmoothLookAndFeel", "2");
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxNimrod(ActionEvent e)
  {
    cambiarLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel", "3");
    PlafOptions.setAntialiasingEnabled(true);
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxTonic(ActionEvent e)
  {
    cambiarLookAndFeel("com.digitprop.tonic.TonicLookAndFeel", "4");
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxTiny(ActionEvent e)
  {
    cambiarLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel", "5");
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxJGoodie(ActionEvent e)
  {
    cambiarLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel", "6");
  }

  /**
   * @param e WindowEvent
   * */
  public void cboxAqua(ActionEvent e)
  {
    cambiarLookAndFeel("aqua", "7");
  }

  /**
   *
   * @param e ActionEvent
   */
  public void cboxPagosoft_actionPerformed(ActionEvent e)
  {
    cambiarLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel", "8");
    PlafOptions.setAntialiasingEnabled(true);
  }

  /**
   *
   * @param e MouseEvent
   */
  public void calendario(MouseEvent e)
  {
    mostrarDialog(calendario, ClassFrm.CALENDARIO, "Calendario", true);
  }

  /**
   *
   * @param e ActionEvent
   */
  public void mnuConfIni(ActionEvent e)
  {
    mostrarDialog(configinicial, ClassFrm.CONFIGINI, "Configuración inicial de la empresa", true);
  }

  /**
   * Metodo para mostrar un JDialog centrado en la aplicacion
   * @param dialog JDialog
   * @param frmdialog ClassFrm
   * @param title String
   * @param modal boolean
   */
  private void mostrarDialog(JDialog dialog, ClassFrm frmdialog, String title, boolean modal)
  {
    switch (frmdialog)
    {
      case CALENDARIO:
        dialog = new Calendario(this, title, modal);
        break;
      case CONFIGINI:
        dialog = new ConfigInicial(this, title, modal);
        break;
    }
    Dimension dlgSize = dialog.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dialog.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                       (frmSize.height - dlgSize.height) / 2 + loc.y);
    dialog.setVisible(true);
  }

  /**
   * Metodo para mostrar la ficha de bancos
   *
   * @param e ActionEvent
   */
  public void linkbancos(ActionEvent e)
  {
    if ((frmbancos == null) || (frmbancos.isClosed()))
    {
      frmbancos = new FrmBancos("Ficha de bancos", ficha);
      frmbancos.setVisible(true);
      layeredpane.add(frmbancos);
      frmbancos.moveToFront();
    }
    if (!frmbancos.isClosed())
    {
      frmbancos.moveToFront();
    }
  }

  /**
   *
   * @param e ActionEvent
   */
  public void linkpoblacion(ActionEvent e)
  {
    if ((frmpoblacion == null) || (frmpoblacion.isClosed()))
    {
      frmpoblacion = new FrmPoblacion("Ficha poblaciones", ficha);
      frmpoblacion.setVisible(true);
      layeredpane.add(frmpoblacion);
      frmpoblacion.moveToFront();
    }
    if (!frmpoblacion.isClosed())
    {
      frmpoblacion.moveToFront();
    }
  }

  /**
   *
   * @param e ActionEvent
   */
  public void linkprovincia(ActionEvent e)
  {
    if ((frmprovincia == null) || (frmprovincia.isClosed()))
    {
      frmprovincia = new FrmProvincia("Ficha provincias", ficha);
      frmprovincia.setVisible(true);
      layeredpane.add(frmprovincia);
      frmprovincia.moveToFront();
    }
    if (!frmprovincia.isClosed())
    {
      frmprovincia.moveToFront();
    }
  }
}

class Guinges_linkprovincia_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_linkprovincia_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  /**
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
    adaptee.linkprovincia(e);
  }
}

class Guinges_linkpoblacion_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_linkpoblacion_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.linkpoblacion(e);
  }
}

class Guinges_mnuConfIni_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_mnuConfIni_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.mnuConfIni(e);
  }
}

class Guinges_cboxPagosoft_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxPagosoft_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxPagosoft_actionPerformed(e);
  }
}

class Guinges_hora_mouseAdapter extends MouseAdapter
{
  private Guinges adaptee;
  Guinges_hora_mouseAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e)
  {
    adaptee.calendario(e);
  }
}

class Guinges_cboxLafMetal_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxLafMetal_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxLafMetal(e);
  }
}

class Guinges_cboxNimrod_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxNimrod_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxNimrod(e);
  }
}

class Guinges_cboxTonic_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxTonic_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxTonic(e);
  }
}

class Guinges_cboxTiny_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxTiny_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxTiny(e);
  }
}

class Guinges_jchbJGoodie_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_jchbJGoodie_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxJGoodie(e);
  }
}

class Guinges_cboxAqua_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxAqua_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxAqua(e);
  }
}

class Guinges_cboxDefault_actionAdapter implements ActionListener
{
  private Guinges adaptee;
  Guinges_cboxDefault_actionAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cboxDefault(e);
  }
}

class LinkTrucos implements ActionListener
{
  private Guinges adaptee;
  LinkTrucos(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.linktrucos_actionPerformed(e);
  }
}

class LinkBancos implements ActionListener
{
  private Guinges adaptee;
  LinkBancos(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  /**
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
    adaptee.linkbancos(e);
  }
}

class MenuFileExit implements ActionListener
{
  private Guinges adaptee;
  MenuFileExit(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  /**
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
    adaptee.mnuFileExit_actionPerformed(e);
  }
}

class GuingesFrame_pupUpMenu_mouseAdapter extends MouseAdapter
{
  private Guinges adaptee;
  GuingesFrame_pupUpMenu_mouseAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }
}

class GuingesFrame_this_windowAdapter extends WindowAdapter
{
  private Guinges adaptee;
  GuingesFrame_this_windowAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }

  /**
   * Evento para cerrar la ventana
   * @param e WindowEvent
   */
  public void windowClosing(WindowEvent e)
  {
    adaptee.this_windowClosing(e);
  }
}

class GuingesFrame_this_mouseAdapter extends MouseAdapter
{
  private Guinges adaptee;
  GuingesFrame_this_mouseAdapter(Guinges adaptee)
  {
    this.adaptee = adaptee;
  }
}
