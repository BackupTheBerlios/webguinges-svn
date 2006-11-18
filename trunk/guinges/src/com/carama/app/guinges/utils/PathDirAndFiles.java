/**
 * RutaDeFicheros.java
 * */
package com.carama.app.guinges.utils;

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
public class PathDirAndFiles
{
  private static final String SEPARADOR = System.getProperty("file.separator");
  private static final String USERDIRPATH = System.getProperty("user.dir") + SEPARADOR;
  private static final String INIDIR = USERDIRPATH + "config";
  private static final String XMLDIR = USERDIRPATH + "xml";
  private static final String DBHOMEDIR = USERDIRPATH + "datos" + SEPARADOR + "guinges.gdb";
  private static final String INIFILE = INIDIR + SEPARADOR + "guinges.properties";
  private static final String DATABASEFILE = INIDIR + SEPARADOR + "database.properties";
  private static final String USERFILE = INIDIR + SEPARADOR + "user.properties";
  private static final String GUINGESXML = INIDIR + SEPARADOR + "guinges.xml";
  private static final String PROVINCIAS = INIDIR + SEPARADOR + "provincias.txt";
  private static final String LOGDIR = USERDIRPATH + "logs";
  private static final String LOGFILE = LOGDIR + SEPARADOR + "guinges.log";
  private static final String SQLFILE = LOGDIR + SEPARADOR + "sql.log";

  /**
   * Metodo que devuelve la ruta del fichero provincias.txt
   *
   * @return String
   */
  public String provinciasFileName()
  {
    return PROVINCIAS;
  }
  /**
     * Metodo que devuelve la ruta del fichero guinges.xml
     *
     * @return String
     */
    public String guingesXMLFileName()
    {
	return GUINGESXML;
  }
  /**
   * Metodo que devuelve la ruta del directorio xml
   *
   * @return String
   */
  public String xmlDir()
  {
    return XMLDIR;
  }

  /**
   * Metodo que devuelve la ruta del fichero user.properties
   *
   * @return String
   */
  public String userFileName()
  {
    return USERFILE;
  }

  /**
   * Metodo que devuelve la ruta del fichero database.properties
   *
   * @return String
   */
  public String databaseFileName()
  {
    return DATABASEFILE;
  }

  /**
   * Metodo que devuelve la ruta del fichero guinges.properties
   *
   * @return String
   */
  public String iniFileName()
  {
    return INIFILE;
  }

  /**
   * Metodo que devuelve la ruta del fichero guinges.log
   *
   * @return String
   */
  public String logFileName()
  {
    return LOGFILE;
  }

  /**
   * Metodo que devuelve la ruta del fichero sql.log
   *
   * @return String
   */
  public String sqlFileName()
  {
    return SQLFILE;
  }

  /**
   * Metodo que devuelve la ruta del del directorio del fichero log
   *
   * @return String
   */
  public String logFileDir()
  {
    return LOGDIR;
  }

  /**
   * Metodo que devuelve la ruta del del directorio de la base de datos
   *
   * @return String
   */
  public String dbHomePath()
  {
    return DBHOMEDIR;
  }

  /**
   * Metodo que devuelve la ruta del del directorio config
   *
   * @return String
   */
  public String iniDirPath()
  {
    return INIDIR;
  }
}
