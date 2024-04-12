package Presentation.View;

import javax.swing.*;
import java.awt.*;



public class RegisterView extends JFrame {

    public static JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 20));
        textField.setBackground(Color.decode("#C3986A"));
        Font font = new Font("Bell MT", Font.BOLD, 14);
        textField.setFont(font);
        return textField;
    }

    public RegisterView() {

        CreateLabel titleLabel = new CreateLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 24), Color.decode("#3B1211"));

        CreateLabel usernameLabel = new CreateLabel("Username:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        JTextField usernameField = createTextField();

        CreateLabel emailLabel = new CreateLabel("Email:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        JTextField emailField = createTextField();

        CreateLabel passwordLabel = new CreateLabel("Password:", new Font("Segoe UI Black", Font.PLAIN, 16),Color.decode("#3B1211"));
        JTextField passwordField = createTextField();

        CreateLabel confirmationLabel = new CreateLabel("Password: Confirmation", new Font("Segoe UI Black", Font.PLAIN, 16),Color.decode("#3B1211"));
        JTextField confirmationField = createTextField();

        OvalButton nextButton = new OvalButton("NEXT", 120, 20, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 16));
        nextButton.applyCustomStyles();
        OvalButton loginButton = new OvalButton("LOGIN", 120, 20, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 16));
        loginButton.applyCustomStyles();

        //PANTALLA GENERAL
        setTitle("Register View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new GridBagLayout()); // Layout de la ventana principal

        //PANELL Titol
        setLayout(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#DB5C39"));
        ImageIcon logoIcon = new ImageIcon("Imagenes/logoSmall.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        //PANELL central
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbcCent = new GridBagConstraints();

        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(10, 0, 20, 300);
        panelInfo.add(logoLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(10, 20, 20, 0);
        panelInfo.add(titleLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(0, 0, 0, 225);
        panelInfo.add(usernameLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(usernameField, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 3;
        gbcCent.insets = new Insets(20, 0, 0, 255);
        panelInfo.add(emailLabel, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 4;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(emailField, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 5;
        gbcCent.insets = new Insets(20, 0, 0, 225);
        panelInfo.add(passwordLabel, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 6;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(passwordField, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 7;
        gbcCent.insets = new Insets(20, 0, 0, 130);
        panelInfo.add(confirmationLabel, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 8;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(confirmationField, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 9;
        gbcCent.insets = new Insets(30, 0, 0, 0);
        panelInfo.add(nextButton, gbcCent);

        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 9;
        gbcCent.insets = new Insets(30, 450, 0, 0);
        panelInfo.add(loginButton, gbcCent);


        panelInfo.setBackground(Color.decode("#F8F2F0"));
        add(panelInfo, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegisterView registerView = new RegisterView();
            registerView.setVisible(true);
        });
    }


}
