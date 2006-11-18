package com.carama.app.guinges.utils;/** * <p>Title: Guinges</p> * * <p>Description: Aplicacion de gestion para proposito general</p> * * <p>Copyright: Copyright (c) 2006</p> * * <p>Company: Carama S.L.L</p> * * @author Carlos & Amador * @version 0.0.1 */import java.io.*;import java.util.Calendar;import java.util.zip.*;class clsBackupZip{  MakeFileDirectory crearDir = new MakeFileDirectory();  String BackupDir = "backup";  public clsBackupZip()  {    boolean exists = (new File(BackupDir)).exists();    if (!exists)    {      crearDir.crearDirectorio(BackupDir);      doZip();    }    else    {      doZip();    }  }  public void doZip()  {    File dir = new File("config");    String[] directorio = dir.list();    String parent = dir.getName();    Calendar cal = Calendar.getInstance();    int diasemana = cal.get(cal.DAY_OF_WEEK);    String dia = new String();    switch (diasemana)    {      case 1:        dia = "Domingo";        break;      case 2:        dia = "Lunes";        break;      case 3:        dia = "Martes";        break;      case 4:        dia = "Miércoles";        break;      case 5:        dia = "Jueves";        break;      case 6:        dia = "Viernes";        break;      case 7:        dia = "Sábado";        break;    }// Create a buffer for reading the files    byte[] buf = new byte[1024];    try    {      // Create the ZIP file      crearDir.crearDirectorio(BackupDir + System.getProperty("file.separator") +                               dia);      String backupName = BackupDir + System.getProperty("file.separator") +                          dia;      String outFilename = backupName + System.getProperty("file.separator") +                           parent + ".zip";      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(          outFilename));      // Compress the files      for (String x : directorio)      {        FileInputStream in = new FileInputStream(parent +                                                 System.getProperty(                                                     "file.separator") + x);        // Add ZIP entry to output stream.        out.putNextEntry(new ZipEntry(parent +                                      System.getProperty("file.separator") + x));        // Transfer bytes from the file to the ZIP file        int len;        while ((len = in.read(buf)) > 0)        {          out.write(buf, 0, len);        }        // Complete the entry        out.closeEntry();        in.close();      }      // Complete the ZIP file      out.setLevel(9);      out.close();    }    catch (IOException e)    {    }  }  public static void main(String[] args)  {    clsBackupZip makezip = new clsBackupZip();  }}