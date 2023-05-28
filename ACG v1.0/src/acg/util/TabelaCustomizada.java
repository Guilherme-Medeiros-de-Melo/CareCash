/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.util;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
public class TabelaCustomizada implements TableCellRenderer{
private static final TableCellRenderer renderer = new DefaultTableCellRenderer();
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(column == 3){
            Object result = table.getModel().getValueAt(row, column);
            float saldo = Float.parseFloat(result.toString().replace("R$ ", "").replace(",", "."));
            Color color = null;
            if(saldo<0){
                color = Color.red;
            }
            else {
                color = Color.green;
            }
            c.setForeground(color);
        }
        else {
            c.setForeground(Color.black);
        }
        return c;
    }
    
}
