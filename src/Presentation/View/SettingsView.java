package Presentation.View;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de les vista de la pantalla de settings.
 */
public class SettingsView extends JFrame {

    public SettingsView() {

        //Marcar-li al JFrame un titol i tamany 800x450
        setTitle("Settings View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new BorderLayout()); // Layout de la ventana principal

        //Inicialització del Label del títol fent us de la classe CustomLabel
        CustomLabel titleLabel = new CustomLabel("COFFEE CLICKER", new Font("Bauhaus 93", Font.PLAIN, 50), Color.decode("#DB5C39"));

        //Inicialització dels botons fent us de la classe CustomButton
        CustomButton deleteButton = new CustomButton("Delete Account", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));
        CustomButton closeButton = new CustomButton("Close Session", 350, 45, Color.decode("#C3986A"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 18));

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
        gbcCent.insets = new Insets(50, 0, 0, 400);
        panelInfo.add(logoLabel, gbcCent);

        //Afegir el Titol
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(65, 70, 0, 0);
        panelInfo.add(titleLabel, gbcCent);

        //Afegir els botó de delete
        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(40, 0, 0, 0);
        panelInfo.add(deleteButton, gbcCent);

        //Afegir els botó de close
        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(30, 0, 100, 0);
        panelInfo.add(closeButton, gbcCent);

        //Afegir el panell a la finestra
        add(panelInfo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SettingsView settingsView = new SettingsView();
            settingsView.setVisible(true);
        });
    }

}
