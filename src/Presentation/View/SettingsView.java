package Presentation.View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import java.awt.*;

public class SettingsView extends JFrame {

    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }

    }

    public static JButton createButton(String string) {
        JButton button = new JButton(string);
        button.setPreferredSize(new Dimension(300, 40));

        button.setFont(new Font("Bell MT", Font.PLAIN, 20));


        button.setBounds(700, 700, 50, 40);
     //   button.setBorder(new RoundedBorder(50)); //10 is the radius
        button.setBackground(Color.blue);
        button.setForeground(Color.decode("#3B1211"));
        button.setVisible(true);


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
