package Presentation.View;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de les vista de la pantalla de start.
 */
public class StartView extends JFrame {

    public StartView() {

        //Marcar-li al JFrame un titol i tamany 800x450
        setTitle("Register View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new BorderLayout()); // Layout de la ventana principal

        //Crear el label del títol fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));

        //Crear els botons fent us de la classe CustomButton
        CustomButton newGameButton = new CustomButton("New Game", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        newGameButton.applyCustomStyles();
        CustomButton startGameButton = new CustomButton("Start Game", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        startGameButton.applyCustomStyles();
        CustomButton statisticsButton = new CustomButton("Statistics", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        statisticsButton.applyCustomStyles();

        //Crear el logo amb la foto del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);


        //Panell esquerra que contindrà la imatge del logo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.decode("#F8F2F0"));
        panelIzquierdo.setLayout(new BorderLayout());               //Crear Layout del panell esquerra per poder posar el logo
        panelIzquierdo.add(logoLabel);                              //Afegir el logo al panell esquerra
        add(panelIzquierdo, BorderLayout.WEST);                     //Afegir el panell esquerra a la finestra principal, a l'esquerra


        //Creació del panell central que conté la informació per l'usuari
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.decode("#F8F2F0"));
        panelInfo.setLayout(new GridBagLayout());                   //Crear GridBagLayout del panell central per poder posar els elements
        GridBagConstraints gbcCent = new GridBagConstraints();

        //Afegir el Titol
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(titleLabel, gbcCent);

        //Afegir el botó de new game
        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(newGameButton, gbcCent);

        //Afegir el botó de start game
        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(startGameButton, gbcCent);

        //Afegir el botó de statistics
        gbcCent.gridx = 0;
        gbcCent.gridy = 3;
        gbcCent.insets = new Insets(20, 0, 20, 0);
        panelInfo.add(statisticsButton, gbcCent);

        //Afegir el panell a la finestra
        add(panelInfo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartView StartView = new StartView();
            StartView.setVisible(true);
        });
    }
}
