package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {
    private int width;
    private int height;
    private Color backgroundColor;
    private Font userFont;

    /*
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

        //initializeTextField();
    }

    void initializeTextField() {
        setPreferredSize(new Dimension(width, height));
        setBackground(backgroundColor);
        setFont(userFont);
    }

    // Getters and setters for customization options
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        initializeTextField();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        initializeTextField();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        initializeTextField();
    }

    public Font getUserFont() {
        return userFont;
    }

    public void setUserFont(Font userFont) {
        this.userFont = userFont;
        initializeTextField();
    }
}
