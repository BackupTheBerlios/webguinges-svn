package com.carama.app.guinges.utils;

import java.util.*;

import org.jdom.*;
import org.jdom.input.SAXBuilder;


public class XMLReader
{

  public static void main(String[] args)
  {
    try
    {
      SAXBuilder builder = new SAXBuilder(false);
      //usar el parser Xerces y no queremos
      //que valide el documento
      Document doc = builder.build("liga.xml");
      //construyo el arbol en memoria desde el fichero
      // que se lo pasaré por parametro.
      Element raiz = doc.getRootElement();
      //cojo el elemento raiz
      System.out.println("La liga es de tipo:" + raiz.getAttributeValue("tipo"));
      //todos los hijos que tengan como nombre plantilla
      List equipos = raiz.getChildren("equipo");
      System.out.println("Formada por:" + equipos.size() + " equipos");
      Iterator i = equipos.iterator();
      while (i.hasNext())
      {
        Element e = (Element)i.next();
        //primer hijo que tenga como nombre club
        Element club = e.getChild("club");
        List plantilla = e.getChildren("plantilla");
        Element presidentes = e.getChild("presidente");
        String strPresidentes = presidentes.getText();
        Element plantel = e.getChild("plantilla");
        List lstnombre = plantel.getChildren("nombre");
        //Attribute atrnombre = plantel.getAttribute("nombre");
        String atrnombre = plantel.getChildText("nombre");
	  //String strnombre = atrnombre.getValue();
        System.out.println(club.getText() + ":" + "valoracion= " +
                           club.getAttributeValue("valoracion") + "," +
                           "ciudad = " + club.getAttributeValue("ciudad") + " Presidente = " +
                           strPresidentes + "," + "formada por: " +
                           lstnombre.size() + " jugadores" + " que son los siguientes: " +
                           atrnombre);
        if (e.getChildren("conextranjeros").size() == 0)
        {
          System.out.println("No tiene extranjeros");
        }
        else
        {
          System.out.println("Tiene extranjeros");
        }

      }
      // Dejamos de mano del lector el sacar el nombre
      //de los arbitros, animate!!
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
