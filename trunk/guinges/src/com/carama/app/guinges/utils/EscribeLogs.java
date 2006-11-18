/**
 * EscribeLogs.java
 * */
package com.carama.app.guinges.utils;

import java.io.*;

import javax.swing.JOptionPane;

import com.carama.app.guinges.ui.mdi.Guinges;

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
public class EscribeLogs
{
  private FechaHora fechahora = new FechaHora();
  private PathDirAndFiles files = new PathDirAndFiles();
  private MakeFileDirectory filedir = new MakeFileDirectory();

  /**
   * Escribe el error en un fichero de textos
   *
   * @param str String
   */
  private void grabaError(String str)
  {
    try
    {
      BufferedWriter out = new BufferedWriter(new FileWriter(files.logFileName(), true));
      out.write(fechahora.mostrarFecha(3) + " " + str + "\n");
      out.close();
    }
    catch (IOException e)
    {}
  }

  /**
   * Metodo para escribir en un fichero log las consultas SQL que se realizan en
   * la aplicacion
   *
   * @param str String
   */
  public void escribeSQL(String str)
  {
    try
    {
      BufferedWriter out = new BufferedWriter(new FileWriter(files.sqlFileName(), true));
      out.write(str + ";" + "\n");
      out.close();
    }
    catch (IOException e)
    {}

  }

  private static void muestraErrorPantalla(String str)
  {

    Guinges frame = null;
    try
    {
      frame = new Guinges();
    }
    catch (Exception ex1)
    {
    }
    JOptionPane.showMessageDialog(frame, str);

  }

  /**
   * Metodo para depurar la aplicacion
   *
   * @param error String
   * @param mostrar boolean
   */
  public void escribeError(String error, boolean mostrar)
  {
    /*Metodo para crear un fichero log para depurar luego la aplicacion*/
    String str = error;
    boolean exists = (new File(files.logFileDir())).exists();
    if (!exists)
    {
      // Directorio no existse
      filedir.crearDirectorio(files.logFileDir());
      grabaError(str);
      if (mostrar)
      {
        muestraErrorPantalla(str);
      }
    }
    else
    {
      grabaError(str);
      if (mostrar)
      {
        muestraErrorPantalla(str);
      }

    }
  }
}
