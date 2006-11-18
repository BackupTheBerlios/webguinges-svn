/**
 * Main.java
 * */
package com.carama.app.guinges.ui.principal;

import java.awt.*;

import com.carama.app.guinges.ui.login.Login;
import com.carama.app.guinges.utils.*;
import javax.swing.UIManager;
import javax.swing.plaf.InsetsUIResource;

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
public class Main {
	private final boolean packFrame = false;

	//Necesitamos la clase ConfigIni para acceder al fichero guinges.ini

	private static ConfigIni config = new ConfigIni();

	// Necesitamos la clase RutaDeFicheros para conocer el path del fichero guinges.ini

	private static PathDirAndFiles pathfile = new PathDirAndFiles();

	//Almacenamos en una variable el valor que nos devuelve la clave "app.laf" del fichero guinges.ini
	// que viene a ser el lookandfeel con el que arranca la aplicacion

	private static String lafvalue = config.obtenerValorIni(pathfile
			.iniFileName(), "app.laf");

	/**
	 * Construct and show the application.
	 */
	public Main() {
		Login frame = new Login();
		// Validate frames that have preset sizes
		// Pack frames that have useful preferred size info, e.g. from their layout
		if (packFrame) {
			frame.pack();
		} else {
			frame.validate();
		}

		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
		frame.repaint();
	}

	/**
	 * Application entry point.
	 *
	 * @param args String[]
	 */
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//LookAndFeelAddons.setAddon(MetalLookAndFeelAddons.class);
			CaramaLookAndFeel userLookAndFeel = new CaramaLookAndFeel();
			Insets m = (Insets) UIManager.get("TextField.margin");
			UIManager.put("TextField.margin", new InsetsUIResource(m.top,
					m.left + 5, m.bottom, m.right));
			final int look = Integer.parseInt(lafvalue);
			switch (look) {
			case 1:
				userLookAndFeel.setRedmondLookAndFeel();
				break;
			case 2:
				userLookAndFeel.setMetalLookAndFeel();
				break;
			case 3:
				userLookAndFeel.setNimrodLookAndFeel();
				break;
			case 4:
				userLookAndFeel.setTonicLookAndFeel();
				break;
			case 5:
				userLookAndFeel.setTinyLookAndFeel();
				break;
			case 6:
				userLookAndFeel.setJGoogiesLookAndFeel();
				break;
			case 7:
				userLookAndFeel.setAquaLookAndFeel();
				break;
			case 8:
				userLookAndFeel.setPagosoftLookAndFeel();
				break;

			default:
				userLookAndFeel.setMetalLookAndFeel();
			}
			// */
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		new Main();
	}
}
