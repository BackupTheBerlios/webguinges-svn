/**
 * ConfigIni.java
 * */
package com.carama.app.guinges.utils;

import java.io.*;
import java.net.*;
import java.util.*;
import org.jdom.*;
import org.jdom.output.XMLOutputter;

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
public class ConfigIni
{
  /*Necesitaremos utilizar la clase clsFicheros para localizar todos los
   archivos que vamos a utilizar en la aplicación*/

  private PathDirAndFiles files = new PathDirAndFiles();
  private MakeFileDirectory crearDir = new MakeFileDirectory();

  private static String url, hostname;
  private static final int PORT = 3050;

  /**
   * Path del fichero guinges.ini
   * */

  private String iniFileDir = files.iniDirPath();
  private String iniFileName = files.iniFileName();

  /**
   * Propiedades por defecto de la aplicacion
   * */

  private static final String APPWEBSITE = "http://www.guinges.com";
  private static final String APPNAME = "GUINGES";
  private static final String APPVERSION = "v.0.0.1";
  private static final String DEFAULTLOOKANDFEEL = "2";
  private static final String FORMATONIF = "########U";
  private static final String FORMATOCIF = "U#######A";
  private static final String FORMATOTFNO = "###-##-##-##";
  private static final String FORMATOCP = "####";
  private static final String FORMATOFECHA = "##/##/##";
  private static final String FORMATONASS = "##/########/##";
  private static final String FORMATOBANCO = "####-####-##-##########";

  /*Propiedades de la base de datos*/

  private static final String DBUSER = "SYSDBA";
  private static final String DRIVER = "org.firebirdsql.jdbc.FBDriver";
  private static final String JDBC = "jdbc:firebirdsql:";
  private String dbFileName = files.dbHomePath();
  private static String firebirdHost;

  /**
   *  Comprobamos si el ficher existe
   * */

  private boolean dirExists = (new File(iniFileDir)).exists();

  private boolean fileExists = (new File(iniFileName)).exists();

  private boolean provExists = (new File(files.provinciasFileName())).exists();

  private boolean databaseExists = (new File(files.databaseFileName())).exists();

  /**
   * Constructor de la clase
   * */
  public ConfigIni()
  {
    if (!dirExists || !fileExists)
    {
      crearDir.crearDirectorio(iniFileDir);
      configuracionPorDefecto();
    }
    if (!provExists)
    {
      crearFicheroProvincias();
    }
    if (!databaseExists)
    {
      crearFicheroDatabase();
	crearDataBaseXML();
    }
  }

  /**
   * crearFicheroDatabase
   */
  private void crearFicheroDatabase()
  {
    try
    {
      BufferedWriter database = new BufferedWriter(new FileWriter(files.databaseFileName(), true));
      /**
       * Fichero database.properties
       *
       * */

      url = JDBC + hostname + "/" + PORT + ":" + dbFileName;
      firebirdHost = JDBC + hostname + "/" + PORT + ":";

      ArrayList<String> defaultdbProperties = new ArrayList<String>();
      defaultdbProperties.add("firebird.hostmane=" + firebirdHost);
      defaultdbProperties.add("user.hostmane=" + hostname);
      defaultdbProperties.add("db.user=" + DBUSER);
      defaultdbProperties.add("db.driver=" + DRIVER);
      for (String str : defaultdbProperties)
      {
        database.write(str + "\n");
      }
      database.close();
      anyadirValorEnIni(files.databaseFileName(), "db.url", url);
    }
    catch (IOException ex)
    {
    }
  }

  private String databaseURL()
  {
    url = JDBC + userHOSTNAME() + "/" + PORT + ":" + dbFileName;
    return url;
  }

  private static String firebirdHOST()
  {
    firebirdHost = JDBC + userHOSTNAME() + "/" + PORT + ":";
    return firebirdHost;
  }

  private static String userHOSTNAME()
  {
    try
    {
      InetAddress addr = InetAddress.getLocalHost();
      /* Obtenemos la ip local*/
      //LOCALHOST = new String(addr.getHostAddress());
      // Obtenemos el nombre de la maquina
      hostname = addr.getHostName();
    }
    catch (UnknownHostException e)
    {
      //error.depura("Error de Host " + e.getLocalizedMessage(), true);
    }
    return hostname;
  }

