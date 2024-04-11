
/*
#DB5C39 naranja
#3B1211 marron oscuro
#F8F2F0 blanco
#C3986A marron claro
 */

package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class HomeView {
    public static void main(String[] args) {

        // Crear la finestra
        JFrame frame = new JFrame("Home View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        //Crear el boto
        OvalButton button = new OvalButton("Hola", 120, 30, Color.cyan, Color.GREEN, new Font("Arial", Font.PLAIN, 16));
        button.applyCustomStyles();

        //afegir el boto al panel
        JPanel panel = new JPanel();
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }
}
