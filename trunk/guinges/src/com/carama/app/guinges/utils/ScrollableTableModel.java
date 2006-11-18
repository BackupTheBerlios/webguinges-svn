/**
 * ScrollableTableModel.java
 * */
package com.carama.app.guinges.utils;

import java.sql.*;
import java.util.*;

import javax.swing.table.AbstractTableModel;

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
public class ScrollableTableModel extends AbstractTableModel
{
  private ResultSet resultSet = null;
  private Connection connection = null;
  private List colNames = null;
  private int rowCount = -1;
  private List colClasses = null;
  private Statement stmt = null;

  /**
   * Constructor de la clase
   * */
  public ScrollableTableModel()
  {
    super();
  }

  /**
   *
   * @param con Connection
   * @param select String
   */
  public ScrollableTableModel(Connection con, String select)
  {
    this(con, select, null);
  }

  /**
   *
   * @param con Connection
   * @param select String
   * @param colNames List
   */
  public ScrollableTableModel(Connection con, String select, List colNames)
  {
    if (con == null)
    {
      throw new IllegalArgumentException(
          "The connection passed as parameter is null.");
    }
    try
    {
      if (con.isClosed())
      {
        throw new IllegalArgumentException(
            "The connection passed as parameter is closed.");
      }
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting connection status.", e);
    }
    if (!supportsScrollInsensitive(con))
    {
      throw new IllegalArgumentException(
          "The connection passed as parameter don't supports insensitive scroll.");
    }
    this.connection = con;
    if (select == null)
    {
      throw new IllegalArgumentException(
          "The query passed as parameter is null.");
    }
    if (select.trim().length() == 0)
    {
      throw new IllegalArgumentException(
          "The query passed as parameter is empty.");
    }
    stmt = null;
    ResultSet rs = null;
    try
    {
      stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException("Error creating statement",
                                              e);
    }

    try
    {
      rs = stmt.executeQuery(select);
      this.resultSet = rs;
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException("Error executing query", e);
    }

    if (colNames == null || colNames.isEmpty())
    {
      fillColNames(rs);
    }
    else
    {
      this.colNames = new ArrayList(colNames);
      ResultSetMetaData rsmd = null;
      try
      {
        rsmd = resultSet.getMetaData();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting ResultSetMetadata", e);
      }

      int colCount = -1;
      try
      {
        colCount = rsmd.getColumnCount();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting the column count", e);
      }
      if (colCount != colNames.size())
      {
        throw new IllegalArgumentException(
            "The colNames parameter contains an invalid number of columns.");
      }
    }
  } // ScrollableTableModel(Connection, String, List)

  /**
   *
   * @param rs ResultSet
   */
  public ScrollableTableModel(ResultSet rs)
  {
    this(rs, null);
  }

  /**
   *
   * @param rs ResultSet
   * @param colNames List
   */
  public ScrollableTableModel(ResultSet rs, List colNames)
  {
    if (rs == null)
    {
      new IllegalArgumentException(
          "The resultset passed as parameter is null.");
    }
    Statement s = null;
    try
    {
      s = rs.getStatement();
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting statement from resultset.", e);
    }
    Connection c = null;
    try
    {
      c = s.getConnection();
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting connection from resultset.", e);
    }
    if (!supportsScrollInsensitive(c))
    {
      throw new IllegalArgumentException(
          "Your connection don't supports insensitive scroll.");
    }

    if (colNames != null)
    {
      ResultSetMetaData rmd = null;
      try
      {
        rmd = rs.getMetaData();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting ResultSetMetaData.", e);
      }

      int colCount = -1;
      try
      {
        colCount = rmd.getColumnCount();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting the column count.", e);
      }
      if (colNames.size() != colCount)
      {
        throw new IllegalArgumentException(
            "The colNames parameter contains an invalid number of columns.");
      }

      this.colNames = new ArrayList(colNames);
    }
    else
    {
      fillColNames(rs);
    }

    this.resultSet = rs;
    this.stmt = s;
  }

  /**
   *
   * @param stmt Statement
   */
  public ScrollableTableModel(Statement stmt)
  {
    this(stmt, null);
  }

