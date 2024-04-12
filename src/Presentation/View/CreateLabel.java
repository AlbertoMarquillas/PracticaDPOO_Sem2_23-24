package Presentation.View;

import javax.swing.*;
import java.awt.*;
public class CreateLabel extends JLabel {

        private String text;
        private Font font;
        private Color color;

        /**
         * Constructor de la classe CreateLabel
         *
         * @param text El text que es vol mostrar.
         * @param font La font del text.
         * @param color El color del text.
         */
        public CreateLabel(String text, Font font, Color color) {
            super(text);
            setFont(font);
            setForeground(color);
        }


        public Color getForeground() {
            return color;
        }

        public void setForeground(Color color) {
            this.color = color;
        }


        public Font getFont() {
            return font;
        }

        public void setFont(Font font) {
            this.font = font;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
         public static void main(String[] args) {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts) {
            System.out.println(font);
        }


    }


}




