/**
 * Authentication.java
 */
package com.carama.app.guinges.db.authentication;

import com.carama.app.guinges.db.connection.Conexion;
import com.carama.app.guinges.db.datos.metadata.JDBCUtils;
import java.sql.ResultSet;
import com.carama.app.guinges.utils.EscribeLogs;
import java.sql.SQLException;

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
public class Authentication
{
  /**
   * Conexion
   * */
  private Conexion conexion = new Conexion();

  /**
   * Clase que construye las consultas on runTime
   * */
  private JDBCUtils strSQL = new JDBCUtils(conexion.mkConection());
  /**
   * Conjunto de resultados
   * */
  private ResultSet rs;

  /**
   * Variable para almacenar la contraseña
   */
  private String passwd;

  /**
   * Clase para escribir el fichero guinges.logs
   * */
  private EscribeLogs logs = new EscribeLogs();

  /**
   *
   * @param username String
   * @param pass char[]
   * @return boolean
   */
  public boolean validarUsuario(final String username, char[] pass)
  {
    String password = new String(pass);
    try
    {
      if (conexion != null)
      {
        rs = strSQL.resultset(
            "SELECT CLAVE FROM PASSWORDS_PERSONAL WHERE COD_PERSONAL=(SELECT COD FROM PERSONAL WHERE NOMBRE='" +
            username + "'");
        while (rs.next())
        {
          passwd = rs.getString(1);
        }
        rs.close();
      }
      else
      {
        logs.escribeError("Conexion es NULL return false", false);
        return false;
      }
    }
    catch (SQLException ex)
    {
      logs.escribeError(ex.getLocalizedMessage(), false);
      return false;
    }
    finally
    {
      try
      {
        conexion.closeConecction();
      }
      catch (Exception ex2)
      {
        logs.escribeError(ex2.getLocalizedMessage(), false);
      }
    }
    if (password.equals(passwd))
    {
      logs.escribeError("El usuario " + username.toUpperCase() +
                        " ha accedido al sistema correctamente", false);
      return true;
    }
    else
    {
      logs.escribeError("El usuario " + username.toUpperCase() +
                        "no ha podido acceder al sistema", false);
      return false;
    }
  }
}
