/**
 * Clase Conexion
 * */
package com.carama.app.guinges.db.connection;

import java.sql.*;

import com.carama.app.guinges.utils.*;
import java.io.File;

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
 * @since 26/06/2006
 */
public class Conexion
{
  /* Atributos */

  /**
   * Necesitamos la clase que lee el fichero guinges.ini
   * y tambien la clase que incluyen los path de los ficherso
   */
  private static ConfigIni config = new ConfigIni();

  private static PathDirAndFiles files = new PathDirAndFiles();

  private static EscribeLogs error = new EscribeLogs();

  private static String url = config.obtenerValorIni(files.databaseFileName(), "db.url");

  private static String driver = config.obtenerValorIni(files.databaseFileName(), "db.driver");

  private static String usr = config.obtenerValorIni(files.databaseFileName(), "db.user");

  private static String pswd = "masterkey";

  private Connection con;

  /**
   * Constructor, carga JDBC
   * */
  public Conexion()
  {
    loadDriver();
    mkConection();
  }

  /**
   * Carga el driver de la conexión a la base de datos
   */

  private static void loadDriver()

  {
    /**
     * Instancía de una nueva clase para el puente
     * org.firebirdsql.jdbc.FBDriver
     * El puente sirve entre la aplicación y el driver.
     */
    try
    {
      Class.forName(driver).newInstance();
    }
    catch (ClassNotFoundException ex)
    {
      System.out.println("Error al crear el JDBC");
    }
    catch (IllegalAccessException ex)
    {
    }
    catch (InstantiationException ex)
    {
    }
  }

  /**
   * Obtiene una conexión con el nombre del driver especificado
   *
   * @return java.sql.Connection
   */
  public Connection mkConection()

  {
    try
    {
      /**
       * Obtiene la conexión
       * */
      File db = new File(files.dbHomePath());

      if (db.exists() && db.canRead() && db.canWrite())
      {
        con = DriverManager.getConnection(url, usr, pswd);
      }
      else
      {
        process(db.exists() ? "exists" : "does not exists");
        process(db.canWrite() ? "is writeable" : "is not writeable");
        process(db.canRead() ? "is readable" : "is not readable");
      }
    }
    catch (SQLException sqle)
    {
      error.escribeError("No se pudo establecer la conexión al intentar cargar el driver" + " " +
                         sqle.getLocalizedMessage(), false);
      return null;
    }

    /**
     * Devuelve la conexión
     * */

    return con;

  }

  private static void process(String s)
  {
    error.escribeError(s, true);
  }

  /**
   * Cerrar la conexión.
   * @return closeConnecction
   */
  public boolean closeConecction()

  {

    try

    {

      con.close();

    }

    catch (SQLException sqle)

    {
      error.escribeError("No se cerro la conexión", false);
      return false;
    }

    System.out.println("Conexión cerrada con éxito ");
    error.escribeError("Conexión cerrada con éxito ", false);

    return true;
  }

  /**
   * Metodo main
   *
   * @param args String[]
   */
  public static void main(String[] args)
  {

    new Conexion();
  }

}
