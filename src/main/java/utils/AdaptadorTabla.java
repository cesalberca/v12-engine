package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AdaptadorTabla extends DefaultTableCellRenderer {
    // Para adaptar el jtable y aparezca la imagen pero sobre un jlabel.
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if(value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            return lbl;
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
