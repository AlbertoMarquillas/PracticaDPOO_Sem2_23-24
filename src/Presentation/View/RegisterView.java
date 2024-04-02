package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {

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

    public RegisterView() {

        JLabel titleLabel = createLabel("COFFEE CLICKER", new Font("Arial", Font.PLAIN, 24), Color.decode("#DB5C39"));
        JLabel usernameLabel = createLabel("Username:", new Font("Arial", Font.PLAIN, 16), Color.decode("#DB5C39"));
        JTextField usernameField = createTextField("Username");

        JLabel emailLabel = createLabel("Email:", new Font("Arial", Font.PLAIN, 16), Color.decode("#DB5C39"));
        JTextField emailField = createTextField("Email");

        JLabel passwordLabel = createLabel("Password:", new Font("Arial", Font.PLAIN, 16),Color.decode("#DB5C39"));
        JTextField passwordField = createTextField("Password");

        JLabel confirmationLabel = createLabel("Password: Confirmation", new Font("Arial", Font.PLAIN, 16),Color.decode("#DB5C39"));
        JTextField confirmationField = createTextField("Password Confirmation");

        JButton nextButton = createButton("NEXT");
        JButton loginButton = createButton("LOGIN");

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
