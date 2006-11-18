/**
 * FrmBancos.java
 * */
package com.carama.app.guinges.ui.bancos;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.InternalFrameUI;

import com.borland.jbcl.layout.*;
import com.carama.app.guinges.db.connection.Conexion;
import com.carama.app.guinges.db.datos.metadata.JDBCUtils;
import com.carama.app.guinges.db.model.GuingesTableModel;
import com.carama.app.guinges.utils.*;
import com.l2fprod.common.swing.JTaskPaneGroup;
import org.jdesktop.swingx.*;

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
public class FrmBancos extends JInternalFrame
{
  /**
   * Constante que contendra el nombre de la tabla
   * */
  private static final String TABLENAME = "bancos";

  /**
   * Conexion
   * */
  private Conexion conexion = new Conexion();

  /**
   * Clase que construye las consultas on runTime
   * */
  private JDBCUtils jdbcutils = new JDBCUtils(conexion.mkConection());
  private JDBCUtils xml = new JDBCUtils(conexion.mkConection());

  /**
   * Clase para construir la consulta para mostrar la tabla
   * */
  private JDBCUtils tableSelect = new JDBCUtils(conexion.mkConection());

  /**
   * Consulta para mostrar los datos de la tabla
   * */
  private String query = jdbcutils.toSelect(TABLENAME);
  /**
   * Conjunto de resultados
   * */
  private ResultSet rs = jdbcutils.resultset(query);

  /**
   * Clase tablemodel que vamos a usar con la tabla
   * */
  private GuingesTableModel model = new GuingesTableModel();

  /**
   * Clase para escribir el fichero guinges.logs
   * */
  private EscribeLogs logs = new EscribeLogs();

  /**
   * Clase para escribir el fichero guinges.properties
   * */
  private ConfigIni config = new ConfigIni();

  /**
   * Clase para mostrar la ruta de los ficheros
   * */
  private PathDirAndFiles files = new PathDirAndFiles();

  /**
   * Atributos
   *
   * */
  private boolean nuevoRegistro = false;
  private BorderLayout borderLayout1 = new BorderLayout();
  private JToolBar toolbar = new JToolBar();
  private JButton btnSalir = new JButton();
  private JButton btnImprimir = new JButton();
  private JButton btnGuardar = new JButton();
  private JButton btnBorrar = new JButton();
  private JButton btnNuevo = new JButton();
  private JCheckBox cboxDejarFijo = new JCheckBox();
  private JCheckBox cbMostrarAyuda = new JCheckBox();
  private JTabbedPane tbpane = new JTabbedPane();
  private JXPanel panelGrupo = new JXPanel();
  private JXPanel panelsur = new JXPanel();
  private VerticalFlowLayout verticalFlowLayout = new VerticalFlowLayout();
  private JPanel panelnavegacion = new JPanel();
  private JButton btnFin = new JButton();
  private JButton btnSiguiente = new JButton();
  private JButton btnReload = new JButton();
  private FlowLayout flowLayout1 = new FlowLayout();
  private JButton btnAnterior = new JButton();
  private JButton btnInicio = new JButton();
  private JComboBox cmbox = new JComboBox();
  private JTextField txtbuscar = new JTextField();
  private JButton btnIr = new JButton();
  private JPanel panelcodigo = new JPanel();
  private JLabel lblCodigo = new JLabel();
  private JTextField txtcodigo = new JTextField();
  private JLabel lbldescripcion = new JLabel();
  private JTextField txtdescripcion = new JTextField();
  private JLabel lblrazonsocial = new JLabel();
  private JTextField txtrazonsocial = new JTextField();
  private JLabel lblcontacto = new JLabel();
  private JLabel lbltelefono = new JLabel();
  private JTextField txtcontacto = new JTextField();
  private JPanel paneltitulo = new JPanel();
  private JTextField txttelefono = new JTextField();
  private JXPanel panelDetalle = new JXPanel();
  private XYLayout xYLayout1 = new XYLayout();
  private XYLayout xYLayout2 = new XYLayout();
  private JPanel panelnorte = new JPanel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private BorderLayout borderLayout3 = new BorderLayout();
  private JPanel panelcodcenter = new JPanel();
  private BorderLayout borderLayout4 = new BorderLayout();
  private BorderLayout borderLayout5 = new BorderLayout();
  private JLabel lbltitulo = new JLabel();
  private JScrollPane scrollpane = new JScrollPane();
  private JLabel label;
  private JComboBox cmboxfiltro = new JComboBox();
  private Border bordeAzul;
  private JLabel lblNotas = new JLabel();
  private JTextArea txtarea = new JTextArea();
  private JScrollPane scrpane = new JScrollPane();
  private JLabel lbltelefono2 = new JLabel();
  private JTextField txttelefono2 = new JTextField();
  private JPanel jpanelnorte = new JPanel();
  private BorderLayout borderLayout6 = new BorderLayout();
  private BorderLayout borderLayout7 = new BorderLayout();
  private final JTaskPaneGroup group = new JTaskPaneGroup();
  private JXTable tabla = new JXTable();
  private JPanel paneldescripcion = new JPanel();
  private TitledBorder titledborder = new TitledBorder("");
  private FlowLayout flowLayout2 = new FlowLayout();
  private JPanel paneldetalleMain = new JPanel();
  private VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();

