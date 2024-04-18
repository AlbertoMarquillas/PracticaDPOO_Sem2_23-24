package Presentation.View;

import javax.swing.*;
import java.awt.*;


/**
 * Classe de les vistes de la pantalla de registre.
 */
public class RegisterView extends JFrame {

    public RegisterView() {

        //Marcar-li al JFrame un titol i tamany 800x450
        setTitle("Register View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana

        //Inicialització dels Labels fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));
        CustomLabel usernameLabel = new CustomLabel("Username:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        CustomLabel emailLabel = new CustomLabel("Email:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        CustomLabel passwordLabel = new CustomLabel("Password:", new Font("Segoe UI Black", Font.PLAIN, 16),Color.decode("#3B1211"));
        CustomLabel confirmationLabel = new CustomLabel("Password confirmation", new Font("Segoe UI Black", Font.PLAIN, 16),Color.decode("#3B1211"));

        //Inicialització dels textFields fent us de la classe CustomTextField
        CustomTextField usernameField = new CustomTextField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        CustomTextField emailField = new CustomTextField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        CustomPasswordField passwordField = new CustomPasswordField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        passwordField.initializePasswordField();
        CustomPasswordField confirmationField = new CustomPasswordField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        confirmationField.initializePasswordField();

        //Inicialització dels botons fent us de la classe CustomButton
        CustomButton nextButton = new CustomButton("NEXT", 140, 25, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        CustomButton loginButton = new CustomButton("LOGIN", 140, 25, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        //Inicialització la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logoSmall.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);


        //Creació del panell principal
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.decode("#F8F2F0"));
        panelInfo.setLayout(new GridBagLayout());               //Crear GridBagLayout del panell central per poder posar els elements
        GridBagConstraints gbcCent = new GridBagConstraints();

        //Afegir el Logo
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(0, 0, 0, 400);
        panelInfo.add(logoLabel, gbcCent);

        //Afegir el Label del títol
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(15, 70, 0, 0);
        panelInfo.add(titleLabel, gbcCent);

        //Afegir el Label de l'usuari
        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(0, 0, 0, 205);
        panelInfo.add(usernameLabel, gbcCent);

        //Afegir el TextField de l'usuari
        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(usernameField, gbcCent);

        //Afegir el Label de l'email
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 3;
        gbcCent.insets = new Insets(10, 0, 0, 240);
        panelInfo.add(emailLabel, gbcCent);

        //Afegir el TextField de l'email
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 4;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(emailField, gbcCent);

        //Afegir el Label de la contrasenya
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 5;
        gbcCent.insets = new Insets(10, 0, 0, 208);
        panelInfo.add(passwordLabel, gbcCent);

        //Afegir el PasswordField de la contrasenya
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 6;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(passwordField, gbcCent);

        //Afegir el Label de la confirmació de la contrasenya
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 7;
        gbcCent.insets = new Insets(10, 0, 0, 100);
        panelInfo.add(confirmationLabel, gbcCent);

        //Afegir el PasswordField de la confirmació de la contrasenya
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 8;
        gbcCent.insets = new Insets(5, 0, 0, 0);
        panelInfo.add(confirmationField, gbcCent);

        //Afegir el botó de NEXT
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 9;
        gbcCent.insets = new Insets(30, 0, 5, 0);
        panelInfo.add(nextButton, gbcCent);

        //Afegir el botó de LOGIN
        gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 9;
        gbcCent.insets = new Insets(30, 600, 5, 0);
        panelInfo.add(loginButton, gbcCent);

        //Afegir el panell central a la finestra principal
        add(panelInfo, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegisterView registerView = new RegisterView();
            registerView.setVisible(true);
        });
    }


}
