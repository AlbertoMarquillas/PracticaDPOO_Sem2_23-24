package Presentation.View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;


/**
 * Botó personalitzat amb les contonades rodones i propietats configurables.
 */
public class CustomButton extends JButton {
    private Color backgroundColor;      // Color de fons
    private Color textColor;            // Color de text
    private Font textFont;              // Font del text
    private final int ArcWidth = 20;    // Amplada de l'arc
    private int ArcHeight = 20;   // Altura de l'arc



    /**
     * Constructor, crea un OvalButton amb propietats personalitzades.
     *
     * @param text     El text a mostrar al botó.
     * @param width    L'amplada del botó.
     * @param height   L'altura del botó.
     * @param bgColor  El color de fons del botó.
     * @param txtColor El color del text del botó.
     * @param font     La font per al text del botó.
     */
    public CustomButton(String text, int width, int height, Color bgColor, Color txtColor, Font font) {
        super(text);
        setOpaque(false);
        setButtonSize(width, height);
        setBackgroundColor(bgColor);
        setTextColor(txtColor);
        setTextFont(font);
        applyCustomStyles();
    }

    public CustomButton(int width, int height, Color bgColor) {
        setOpaque(false);
        setButtonSize(width, height);
        setBackgroundColor(bgColor);

    }


    /**
     * Sobreescriu el mètode paintComponent per personalitzar l'aparença del botó.
     *
     * @param g El context gràfic per a la pintura.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Paint oldPaint = g2.getPaint();
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight() - 1, getArcWidth(), getArcHeight());
        g2.clip(r2d);
        g2.setPaint(getBackgroundColor());
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 18, 18);
        g2.setPaint(oldPaint);
        super.paintComponent(g);
    }


    /**
     * Aplica els estils personalitzats al botó.
     */
    void applyCustomStyles() {
        setForeground(getTextColor());      // Establecer color de texto
        setFont(getTextFont());             // Establecer fuente de texto
        setContentAreaFilled(false);        // No rellenar el área de contenido
        setBorderPainted(false);            // No dibujar borde
    }


    /**
     * Obté el color de fons del botó.
     *
     * @return El color de fons actual.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }


    /**
     * Estableix el color de fons del botó.
     *
     * @param backgroundColor El color de fons desitjat.
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    /**
     * Obté el color del text del botó.
     *
     * @return El color del text actual.
     */
    public Color getTextColor() {
        return textColor;
    }


    /**
     * Estableix el color del text del botó.
     *
     * @param textColor El color del text desitjat.
     */
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }


    /**
     * Obté la font del text del botó.
     *
     * @return La font actual del text.
     */
    public Font getTextFont() {
        return textFont;
    }


    /**
     * Estableix la font del text del botó.
     *
     * @param textFont La font desitjada per al text.
     */
    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }


    /**
     * Obté l'amplada de les vores arrodonides del botó.
     *
     * @return L'amplada actual de les vores arrodonides.
     */
    public int getArcWidth() {
        return ArcWidth;
    }


    /**
     * Obté l'altura de les vores arrodonides del botó.
     *
     * @return L'altura actual de les vores arrodonides.
     */
    public int getArcHeight() {
        return ArcHeight;
    }


    /**
     * Estableix l'altura de les vores arrodonides del botó.
     *
     * @param arcHeight L'altura desitjada per a les vores arrodonides.
     */
    public void setArcHeight(int arcHeight) {
        this.ArcHeight = arcHeight;
    }


    /**
     * Estableix la mida del botó.
     *
     * @param width  L'amplada desitjada del botó.
     * @param height L'altura desitjada del botó.
     */
    public void setButtonSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        revalidate();
    }

}
