/**
 * DlgProvincia.java
 * */
package com.carama.app.guinges.ui.provincia.dlg;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import com.borland.jbcl.layout.*;
import com.carama.app.guinges.db.connection.Conexion;
import com.carama.app.guinges.db.datos.metadata.JDBCUtils;
import com.carama.app.guinges.db.model.GuingesTableModel;
import com.carama.app.guinges.utils.EscribeLogs;
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
public class DlgProvincia extends JFrame
{
  /**
   * Constante que contendra el nombre de la tabla
   * */
  private static final String TABLENAME = "provincia";

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
  private JPanel paneltitulo = new JPanel();
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
  private JComboBox cmboxfiltro = new JComboBox();
  private Border bordeAzul;
  private JPanel jpanelnorte = new JPanel();
  private BorderLayout borderLayout6 = new BorderLayout();
  private JXPanel group = new JXPanel();
  private JXTable tabla = new JXTable();
  private JPanel paneldescripcion = new JPanel();
  private TitledBorder titledborder = new TitledBorder("");
  private FlowLayout flowLayout2 = new FlowLayout();
  private JPanel paneldetalleMain = new JPanel();
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
  private FlowLayout flowLayout3 = new FlowLayout();
  private BorderLayout borderLayout11 = new BorderLayout();
  private JTextField codProv = new JTextField();
  private JTextField descProv = new JTextField();
  /**
   * Constructor de la clase
   *
   * @param title String
   * @param cod JTextField
   * @param desc JTextField
   */
  public DlgProvincia(String title, JTextField cod, JTextField desc)
  {
    super(title);
    this.codProv = cod;
    this.descProv = desc;
    try
    {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    if (strSQL.numeroFilasConsulta() > 0)
    {
      txtcodigo.setText(rs.getString(1));
      txtdescripcion.setText(rs.getString(2));
    }
  }

  private void jbInit() throws Exception
  {
    llenarcmbox();
    bordeAzul = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue, 1),
                                                   BorderFactory.createEmptyBorder(0, 5, 0, 0));
    this.setSize(590, 490);
    getContentPane().setLayout(borderLayout1);
    btnSalir.setOpaque(false);
    model.configureHighlighters(tabla);
    btnSalir.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/exit.png")));
    btnSalir.addActionListener(new BotonSalir(this));
    btnImprimir.setOpaque(false);
    btnImprimir.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/print.png")));
    btnGuardar.setOpaque(false);
    btnGuardar.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/save.png")));
    btnGuardar.addActionListener(new BotonGuardar(this));
    btnBorrar.setOpaque(false);
    llenarfiltro();
    btnBorrar.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/editdelete.png")));
    btnBorrar.addActionListener(new BtnBorrar(this));
    btnNuevo.setOpaque(false);
    btnNuevo.setHorizontalAlignment(SwingConstants.RIGHT);
    btnNuevo.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/new.png")));
    btnNuevo.addActionListener(new BotonNuevo(this));
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
    jpanelnorte.setBorder(null);
    jpanelnorte.setOpaque(false);
    tbpane.setBorder(titledborder);
    panelGrupo.setBorder(null);
    panelGrupo.addComponentListener(new PanelGrupo(this));
    txtdescripcion.setBorder(bordeAzul);
    group.setOpaque(true);
    group.setLayout(borderLayout11);
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
    panelgeneral.setLayout(verticalFlowLayout1);
    tabbedpane.setBorder(null);
    panelgeneral.setBorder(null);
    panelClientes.setBorder(null);
    panelClientes.setLayout(borderLayout9);
    panelProveedores.setBorder(null);
    panelProveedores.setLayout(borderLayout10);
    lbltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
    lbltitulo.setText("FICHA DE PROVINCIAS");
    this.setResizable(false);
    tabla.setBorder(null);
    //this.setBorder(null);
    toolbar.add(btnNuevo);
    toolbar.add(btnBorrar);
    toolbar.add(btnGuardar);
    toolbar.add(btnImprimir);
    toolbar.add(btnSalir);
    toolbar.add(cbMostrarAyuda);
    cbMostrarAyuda.setOpaque(false);
    cbMostrarAyuda.setText("Mostrar textos de ayuda");
    panelGrupo.setLayout(borderLayout2);
    panelsur.setLayout(verticalFlowLayout);
    btnFin.setPreferredSize(new Dimension(20, 20));
    btnFin.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/player_end.png")));
    btnFin.addActionListener(new BotonFin(this));
    btnSiguiente.setMinimumSize(new Dimension(26, 26));
    btnSiguiente.setPreferredSize(new Dimension(20, 20));
    btnSiguiente.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/player_fwd.png")));
    btnSiguiente.addActionListener(new BotonSiguiente(this));
    panelnavegacion.setLayout(flowLayout1);
    panelnavegacion.setOpaque(false);
    panelnavegacion.setPreferredSize(new Dimension(245, 36));
    btnAnterior.setPreferredSize(new Dimension(20, 20));
    btnAnterior.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/player_rew.png")));
    btnAnterior.addActionListener(new BotonAnterior(this));
    btnInicio.setPreferredSize(new Dimension(20, 20));
    btnInicio.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/player_start.png")));
    btnInicio.addActionListener(new BotonInicio(this));
    btnIr.setPreferredSize(new Dimension(20, 20));
    btnIr.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/ok.png")));
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
    paneltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
    paneltitulo.setMinimumSize(new Dimension(209, 50));
    paneltitulo.setPreferredSize(new Dimension(410, 100));
    paneltitulo.setLayout(flowLayout3);
    panelcodigo.setLayout(xYLayout);
    panelnorte.setLayout(borderLayout3);
    panelcodcenter.setLayout(borderLayout4);
    panelDetalle.setLayout(borderLayout5);
    tbpane.setOpaque(true);
    lbltitulo.setIcon(new ImageIcon(com.carama.app.guinges.ui.provincia.dlg.DlgProvincia.class.getResource(
        "../../img/iconoFichas.png")));
    cmboxfiltro.setBorder(null);
    cmboxfiltro.setPreferredSize(new Dimension(120, 20));
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
    panelGrupo.add(scrollpane, java.awt.BorderLayout.CENTER);
    tbpane.add(panelGrupo, "Grupo");
    tbpane.add(panelDetalle, "Detalle");
    panelDetalle.add(paneldetalleMain, java.awt.BorderLayout.CENTER);
    panelnorte.add(paneltitulo, java.awt.BorderLayout.NORTH);
    paneldetalleMain.add(tabbedpane, java.awt.BorderLayout.CENTER);
    paneldetalleMain.add(panelnorte, java.awt.BorderLayout.NORTH);
    panelClientes.add(scrollpaneclientes, java.awt.BorderLayout.CENTER);
    scrollpaneclientes.getViewport().add(tablaclientes);
    panelProveedores.add(scrollpaneproveedores, java.awt.BorderLayout.CENTER);
    scrollpaneproveedores.getViewport().add(tablaproveedores);
    paneltitulo.add(lbltitulo, null);
    group.add(toolbar, java.awt.BorderLayout.CENTER);
    tbpane.setSelectedComponent(panelDetalle);
    tbpane.setSelectedIndex(0);
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
      camposTabla = strSQL.camposTabla(TABLENAME.toUpperCase());
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
   * Boton siguiente
   *
   * @param e ActionEvent
   */
  public void btnSiguiente_actionPerformed(ActionEvent e)
  {
    try
    {
      strSQL.siguiente();
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
      strSQL.anterior();
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
      strSQL.primero();
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
      strSQL.ultimo();
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
        update.add("'" + txtdescripcion.getText() + "'");
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
      update.add("DESCRIPCION='" + txtdescripcion.getText() + "'");
      try
      {
        strSQL.toUpdate(TABLENAME, update, txtcodigo.getText());
        this.rs = strSQL.resultset(query);
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

    /**
     * Seleccionamos la fila y la columna que estamos haciendo
     * click, en este caso vamos la tener la siguiente coordenada
     * tabla(?,0) para tener siempre escogida la primera columna ya que la
     * fila aun no la sabemos por eso ponemos un "?" en su lugar.
     * */
    int rowIndex = tabla.getSelectedRow();
    final int mColIndex = 0;
    final int mColDesc = 1;
    Object codigo = tabla.getModel().getValueAt(rowIndex, mColIndex);
    Object descripcion = tabla.getModel().getValueAt(rowIndex, mColDesc);
    codProv.setText(codigo.toString());
    descProv.setText(descripcion.toString());
    try
    {
      this.finalize();
    }
    catch (Throwable ex1)
    {
      logs.escribeError(ex1.getLocalizedMessage(), false);
    }
    this.dispose();
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
      strSQL.toDelete(TABLENAME, Integer.parseInt(txtcodigo.getText()));
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
}

class BtnBorrar implements ActionListener
{
  private DlgProvincia adaptee;
  BtnBorrar(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  TxtBuscar(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  Tabla(DlgProvincia adaptee)
  {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e)
  {
    adaptee.tabla_mouseClicked(e);
  }
}

class DlgProvincia_tabla_keyAdapter extends KeyAdapter
{
  private DlgProvincia adaptee;
  DlgProvincia_tabla_keyAdapter(DlgProvincia adaptee)
  {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e)
  {
    adaptee.tabla_keyPressed(e);
  }
}

class PanelGrupo extends java.awt.event.ComponentAdapter
{
  private DlgProvincia adaptee;
  PanelGrupo(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonGuardar(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonIr(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonNuevo(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonFin(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonInicio(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonAnterior(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonSiguiente(DlgProvincia adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnSiguiente_actionPerformed(e);
  }
}

class TxtCodigo extends FocusAdapter
{
  private DlgProvincia adaptee;
  TxtCodigo(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  TxtDescripcion(DlgProvincia adaptee)
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
  private DlgProvincia adaptee;
  BotonSalir(DlgProvincia adaptee)
  {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e)
  {
    adaptee.btnSalir_actionPerformed(e);
  }
}
