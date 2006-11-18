/**
 * MakeFileDirectory.java
 * */
package com.carama.app.guinges.utils;

import java.io.*;

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
public class MakeFileDirectory
{
  /**
   *
   * @param fileName String
   */
  public void crearFichero(String fileName)
  {
    try
    {
      File file = new File(fileName);

      // Crea el fichero si no existe
      boolean success = file.createNewFile();
      if (success)
      {
        // El fichero no existia y se ha creado

      }
      else
      {
        // El fichero existe
      }
    }
    catch (IOException e)
    {
    }

  }

  /**
   *
   * @param dirName String
   */
  public void crearDirectorio(String dirName)
  {
    boolean success = (new File(dirName)).mkdir();
    if (!success)
    {
      // Directory creation failed
    }

  }

  /**
   *
   * @param fileName String
   * @param str String
   */
  public void escribirEnFichero(String fileName, String str)
  {
    try
    {
      BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
      out.write(str);
      out.close();
    }
    catch (IOException e)
    {
    }
  }
}