  /**
   * Constructor de la clase
   *
   * @param title String
   * @param message JLabel
   */
  public FrmBancos(String title, JLabel message)
  {
    super(title);
    message.setText(title);
    this.label = message;
    try
    {
      jdbcutils.primero();
      btnAnterior.setEnabled(false);
      btnInicio.setEnabled(false);
      displayRows();
      jbInit();
      this.rs = jdbcutils.resultset(query);
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }

  private void displayRows() throws SQLException
  {
    if (jdbcutils.numeroFilasConsulta() > 0)
    {
      txtcodigo.setText(rs.getString(1));
      txtdescripcion.setText(rs.getString(2));
      txtrazonsocial.setText(rs.getString(3));
      txttelefono.setText(rs.getString(4));
      txtcontacto.setText(rs.getString(5));
      txttelefono2.setText(rs.getString(6));
      txtarea.setText(rs.getString(7));
    }
  }

  private void jbInit() throws Exception
  {
    llenarcmbox();
    ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //quitamos la barra de titulo de la ventana
    bordeAzul = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue, 1),
                                                   BorderFactory.createEmptyBorder(0, 5, 0, 0));
    this.setSize(800, 680);
    getContentPane().setLayout(borderLayout1);
    btnSalir.setOpaque(false);
    model.configureHighlighters(tabla);
    //tabla.setTableHeader(model.tooltipHeader(tabla));
    btnSalir.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/exit.png")));
    btnSalir.addActionListener(new BotonSalir(this));
    btnImprimir.setOpaque(false);
    btnImprimir.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/print.png")));
    btnGuardar.setOpaque(false);
    btnGuardar.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/save.png")));
    btnGuardar.addActionListener(new BotonGuardar(this));
    btnBorrar.setOpaque(false);
    btnBorrar.setToolTipText("");
    llenarfiltro();
    btnBorrar.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/editdelete.png")));
    btnBorrar.addActionListener(new BotonBorrar(this));
    btnNuevo.setOpaque(false);
    btnNuevo.setHorizontalAlignment(SwingConstants.RIGHT);
    btnNuevo.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/new.png")));
    btnNuevo.addActionListener(new BotonNuevo(this));
    cboxDejarFijo.setOpaque(false);
    cboxDejarFijo.setText("Menu fijo");
    cboxDejarFijo.addActionListener(new FrmBancos_cbDejarFijo_actionAdapter(this));

