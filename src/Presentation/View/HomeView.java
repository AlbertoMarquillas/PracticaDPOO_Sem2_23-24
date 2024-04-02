package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {

    public static JButton createButton(String string) {
        JButton button = new JButton(string);
        button.setPreferredSize(new Dimension(70, 15));
        button.setBackground(Color.decode("#C3986A"));
        button.setForeground(Color.decode("#F8F2F0"));
        button.setFont(new Font("Bell MT", Font.PLAIN, 12));
        return button;
    }

    public static JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.decode("#3B1211"));
        return label;
    }

    public static JTextField createTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setPreferredSize(new Dimension(300, 20));
        textField.setFont(new Font("Bell MT", Font.PLAIN, 12));
        return textField;
    }

    public HomeView() {
        //init botons i textos
        // RegisterButtong = new JButton("Register");
        JButton RegisterButtong = createButton("Register");
        JButton loginButton = createButton("LOGIN");
        //createButton(loginButton);
        JLabel usernameLabel = createLabel("User:", new Font("Arial", Font.PLAIN, 16), Color.decode("#3B1211"));
        JLabel passwordLabel = createLabel("Password:", new Font("Arial", Font.PLAIN, 16),Color.decode("#3B1211"));
        JLabel titleLabel = createLabel("COFFEE CLICKER", new Font("Arial", Font.BOLD, 30), Color.decode("#3B1211"));
        JLabel infoLabel = createLabel("Dont have an account?", new Font("Arial", Font.PLAIN, 12), Color.decode("#3B1211"));
        JTextField userName = createTextField("UserName");
        JTextField password = createTextField("Password");

        //PANTALLA GENERAL
        setTitle("Initial View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new GridBagLayout()); // Layout de la ventana principal

        //PANELL ESQUERRA
        setLayout(new BorderLayout());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.decode("#DB5C39"));
        add(panelIzquierdo, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#F8F2F0"));
        add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#DB5C39"));
        add(rightPanel, BorderLayout.EAST);

        //ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        //JLabel logoLabel = new JLabel(logoIcon);

        /*panelIzquierdo.setLayout(new GridBagLayout());
        GridBagConstraints gbcPri = new GridBagConstraints();
        gbcPri.gridx = 0;
        gbcPri.gridy = 0;
        gbcPri.insets = new Insets(20, 0, 20, 0);
        panelIzquierdo.add(logoLabel, gbcPri);*/

        //AÑADIR LA IMAGEN EN EL CENTO DEL PANEL



        //PANELL DRET
        /*JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbcSec = new GridBagConstraints();

        gbcSec.gridx = 0;
        gbcSec.gridy = 0;
        gbcSec.insets = new Insets(50, 10, 0, 10);
        panelInfo.add(titleLabel, gbcSec);

        gbcSec.gridx = 0;
        gbcSec.gridy = 1;
        gbcSec.insets = new Insets(30, 0, 5, 260);
        panelInfo.add(usernameLabel, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 2;
        gbcSec.insets = new Insets(0, 0, 20, 0);
        panelInfo.add(userName, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 3;
        gbcSec.insets = new Insets(20, 0, 5, 225);
        panelInfo.add(passwordLabel, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 4;
        gbcSec.insets = new Insets(0, 0, 20, 0);
        panelInfo.add(password, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 8;
        gbcSec.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(loginButton, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 10;
        gbcSec.insets = new Insets(50, 100, 0, 0);
        panelInfo.add(infoLabel, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 10;
        gbcSec.insets = new Insets(50, 350, 0, 0);
        panelInfo.add(RegisterButtong, gbcSec);

        panelInfo.setBackground(Color.decode("#DB5C39"));
        add(panelInfo, BorderLayout.CENTER);*/


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeView homeView = new HomeView();
            homeView.setVisible(true);
        });
    }
}


/*
#DB5C39 naranja
#3B1211 marron oscuro
#F8F2F0 blanco
#C3986A marron claro
 */
