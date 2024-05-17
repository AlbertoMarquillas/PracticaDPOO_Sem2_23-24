package Presentation.View;

import Presentation.View.Custom.CustomButton;
import Presentation.View.Custom.CustomLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Classe de les vista de la pantalla de settings.
 */
public class SettingsView extends JPanel implements KeyListener, ActionListener {

    private static final String DELETE = "delete";
    private static final String CLOSE = "close";
    private static final String BACK = "back";

    private CustomButton deleteButton;
    private CustomButton closeButton;

    private CustomButton backButton;

    /**
     * Constructor de la classe SettingsView.
     */
    public SettingsView() {

        //Marcar-li al JFrame un titol i tamany 800x450
        //setTitle("Settings View");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new BorderLayout()); // Layout de la ventana principal

        //Inicialització del Label del títol fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));

        //Inicialització dels botons fent us de la classe CustomButton
        deleteButton = new CustomButton("Delete Account", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        closeButton = new CustomButton("LogOut", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        backButton = new CustomButton("Back", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        //Inicialitzem la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logoSmall.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);


        //Panell amb els element
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.decode("#F8F2F0"));
        panelInfo.setLayout(new GridBagLayout());               //Crear GridBagLayout del panell central per poder posar els elements
        GridBagConstraints gbcCent = new GridBagConstraints();

        //Afegir el Logo
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(30, 0, 0, 400);
        panelInfo.add(logoLabel, gbcCent);

        //Afegir el Titol
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(45, 70, 0, 0);
        panelInfo.add(titleLabel, gbcCent);

        //Afegir els botó de delete
        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(deleteButton, gbcCent);

        //Afegir els botó de close
        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(closeButton, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 3;
        gbcCent.insets = new Insets(50, 0, 50, 0);
        panelInfo.add(backButton, gbcCent);

        //Afegir el panell a la finestra
        add(panelInfo, BorderLayout.CENTER);
    }

    /**
     * Mètode per controlar els botons de la vista.
     * @param rvc ActionListener
     */
    public void buttonController(ActionListener rvc){
        deleteButton.addActionListener(rvc);
        deleteButton.setActionCommand(DELETE);
        closeButton.addActionListener(rvc);
        closeButton.setActionCommand(CLOSE);
        backButton.addActionListener(rvc);
        backButton.setActionCommand(BACK);
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
