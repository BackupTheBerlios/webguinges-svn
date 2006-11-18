/**
 * Clase JDBCUtils.java
 * */
package com.carama.app.guinges.db.datos.metadata;

import java.sql.*;
import java.util.ArrayList;
import org.w3c.dom.Document;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.carama.app.guinges.utils.EscribeLogs;
import java.io.FileWriter;
import java.io.BufferedWriter;
import com.carama.app.guinges.utils.PathDirAndFiles;
import java.io.File;
import com.carama.app.guinges.utils.MakeFileDirectory;

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
public class JDBCUtils
{
  private PathDirAndFiles files = new PathDirAndFiles();
  private java.sql.Statement statement;
  private java.sql.Connection conexion;
  private java.sql.Statement querySQL;
  private java.sql.Statement countSQL;
  private java.sql.ResultSetMetaData metaData;
  private java.sql.ResultSet rs; // conjunto de resultados
  private EscribeLogs logs = new EscribeLogs();
  private int numFilas;
  private boolean existsDir = (new File(files.xmlDir())).exists();

  private MakeFileDirectory crearDir = new MakeFileDirectory();

  /**
   * Constructor de la clase
   *
   * @param conn Connection
   */
  public JDBCUtils(Connection conn)
  {
    this.conexion = conn;
    conectar(conn);
  }

  /**
   * Metodo para exportar XML
   *
   * @param query String
   * @param filename String
   * @param tablename String
   */
  public void exporXML(String query, String tablename)
  {
    Document doc = getDataToXML(query.toUpperCase(), tablename);
    if (!existsDir)
    {
      crearDir.crearDirectorio(files.xmlDir());
    }
    String xmlFileName = files.xmlDir() + System.getProperty("file.separator") +
                         tablename.toString() + ".xml";
    BufferedWriter xmlFile = null;
    try
    {
      xmlFile = new BufferedWriter(new FileWriter(xmlFileName, false));
      xmlFile.write(serialize(doc));
      xmlFile.close();
    }
    catch (IOException ex)
    {
    }
  }

  /**
   *
   * @param doc Document
   * @throws IOException
   * @return String
   */
  public static String serialize(Document doc) throws IOException
  {
    StringWriter writer = new StringWriter();
    OutputFormat format = new OutputFormat();
    format.setIndenting(true);

    XMLSerializer serializer = new XMLSerializer(writer, format);
    serializer.serialize(doc);

    return writer.getBuffer().toString();
  }

  /**
   * Metodo para crear una cadena de texto xml
   * @param rs ResultSet
   * @throws SQLException
   * @return String
   */
  public static String toXML(ResultSet rs) throws SQLException
  {
    ResultSetMetaData rsmd = rs.getMetaData();
    int colCount = rsmd.getColumnCount();
    StringBuffer xml = new StringBuffer();
    xml.append("<Results>");

    while (rs.next())
    {
      xml.append("<Row>");

      for (int i = 1; i <= colCount; i++)
      {
        String columnName = rsmd.getColumnName(i);
        Object value = rs.getObject(i);
        xml.append("<" + columnName + ">");

        if (value != null)
        {
          xml.append(value.toString().trim());
        }
        xml.append("</" + columnName + ">");
      }
      xml.append("</Row>");
    }

    xml.append("</Results>");

    return xml.toString();
  }

  /**
   * Crea un documento usando la api DOM
   *
   * @param rs ResultSet
   * @param tablename String
   * @throws ParserConfigurationException
   * @throws SQLException
   * @return Document
   */
  public static Document toDocument(ResultSet rs, String tablename) throws javax.xml.parsers.
      ParserConfigurationException, java.sql.SQLException
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.newDocument();

    Element results = doc.createElement(tablename.toUpperCase());
    doc.appendChild(results);

    ResultSetMetaData rsmd = rs.getMetaData();
    int colCount = rsmd.getColumnCount();