  private void crearDataBaseXML()
  {
    Element root = new Element("DATABASE");
    DocType type = new DocType("DATABASE",
                               "DATABASE.dtd");
    Document doc = new Document(root, type);
    Element firebirdhostname = new Element("FIREBIRD");
    firebirdhostname.setText(firebirdHOST());
    root.addContent(firebirdhostname);

    Element userhostname = new Element("HOSTNAME");
    userhostname.setText(hostname);
    root.addContent(userhostname);

    Element userdhostname = new Element("USER");
    userdhostname.setText(DBUSER);
    root.addContent(userdhostname);

    Element driver = new Element("DRIVER");
    driver.setText(DRIVER);
    root.addContent(driver);

    Element dburl = new Element("URL");
    dburl.setText(databaseURL());
    root.addContent(dburl);
    try
    {
      XMLOutputter outputter = new XMLOutputter();
      outputter.output(doc, System.out);
      FileOutputStream out = new FileOutputStream(files.guingesXMLFileName());
      outputter.output(doc, out);
      out.flush();
      out.close();
    }
    catch (java.io.IOException e)
    {
      e.printStackTrace();
    }
  }

  private void crearFicheroProvincias()
  {
    BufferedWriter provincias = null;
    try
    {
      provincias = new BufferedWriter(new FileWriter(files.provinciasFileName(), true));
    }
    catch (IOException ex)
    {
    }
    /**
     * Fichero provincias.properties
     * */
    if (System.getProperty("user.country").equals("ES"))
    {
      ArrayList<String> defaultprovincias = new ArrayList<String>();
      defaultprovincias.add("Álava");
      defaultprovincias.add("Albacete");
      defaultprovincias.add("Alicante");
      defaultprovincias.add("Almería");
      defaultprovincias.add("Asturias\n");
      defaultprovincias.add("Ávila\n");
      defaultprovincias.add("Badajoz\n");
      defaultprovincias.add("Islas Baleares\n");
      defaultprovincias.add("Barcelona\n");
      defaultprovincias.add("Burgos\n");
      defaultprovincias.add("Cáceres\n");
      defaultprovincias.add("Cádiz\n");
      defaultprovincias.add("Cantabria\n");
      defaultprovincias.add("Castellón\n");
      defaultprovincias.add("Ciudad Real\n");
      defaultprovincias.add("Córdoba\n");
      defaultprovincias.add("La Coruña\n");
      defaultprovincias.add("Cuenca\n");
      defaultprovincias.add("Gerona\n");
      defaultprovincias.add("Granada\n");
      defaultprovincias.add("Guadalajara\n");
      defaultprovincias.add("Guipúzcoa\n");
      defaultprovincias.add("Huelva\n");
      defaultprovincias.add("Huesca\n");
      defaultprovincias.add("Jaén\n");
      defaultprovincias.add("León\n");
      defaultprovincias.add("Lérida\n");
      defaultprovincias.add("Lugo\n");
      defaultprovincias.add("Madrid\n");
      defaultprovincias.add("Málaga\n");
      defaultprovincias.add("Murcia\n");
      defaultprovincias.add("Navarra\n");
      defaultprovincias.add("Orense\n");
      defaultprovincias.add("Palencia\n");
      defaultprovincias.add("Las Palmas\n");
      defaultprovincias.add("Pontevedra\n");
      defaultprovincias.add("La Rioja\n");
      defaultprovincias.add("Salamanca\n");
      defaultprovincias.add("Santa Cruz de Tenerife\n");
      defaultprovincias.add("Segovia\n");
      defaultprovincias.add("Sevilla\n");
      defaultprovincias.add("Soria\n");
      defaultprovincias.add("Tarragona\n");
      defaultprovincias.add("Teruel\n");
      defaultprovincias.add("Toledo\n");
      defaultprovincias.add("Valencia\n");
      defaultprovincias.add("Valladolid\n");
      defaultprovincias.add("Vizcaya\n");
      defaultprovincias.add("Zamora\n");
      defaultprovincias.add("Zaragoza");

      for (String str : defaultprovincias)
      {
        try
        {
          provincias.write(str.toString().trim());
        }
        catch (IOException ex1)
        {
        }
      }
      try
      {
        provincias.close();
      }
      catch (IOException ex2)
      {
      }
    }

  }

