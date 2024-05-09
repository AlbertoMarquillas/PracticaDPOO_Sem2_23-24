package Presentation.View;

import Presentation.View.Custom.CustomButton;
import Presentation.View.Custom.CustomLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StatsView extends JPanel implements KeyListener, ActionListener {

    private CustomButton backButton;
    private static final String BACK = "back";

    /**
     * Constructor de la classe StatsView.
     */
    public StatsView() {
        setLayout(new BorderLayout()); // Layout de la ventana principal
        setBackground(Color.decode("#F8F2F0"));

        //Inicialització del Label del títol fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));

        //Inicialitzem la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logoSmall.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        //Incicialitzar el botó del back
        backButton = new CustomButton("Back", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        //Panell per posar el títol i el logo
        JPanel titolPanel = new JPanel();
        titolPanel.setBackground(Color.decode("#F8F2F0"));
        titolPanel.setLayout(new GridBagLayout());               //Crear GridBagLayout del panell central per poder posar els elements
        GridBagConstraints gbcSup = new GridBagConstraints();

        //Afegir el Logo
        gbcSup.gridx = 0;
        gbcSup.gridy = 0;
        gbcSup.insets = new Insets(30, 0, 0, 400);
        titolPanel.add(logoLabel, gbcSup);

        //Afegir el Titol
        gbcSup.gridx = 0;
        gbcSup.gridy = 0;
        gbcSup.insets = new Insets(45, 70, 0, 0);
        titolPanel.add(titleLabel, gbcSup);


        //Panell per afagir el gràfic de les estadístiques
        //ORIOL FES LA GRÀFICA DE STATS DINTRE D'AQUEST PANELL
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.decode("#F8F2F0"));
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcCent = new GridBagConstraints();//Crear GridBagLayout del panell central per poder posar els elements

        //Afegir el gràfic amb les estadístiques
        //gbcCent.gridx = 0;
        //gbcCent.gridy = 0;
        //gbcCent.insets = new Insets(30, 0, 0, 0);
        //infoPanel.add(backButton, gbcCent);


        //Afegir el botó
        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(30, 0, 0, 0);
        infoPanel.add(backButton, gbcCent);

        add(titolPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
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

    /**
     * Mètode per controlar els botons de la vista.
     * @param rvc ActionListener
     */
    public void buttonController(ActionListener rvc) {
        backButton.addActionListener(rvc);
        backButton.setActionCommand(BACK);
    }
}
