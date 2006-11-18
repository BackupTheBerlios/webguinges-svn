/**
 * FrmPoblacion.java
 * */
package com.carama.app.guinges.ui.poplacion;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.InternalFrameUI;

import com.borland.jbcl.layout.*;
import com.carama.app.guinges.utils.EscribeLogs;
import com.l2fprod.common.swing.JTaskPaneGroup;
import org.jdesktop.swingx.*;
import com.carama.app.guinges.ui.provincia.dlg.DlgProvincia;
import java.awt.Font;
import com.carama.app.guinges.db.model.GuingesTableModel;
import java.sql.ResultSet;
import com.carama.app.guinges.db.datos.metadata.JDBCUtils;
import com.carama.app.guinges.db.connection.Conexion;
import com.carama.app.guinges.utils.ConfigIni;
import com.carama.app.guinges.utils.PathDirAndFiles;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameAdapter;

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
public class FrmPoblacion extends JInternalFrame
{
  /**
   * Constante que contendra el nombre de la tabla
   * */
  private static final String TABLENAME = "poblacion";

  /**
   * Conexion
   * */
  private Conexion conexion = new Conexion();

  /**
   * Clase que construye las consultas on runTime
   * */
  private JDBCUtils strSQL = new JDBCUtils(conexion.mkConection());

  /**
   * Clase para construir la consulta para mostrar la tabla
   * */
  private JDBCUtils tableSelect = new JDBCUtils(conexion.mkConection());

  /**
   * Consulta para mostrar los datos de la tabla
   * */
  private String query = strSQL.toSelect(TABLENAME);
  /**
   * Conjunto de resultados
   * */
  private ResultSet rs = strSQL.resultset(query);

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
  private FlowLayout flowLayout1 = new FlowLayout();
  private JButton btnAnterior = new JButton();
  private JButton btnInicio = new JButton();
  private JComboBox cmbox = new JComboBox();
  private JTextField txtbuscar = new JTextField();
  private JButton btnIr = new JButton();
  private JPanel panelcodigo = new JPanel();
  private JLabel lblCodigo = new JLabel("Código");
  private JTextField txtcodigo = new JTextField();
  private JLabel lbldescripcion = new JLabel("Descripción");
  private JTextField txtdescripcion = new JTextField();
  private JLabel lblcp = new JLabel();
  private JPanel paneltitulo = new JPanel();
  private JTextField txtcodpostal = new JTextField();
  private JXPanel panelDetalle = new JXPanel();
  private XYLayout xYLayout = new XYLayout();
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
  private JLabel lblcodprovincia = new JLabel();
  private JTextField txtnumprov = new JTextField();
  private JPanel jpanelnorte = new JPanel();
  private BorderLayout borderLayout6 = new BorderLayout();
  private BorderLayout borderLayout7 = new BorderLayout();
  private JTaskPaneGroup group = new JTaskPaneGroup();
  private JXTable tabla = new JXTable();
  private JPanel paneldescripcion = new JPanel();
  private TitledBorder titledborder = new TitledBorder("");
  private FlowLayout flowLayout2 = new FlowLayout();
  private JPanel paneldetalleMain = new JPanel();
  private JButton botonBuscar = new JButton();
  private JTextField txtcodprovincia = new JTextField();
  private JTabbedPane tabbedpane = new JTabbedPane();
  private BorderLayout borderLayout8 = new BorderLayout();
  private JXPanel panelgeneral = new JXPanel();
  private VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
  private JXPanel panelClientes = new JXPanel();
  private JXPanel panelProveedores = new JXPanel();
  private BorderLayout borderLayout9 = new BorderLayout();
  private BorderLayout borderLayout10 = new BorderLayout();
  private JScrollPane scrollpaneclientes = new JScrollPane();
  private JXTable tablaclientes = new JXTable();
  private JXTable tablaproveedores = new JXTable();
  private JScrollPane scrollpaneproveedores = new JScrollPane();

