package com.carama.app.guinges.utils.files;

import java.io.*;
import com.carama.app.guinges.db.connection.Conexion;
import com.carama.app.guinges.db.datos.metadata.JDBCUtils;

class FileRead
{
  /**
   * Conexion
   * */
  private static Conexion conexion = new Conexion();
  /**
   * Clase que construye las consultas on runTime
   * */
  private static JDBCUtils strSQL = new JDBCUtils(conexion.mkConection());

  public static void main(String args[])
  {
    try
    {
      // Open the file that is the first
      // command line parameter
      FileInputStream fstream = new FileInputStream("config/provincias.txt");
      // Get the object of DataInputStream
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;
      //Read File Line By Line
      while ((strLine = br.readLine()) != null)
      {
        // Print the content on the console
        strSQL.toExecQuery("INSERT INTO PROVINCIA (DESCRIPCION) VALUES ('" +
                         strLine.toUpperCase().trim() + "')");
      }
      //Close the input stream
      in.close();
    }
    catch (Exception e)
    { //Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}
