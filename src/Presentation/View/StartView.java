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
 * Classe de les vista de la pantalla de start.
 */
public class StartView extends JPanel implements KeyListener, ActionListener {
    private static final String NEWGAME = "newgame";
    private static final String RESUMEGAME = "resumegame";
    private static final String STATISTICS = "stats";

    private CustomButton newGameButton;
    private CustomButton startGameButton;
    private CustomButton statisticsButton;

    /**
     * Constructor de la classe StartView.
     */
    public StartView() {

        //Marcar-li al JFrame un titol i tamany 800x450
        //setTitle("Start View");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new BorderLayout()); // Layout de la ventana principal

        //Crear el label del títol fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));

        //Crear els botons fent us de la classe CustomButton
        newGameButton = new CustomButton("New Game", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));

        startGameButton = new CustomButton("Resume Game", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        startGameButton.setEnabled(false);
        statisticsButton = new CustomButton("Statistics", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        statisticsButton.setEnabled(false);

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


    /**
     * Mètode per controlar els botons de la vista.
     * @param rvc ActionListener
     */
    public void buttonController(ActionListener rvc){
        startGameButton.addActionListener(rvc);
        startGameButton.setActionCommand(RESUMEGAME);
        newGameButton.addActionListener(rvc);
        newGameButton.setActionCommand(NEWGAME);
        statisticsButton.addActionListener(rvc);
        statisticsButton.setActionCommand(STATISTICS);
    }


    /**
     * Mètode per obtenir el botó de new game.
     * @return CustomButton botó de new game
     */
    public CustomButton getNewGameButton() {
        return newGameButton;
    }


    /**
     * Mètode per obtenir el botó de start game.
     * @return CustomButton botó de start game
     */
    public CustomButton getStartGameButton() {
        return startGameButton;
    }


    /**
     * Mètode per obtenir el botó de statistics.
     * @return CustomButton botó de statistics
     */
    public CustomButton getStatisticsButton() {
        return statisticsButton;
    }

    /**
     * Mètode per assignar el botó de new game.
     * @param newGameButton CustomButton
     */
    public void setNewGameButton(CustomButton newGameButton) {
        this.newGameButton = newGameButton;
    }


    /**
     * Mètode per assignar el botó de start game.
     * @param startGameButton CustomButton
     */
    public void setStartGameButton(CustomButton startGameButton) {
        this.startGameButton = startGameButton;
    }


    /**
     * Mètode per assignar el botó de statistics.
     * @param statisticsButton CustomButton
     */
    public void setStatisticsButton(CustomButton statisticsButton) {
        this.statisticsButton = statisticsButton;
    }


    /**
     * Estableix l'estat d'habilitat dels botons de nova partida, de continuar partida i d'estadístiques,
     * segons les condicions proporcionades.
     *
     * @param enabledNewGame true si es vol habilitar el botó de nova partida, false si es vol deshabilitar
     * @param enabledResumeGame true si es vol habilitar el botó de continuar partida, false si es vol deshabilitar
     * @param enabledStatistics true si es vol habilitar el botó d'estadístiques, false si es vol deshabilitar
     */

    public void setButtonsEnabled(boolean enabledNewGame, boolean enabledResumeGame, boolean enabledStatistics) {
        setNewGameEnable(enabledNewGame);
        setResumeGameEnable(enabledResumeGame);
        setStatisticsEnable(enabledStatistics);

    }


    /**
     * Habilita o deshabilita el botó de nova partida i canvia el color de fons segons la condició proporcionada.
     *
     * @param enableNew true si es vol habilitar el botó de nova partida, false si es vol deshabilitar
     */
    public void setNewGameEnable (boolean enableNew) {
        newGameButton.setEnabled(enableNew);
        if (enableNew)
            newGameButton.setBackgroundColor(Color.decode("#C3986A"));
        else
            newGameButton.setBackgroundColor(Color.LIGHT_GRAY);
    }


    /**
     * Estableix l'estat d'habilitat del botó de continuar partida segons la condició proporcionada.
     *
     * @param enableResume true si es vol habilitar el botó de continuar partida, false si es vol deshabilitar
     */

    public void setResumeGameEnable (boolean enableResume){
        startGameButton.setEnabled(enableResume);
        if (enableResume)
            startGameButton.setBackgroundColor(Color.decode("#C3986A"));
        else
            startGameButton.setBackgroundColor(Color.LIGHT_GRAY);
    }


    /**
     * Estableix l'estat d'habilitat del botó d'estadístiques segons la condició proporcionada.
     *
     * @param enableStatistics true si es vol habilitar el botó d'estadístiques, false si es vol deshabilitar
     */

    public void setStatisticsEnable (boolean enableStatistics){
        statisticsButton.setEnabled(enableStatistics);
        if (enableStatistics)
            statisticsButton.setBackgroundColor(Color.decode("#C3986A"));
        else
            statisticsButton.setBackgroundColor(Color.LIGHT_GRAY);
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
