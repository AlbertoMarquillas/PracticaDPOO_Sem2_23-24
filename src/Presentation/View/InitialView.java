package Presentation.View;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de les vistes de la pantalla inicial.
 */
public class InitialView extends JFrame {

    public InitialView() {

        //Inicialitzem els botons fent us de la classe CustomButton
        CustomButton RegisterButtong = new CustomButton("REGISTER", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        CustomButton loginButton = new CustomButton("LOGIN", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        //Inicialitzem els labels fent us de la classe CustomLabel
        CustomLabel usernameLabel = new CustomLabel("User:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#F8F2F0"));
        CustomLabel passwordLabel = new CustomLabel("Password:", new Font("Segoe UI Black", Font.PLAIN, 16), Color.decode("#F8F2F0"));
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.BOLD, 50), Color.decode("#F8F2F0"));
        CustomLabel infoLabel =  new CustomLabel("Don't have an account?", new Font("Segoe UI Black", Font.PLAIN, 12), Color.decode("#F8F2F0"));

        //Inicialitzem els textFields fent us de la classe CustomTextField
        CustomTextField userName = new CustomTextField(300, 30, Color.decode("#3B1211"), new Font("Berlin Sans FB", Font.PLAIN, 14));
        CustomPasswordField password = new CustomPasswordField(300, 30, Color.decode("#3B1211"), new Font("Berlin Sans FB", Font.PLAIN, 14));

        //Inicialitzem la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        //Creació del panell principal i finestra de tamany 800x450
        setTitle("Initial View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        panelInfo.add(userName, gbcSec);

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
        panelInfo.add(password, gbcSec);

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
        panelInfo.add(RegisterButtong, gbcSec);

        //Afegir el panell central a la finestra principal
        add(panelInfo, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InitialView initialView = new InitialView();
            initialView.setVisible(true);
        });
    }
}