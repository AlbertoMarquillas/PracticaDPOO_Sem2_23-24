package Presentation.View;

import Presentation.Controller.StatsController;
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

public class StatsView extends JPanel implements KeyListener, ActionListener {

    private CustomButton backButton;
    private JButton nextGameButton;
    private JButton nextPlayerButton;
    private JButton backGameButton;
    private JButton backPlayerButton;
    private CustomButton settingsButton;
    private CustomStatisticsGraph customStadisticsGraph;
    private ArrayList stats = new ArrayList();
    private static final String BACK = "back";
    private static final String SETTINGS = "settings";
    private JPanel statsPanel;  // Make statsPanel an instance variable

    private JPanel backButtonPanel;
    private JPanel titleLabelPanel;
    private JPanel settingsButtonPanel;
    private JLabel dynamicLabel;  // JLabel que se actualizará dinámicamente


    public StatsView() {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#F8F2F0"));

        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));

        backButton = new CustomButton("Back", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        // Create a new settings button
        settingsButton = new CustomButton("Settings", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        backButtonPanel = new JPanel();
        setBackButtonPanelSize(200, 100);
        backButtonPanel.setBackground(Color.decode("#F8F2F0"));
        backButtonPanel.add(backButton);  // Add the back button to backButtonPanel

        titleLabelPanel = new JPanel();
        titleLabelPanel.setBackground(Color.decode("#F8F2F0"));
        ImageIcon logoIcon = new ImageIcon("path/to/your/logo.png");  // Replace with the path to your logo
        JLabel logoLabel = new JLabel(logoIcon);
        titleLabelPanel.add(logoLabel);
        titleLabelPanel.add(titleLabel);

        settingsButtonPanel = new JPanel();
        setSettingsButtonPanelSize(200, 100);
        settingsButtonPanel.setBackground(Color.decode("#F8F2F0"));
        settingsButtonPanel.add(settingsButton);  // Add the settings button to settingsButtonPanel

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.decode("#F8F2F0"));

        dynamicLabel = new JLabel("");  // Inicializa el JLabel con texto vacío
        dynamicLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));  // Establece la fuente del JLabel


        titlePanel.add(backButtonPanel, BorderLayout.WEST);
        titlePanel.add(titleLabelPanel, BorderLayout.CENTER);
        titlePanel.add(settingsButtonPanel, BorderLayout.EAST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(titlePanel, gbc);

        // Initialize the buttons
        nextGameButton = new CustomButton("Next Game", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        backGameButton = new CustomButton("Previous Game", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        nextPlayerButton = new CustomButton("Next Player", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        backPlayerButton = new CustomButton("Previous Player", 150, 30, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));

        // Add the buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backPlayerButton);
        buttonPanel.add(nextPlayerButton);
        buttonPanel.add(backGameButton);
        buttonPanel.add(nextGameButton);
        buttonPanel.add(dynamicLabel);

        statsPanel = new JPanel();  // Initialize statsPanel
        customStadisticsGraph = new CustomStatisticsGraph(stats);
        customStadisticsGraph.setPreferredSize(new Dimension(800, 600));  // Adjust the width and height as needed
        statsPanel.add(customStadisticsGraph);

        // Add the title panel to the view
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titlePanel, gbc);

        // Add the rest of the components to the panel
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(statsPanel, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0;
        add(buttonPanel, gbc);
    }

    public void updateDynamicLabel(String player, int ID_G) {
        dynamicLabel.setText("Player: " + player + "      Game: " + ID_G);
    }

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

    public void setBackButtonPanelSize(int width, int height) {
        backButtonPanel.setPreferredSize(new Dimension(width, height));
        backButtonPanel.revalidate();
    }

    public void setTitleLabelPanelSize(int width, int height) {
        titleLabelPanel.setPreferredSize(new Dimension(width, height));
        titleLabelPanel.revalidate();
    }

    public void setSettingsButtonPanelSize(int width, int height) {
        settingsButtonPanel.setPreferredSize(new Dimension(width, height));
        settingsButtonPanel.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


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