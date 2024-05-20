package Presentation.View.Custom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


/**
 * Classe CustomRenderer per renderitzar les cel·les personalitzades de la taula.
 */
public class CustomRenderer extends DefaultTableCellRenderer {

    private int borderThickness = 5;


    /**
     * Constructor de CustomRenderer.
     *
     * @param borderThickness el gruix del vora de la cel·la.
     */
    public CustomRenderer(int borderThickness) {
        this.borderThickness = borderThickness;
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Sobreescriu el mètode getTableCellRendererComponent per personalitzar les cel·les de la taula.
     *
     * @param table       la taula a renderitzar.
     * @param value       el valor de la cel·la.
     * @param isSelected  true si la cel·la està seleccionada; false altrament.
     * @param hasFocus    true si la cel·la té el focus; false altrament.
     * @param row         la fila de la cel·la.
     * @param column      la columna de la cel·la.
     * @return la component de la cel·la renderitzada.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Ajustar el borde de la celda
        ((JComponent) cell).setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, 0, 0, Color.decode("#DB5C39")));

        return cell;
    }
}
