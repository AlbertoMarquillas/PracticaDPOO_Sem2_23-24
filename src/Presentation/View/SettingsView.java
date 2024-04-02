package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class SettingsView extends JFrame {

    public static JButton createButton(String string) {
        JButton button = new JButton(string);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(Color.decode("#C3986A"));
        button.setForeground(Color.decode("#F8F2F0"));
        button.setFont(new Font("Bell MT", Font.PLAIN, 20));
        return button;
    }

    public static JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.decode("#3B1211"));
        return label;
    }

    public SettingsView() {

        JLabel titleLabel = createLabel("COFFEE CLICKER", new Font("Arial", Font.PLAIN, 24), Color.decode("#DB5C39"));
        JButton deleteButton = createButton("Delete Account");
        JButton closeButton = createButton("Close Session");

        //PANTALLA GENERAL
        setTitle("Settings View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new GridBagLayout()); // Layout de la ventana principal

        //PANELL Titol
        setLayout(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#DB5C39"));
        ImageIcon logoIcon = new ImageIcon("Imagenes/logoSmall.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        //PANELL central
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbcCent = new GridBagConstraints();

        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(10, 0, 20, 300);
        panelInfo.add(logoLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(10, 20, 20, 0);
        panelInfo.add(titleLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(deleteButton, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(closeButton, gbcCent);

        panelInfo.setBackground(Color.decode("#F8F2F0"));
        add(panelInfo, BorderLayout.CENTER);


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SettingsView settingsView = new SettingsView();
            settingsView.setVisible(true);
        });
    }

}
