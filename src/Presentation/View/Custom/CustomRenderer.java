package Presentation.View.Custom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomRenderer extends DefaultTableCellRenderer {

    private int borderThickness = 5;

    public CustomRenderer(int borderThickness) {
        this.borderThickness = borderThickness;
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Ajustar el borde de la celda
        ((JComponent) cell).setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, 0, 0, Color.decode("#DB5C39")));

        return cell;
    }
}
