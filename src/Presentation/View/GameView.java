
/*
#DB5C39 naranja
#3B1211 marron oscuro
#F8F2F0 blanco
#C3986A marron claro
 */

package Presentation.View;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que crea la finestra principal de l'aplicació.
 */
public class GameView extends JFrame{

    //crear una funcio que crei unJPanel amb un layout i un color
    public static JPanel createPotenciadorPanel(String pathFoto, String nom, String cost, String produccio){
        CustomLabel nomLabel = new CustomLabel(nom, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        CustomLabel costLabel = new CustomLabel(cost, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        CustomLabel produccioLabel = new CustomLabel(produccio, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        ImageIcon foto = new ImageIcon(pathFoto); // Ruta de la imagen del logo
        JLabel fotoLabel = new JLabel(foto);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#F8F2F0"));
        panel.setLayout(new BorderLayout());

        //Subpanell amb la foto
        JPanel panelImatge = new JPanel();
        panelImatge.setBackground(Color.decode("#F8F2F0"));
        panelImatge.setLayout(new BorderLayout());
        panelImatge.add(fotoLabel, BorderLayout.CENTER);
        panel.add(panelImatge, BorderLayout.CENTER);

        //Subpanell amb la informació
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbcInfo = new GridBagConstraints();
        gbcInfo.gridx = 0;
        gbcInfo.gridy = 0;
        gbcInfo.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(nomLabel, gbcInfo);

        gbcInfo.gridx = 0;
        gbcInfo.gridy = 1;
        gbcInfo.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(costLabel, gbcInfo);

        gbcInfo.gridx = 0;
        gbcInfo.gridy = 2;
        gbcInfo.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(produccioLabel, gbcInfo);

        panel.add(panelInfo, BorderLayout.EAST);

        /*GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(panelImatge, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(panelInfo, gbc);*/


        return panel;
    }

    public GameView() {

        setTitle("Game View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setLayout(new BorderLayout());  // Layout de la finestra principal per posar els dos subpanells

        //Inicialitzem la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        //Crear els botons fent us de la classe CustomButton
        CustomButton millora1 = new CustomButton("millora1", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        millora1.applyCustomStyles();
        CustomButton millora2 = new CustomButton("millora2", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        millora2.applyCustomStyles();
        CustomButton millora3 = new CustomButton("millora3", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        millora3.applyCustomStyles();
        CustomButton millora4 = new CustomButton("millora4", 140, 25, Color.decode("#3B1211"), Color.decode("#F8F2F0"), new Font("Segoe UI Black", Font.PLAIN, 12));
        millora4.applyCustomStyles();

        JPanel potenciador1 = createPotenciadorPanel("Imagenes/potenciador1.png", "potenciador1", "cost1", "produccio1");
        JPanel potenciador2 = createPotenciadorPanel("Imagenes/potenciador2.png", "potenciador1", "cost1", "produccio1");
        JPanel potenciador3 = createPotenciadorPanel("Imagenes/potenciador3.png", "potenciador1", "cost1", "produccio1");



        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#DB5C39"));
        leftPanel.setLayout(new GridBagLayout());


        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.insets = new Insets(10, 0, 0, 0);
        leftPanel.add(logoLabel, gbcLeft);
        add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#DB5C39"));
        rightPanel.setLayout(new GridBagLayout());
        add(rightPanel, BorderLayout.EAST);

        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridx = 0;
        gbcRight.gridy = 0;
        gbcRight.insets = new Insets(0, 0, 0, 0);
        rightPanel.add(millora1, gbcRight);

        gbcRight.gridx = 1;
        gbcRight.gridy = 0;
        gbcRight.insets = new Insets(0, 0, 0, 0);
        rightPanel.add(millora2, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 1;
        gbcRight.insets = new Insets(3, 0, 0, 0);
        rightPanel.add(millora3, gbcRight);

        gbcRight.gridx = 1;
        gbcRight.gridy = 1;
        gbcRight.insets = new Insets(3, 0, 0, 0);
        rightPanel.add(millora4, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 3;
        gbcRight.insets = new Insets(20, 0, 0, 0);
        rightPanel.add(potenciador1, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 4;
        gbcRight.insets = new Insets(10, 0, 0, 0);
        rightPanel.add(potenciador2, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 5;
        gbcRight.insets = new Insets(10, 0, 0, 0);
        rightPanel.add(potenciador3, gbcRight);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#F8F2F0"));
        centerPanel.setLayout(new GridBagLayout());

        CustomLabel supTitleLabel = new CustomLabel("COFFEE", new Font("Bauhaus 93", Font.BOLD, 50), Color.decode("#DB5C39"));
        CustomLabel lowTitleLabel = new CustomLabel("CLICKER", new Font("Bauhaus 93", Font.BOLD, 50), Color.decode("#DB5C39"));


        GridBagConstraints gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(10, 0, 0, 0);
        centerPanel.add(supTitleLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(10, 0, 0, 0);
        centerPanel.add(lowTitleLabel, gbcCent);
        add(centerPanel, BorderLayout.CENTER);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameView initialView = new GameView();
            initialView.setVisible(true);
        });
    }
}
