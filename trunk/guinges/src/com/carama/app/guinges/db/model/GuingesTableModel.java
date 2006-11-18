/**
 * GuingesTableModel.java
 * */
package com.carama.app.guinges.db.model;

import java.sql.Connection;

import com.carama.app.guinges.utils.ScrollableTableModel;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.AlternateRowHighlighter;
import javax.swing.JTable;
import org.jdesktop.swingx.decorator.HighlighterPipeline;
import java.awt.Color;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseEvent;

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
public class GuingesTableModel
{

  /**
   * Metodo que devuelve el tableModel que vamos a utilizar
   * @param conn Connection
   * @param query String
   * @return ScrollableTableModel
   */
  public ScrollableTableModel mostrarGrupo(Connection conn, String query)
  {
    ScrollableTableModel model = new ScrollableTableModel(conn, query);
    return model;
  }

  /**
   * Metodo para para configurar la tabla
   * @param table JXTable
   */
  public void configureHighlighters(JXTable table)
  {
    HighlighterPipeline highlighters = new HighlighterPipeline();
    highlighters.addHighlighter(new AlternateRowHighlighter());
    table.setHorizontalScrollEnabled(true);
    table.getVisibleRowCount();
    table.setColumnControlVisible(true);
    table.selectAll();
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    table.setRowHeightEnabled(true);
    table.setHighlighters(highlighters);
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(false);
    table.setGridColor(Color.ORANGE);
    table.setColumnSelectionAllowed(true);
    table.setRowSelectionAllowed(true);
  }

  /**
   * Metodo para mostar el tooltip en la tabla
   *
   * @param table JXTable
   * @return JTableHeader
   */
  public JTableHeader tooltipHeader(JXTable table)
  {
    JTableHeader header = new JTableHeader(table.getColumnModel())
    {
      public String getToolTipText(MouseEvent me)
      {
        int col = columnAtPoint(me.getPoint());
        if (col < 0)
        {
          return null;
        }
        else
        {
          return getTable().getColumnName(col);
        }
      }
    };
    return header;
  }
}