  /**
   * Constructor de la clase
   *
   * @param title String
   * @param message JLabel
   */
  public FrmPoblacion(String title, JLabel message)
  {
    super(title);
    message.setText(title);
    this.label = message;
    try
    {
      strSQL.primero();
      btnAnterior.setEnabled(false);
      btnInicio.setEnabled(false);
      displayRows();
      jbInit();
      this.rs = strSQL.resultset(query);
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }

  private void displayRows() throws SQLException
  {
    /*if (strSQL.numeroFilasConsulta() > 0)
         {
      txtcodigo.setText(rs.getString(1));
      txtdescripcion.setText(rs.getString(2));
      txttelefono.setText(rs.getString(4));
      txttelefono2.setText(rs.getString(6));
         }*/
  }

  private void jbInit() throws Exception
  {
    //llenarcmbox();
    ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //quitamos la barra de titulo de la ventana
    bordeAzul = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue, 1),
                                                   BorderFactory.createEmptyBorder(0, 5, 0, 0));
    this.setSize(800, 680);
    getContentPane().setLayout(borderLayout1);
    btnSalir.setOpaque(false);
    //model.configureHighlighters(tabla);
    btnSalir.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/exit.png")));
    btnSalir.addActionListener(new BotonSalir(this));
    btnImprimir.setOpaque(false);
    btnImprimir.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/print.png")));
    btnGuardar.setOpaque(false);
    btnGuardar.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/save.png")));
    btnGuardar.addActionListener(new BotonGuardar(this));
    btnBorrar.setOpaque(false);
    llenarfiltro();
    btnBorrar.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/editdelete.png")));
    btnBorrar.addActionListener(new BotonBorrar(this));
    btnNuevo.setOpaque(false);
    btnNuevo.setHorizontalAlignment(SwingConstants.RIGHT);
    btnNuevo.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/new.png")));
    btnNuevo.addActionListener(new BotonNuevo(this));
    cboxDejarFijo.setOpaque(false);
    cboxDejarFijo.setText("Menu fijo");

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
    tbpane.setBorder(titledborder);
    panelGrupo.setBorder(null);
    panelGrupo.addComponentListener(new PanelGrupo(this));
    txtdescripcion.setBorder(bordeAzul);
    group.setSpecial(true);
    group.setExpanded(false);
    group.setOpaque(true);
    txtnumprov.addFocusListener(new TxtTelefono2(this));
    tabla.addMouseListener(new Tabla(this));
    txtbuscar.addKeyListener(new TxtBuscar(this));
    paneldescripcion.setBorder(titledborder);
    paneldescripcion.setLayout(flowLayout2);
    panelcodigo.setBorder(null);
    panelcodigo.setPreferredSize(new Dimension(616, 190));
    panelDetalle.setBorder(null);
    panelnavegacion.setBorder(titledborder);
    paneldetalleMain.setLayout(borderLayout8);
    panelnorte.setBorder(titledborder);
    panelcodcenter.setBorder(titledborder);
    paneldetalleMain.setPreferredSize(new Dimension(636, 300));
    panelsur.setBorder(null);
    txtcodpostal.setBorder(bordeAzul);
    botonBuscar.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/kfilereplace.png")));
    botonBuscar.setText("Provincias");
    botonBuscar.addActionListener(new FrmPoblacion_botonBuscar_actionAdapter(this));
    txtcodprovincia.setBackground(new Color(206, 248, 255));
    txtcodprovincia.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtcodprovincia.setBorder(bordeAzul);
    txtcodprovincia.setPreferredSize(new Dimension(4, 20));
    txtcodprovincia.setEditable(false);
    txtcodprovincia.setText("");
    panelgeneral.setLayout(verticalFlowLayout1);
    tabbedpane.setBorder(null);
    panelgeneral.setBorder(null);
    panelClientes.setBorder(null);
    panelClientes.setLayout(borderLayout9);
    panelProveedores.setBorder(null);
    panelProveedores.setLayout(borderLayout10);
    this.setBorder(null);
    this.addInternalFrameListener(new FrmPoblacion_this_internalFrameAdapter(this));
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
    btnFin.setPreferredSize(new Dimension(20, 20));
    btnFin.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/player_end.png")));
    btnFin.addActionListener(new BotonFin(this));
    btnSiguiente.setMinimumSize(new Dimension(26, 26));
    btnSiguiente.setPreferredSize(new Dimension(20, 20));
    btnSiguiente.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/player_fwd.png")));
    btnSiguiente.addActionListener(new BotonSiguiente(this));
    panelnavegacion.setLayout(flowLayout1);
    panelnavegacion.setOpaque(false);
    panelnavegacion.setPreferredSize(new Dimension(245, 36));
    btnAnterior.setPreferredSize(new Dimension(20, 20));
    btnAnterior.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/player_rew.png")));
    btnAnterior.addActionListener(new BotonAnterior(this));
    btnInicio.setPreferredSize(new Dimension(20, 20));
    btnInicio.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/player_start.png")));
    btnInicio.addActionListener(new BotonInicio(this));
    btnIr.setPreferredSize(new Dimension(20, 20));
    btnIr.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/ok.png")));
    panelsur.setPreferredSize(new Dimension(255, 50));
    txtbuscar.setBorder(bordeAzul);
    txtbuscar.setPreferredSize(new Dimension(100, 20));
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
    txtdescripcion.setMargin(new Insets(5, 0, 0, 0));
    txtdescripcion.addFocusListener(new TxtDescripcion(this));
    lblcp.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblcp.setText("Cód. Postal");
    txtcodpostal.setBackground(new Color(206, 248, 255));
    txtcodpostal.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtcodpostal.setPreferredSize(new Dimension(40, 18));
    txtcodpostal.addFocusListener(new TxtGrupo(this));
    paneltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    paneltitulo.setMinimumSize(new Dimension(209, 50));
    paneltitulo.setPreferredSize(new Dimension(410, 100));
    panelcodigo.setLayout(xYLayout);
    panelnorte.setLayout(borderLayout3);
    panelcodcenter.setLayout(borderLayout4);
    panelDetalle.setLayout(borderLayout5);
    tbpane.setOpaque(true);
    lbltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
    lbltitulo.setText(label.getText().toUpperCase());
    lbltitulo.setIcon(new ImageIcon(com.carama.app.guinges.ui.poplacion.FrmPoblacion.class.getResource(
        "../img/iconoFichas.png")));
    cmboxfiltro.setBorder(null);
    cmboxfiltro.setPreferredSize(new Dimension(120, 20));
    lblcodprovincia.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    lblcodprovincia.setText("Cód. Provincia");
    txtnumprov.setBackground(new Color(206, 248, 255));
    txtnumprov.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
    txtnumprov.setBorder(bordeAzul);
    txtnumprov.setPreferredSize(new Dimension(40, 18));
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
    tabbedpane.add(panelgeneral, "General");
    tabbedpane.add(panelClientes, "Clientes");
    tabbedpane.add(panelProveedores, "Proveedores");
    paneldescripcion.add(lblCodigo);
    paneldescripcion.add(txtcodigo);
    paneldescripcion.add(lbldescripcion);
    paneldescripcion.add(txtdescripcion);
    panelgeneral.add(paneldescripcion);
    panelgeneral.add(panelcodcenter);
    panelcodcenter.add(panelcodigo, java.awt.BorderLayout.CENTER);
    this.getContentPane().add(jpanelnorte, java.awt.BorderLayout.NORTH);
    jpanelnorte.add(group, java.awt.BorderLayout.NORTH);
    group.setTitle(label.getText());
    group.getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);
    panelGrupo.add(scrollpane, java.awt.BorderLayout.CENTER);
    tbpane.add(panelGrupo, "Grupo");
    tbpane.add(panelDetalle, "Detalle");
    panelDetalle.add(paneldetalleMain, java.awt.BorderLayout.CENTER);
    panelnorte.add(paneltitulo, java.awt.BorderLayout.NORTH);
    paneldetalleMain.add(tabbedpane, java.awt.BorderLayout.CENTER);
    paneldetalleMain.add(panelnorte, java.awt.BorderLayout.NORTH);
    panelcodigo.add(lblcp, new XYConstraints(83, 33, 90, -1));
    panelcodigo.add(txtcodprovincia, new XYConstraints(246, 63, 190, -1));
    panelcodigo.add(lblcodprovincia, new XYConstraints(74, 69, -1, -1));
    panelcodigo.add(botonBuscar, new XYConstraints(461, 59, 127, -1));
    panelcodigo.add(txtcodpostal, new XYConstraints(203, 30, 90, -1));
    panelcodigo.add(txtnumprov, new XYConstraints(202, 64, 35, -1));
    panelClientes.add(scrollpaneclientes, java.awt.BorderLayout.CENTER);
    scrollpaneclientes.getViewport().add(tablaclientes);
    panelProveedores.add(scrollpaneproveedores, java.awt.BorderLayout.CENTER);
    scrollpaneproveedores.getViewport().add(tablaproveedores);
    paneltitulo.add(lbltitulo, null);
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
        /* query = tableFilter.selectWithFilterClause(TABLENAME, cmbox.getSelectedIndex(),
                                                    cmboxfiltro.getSelectedIndex() + 1,
                                                    txtbuscar.getText());
         tabla.setModel(model.mostrarGrupo(conexion.mkConection(), query));*/
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
      //camposTabla = strSQL.camposTabla(TABLENAME.toUpperCase());
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
      txtcodigo.setText(Integer.toString(strSQL.numeroFilasConsulta() + 1));
    }
    catch (Exception ex)
    {
      logs.escribeError(ex.getMessage() + " " + ex.getLocalizedMessage(), false);
    }
    txtdescripcion.setText("");
    txtcodpostal.setText("");
    txtnumprov.setText("");
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
  }

  /**
   * Caja de texto telefono gana el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txttelefono_focusGained(FocusEvent e)
  {
    txtcodpostal.setBackground(new Color(255, 255, 255));
    txtcodpostal.selectAll();
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
  }

  /**
   * Caja de texto telefono pierde el foco y cambia de color
   *
   * @param e FocusEvent
   */
  public void txttelefono_focusLost(FocusEvent e)
  {
    txtcodpostal.setBackground(new Color(206, 248, 255));
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
   * Boton siguiente
   *
   * @param e ActionEvent
   */
  public void btnSiguiente_actionPerformed(ActionEvent e)
  {
    try
    {
      //strSQL.siguiente();
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
      //strSQL.anterior();
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
      //strSQL.primero();
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
      //strSQL.ultimo();
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
    /*ArrayList<String> update = new ArrayList<String>();
         if (nuevoRegistro)
         {
      if (!txtdescripcion.getText().equals(""))
      {
        update.add("'" + txtdescripcion.getText() + "', ");
        update.add("'" + txttelefono.getText() + "' ,");
        update.add("'" + txttelefono2.getText() + "' ,");
        try
        {
         strSQL.insertSQL(TABLENAME, update);
          this.rs = strSQL.resultset(query);
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
          this.rs = strSQL.resultset(query);
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
      update.add("TELEFONO2='" + txttelefono2.getText() + "', ");
      try
      {
        strSQL.updateSQL(TABLENAME, update, txtcodigo.getText());
        this.rs = strSQL.resultset(query);
        this.rs.absolute(Integer.parseInt(txtcodigo.getText()));
      }
      catch (Exception ex)
      {
        logs.escribeError(ex.getLocalizedMessage(), false);
      }
         }*/
  }

  /**
   *
   * @param e ComponentEvent
   */
  public void panelGrupo_componentShown(ComponentEvent e)
  {
    // String select = tableSelect.select(TABLENAME);
    /**
     * Mostramos la tabla con el tableModel correspondiente
     */
    // tabla.setModel(model.mostrarGrupo(conexion.mkConection(), select));
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtarea_focusGained(FocusEvent e)
  {
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txttelefono2_focusGained(FocusEvent e)
  {
    txtnumprov.setBackground(new Color(255, 255, 255));
    txtnumprov.selectAll();
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txttelefono2_focusLost(FocusEvent e)
  {
    txtnumprov.setBackground(new Color(206, 248, 255));
  }

  /**
   *
   * @param e FocusEvent
   */
  public void txtarea_focusLost(FocusEvent e)
  {
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
      //strSQL.irRegistro(Integer.parseInt(o.toString()));
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
      /*strSQL.deleteSQL(TABLENAME, Integer.parseInt(txtcodigo.getText()));
             this.rs = strSQL.resultset(query);
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
             }*/
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

  public void botonBuscar_actionPerformed(ActionEvent e)
  {
    DlgProvincia dlgprovincia = new DlgProvincia("Poblaciones disponibles", txtnumprov,
                                                 txtcodprovincia);
    Dimension dlgSize = this.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlgprovincia.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                             (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlgprovincia.setVisible(true);
    dlgprovincia.setAlwaysOnTop(true);
  }

  public void this_internalFrameOpened(InternalFrameEvent e)
  {
    mostrarmenu();
  }
}

class FrmPoblacion_this_internalFrameAdapter extends InternalFrameAdapter
{
  private FrmPoblacion adaptee;
  FrmPoblacion_this_internalFrameAdapter(FrmPoblacion adaptee)
  {
    this.adaptee = adaptee;
  }

  public void internalFrameOpened(InternalFrameEvent e)
  {
    adaptee.this_internalFrameOpened(e);
  }
}

class FrmPoblacion_botonBuscar_actionAdapter implements ActionListener
{
  private FrmPoblacion adaptee;
  FrmPoblacion_botonBuscar_actionAdapter(FrmPoblacion adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.botonBuscar_actionPerformed(e);
  }
}

class BotonBorrar implements ActionListener
{
  private FrmPoblacion adaptee;
  BotonBorrar(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  TxtBuscar(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  Tabla(FrmPoblacion adaptee)
  {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e)
  {
    adaptee.tabla_mouseClicked(e);
  }
}

class FrmPoblacion_tabla_keyAdapter extends KeyAdapter
{
  private FrmPoblacion adaptee;
  FrmPoblacion_tabla_keyAdapter(FrmPoblacion adaptee)
  {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e)
  {
    adaptee.tabla_keyPressed(e);
  }
}

class TxtTelefono2 extends FocusAdapter
{
  private FrmPoblacion adaptee;
  TxtTelefono2(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  PanelGrupo(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonGuardar(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonIr(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonNuevo(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonFin(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonInicio(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonAnterior(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonSiguiente(FrmPoblacion adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnSiguiente_actionPerformed(e);
  }
}

class TxtGrupo extends FocusAdapter
{
  private FrmPoblacion adaptee;
  TxtGrupo(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  TxtCodigo(FrmPoblacion adaptee)
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

class TxtDescripcion extends FocusAdapter
{
  private FrmPoblacion adaptee;
  TxtDescripcion(FrmPoblacion adaptee)
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
  private FrmPoblacion adaptee;
  BotonSalir(FrmPoblacion adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnSalir_actionPerformed(e);
  }
}