  /**
   *
   * @param stmt Statement
   * @param colNames List
   */
  public ScrollableTableModel(Statement stmt, List colNames)
  {
    if (stmt == null)
    {
      new IllegalArgumentException(
          "The statement passed as parameter is null.");
    }
    ResultSet rs = null;
    try
    {
      rs = stmt.getResultSet();
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting resultset from statement.", e);
    }
    Connection c = null;
    try
    {
      c = stmt.getConnection();
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting connection from resultset.", e);
    }
    if (!supportsScrollInsensitive(c))
    {
      throw new IllegalArgumentException(
          "Your connection don't supports insensitive scroll.");
    }

    if (colNames != null)
    {
      ResultSetMetaData rmd = null;
      try
      {
        rmd = rs.getMetaData();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting ResultSetMetaData.", e);
      }

      int colCount = -1;
      try
      {
        colCount = rmd.getColumnCount();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting the column count.", e);
      }
      if (colNames.size() != colCount)
      {
        throw new IllegalArgumentException(
            "The colCount parameter contains an invalid number of columns.");
      }

      this.colNames = new ArrayList(colNames);
    }
    else
    {
      fillColNames(rs);
    }

    this.resultSet = rs;
    this.stmt = stmt;
  }

  /**
   * private void fillColNames() { fillColNames(this.resultSet); } //
   * fillColNames()
   *
   * @param resultSet ResultSet
   */
  private void fillColNames(ResultSet resultSet)
  {
    if (resultSet == null)
    {
      throw new IllegalArgumentException(
          "Error filling column names: The ResultSet parameter is null");
    }
    if (this.colNames == null)
    {
      ResultSetMetaData rsmd = null;
      try
      {
        rsmd = resultSet.getMetaData();
        int colCount = rsmd.getColumnCount();
        if (colCount == 0)
        {
          // DO NOTHING!
        }
        this.colNames = new ArrayList();
        for (int i = 0; i < colCount; i++)
        {
          String colLabel = rsmd.getColumnLabel(i + 1);
          this.colNames.add(colLabel);
        }
      }
      catch (SQLException e)
      {
        e.printStackTrace();
        throw new ScrollableTableModelException(
            "Error getting ResultSetMetadata", e);
      }
    }
  } // fillColNames(ResultSet)

  /**
   *
   * @return int
   */
  public int getColumnCount()
  {
    return colNames.size();
  }

  /**
   *
   * @return int
   */
  public int getRowCount()
  {
    if (this.rowCount == -1)
    {
      try
      {
        resultSet.last();
        this.rowCount = resultSet.getRow();
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error scrolling to latest row",
            e);
      }
    }

    return rowCount;
  }

  /**
   *
   * @param rowIndex int
   * @param columnIndex int
   * @return Object
   */
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    int rowNdx = rowIndex + 1;
    int colNdx = columnIndex + 1;
    try
    {
      resultSet.absolute(rowNdx);
      return resultSet.getObject(colNdx);
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException("Error getting value at " +
                                              rowIndex + ", " + columnIndex, e);
    }
  }

  /**
   *
   * @param column int
   * @return String
   */
  public String getColumnName(int column)
  {
    return (String)colNames.get(column);
  }

  /**
   *
   * @param columnIndex int
   * @return Class
   */
  public Class getColumnClass(int columnIndex)
  {
    if (colClasses == null)
    {
      colClasses = new ArrayList();
      ResultSetMetaData md = null;
      try
      {
        md = resultSet.getMetaData();
        int colCount = md.getColumnCount();
        for (int i = 0; i < colCount; i++)
        {
          try
          {
            String className = md.getColumnClassName(i + 1);
            Class c = Class.forName(className);
            colClasses.add(c);
          }
          catch (ClassNotFoundException e)
          {
            throw new ScrollableTableModelException(
                "Error getting column classes.", e);
          }
        } // for i
      }
      catch (SQLException e)
      {
        throw new ScrollableTableModelException(
            "Error getting column classes.",
            e);
      }
    }
    Class c = (Class)colClasses.get(columnIndex);

    return c;
  }

  static private boolean supportsScrollInsensitive(Connection con)
  {
    DatabaseMetaData md = null;
    try
    {
      md = con.getMetaData();
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting database metadata.", e);
    }
    try
    {
      return md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
    }
    catch (SQLException e)
    {
      throw new ScrollableTableModelException(
          "Error getting database metadata info.", e);
    }
  } // supportsScrollInsensitive()

  /**
   * Metodo para cerrar la conexion
   * */
  public void destroy()
  {
    if (stmt != null)
    {
      try
      {
        stmt.close();
      }
      catch (SQLException e)
      {
      }
    }
    stmt = null;
  }

}