  private void configuracionPorDefecto()
  {

    /*Metodo para crear la configuracion por defecto*/
    try
    {
      /*Si el fichero no existe se crea*/
      try
      {
        InetAddress addr = InetAddress.getLocalHost();
        /* Obtenemos la ip local*/
        //LOCALHOST = new String(addr.getHostAddress());
        // Obtenemos el nombre de la maquina
        hostname = addr.getHostName();
      }
      catch (UnknownHostException e)
      {
        //error.depura("Error de Host " + e.getLocalizedMessage(), true);
      }

      BufferedWriter guinges = new BufferedWriter(new FileWriter(iniFileName, true));

      /**
       * Fichero guinges.properties
       *
       * */

      ArrayList<String> defaultProperties = new ArrayList<String>();
      /*Simbolo de la moneda del pais*/
      Currency c;
      c = Currency.getInstance(Locale.getDefault());
      /*Ruta por defecto de la base de datos */
      defaultProperties.add("mostrar.menu=true");
      defaultProperties.add("app.name=" + APPNAME);
      defaultProperties.add("app.version=" + APPVERSION);
      defaultProperties.add("user.country=" + System.getProperty("user.country"));
      defaultProperties.add("user.language=" + System.getProperty("user.language"));
      defaultProperties.add("app.laf=" + DEFAULTLOOKANDFEEL);
      defaultProperties.add("app.website=" + APPWEBSITE);
      defaultProperties.add("formato.nif=" + FORMATONIF);
      defaultProperties.add("formato.cif=" + FORMATOCIF);
      defaultProperties.add("formato.tfno=" + FORMATOTFNO);
      defaultProperties.add("formato.cp=" + FORMATOCP);
      defaultProperties.add("formato.fecha=" + FORMATOFECHA);
      defaultProperties.add("formato.nass=" + FORMATONASS);
      defaultProperties.add("formato.banco=" + FORMATOBANCO);
      defaultProperties.add("user.currency.symbol=" + c.getSymbol());
      defaultProperties.add("user.fractional.digits=" +
                            c.getDefaultFractionDigits());
      for (String str : defaultProperties)
      {
        guinges.write(str + "\n");
      }
      guinges.close();
    }
    catch (IOException e)
    {}
  }

  /**
   * Metodo para añadir algun valor al fichero guinges.ini
   *
   * @param iniFileName String
   * @param nuevaClave String
   * @param valor String
   */
  public void anyadirValorEnIni(String iniFileName, String nuevaClave,
                                String valor)
  {

    /*Metodo para añadir propiedades al fichero ini*/
    try
    {
      Properties p = new Properties();
      p.load(new FileInputStream(iniFileName));
      p.put(nuevaClave, valor);
      FileOutputStream out = new FileOutputStream(iniFileName);
      p.store(out, null);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  /**
   * Metodo para borrar un valor del fichero
   *
   * @param iniFileName String
   * @param claveABorrar String
   */
  public void borraValorIni(String iniFileName, String claveABorrar)
  {

    /*Metodo para añadir propiedades al fichero ini*/

    try
    {
      Properties p = new Properties();
      p.load(new FileInputStream(iniFileName));
      p.remove(claveABorrar);
      FileOutputStream out = new FileOutputStream(iniFileName);
      p.store(out, null);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  /**
   * Metodo para modificar un valor del fichero
   *
   * @param iniFileName String
   * @param clave String
   * @param valor String
   */
  public void actualizarValorIni(String iniFileName, String clave,
                                 String valor)
  {

    /*Metodo para actualizar el fichero ini*/

    try
    {
      Properties p = new Properties();
      p.load(new FileInputStream(iniFileName));

      /* Modificamos una propiedad */

      p.put(clave, valor);
      FileOutputStream out = new FileOutputStream(iniFileName);
      p.store(out, null);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  /**
   * Metodo para añadir ceros a la izquierda
   *
   * @param i String
   * @param len int
   * @return java.lang.String
   */
  public static String ceros(String i, int len)
  {
    //Metodo para añadir ceros a la izquierda.
    String s = i;
    if (s.length() > len)
    {
      return s.substring(0, len);
    }
    else if (s.length() < len)
    {
      return "000000".substring(0, len - s.length()) + s;
    }
    else
    {
      return s;
    }
  }

  /**
   * Metodo para obtener algun valor del fichero
   *
   * @param filename String
   * @param value String
   * @return java.lang.String
   */
  public String obtenerValorIni(String filename, String value)
  {

    /*Metodo para leer un valor pasado por parametro en el fichero ini */

    String str = new String();
    try
    {
      Properties p = new Properties();
      p.load(new FileInputStream(filename));
      str = p.getProperty(value);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return str;
  }
}