    /**
     * Toolbar
     * */
    toolbar.setEnabled(true);
    toolbar.setBorder(null);
    toolbar.setFloatable(false);
    toolbar.setOpaque(false);
    toolbar.setMargin(new Insets(5, 5, 5, 0));
    txtcodigo.setBorder(bordeAzul);
    txtcodigo.setEditable(false);
    btnIr.addActionListener(new BotonIr(this));
    jpanelnorte.setLayout(borderLayout6);
    group.getContentPane().setLayout(borderLayout7);
    jpanelnorte.setBorder(null);
    jpanelnorte.setOpaque(false);
    this.setBorder(null);
    this.addInternalFrameListener(new FrmBancos_this_internalFrameAdapter(this));
    tbpane.setBorder(titledborder);
    panelGrupo.setBorder(null);
    panelGrupo.addComponentListener(new PanelGrupo(this));
    txtdescripcion.setBorder(bordeAzul);
    scrpane.setBorder(null);
    scrpane.setOpaque(false);
    group.setSpecial(true);
    group.setOpaque(true);
    txtarea.setBorder(bordeAzul);
    txtarea.setOpaque(true);
    txtarea.setPreferredSize(new Dimension(0, 60));
    txtarea.setLineWrap(true);
    txtarea.setWrapStyleWord(true);
    txtarea.addFocusListener(new TxtArea(this));
    txttelefono2.addFocusListener(new TxtTelefono2(this));
    tabla.addMouseListener(new Tabla(this));
    txtbuscar.addKeyListener(new TxtBuscar(this));
    tabla.addKeyListener(new FrmBancos_tabla_keyAdapter(this));
    paneldescripcion.setBorder(titledborder);
    paneldescripcion.setLayout(flowLayout2);
    panelcodigo.setBorder(null);
    panelcodigo.setPreferredSize(new Dimension(616, 190));
    panelDetalle.setBorder(null);
    panelnavegacion.setBorder(titledborder);
    paneldetalleMain.setLayout(verticalFlowLayout1);
    panelnorte.setBorder(titledborder);
    panelcodcenter.setBorder(titledborder);
    paneldetalleMain.setPreferredSize(new Dimension(636, 300));
    panelsur.setBorder(null);
    txtrazonsocial.setBorder(bordeAzul);
    txttelefono.setBorder(bordeAzul);
    btnReload.addActionListener(new FrmBancos_btnReload_actionAdapter(this));
    toolbar.add(btnNuevo);
    toolbar.add(btnBorrar);
    toolbar.add(btnGuardar);
    toolbar.add(btnImprimir);
    toolbar.add(btnSalir);
    toolbar.add(cboxDejarFijo);
    toolbar.add(cbMostrarAyuda);
    cbMostrarAyuda.setOpaque(false);
    cbMostrarAyuda.setText("Mostrar textos de ayuda");
    panelGrupo.setLayout(borderLayout2);
    panelsur.setLayout(verticalFlowLayout);
    btnReload.setPreferredSize(new Dimension(20, 20));
    btnReload.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/reload.png")));
    btnFin.setPreferredSize(new Dimension(20, 20));
    btnFin.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/player_end.png")));
    btnFin.addActionListener(new BotonFin(this));
    btnSiguiente.setMinimumSize(new Dimension(26, 26));
    btnSiguiente.setPreferredSize(new Dimension(20, 20));
    btnSiguiente.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/player_fwd.png")));
    btnSiguiente.addActionListener(new BotonSiguiente(this));
    panelnavegacion.setLayout(flowLayout1);
    panelnavegacion.setOpaque(false);
    panelnavegacion.setPreferredSize(new Dimension(245, 36));
    btnAnterior.setPreferredSize(new Dimension(20, 20));
    btnAnterior.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/player_rew.png")));
    btnAnterior.addActionListener(new BotonAnterior(this));
    btnInicio.setPreferredSize(new Dimension(20, 20));
    btnInicio.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/player_start.png")));
    btnInicio.addActionListener(new BotonInicio(this));
    btnIr.setPreferredSize(new Dimension(20, 20));
    btnIr.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/ok.png")));
    panelsur.setPreferredSize(new Dimension(255, 50));
    txtbuscar.setBorder(bordeAzul);
    txtbuscar.setPreferredSize(new Dimension(100, 20));
    this.setResizable(true);
    this.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    cmbox.setPreferredSize(new Dimension(180, 20));
    lblCodigo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblCodigo.setText("Código");
    txtcodigo.setBackground(new Color(206, 248, 255));
    txtcodigo.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtcodigo.setPreferredSize(new Dimension(120, 20));
    txtcodigo.setHorizontalAlignment(SwingConstants.RIGHT);
    txtcodigo.addFocusListener(new TxtCodigo(this));
    lbldescripcion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lbldescripcion.setText("Descripción");
    txtdescripcion.setBackground(new Color(206, 248, 255));
    txtdescripcion.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtdescripcion.setPreferredSize(new Dimension(210, 20));
    txtdescripcion.setToolTipText("");
    txtdescripcion.setMargin(new Insets(5, 0, 0, 0));
    txtdescripcion.addFocusListener(new TxtDescripcion(this));
    lblrazonsocial.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblrazonsocial.setText("Razón social");
    txtrazonsocial.setBackground(new Color(206, 248, 255));
    txtrazonsocial.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtrazonsocial.setPreferredSize(new Dimension(40, 18));
    txtrazonsocial.addFocusListener(new TxtRazonSocial(this));
    lblcontacto.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblcontacto.setText("Contacto");
    lbltelefono.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lbltelefono.setText("Teléfono");
    txtcontacto.setBackground(new Color(206, 248, 255));
    txtcontacto.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtcontacto.setBorder(bordeAzul);
    txtcontacto.setPreferredSize(new Dimension(40, 18));
    txtcontacto.addFocusListener(new TxtContacto(this));
    txttelefono.setBackground(new Color(206, 248, 255));
    txttelefono.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txttelefono.setPreferredSize(new Dimension(40, 18));
    txttelefono.addFocusListener(new TxtGrupo(this));
    paneltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    paneltitulo.setMinimumSize(new Dimension(209, 50));
    paneltitulo.setPreferredSize(new Dimension(410, 100));
    paneltitulo.setLayout(xYLayout2);
    panelcodigo.setLayout(xYLayout1);
    panelnorte.setLayout(borderLayout3);
    panelcodcenter.setLayout(borderLayout4);
    panelDetalle.setLayout(borderLayout5);
    tbpane.setOpaque(true);
    lbltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
    lbltitulo.setIcon(new ImageIcon(com.carama.app.guinges.ui.bancos.FrmBancos.class.getResource(
        "../img/iconoFichas.png")));
    lbltitulo.setText("FICHA DE BANCOS");
    cmboxfiltro.setBorder(null);
    cmboxfiltro.setPreferredSize(new Dimension(120, 20));
    lblNotas.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblNotas.setText("Notas");
    txtarea.setBackground(new Color(206, 248, 255));
    txtarea.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    lbltelefono2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lbltelefono2.setText("Teléfono 2");
    txttelefono2.setBackground(new Color(206, 248, 255));
    txttelefono2.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txttelefono2.setBorder(bordeAzul);
    txttelefono2.setPreferredSize(new Dimension(40, 18));
    this.getContentPane().add(tbpane, java.awt.BorderLayout.CENTER);
    this.getContentPane().add(panelsur, java.awt.BorderLayout.SOUTH);
    panelsur.add(panelnavegacion);
    scrollpane.getViewport().add(tabla);
    panelnavegacion.add(cmbox);
    panelnavegacion.add(cmboxfiltro);
    panelnavegacion.add(txtbuscar);
    panelnavegacion.add(btnIr);
    panelnavegacion.add(btnInicio);
    panelnavegacion.add(btnAnterior);
    panelnavegacion.add(btnSiguiente, null);
    panelnavegacion.add(btnFin, null);
    panelnavegacion.add(btnReload, null);
    panelcodigo.add(txtrazonsocial, new XYConstraints(211, 9, 405, -1));
    panelcodigo.add(txttelefono, new XYConstraints(211, 37, 193, -1));
    panelcodigo.add(txttelefono2, new XYConstraints(211, 64, 193, -1));
    panelcodigo.add(txtcontacto, new XYConstraints(211, 89, 193, -1));
    panelcodigo.add(lblrazonsocial, new XYConstraints(80, 9, 87, -1));
    panelcodigo.add(lbltelefono, new XYConstraints(80, 37, 62, -1));
    panelcodigo.add(lbltelefono2, new XYConstraints(80, 64, -1, -1));
    panelcodigo.add(lblNotas, new XYConstraints(80, 117, -1, -1));
    panelcodigo.add(lblcontacto, new XYConstraints(80, 89, 121, -1));
    panelcodigo.add(scrpane, new XYConstraints(133, 115, 428, 65));
    scrpane.getViewport().add(txtarea);
    panelcodcenter.add(panelcodigo, java.awt.BorderLayout.CENTER);
    paneldescripcion.add(lblCodigo);
    paneldescripcion.add(txtcodigo);
    paneldescripcion.add(lbldescripcion);
    paneldescripcion.add(txtdescripcion);
    this.getContentPane().add(jpanelnorte, java.awt.BorderLayout.NORTH);
    jpanelnorte.add(group, java.awt.BorderLayout.NORTH);
    group.setTitle(label.getText());
    group.getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);
    panelGrupo.add(scrollpane, java.awt.BorderLayout.CENTER);
    tbpane.add(panelGrupo, "Grupo");
    tbpane.add(panelDetalle, "Detalle");
    panelDetalle.add(paneldetalleMain, java.awt.BorderLayout.CENTER);
    paneldetalleMain.add(panelnorte);
    panelnorte.add(paneltitulo, java.awt.BorderLayout.NORTH);
    paneltitulo.add(lbltitulo, new XYConstraints(85, 15, 325, 68));
    paneldetalleMain.add(paneldescripcion);
    paneldetalleMain.add(panelcodcenter);
    tbpane.setSelectedComponent(panelDetalle);
    tbpane.setSelectedIndex(0);
  }

  private void mostrarmenu()
  {
    if (config.obtenerValorIni(files.iniFileName(), "mostrar.menu").equals("true"))
    {
      group.setExpanded(true);
      cboxDejarFijo.setSelected(true);
    }
    else
    {
      group.setExpanded(false);
      cboxDejarFijo.setSelected(false);
    }
  }

  private void filtroTabla()
  {
    if (!txtbuscar.equals(""))
    {
      try
      {
        query = tableSelect.selectWithFilterClause(TABLENAME, cmbox.getSelectedIndex(),
                                                   cmboxfiltro.getSelectedIndex() + 1,
                                                   txtbuscar.getText());
        tabla.setModel(model.mostrarGrupo(conexion.mkConection(), query));
      }
      catch (Exception ex)
      {
        logs.escribeError(ex.getLocalizedMessage(), false);
      }
    }
  }

  private void llenarcmbox()
  {
    String[] camposTabla = null;
    try
    {
      camposTabla = jdbcutils.camposTabla(TABLENAME.toUpperCase());
    }
    catch (Exception ex)
    {
      logs.escribeError(ex.getMessage(), false);
    }
    for (String str : camposTabla)
    {
      if (str.contains("_"))
      {
        str = str.replace('_', ' ');
      }
      if (str.contains("NOTAS"))
      {
        continue;
      }
      cmbox.addItem(str);
    }
    cmbox.setSelectedIndex(1);
  }

  private void limpiarCamposTexto()
  {
    try
    {
      txtcodigo.setText(Integer.toString(jdbcutils.numeroFilasConsulta() + 1));
    }
    catch (Exception ex)
    {
      logs.escribeError(ex.getMessage() + " " + ex.getLocalizedMessage(), false);
    }
    txtdescripcion.setText("");
    txttelefono.setText("");
    txttelefono2.setText("");
    txtrazonsocial.setText("");
    txtcontacto.setText("");
    txtarea.setText("");
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
      cmboxfiltro.addItem(str);
    }
    cmboxfiltro.setSelectedIndex(8);
  }

  /**
   * Boton salir
   *
   * @param e ActionEvent
   */
  public void btnSalir_actionPerformed(ActionEvent e)
  {
    label.setText("Listo ");
    conexion.closeConecction();
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
    txtcodigo.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto codigo pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcodigo_focusLost(FocusEvent e)
  {
    txtcodigo.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto descripcion gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtdescripcion_focusGained(FocusEvent e)
  {
    txtdescripcion.setBackground(new Color(255, 255, 255));
    txtdescripcion.selectAll();
  }

  /**
   * Caja de texto descripcion pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtdescripcion_focusLost(FocusEvent e)
  {
    txtdescripcion.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto razonsocial gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtrazonsocial_focusGained(FocusEvent e)
  {
    txtrazonsocial.setBackground(new Color(255, 255, 255));
    txtrazonsocial.selectAll();
  }

  /**
   * Caja de texto telefono gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txttelefono_focusGained(FocusEvent e)
  {
    txttelefono.setBackground(new Color(255, 255, 255));
    txttelefono.selectAll();
  }

  /**
   * Caja de texto contacto gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcontacto_focusGained(FocusEvent e)
  {
    txtcontacto.setBackground(new Color(255, 255, 255));
    txtcontacto.selectAll();
  }

  /**
   * Caja de texto razonsocial pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtrazonsocial_focusLost(FocusEvent e)
  {
    txtrazonsocial.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto telefono pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txttelefono_focusLost(FocusEvent e)
  {
    txttelefono.setBackground(new Color(206, 248, 255));
  }

  /**
   * Caja de texto contacto pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txtcontacto_focusLost(FocusEvent e)
  {
    txtcontacto.setBackground(new Color(206, 248, 255));
  }

  /**
   * Boton siguiente
   *
   * @param e ActionEvent
   */
  public void btnSiguiente_actionPerformed(ActionEvent e)
  {
    try
    {
      jdbcutils.siguiente();
      displayRows();
      btnAnterior.setEnabled(true);
      btnInicio.setEnabled(true);
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Boton anterior
   *
   * @param e ActionEvent
   */
  public void btnAnterior_actionPerformed(ActionEvent e)
  {
    try
    {
      jdbcutils.anterior();
      displayRows();
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Boton Inicio
   *
   * @param e ActionEvent
   */
  public void btnInicio_actionPerformed(ActionEvent e)
  {
    try
    {
      jdbcutils.primero();
      displayRows();
      btnInicio.setEnabled(false);
      btnAnterior.setEnabled(false);
      btnSiguiente.setEnabled(true);
      btnFin.setEnabled(true);
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Boton fin
   *
   * @param e ActionEvent
   */
  public void btnFin_actionPerformed(ActionEvent e)
  {
    try
    {
      jdbcutils.ultimo();
      displayRows();
      btnFin.setEnabled(false);
      btnSiguiente.setEnabled(false);
      btnInicio.setEnabled(true);
      btnAnterior.setEnabled(true);
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Hacemos clic en el Boton nuevo
   *
   * @param e ActionEvent
   */
  public void btnNuevo_actionPerformed(ActionEvent e)
  {
    btnNuevo.setEnabled(false);
    txtdescripcion.requestFocus();
    nuevoRegistro = true;
    limpiarCamposTexto();
  }

  /**
   * Hacemos clic en el Boton ir
   *
   * @param e ActionEvent
   */
  public void btnIr_actionPerformed(ActionEvent e)
  {
    filtroTabla();
  }

  /**
   *
   * @param e ActionEvent
   */
  public void btnGuardar_actionPerformed(ActionEvent e)
  {
    ArrayList<String> update = new ArrayList<String>();
    if (nuevoRegistro)
    {
      if (!txtdescripcion.getText().equals(""))
      {
        update.add("'" + txtdescripcion.getText() + "', ");
        update.add("'" + txtrazonsocial.getText() + "' ,");
        update.add("'" + txttelefono.getText() + "' ,");
        update.add("'" + txtcontacto.getText() + "' ,");
        update.add("'" + txttelefono2.getText() + "' ,");
        update.add("'" + txtarea.getText() + "'");
        try
        {
          jdbcutils.insertSQL(TABLENAME, update);
          this.rs = jdbcutils.resultset(query);
          this.rs.absolute(Integer.parseInt(txtcodigo.getText()));
        }
        catch (Exception ex)
        {
          logs.escribeError(ex.getLocalizedMessage(), false);
        }
      }
      else
      {
        try
        {
          this.rs = jdbcutils.resultset(query);
          this.rs.absolute(Integer.parseInt(txtcodigo.getText()) - 1);
        }
        catch (SQLException ex)
        {
          logs.escribeError(ex.getLocalizedMessage(), false);
        }
      }
      btnNuevo.setEnabled(true);
      nuevoRegistro = false;
    }
    else
    {
      update.add("DESCRIPCION='" + txtdescripcion.getText() + "', ");
      update.add("TELEFONO='" + txttelefono.getText() + "', ");
      update.add("RAZON_SOCIAL='" + txtrazonsocial.getText() + "', ");
      update.add("TELEFONO2='" + txttelefono2.getText() + "', ");
      update.add("PERSONA_CONTACTO='" + txtcontacto.getText() + "', ");
      update.add("NOTAS='" + txtarea.getText() + "'");
      try
      {
        jdbcutils.toUpdate(TABLENAME, update, txtcodigo.getText());
        this.rs = jdbcutils.resultset(query);
        this.rs.absolute(Integer.parseInt(txtcodigo.getText()));
      }
      catch (Exception ex)
      {
        logs.escribeError(ex.getLocalizedMessage(), false);
      }
    }
  }

  /**
   *
   * @param e ComponentEvent
   */
  public void panelGrupo_componentShown(ComponentEvent e)
  {
    String select = tableSelect.toSelect(TABLENAME);
    /**
     * Mostramos la tabla con el tableModel correspondiente
     */
    tabla.setModel(model.mostrarGrupo(conexion.mkConection(), select));
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtarea_focusGained(FocusEvent e)
  {
    txtarea.setBackground(new Color(255, 255, 255));
    txtarea.selectAll();
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txttelefono2_focusGained(FocusEvent e)
  {
    txttelefono2.setBackground(new Color(255, 255, 255));
    txttelefono2.selectAll();
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txttelefono2_focusLost(FocusEvent e)
  {
    txttelefono2.setBackground(new Color(206, 248, 255));
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtarea_focusLost(FocusEvent e)
  {
    txtarea.setBackground(new Color(206, 248, 255));
  }

  /**
   * @param e FocusEvent
   * */
  public void tabla_mouseClicked(MouseEvent e)
  {
    if (e.getClickCount() == 2)
    {
      selectTableRow();
    }
  }

  private void selectTableRow()
  {
    try
    {
      /**
       * Seleccionamos la fila y la columna que estamos haciendo
       * click, en este caso vamos la tener la siguiente coordenada
       * tabla(?,0) para tener siempre escogida la primera columna ya que la
       * fila aun no la sabemos por eso ponemos un "?" en su lugar.
       * */
      int rowIndex = tabla.getSelectedRow();
      final int mColIndex = 0;
      Object o = tabla.getModel().getValueAt(rowIndex, mColIndex);
      System.out.println(tabla.getColumnName(tabla.getSelectedColumn()).toString());
      System.out.println(o.toString());
      tbpane.setSelectedIndex(1);
      jdbcutils.irRegistro(Integer.parseInt(o.toString()));
      displayRows();
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }

  }

  /**
   *
   * @param e KeyEvent
   */
  public void txtbuscar_keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == 10)
    {
      filtroTabla();
    }
    System.out.println(e.getKeyCode());
  }

  /**
   *
   * @param e KeyEvent
   */
  public void botonBorrar(ActionEvent e)
  {
    if (!txtcodigo.equals(""))
    {
      jdbcutils.toDelete(TABLENAME, Integer.parseInt(txtcodigo.getText()));
      this.rs = jdbcutils.resultset(query);
      try
      {
        this.rs.absolute(Integer.parseInt(txtcodigo.getText()) - 1);
      }
      catch (NumberFormatException ex)
      {
        logs.escribeError(ex.getLocalizedMessage(), false);
      }
      catch (SQLException ex)
      {
        logs.escribeError(ex.getLocalizedMessage(), false);
      }
    }
  }

  /**
   *
   * @param e KeyEvent
   */
  public void tabla_keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == 10)
    {
      selectTableRow();
    }
  }

  public void cbDejarFijo_actionPerformed(ActionEvent e)
  {
    if (cboxDejarFijo.isSelected())
    {
      config.actualizarValorIni(files.iniFileName(), "mostrar.menu", "true");
    }
    else
    {
      config.actualizarValorIni(files.iniFileName(), "mostrar.menu", "false");
      group.setExpanded(false);
    }
  }

  public void this_internalFrameOpened(InternalFrameEvent e)
  {
    mostrarmenu();
  }

  public void btnReload_actionPerformed(ActionEvent e)
  {
    xml.exporXML(query, TABLENAME);
  }
}

class FrmBancos_btnReload_actionAdapter implements ActionListener
{
  private FrmBancos adaptee;
  FrmBancos_btnReload_actionAdapter(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnReload_actionPerformed(e);
  }
}

class FrmBancos_this_internalFrameAdapter extends InternalFrameAdapter
{
  private FrmBancos adaptee;
  FrmBancos_this_internalFrameAdapter(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void internalFrameOpened(InternalFrameEvent e)
  {
    adaptee.this_internalFrameOpened(e);
  }
}

class FrmBancos_cbDejarFijo_actionAdapter implements ActionListener
{
  private FrmBancos adaptee;
  FrmBancos_cbDejarFijo_actionAdapter(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.cbDejarFijo_actionPerformed(e);
  }
}

class BotonBorrar implements ActionListener
{
  private FrmBancos adaptee;
  BotonBorrar(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.botonBorrar(e);
  }
}

class TxtBuscar extends KeyAdapter
{
  private FrmBancos adaptee;
  TxtBuscar(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e)
  {
    adaptee.txtbuscar_keyPressed(e);
  }
}

class Tabla extends MouseAdapter
{
  private FrmBancos adaptee;
  Tabla(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e)
  {
    adaptee.tabla_mouseClicked(e);
  }
}

class FrmBancos_tabla_keyAdapter extends KeyAdapter
{
  private FrmBancos adaptee;
  FrmBancos_tabla_keyAdapter(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e)
  {
    adaptee.tabla_keyPressed(e);
  }
}

class TxtArea extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtArea(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txtarea_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txtarea_focusLost(e);
  }
}

class TxtTelefono2 extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtTelefono2(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txttelefono2_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txttelefono2_focusLost(e);
  }
}

class PanelGrupo extends java.awt.event.ComponentAdapter
{
  private FrmBancos adaptee;
  PanelGrupo(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void componentShown(ComponentEvent e)
  {
    adaptee.panelGrupo_componentShown(e);
  }
}

class BotonGuardar implements ActionListener
{
  private FrmBancos adaptee;
  BotonGuardar(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnGuardar_actionPerformed(e);
  }
}

class BotonIr implements ActionListener
{
  private FrmBancos adaptee;
  BotonIr(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  /**
   *
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnIr_actionPerformed(e);
  }
}

class BotonNuevo implements ActionListener
{
  private FrmBancos adaptee;
  BotonNuevo(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnNuevo_actionPerformed(e);
  }
}

class BotonFin implements ActionListener
{
  private FrmBancos adaptee;
  BotonFin(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnFin_actionPerformed(e);
  }
}

class BotonInicio implements ActionListener
{
  private FrmBancos adaptee;
  BotonInicio(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnInicio_actionPerformed(e);
  }
}

class BotonAnterior implements ActionListener
{
  private FrmBancos adaptee;
  BotonAnterior(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnAnterior_actionPerformed(e);
  }
}

class BotonSiguiente implements ActionListener
{
  private FrmBancos adaptee;
  BotonSiguiente(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnSiguiente_actionPerformed(e);
  }
}

class TxtContacto extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtContacto(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txtcontacto_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txtcontacto_focusLost(e);
  }
}

class TxtGrupo extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtGrupo(FrmBancos adaptee)
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

class TxtCodigo extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtCodigo(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txtcodigo_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txtcodigo_focusLost(e);
  }
}

class TxtRazonSocial extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtRazonSocial(FrmBancos adaptee)
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

class TxtDescripcion extends FocusAdapter
{
  private FrmBancos adaptee;
  TxtDescripcion(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void focusGained(FocusEvent e)
  {
    adaptee.txtdescripcion_focusGained(e);
  }

  public void focusLost(FocusEvent e)
  {
    adaptee.txtdescripcion_focusLost(e);
  }
}

class BotonSalir implements ActionListener
{
  private FrmBancos adaptee;
  BotonSalir(FrmBancos adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnSalir_actionPerformed(e);
  }
}
