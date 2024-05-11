package Presentation.View;

import Presentation.View.Custom.CustomButton;
import Presentation.View.Custom.CustomLabel;
import Presentation.View.Custom.CustomPasswordField;
import Presentation.View.Custom.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Classe de les vistes de la pantalla inicial.
 */
public class InitialView extends JPanel implements KeyListener{

    public static final String REGISTER = "register";
    public static final String LOGIN = "login";


    private CustomButton registerButton;
    private CustomButton loginButton;
    private CustomTextField userNameField;
    private CustomPasswordField passwordField;


    /**
     * Constructor de la classe InitialView.
     */
    public InitialView() {
        setSize(800, 450);
        //Inicialitzem els botons fent us de la classe CustomButton
        registerButton = new CustomButton("REGISTER", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        loginButton = new CustomButton("LOGIN", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        loginButton.addKeyListener(this);

        //Inicialitzem els labels fent us de la classe CustomLabel
        CustomLabel usernameLabel = new CustomLabel("User:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#F8F2F0"));
        CustomLabel passwordLabel = new CustomLabel("Password:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#F8F2F0"));
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.BOLD, 50), Color.decode("#F8F2F0"));
        CustomLabel infoLabel =  new CustomLabel("Don't have an account?", new Font("Segoe UI Black", Font.PLAIN, 12), Color.decode("#F8F2F0"));

        //Inicialitzem els textFields fent us de la classe CustomTextField
        userNameField = new CustomTextField(300, 30, Color.decode("#3B1211"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        passwordField = new CustomPasswordField(300, 30, Color.decode("#3B1211"), new Font("Berlin Sans FB", Font.PLAIN, 14));

        //Inicialitzem la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        //Creació del panell principal i finestra de tamany 800x450
        //setTitle("Initial View");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setLayout(new BorderLayout());  // Layout de la finestra principal per posar els dos subpanells

        //Creació del panell esquerra que conté el logo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.decode("#DB5C39"));
        panelIzquierdo.setLayout(new BorderLayout());               //Crear Layout del panell esquerra per poder posar el logo
        panelIzquierdo.add(logoLabel);                              //Afegir el logo al panell esquerra
        add(panelIzquierdo, BorderLayout.WEST);                     //Afegir el panell esquerra a la finestra principal, a l'esquerra

        //Creació del panell central que conté la informació per l'usuari
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.decode("#DB5C39"));
        panelInfo.setLayout(new GridBagLayout());                   //Crear GridBagLayout del panell central per poder posar els elements
        GridBagConstraints gbcSec = new GridBagConstraints();

        //Afegir el titol al panell central
        gbcSec.gridx = 0;
        gbcSec.gridy = 0;
        gbcSec.insets = new Insets(40, 10, 0, 10);
        panelInfo.add(titleLabel, gbcSec);

        //Afegir el JLabel d'usuari
        gbcSec.gridx = 0;
        gbcSec.gridy = 1;
        gbcSec.insets = new Insets(20, 0, 5, 250);
        panelInfo.add(usernameLabel, gbcSec);

        //Afegir el JTextField d'usuari
        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 2;
        gbcSec.insets = new Insets(0, 0, 20, 0);
        panelInfo.add(userNameField, gbcSec);

        //Afegir el JLabel de la contrasenya
        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 3;
        gbcSec.insets = new Insets(10, 0, 5, 210);
        panelInfo.add(passwordLabel, gbcSec);

        //Afegir el JPasswordField de la contrasenya
        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 4;
        gbcSec.insets = new Insets(0, 0, 20, 0);
        panelInfo.add(passwordField, gbcSec);

        //Afegir el botó de login
        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 8;
        gbcSec.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(loginButton, gbcSec);

        //Afegir el JLabel de "Don't have an account?"
        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 10;
        gbcSec.insets = new Insets(40, 0, 0, 0);
        panelInfo.add(infoLabel, gbcSec);

        //Afegir el botó de registre
        gbcSec = new GridBagConstraints();
        gbcSec.gridx = 0;
        gbcSec.gridy = 10;
        gbcSec.insets = new Insets(40, 300, 0, 0);
        panelInfo.add(registerButton, gbcSec);

        //Afegir el panell central a la finestra principal
        add(panelInfo, BorderLayout.CENTER);

    }

    /**
     * Metode per controlar els botons de la vista
     * @param rvc ActionListener
     */
    public void buttonController(ActionListener rvc){
        registerButton.addActionListener(rvc);
        registerButton.setActionCommand(REGISTER);
        loginButton.addActionListener(rvc);
        loginButton.setActionCommand(LOGIN);
    }

    /**
     * Metode per obtenir el nom d'usuari
     * @return String amb el nom d'usuari
     */
    public String getUsernameField() {
        return userNameField.getText();
    }


    /**
     * Metode per obtenir la contrasenya
     * @return String amb la contrasenya
     */
    public String getPasswordField() {
        return String.valueOf(passwordField.getPassword());
    }


    /**
     * Metode per obtenir el botó de registre
     * @return CustomButton del botó de registre
     */
    public CustomButton getRegisterButton() {
        return registerButton;
    }


    /**
     * Metode per obtenir el botó de login
     * @return CustomButton del botó de login
     */
    public CustomButton getLoginButton() {
        return loginButton;
    }


    /**
     * Metode per establir el nom d'usuari
     * @param passwordField String amb el nom d'usuari
     */
    public void setPasswordField(String passwordField) {
        this.passwordField.setText(passwordField);
    }


    /**
     * Metode per establir la contrasenya
     * @param username String amb la contrasenya
     */
    public void setUsernameField(String username) {
        this.userNameField.setText(username);
    }


    /**
     * Metode per establir el botó de registre
     * @param registerButton CustomButton del botó de registre
     */
    public void setRegisterButton(CustomButton registerButton) {
        this.registerButton = registerButton;
    }


    /**
     * Metode per establir el botó de login
     * @param loginButton CustomButton del botó de login
     */
    public void setLoginButton(CustomButton loginButton) {
        this.loginButton = loginButton;
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