package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class FontExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom JLabels with Fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));

        String[] fontNames = {
               "Segoe UI Black" ,

                "Arial Rounded MT Bold" ,
                       "Berlin Sans FB",

                       "Franklin Gothic Heavy",
                       "Gill Sans MT",

        };

        for (String fontName : fontNames) {
            JLabel label = new JLabel("Texto Personalizado");
            label.setFont(new Font(fontName, Font.PLAIN, 16));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(label);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
