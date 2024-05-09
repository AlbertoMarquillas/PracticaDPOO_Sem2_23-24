package Presentation.View;

import Presentation.View.Custom.CustomButton;
import Presentation.View.Custom.CustomLabel;
import Presentation.View.Custom.CustomPasswordField;
import Presentation.View.Custom.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Classe de les vistes de la pantalla de registre.
 */
public class RegisterView extends JPanel implements KeyListener, ActionListener {
    private static final String NEXT = "next";
    private static final String LOGIN = "login";
    private CustomTextField usernameField;
    private CustomTextField emailField;
    private CustomPasswordField passwordField;
    private CustomPasswordField confirmationField;
    private CustomButton nextButton;
    private CustomButton loginButton;


    /**
     * Constructor de la classe RegisterView.
     */
    public RegisterView() {
        setBackground(Color.decode("#F8F2F0"));

        //Inicialització dels Labels fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));
        CustomLabel usernameLabel = new CustomLabel("Username:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        CustomLabel emailLabel = new CustomLabel("Email:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#3B1211"));
        CustomLabel passwordLabel = new CustomLabel("Password:", new Font("Segoe UI Black", Font.PLAIN, 16),Color.decode("#3B1211"));
        CustomLabel confirmationLabel = new CustomLabel("Password confirmation", new Font("Segoe UI Black", Font.PLAIN, 16),Color.decode("#3B1211"));

        //Inicialització dels textFields fent us de la classe CustomTextField
        usernameField = new CustomTextField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        emailField = new CustomTextField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        passwordField = new CustomPasswordField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        confirmationField = new CustomPasswordField(300, 20, Color.decode("#C3986A"), new Font("Berlin Sans FB", Font.PLAIN, 14));

        //Inicialització dels botons fent us de la classe CustomButton
        nextButton = new CustomButton("NEXT", 140, 25, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        loginButton = new CustomButton("LOGIN", 140, 25, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

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

    /**
     * Funció per afegir un controlador als botons de la vista.
     * @param rvc ActionListener
     */
    public void buttonController(ActionListener rvc){
        nextButton.addActionListener(rvc);
        nextButton.setActionCommand(NEXT);
        loginButton.addActionListener(rvc);
        loginButton.setActionCommand(LOGIN);
    }


    /**
     * Funció per afegir un controlador als textFields de la vista.
     * @return KeyListener per als textFields
     */
    public String getUsernameField() {
        return usernameField.getText();
    }

    /**
     * Funció per obtenir el text del textField de l'email
     * @return String amb el text del textField de l'email
     */
    public String getEmailField() {
        return emailField.getText();
    }

    /**
     * Funció per obtenir el text del textField de la contrasenya
     * @return String amb el text del textField de la contrasenya
     */
    public String getPasswordField() {
        return String.valueOf(passwordField.getPassword());
    }

    /**
     * Funció per obtenir el text del textField de la confirmació de la contrasenya
     * @return String amb el text del textField de la confirmació de la contrasenya
     */
    public String getConfirmPasswordField() {
        return String.valueOf(confirmationField.getPassword());
    }


    /**
     * Funció per obtenir el botó de NEXT
     * @return CustomButton del botó de NEXT
     */
    public CustomButton getNextButton() {
        return nextButton;
    }


    /**
     * Funció per obtenir el botó de LOGIN
     * @return CustomButton del botó de LOGIN
     */
    public CustomButton getLoginButton() {
        return loginButton;
    }

    /**
     * Funció per establir el text del textField de l'usuari
     * @param usernameField String amb el text del textField de l'usuari
     */
    public void setUsernameField(String usernameField) {
        this.usernameField.setText(usernameField);
    }


    /**
     * Funció per establir el text del textField de l'email
     * @param emailField String amb el text del textField de l'email
     */
    public void setEmailField(String emailField) {
        this.emailField.setText(emailField);
    }

    /**
     * Funció per establir el text del textField de la contrasenya
     * @param passwordField String amb el text del textField de la contrasenya
     */
    public void setPasswordField(String passwordField) {
        this.passwordField.setText(passwordField);
    }

    /**
     * Funció per establir el text del textField de la confirmació de la contrasenya
     * @param confirmPasswordField String amb el text del textField de la confirmació de la contrasenya
     */
    public void setConfirmPasswordField(String confirmPasswordField) {
        this.confirmationField.setText(confirmPasswordField);
    }


    /**
     * Funció per establir el botó de NEXT
     * @param nextButton CustomButton del botó de NEXT
     */
    public void setNextButton(CustomButton nextButton) {
        this.nextButton = nextButton;
    }


    /**
     * Funció per establir el botó de LOGIN
     * @param loginButton CustomButton del botó de LOGIN
     */
    public void setLoginButton(CustomButton loginButton) {
        this.loginButton = loginButton;
    }



    /**
     * Gestiona les accions produïdes per l'usuari.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    /**
     * Gestiona un esdeveniment quan s'escriu per pantalla.
     * @param e L'esdeveniment que s'ha produit.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }


    /**
     * Gestiona l'esdeveniment quan una tecla és premuda.
     * @param e L'esdeveniment que representa una tecla que ha estat premuda.
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }


    /**
     * Gestiona l'esdeveniment quan una tecla és alliberada.
     * @param e L'esdeveniment que representa una tecla que ha estat alliberada.
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }


}
