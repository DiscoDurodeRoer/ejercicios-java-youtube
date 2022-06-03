package ejercicio_interfaces_graficas_ddr_12;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRendererNum extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        
        int num = (int) table.getValueAt(row, column);
        
        if (num<=8) {
            this.setBackground(Color.RED);
        } else {
            this.setBackground(Color.GREEN);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}