    while (rs.next())
    {
      Element row = doc.createElement("Row");
      results.appendChild(row);

      for (int i = 1; i <= colCount; i++)
      {
        String columnName = rsmd.getColumnName(i);
        Object value = rs.getObject(i);

        Element node = doc.createElement(columnName);
        node.appendChild(doc.createTextNode(value.toString()));
        row.appendChild(node);
      }
    }
    return doc;
  }

  /**
   * Crea un documento string xml - es mas lento que usar la api DOM
   *
   * @param rs ResultSet
   * @throws java.io.SQLException
   * @throws FactoryConfigurationError
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   * @return Document
   */
  public static Document toDoc(ResultSet rs) throws
      SQLException,
      FactoryConfigurationError,
      ParserConfigurationException,
      SAXException,
      IOException
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    String xml = toXML(rs);
    StringReader reader = new StringReader(xml);
    InputSource source = new InputSource(reader);
    return builder.parse(source);
  }

  /**
   *
   * @param query String
   * @param tablename String
   * @return Document
   */
  public Document getDataToXML(String query, String tablename)
  {
    Document doc = null;

    try
    {
      Statement stmt = conexion.createStatement();
      ResultSet resultset = stmt.executeQuery(query.toUpperCase());

      doc = toDocument(resultset, tablename);

      resultset.close();
      stmt.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return doc;
  }

  /**
   * Nos devuelte el resultado de la consulta en XML
   * @return String
   * @param query String
   */
  public String getDataToXMLasString(String query)
  {
    String xml = null;

    try
    {
      Statement stmt = conexion.createStatement();
      ResultSet resultset = stmt.executeQuery(query.toUpperCase());

      xml = toXML(resultset);

      resultset.close();
      stmt.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return xml;
  }

  /**
   * Medoto para filtrar la consulta se le pasa por parametro un valor entero y
   * el nos devuelve el tipo de filtro
   *
   * @param filter int
   * @return String
   */
  private static String filter(int filter)
  {
    String filterclause = new String();
    switch (filter)
    {
      case 1:
        filterclause = "=";
        break;
      case 2:
        filterclause = "<";
        break;
      case 3:
        filterclause = "<=";
        break;
      case 4:
        filterclause = ">";
        break;
      case 5:
        filterclause = ">=";
        break;

      case 6:
        filterclause = "<>";
        break;
      case 7:
        filterclause = "STARTING WITH";
        break;
      case 8:
        filterclause = "NOT STARTING WITH";
        break;
      case 9:
        filterclause = "CONTAINING";
        break;
      case 10:
        filterclause = "NOT CONTAINING";
        break;
      case 11:
        filterclause = "LIKE";
        break;
    }
    return filterclause;
  }

  /**
   * Makes an SQL statement for cmpTable. Constructs an SQL statement that will
   *
   * @param tableName String
   * @return An SQL statement
   */
  public String toSelect(String tableName)
  {
    String nombreTabla = tableName.toUpperCase();
    StringBuffer strsql = new StringBuffer("SELECT ");
    try
    {
      String[] tabla = camposTabla(nombreTabla.toUpperCase());

      for (int i = 0; i < tabla.length; i++)
      {
        if (i > 0)
        {
          strsql.append(", ");
        }
        strsql.append(tabla[i].toString().trim().toUpperCase());
      }
      strsql.append(" FROM " + nombreTabla);
    }
    catch (Exception ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    System.out.println(strsql.toString());
    return strsql.toString();
  }

  /**
   * Consulta para actualizar una tabla de la base de datos
   *
   * @param tableName String
   * @param data ArrayList
   * @param codigo int
   */
  public void toUpdate(String tableName, ArrayList<String> data, String codigo)
  {
    StringBuffer sqlUpdate = new StringBuffer();
    try
    {
      sqlUpdate.append("UPDATE " + tableName.toUpperCase() + " SET ");
      for (String sql : data)
      {
        sqlUpdate.append(sql.toString().trim());
      }
      sqlUpdate.append(" WHERE COD =" + Integer.parseInt(codigo));
      toExecQuery(sqlUpdate.toString());
    }
    catch (Exception ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Metodo para borrar un registro
   *
   * @param tableName String
   * @param cod int
   * @since 31/07/2006
   */
  public void toDelete(String tableName, int cod)
  {
    String delete = "DELETE FROM " + tableName.toUpperCase().toString() + " WHERE COD=" + cod;
    toExecQuery(delete);
  }

  /**
   * Metodo para ejecutar una una consulta
   *
   * @param query String
   * @since 01/08/2006
   */
  public void toExecQuery(String query)
  {
    try
    {
      querySQL = conexion.createStatement();
      querySQL.execute(query);

      /**
       * Comprobamos que la consulta sea de seleccion
       * ya que no tiene sentido almacenar en un log las consultas
       * de seleccion
       * @since 02/08/2006
       * */
      if (!query.toUpperCase().startsWith("SELECT"))
      {
        logs.escribeSQL(query);
      }
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Conjunto de resultados de la consulta
   * @param query String
   * @return ResultSet
   * @since 31/07/2006
   * Last modified 31/02/2006
   */
  public ResultSet resultset(String query)
  {
    try
    {
      rs = statement.executeQuery(query.toUpperCase());

      /**
       * Apuntamos al ultimo registro del resultset
       * */
      rs.last();

      /**
       * Obtenemos la posicion del registro que tambien sera el numero de registros en el ResultSet
       * */
      int rowcount = rs.getRow();
      this.numFilas = rowcount;

      /**
       * Volvemos al inicio del resultset para poder recibir la llamada rs.next()
       * */
      rs.beforeFirst();

    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    return rs;
  }

  /**
   * Metodo que devuelve el numero de filas que tiene una deteminada consulta
   *
   * @return int
   * @since 31/07/2006
   */
  public int numeroFilasConsulta()
  {
    int nFilas = numFilas;
    return nFilas;
  }

  /**
   * Metodo que devuelve el numero de registros que tiene una tabla
   * @param table String
   * @return ResultSet
   */
  public ResultSet numReg(String table)
  {
    String count = "SELECT COUNT(0) FROM " + table.toUpperCase();
    try
    {
      countSQL = conexion.createStatement();
      rs = countSQL.executeQuery(count);
      rs.next();
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    return rs;
  }

  /**
   * Metodo para insertar registros en la base de datos
   *
   * @param table String
   * @param data ArrayList
   */
  public void insertSQL(String table, ArrayList<String> data)
  {
    String[] campostabla = camposTabla(table.toUpperCase());
    StringBuffer insert = new StringBuffer("INSERT INTO ");
    insert.append(table.toUpperCase());
    insert.append(" (");
    for (int i = 1; i < campostabla.length; i++)
    {
      if (i > 1)
      {
        insert.append(", ");
      }
      insert.append(campostabla[i].toString().trim());
    }
    insert.append(") ");
    insert.append("VALUES (");
    for (String sql : data)
    {
      insert.append(sql.toString().trim());
    }
    insert.append(")");
    toExecQuery(insert.toString());
  }

  /**
   * metodo que devuelve una consulta select con clausulas where y un filtro
   * <html> <u>Se usa de la siguiente manera:</u>
   * <br> selectWithFilterClause("BANCOS", 1, 5, "BAN"); </html> los parametro
   * que hay que pasarle son los siguientes:
   *
   * @param table <b>Nombre de la tabla</b>
   * @param col <b>Un valor numerico que corresponde con el numero de
   *   columna</b>
   * @param filtro <b>Un valor numerico que corresponde con numero de
   *   filtro</b> p.e el numero 1 corresponde al "=", el 2 al ">" el 3 al "<" y
   *   asi sucesivamente
   * @param value <b>Corresponde a una cadena de texto que luego se le asignara
   *   el tipo segun el tipo de la columna</b> p.e si el tipo de columna
   *   corresponde a un <b><i>VARCHAR</i></b>, <b>value</b> se le asignara tipo
   *   <b>String</b>
   * @return String
   */
  public String selectWithFilterClause(String table, int col, int filtro, String value)
  {
    String[] tabla;
    String filterClause = filter(filtro);
    tabla = camposTabla(table.toUpperCase());
    StringBuffer whereClause = null;
    try
    {
      whereClause = new StringBuffer(toSelect(table.toUpperCase()));
    }
    catch (Exception ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    whereClause.append(" ");
    whereClause.append("WHERE");
    whereClause.append(" ");
    whereClause.append(tabla[col].toString().trim().toUpperCase());
    whereClause.append(" ");
    if (filterClause.startsWith("LIKE"))
    {
      filterClause = "LIKE '%" + value + "'";
      whereClause.append(filterClause);
    }
    else
    {
      whereClause.append(filterClause);
      whereClause.append(" ");
      try
      {
        rs = statement.executeQuery(toSelect(table));
        metaData = rs.getMetaData();
        int type = metaData.getColumnType(col + 1);
        switch (type)
        {
          case Types.INTEGER:
            whereClause.append(Integer.parseInt(value));
            break;
          case Types.DOUBLE:
            whereClause.append(Double.parseDouble(value));
            break;
          case Types.DECIMAL:
          case Types.FLOAT:
          case Types.REAL:
            whereClause.append(Float.parseFloat(value));
            break;
          case Types.BIGINT:
            whereClause.append(Long.parseLong(value));
            break;

          case Types.VARCHAR:
          case Types.CHAR:
          case Types.LONGVARCHAR:
            whereClause.append("'" + value.toString() + "'");
            break;
        }
      }

      catch (SQLException ex)
      {
        logs.escribeError(ex.getLocalizedMessage(), false);
      }

    }
    System.out.println(whereClause.toString());
    return whereClause.toString();
  }

  /**
   * conectar
   *
   * @param conn Connection
   */
  public void conectar(Connection conn)
  {
    // Crear una sentencia SQL
    try
    {
      statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                       ResultSet.CONCUR_UPDATABLE);
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
  }

  /**
   * Este procedimiento devuelve un String con la Consulta para obtener la
   * metadata de los campos de una tabla que pasaremos por parametro:
   *
   * @param tabla String
   * @return strTabla
   */
  private static String strSQLtabla(String tabla)
  {
    final String strTabla = "SELECT TEXTOENTABLA FROM DESCRIPTORES  WHERE CTABLA ='" +
                            tabla.toUpperCase() + "' ORDER BY COD ASC";
    return strTabla;
  }

  /**
   *
   * @param tabla String
   * @throws SQLException
   * @return String[]
   */
  public String[] camposTabla(String tabla)
  {

    try
    {
      rs = statement.executeQuery(strSQLtabla(tabla));
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    try
    {
      rs.last(); // mover el cursor a la última fila
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }

    String[] cmptablas = null;
    try
    {
      cmptablas = new String[rs.getRow()];
    }
    catch (SQLException ex)
    {
      System.out.println(ex.getMessage());
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    try
    {
      rs.beforeFirst(); // mover el cursor a su posición inicial
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }
    int i = 0;
    try
    {
      while (rs.next())
      {
        cmptablas[i++] = rs.getString(1);
      }
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
    }

    return cmptablas;
  }

  /**
   * Metodo para moverse al siguiente registro
   *
   * @throws java.sql.SQLException
   */
  public void siguiente() throws java.sql.SQLException
  {
    if (numFilas > 0)
    {
      if (!rs.isLast())
      {
        rs.next();
      }
    }
  }

  /**
   * Metodo para moverse al registro anterior
   *
   * @throws java.sql.SQLException
   */
  public void anterior() throws java.sql.SQLException
  {
    if (numFilas > 0)
    {
      if (!rs.isFirst())
      {
        rs.previous();
      }
    }
  }

  /**
   * Metodo para moverse al primer registro
   *
   * @throws java.sql.SQLException
   */
  public void primero() throws java.sql.SQLException
  {
    if (numFilas > 0)
    {
      rs.first();
    }
  }

  /**
   * Metodo para moverse a un registro concreto
   *
   * @throws java.sql.SQLException
   * @param reg int
   */
  public void irRegistro(int reg) throws java.sql.SQLException
  {
    if (numFilas > 0)
    {
      rs.absolute(reg);
    }
  }

  /**
   * Metodo para moverse al ultimo registro
   *
   * @throws java.sql.SQLException
   */
  public void ultimo() throws java.sql.SQLException
  {
    if (numFilas > 0)
    {
      rs.last();
    }
  }
}
