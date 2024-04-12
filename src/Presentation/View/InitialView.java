package Presentation.View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class InitialView extends JFrame {

    public static JTextField createTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setFont(new Font("Bell MT", Font.PLAIN, 12));
        return textField;
    }
    public InitialView() {
        //init botons i textos

        OvalButton RegisterButtong = new OvalButton("register", 120, 20, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        RegisterButtong.applyCustomStyles();

        OvalButton loginButton = new OvalButton("login", 120, 20, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        loginButton.applyCustomStyles();

        CreateLabel usernameLabel = new CreateLabel("User:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        CreateLabel passwordLabel = new CreateLabel("Password:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));

        CreateLabel titleLabel = new CreateLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.BOLD, 30), Color.decode("#3B1211"));
        CreateLabel infoLabel =  new CreateLabel("Dont have an account?", new Font("Segoe UI Black", Font.PLAIN, 12), Color.decode("#3B1211"));

        //JTextField userName = createTextField("UserName");
        CustomTextField userName = new CustomTextField(300, 30, Color.white, new Font("Segoe UI Light", Font.BOLD, 10));
        userName.initializeTextField();
        CustomTextField password = new CustomTextField(300, 30, Color.white, new Font("Segue UI Light", Font.BOLD, 10));
        password.initializeTextField();

        //PANTALLA GENERAL
        setTitle("Initial View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new GridBagLayout()); // Layout de la ventana principal

        //PANELL ESQUERRA
        setLayout(new BorderLayout());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.decode("#DB5C39"));
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        panelIzquierdo.setLayout(new GridBagLayout());
        GridBagConstraints gbcPri = new GridBagConstraints();
        gbcPri.gridx = 0;
        gbcPri.gridy = 0;
        gbcPri.insets = new Insets(20, 0, 20, 0);
        panelIzquierdo.add(logoLabel, gbcPri);

        //AÑADIR LA IMAGEN EN EL CENTO DEL PANEL
        add(panelIzquierdo, BorderLayout.WEST);


        //PANELL DRET
        JPanel panelInfo = new JPanel();
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
        gbcSec.insets = new Insets(20, 0, 5, 220);
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
        gbcSec.insets = new Insets(50, 90, 0, 0);
        panelInfo.add(infoLabel, gbcSec);

        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 10;
        gbcSec.insets = new Insets(50, 350, 0, 0);
        panelInfo.add(RegisterButtong, gbcSec);

        panelInfo.setBackground(Color.decode("#DB5C39"));
        add(panelInfo, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InitialView initialView = new InitialView();
            initialView.setVisible(true);
        });
    }
}


/*
#DB5C39 naranja
#3B1211 marron oscuro
#F8F2F0 blanco
#C3986A marron claro
 */