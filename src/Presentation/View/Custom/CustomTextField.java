package Presentation.View.Custom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Classe que crea un camp de text personalitzat.
 */
public class CustomTextField extends JTextField {
    private int width;              // L'amplada del camp de text.
    private int height;             // L'altura del camp de text.
    private Color backgroundColor;  // El color de fons del camp de text.
    private Font userFont;          // La font per al text del camp de text.

    /**
        * Constructor, crea un CustomTextField amb propietats personalitzades.
        * @param width L'amplada del camp de text.
        * @param height L'altura del camp de text.
        * @param backgroundColor El color de fons del camp de text.
        * @param userFont La font per al text del camp de text.
     */
    public CustomTextField(int width, int height, Color backgroundColor, Font userFont) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.userFont = userFont;
        initializeTextField();
    }


    /**
     * Inicialitza el camp de text.
     */
    private void initializeTextField() {
        setPreferredSize(new Dimension(width, height));
        setBackground(backgroundColor);
        setFont(userFont);
        //cambiar el color de la fuente del texto
        setForeground(Color.white);
        //cambiar el color del marco del Jtextfield
        setBorder(BorderFactory.createLineBorder(backgroundColor));
    }


    /**
     * Sobreescriu el mètode paintComponent per personalitzar l'aparença del camp de text.
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


    /**
     * Getter i setter per a la propietat width.
     * @return L'amplada del camp de text.
     */
    public int getWidth() {
        return width;
    }


    /**
     * Setter per a la propietat width.
     * @param width L'amplada del camp de text.
     */
    public void setWidth(int width) {
        this.width = width;
        initializeTextField();
    }


    /**
     * Getter i setter per a la propietat height.
     * @return L'altura del camp de text.
     */
    public int getHeight() {
        return height;
    }


    /**
     * Setter per a la propietat height.
     * @param height L'altura del camp de text.
     */
    public void setHeight(int height) {
        this.height = height;
        initializeTextField();
    }


    /**
     * Getter i setter per a la propietat backgroundColor.
     * @return El color de fons del camp de text.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }


    /**
     * Setter per a la propietat backgroundColor.
     * @param backgroundColor El color de fons del camp de text.
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        initializeTextField();
    }


    /**
     * Getter i setter per a la propietat userFont.
     * @return La font per al text del camp de text.
     */
    public Font getUserFont() {
        return userFont;
    }


    /**
     * Setter per a la propietat userFont.
     * @param userFont La font per al text del camp de text.
     */
    public void setUserFont(Font userFont) {
        this.userFont = userFont;
        initializeTextField();
    }

}
