package Presentation.View;

import Presentation.View.Custom.CustomButton;
import Presentation.View.Custom.CustomLabel;
import Presentation.View.Custom.CustomStatisticsGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Classe de les vistes de la pantalla d'estadístiques.
 */
public class StatsView extends JPanel implements KeyListener, ActionListener {

    private static final String BACK = "back";
    private static final String SETTINGS = "settings";

    private CustomButton backButton;
    private CustomButton nextGameButton;
    private CustomButton nextPlayerButton;
    private CustomButton backGameButton;
    private CustomButton backPlayerButton;
    private JButton settingsButton;
    private CustomStatisticsGraph customStadisticsGraph;
    private ArrayList stats = new ArrayList();
    private JLabel dynamicLabel;  // JLabel que se actualizará dinámicamente
    private JPanel statsPanel;
    /**
     * Constructor de la classe StatsView.
     */
    public StatsView() {

        setSize(1500, 800);
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F8F2F0"));

        //Incialitzem els botons fent us de la classe CustomButton
        backButton = new CustomButton("Back", 150, 30, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        nextGameButton = new CustomButton("Next Game", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        backGameButton = new CustomButton("Previous Game", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        nextPlayerButton = new CustomButton("Next Player", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        backPlayerButton = new CustomButton("Previous Player", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        //Botó de settings amb la foto
        settingsButton = new JButton();
        ImageIcon ajustesIcon = new ImageIcon("Imagenes/ajustes.png"); // Ruta de la imagen del logo
        settingsButton.setIcon(ajustesIcon);
        settingsButton.setBorderPainted(false);         // Eliminar borde
        settingsButton.setContentAreaFilled(false);

        //Labels amb la info
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 65), Color.decode("#DB5C39"));
        dynamicLabel = new JLabel("");  // Inicializa el JLabel con texto vacío
        dynamicLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));  // Establece la fuente del JLabel
        dynamicLabel.setForeground(Color.decode("#3B1211"));

        //Panell superior (back + titol + settings)
        JPanel supPanel = new JPanel();
        supPanel.setBackground(Color.decode("#F8F2F0"));
        supPanel.setLayout(new GridBagLayout());
        supPanel.setSize(1500, 400);

        GridBagConstraints gbcSup = new GridBagConstraints();

        gbcSup.gridx = 0;
        gbcSup.gridy = 0;
        gbcSup.insets = new Insets(30, 500, 20, 150);
        supPanel.add(titleLabel, gbcSup);

        gbcSup.gridx = 1;
        gbcSup.gridy = 0;
        gbcSup.insets = new Insets(5, 170, 20, 0);
        supPanel.add(settingsButton, gbcSup);


        //Panell inferior (back + next + back + next + label)
        JPanel infPanel = new JPanel();
        infPanel.setBackground(Color.decode("#F8F2F0"));
        infPanel.setSize(1500, 150);
        infPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbcInf = new GridBagConstraints();
        gbcInf.gridx = 0;
        gbcInf.gridy = 0;
        gbcInf.insets = new Insets(20, 15, 30, 230);
        infPanel.add(backButton, gbcInf);

        gbcInf.gridx = 1;
        gbcInf.gridy = 0;
        gbcInf.insets = new Insets(20, 0, 30, 0);
        infPanel.add(backPlayerButton, gbcInf);

        gbcInf.gridx = 2;
        gbcInf.gridy = 0;
        gbcInf.insets = new Insets(20, 20, 30, 0);
        infPanel.add(nextPlayerButton, gbcInf);

        gbcInf.gridx = 3;
        gbcInf.gridy = 0;
        gbcInf.insets = new Insets(20, 20, 30, 0);
        infPanel.add(backGameButton, gbcInf);

        gbcInf.gridx = 4;
        gbcInf.gridy = 0;
        gbcInf.insets = new Insets(20, 20, 30, 0);
        infPanel.add(nextGameButton, gbcInf);

        gbcInf.gridx = 5;
        gbcInf.gridy = 0;
        gbcInf.insets = new Insets(20, 30, 30, 250);
        infPanel.add(dynamicLabel, gbcInf);


        //Panell del centre amb la grafica
        statsPanel = new JPanel();  // Initialize statsPanel
        statsPanel.setLayout(new BorderLayout());
        statsPanel.setBackground(Color.decode("#F8F2F0"));
        statsPanel.setSize(1400, 450);
        customStadisticsGraph = new CustomStatisticsGraph(stats);
        customStadisticsGraph.setPreferredSize(new Dimension(1350, 400));
        statsPanel.add(customStadisticsGraph, BorderLayout.CENTER);

        //Afegir els subpanells al panell principal
        add(statsPanel, BorderLayout.CENTER);
        add(supPanel, BorderLayout.NORTH);
        add(infPanel, BorderLayout.SOUTH);

    }


    /**
     * Actualitza el text de l'etiqueta dinàmica amb el nom del jugador i l'identificador de joc especificats.
     *
     * @param player El nom del jugador.
     * @param ID_G   L'identificador del joc.
     */
    public void updateDynamicLabel(String player, int ID_G) {
        dynamicLabel.setText("Player: " + player + "      Game: " + ID_G);
    }


    /**
     * Estableix les estadístiques amb les noves dades, actualitza el text de l'etiqueta dinàmica amb el nom del jugador
     * i l'identificador de joc especificats, i actualitza el panell d'estadístiques amb el nou gràfic.
     *
     * @param newStats    Les noves estadístiques.
     * @param player      El nom del jugador.
     * @param ID_G        L'identificador del joc.
     */
    public void setStats(ArrayList newStats, String player, int ID_G) {
        this.stats = newStats;

        // Create a new graph with the updated stats
        customStadisticsGraph = new CustomStatisticsGraph(stats);

        updateDynamicLabel(player, ID_G);

        // Update statsPanel
        statsPanel.removeAll();
        statsPanel.add(customStadisticsGraph);
        statsPanel.revalidate();
        statsPanel.repaint();
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
     * Controlador dels botons de la vista.
     *
     * @param rvc L'objecte que gestionarà els esdeveniments dels botons.
     */
    public void buttonController(ActionListener rvc){
        backButton.addActionListener(rvc);
        backButton.setActionCommand(BACK);
        nextGameButton.addActionListener(rvc);
        nextPlayerButton.addActionListener(rvc);
        backGameButton.addActionListener(rvc);
        backPlayerButton.addActionListener(rvc);
        settingsButton.addActionListener(rvc);
        settingsButton.setActionCommand(SETTINGS);
    }
}