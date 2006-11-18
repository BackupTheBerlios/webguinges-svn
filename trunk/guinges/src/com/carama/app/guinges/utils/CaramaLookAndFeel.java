/**
 * Clase CaramaLookAndFeel.java
 * */
package com.carama.app.guinges.utils;

import javax.swing.UIManager;

import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.aqua.AquaLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsClassicLookAndFeelAddons;
import com.pagosoft.plaf.PlafOptions;

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
public class CaramaLookAndFeel
{
  private EscribeLogs error = new EscribeLogs();
  /**
   * Metodo para mostrar el look Nimrod
   * */
  public void setNimrodLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrar NimrodLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

  /**
   * Metodo para mostrar el look JGoodies
   * */
  public void setJGoogiesLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrar JGoodies -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

  /**
   * Metodo para mostrar el look Tiny
   * @since 31/07/2006
   * */
  public void setTinyLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel");
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrarsetTinyLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

  /**
   * Metodo para mostrar el look Pagosoft
   * @since 31/07/2006
   * */
  public void setPagosoftLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
      PlafOptions.setAntialiasingEnabled(true);
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrarsetTinyLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

  /**
   * Metodo para mostrar el look Aqua
   * */
  public void setAquaLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      LookAndFeelAddons.setAddon(AquaLookAndFeelAddons.class);
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrar AquaLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true);
    }
  }

  /**
   * Metodo para mostrar el look Nativo
   * */
  public void setRedmondLookAndFeel()
  {
    try
    {
      if (!System.getProperty("os.name").startsWith("Windows"))
      {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      else
      {
        UIManager.setLookAndFeel("smooth.windows.SmoothLookAndFeel");
      }
      LookAndFeelAddons.setAddon(WindowsClassicLookAndFeelAddons.class);

    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrar setRedmondLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

  /**
   * Metodo para mostrar el look Java
   * */
  public void setMetalLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel("smooth.metal.SmoothLookAndFeel");
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrar JavaLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

  /**
   * Metodo para mostrar el look Java
   * */
  public void setTonicLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel("com.digitprop.tonic.TonicLookAndFeel");
    }
    catch (Exception e)
    {
      error.escribeError("Intento de mostrar JavaLookAndFeel -Mensaje: " +
                         e.getLocalizedMessage() + " " + e.getCause() +
                         ", " +
                         e.getClass(), true
          );
    }
  }

}
