/**
 * FechaHora.java
 * */
package com.carama.app.guinges.utils;

import java.text.*;
import java.util.*;

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
public class FechaHora
{
  private ConfigIni config = new ConfigIni();
  private PathDirAndFiles files = new PathDirAndFiles();
  private Formatter fmt = new Formatter();
  private Calendar cal = Calendar.getInstance();
  private Date today;
  private String dateOut;
  private DateFormat dateFormatter;
  private Locale currentLocale = Locale.getDefault();
  /**
   * Devulve fecha en formato corto o largo segun el parametro
   *
   * @param tipo int
   * @return java.lang.String
   */
  public String mostrarFecha(int tipo)
  {
    String inifile = files.iniFileName();
    String idioma = config.obtenerValorIni(inifile, "user.language");
    String pais = config.obtenerValorIni(inifile, "user.country");
    currentLocale = new Locale(idioma, pais);
    switch (tipo)
    {
      case 1:
        dateFormatter =
            DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);
        break;
      case 2:
        dateFormatter =
            DateFormat.getDateInstance(DateFormat.LONG, currentLocale);
        break;
      case 3:
        dateFormatter = new SimpleDateFormat("EEE, d MMM, yyyy H:mm:ss:SSS", currentLocale);
        break;

    }
    today = new Date();
    dateOut = dateFormatter.format(today);
    return dateOut.toString();
  }

  /**
   * Constructor de la clase
   * */
  public FechaHora()
  {
  }

  /**
   * Devuelve Dia hora min seg
   *
   * @return java.lang.String
   */
  public String fechaHoraMinSeg()
  {
    fmt.format("%tD %tH:%tM:%tS:%tL", cal, cal, cal, cal, cal);
    return fmt.toString();
  }

  /**
   * Devuelve Nombre del dia de la semana
   *
   * @return java.lang.String
   */
  public String nombreDiaSemana()
  {
    fmt.format("%tA", cal);
    return fmt.toString();
  }

  /**
   * Devuelve el dia del mes en numero
   *
   * @return java.lang.String
   */
  public final String numeroDiaMes()
  {
    fmt.format("%td", cal);
    return fmt.toString();
  }

  /**
   * Devuelve Nombre del mes
   *
   * @return java.lang.String
   */
  public String nombreMes()
  {
    fmt.format("%tB", cal);
    return fmt.toString();
  }

  /**
   * Metodo main de la clase
   *
   * @param args String[]
   */
  public static void main(String[] args)
  {
    new FechaHora();
  }
}
