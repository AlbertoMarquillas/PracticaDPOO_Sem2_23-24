package Presentation.View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import java.awt.*;

public class SettingsView extends JFrame {



    public SettingsView() {

        //JLabel titleLabel = createLabel("COFFEE CLICKER", new Font("Arial", Font.PLAIN, 24), Color.decode("#DB5C39"));
        CreateLabel titleLabel = new CreateLabel("COFFEE CLICKER", new Font("Bell MT", Font.BOLD, 30), Color.decode("#DB5C39"));

        OvalButton deleteButton = new OvalButton("Delete Account", 300, 40, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Bell MT", Font.PLAIN, 16));
        deleteButton.applyCustomStyles();
        OvalButton closeButton = new OvalButton("Close Session", 300, 40, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Bell MT", Font.PLAIN, 16));
        closeButton.applyCustomStyles();


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
