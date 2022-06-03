package ejercicio_interfaces_graficas_ddr_12;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRendererFila extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (row % 2 == 0) {
            this.setBackground(Color.RED);
        } else {
            this.setBackground(Color.GREEN);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}
