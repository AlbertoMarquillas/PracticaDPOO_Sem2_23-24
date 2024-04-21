package Presentation.View.Custom;

import javax.swing.*;
import java.awt.*;


/**
 * Classe que crea un label personalitzat.
 */
public class CustomLabel extends JLabel {
    private String text;    // El text que es vol mostrar.
    private Font font;      // La font del text.
    private Color color;    // El color del text.


    /**
     * Constructor de la classe CreateLabel
     *
     * @param text El text que es vol mostrar.
     * @param font La font del text.
     * @param color El color del text.
     */
    public CustomLabel(String text, Font font, Color color) {
        super(text);
        setFont(font);
        setForeground(color);
    }


    /**
     * Getter i setter per a la propietat color.
     * @return El color del text.
     */
    public Color getForeground() {
        return color;
    }


    /**
     * Setter per a la propietat color.
     * @param color El color del text.
     */
    public void setForeground(Color color) {
        this.color = color;
    }


    /**
     * Getter i setter per a la propietat font.
     * @return La font del text.
     */
    public Font getFont() {
        return font;
    }


    /**
     * Setter per a la propietat font.
     * @param font La font del text.
     */
    public void setFont(Font font) {
        this.font = font;
    }


    /**
     * Getter i setter per a la propietat text.
     * @return El text que es vol mostrar.
     */
    public String getText() {
        return text;
    }


    /**
     * Setter per a la propietat text.
     * @param text El text que es vol mostrar.
     */
    public void setText(String text) {
        this.text = text;
    }

}




