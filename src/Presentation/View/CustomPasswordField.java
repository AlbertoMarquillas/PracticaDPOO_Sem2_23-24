package Presentation.View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Classe que crea una camp de contrasenya personalitzat.
 */
public class CustomPasswordField extends JPasswordField {
    private final int width;                // L'amplada del camp de contrasenya.
    private final int height;               // L'altura del camp de contrasenya.
    private final Color backgroundColor;    // El color de fons del camp de contrasenya.
    private final Font userFont;            // La font per al text del camp de contrasenya.


    /**
     * Constructor, crea un CustomPasswordField amb propietats personalitzades.
     * @param width L'amplada del camp de contrasenya.
     * @param height L'altura del camp de contrasenya.
     * @param backgroundColor El color de fons del camp de contrasenya.
     * @param userFont La font per al text del camp de contrasenya.
     */
    public CustomPasswordField(int width, int height, Color backgroundColor, Font userFont) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.userFont = userFont;

        initializePasswordField();
    }


    /**
     * Inicialitza el camp de contrasenya.
     */
    void initializePasswordField() {
        setPreferredSize(new Dimension(width, height));
        setBackground(backgroundColor);
        setFont(userFont);
        setForeground(Color.white);
        setBorder(BorderFactory.createLineBorder(backgroundColor));
        setEchoChar('*'); // Configurar el carácter de ocultación (puedes usar '*' u otro carácter)
    }


    /**
     * Sobreescriu el mètode paintComponent per personalitzar l'aparença del camp de contrasenya.
     * @param g El context gràfic per a la pintura.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Paint oldPaint = g2.getPaint();
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight() - 1, 18, 18); // Oval corners
        g2.clip(r2d);
        g2.setPaint(backgroundColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 18, 18);
        g2.setPaint(oldPaint);
        super.paintComponent(g);
    }

}
