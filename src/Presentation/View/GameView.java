
/*
#DB5C39 naranja
#3B1211 marron oscuro
#F8F2F0 blanco
#C3986A marron claro
 */

package Presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Classe que crea la finestra principal de l'aplicació.
 */
public class GameView extends JFrame{

    //crear una funcio que crei unJPanel amb un layout i un color

    public static JPanel createPotenciadorPanel(String pathFoto, String nom, String cost, String produccio) {
        // Crear los labels con la información del potenciador
        CustomLabel nomLabel = new CustomLabel(nom, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        CustomLabel costLabel = new CustomLabel(cost, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        CustomLabel produccioLabel = new CustomLabel(produccio, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));

        ImageIcon foto = new ImageIcon(pathFoto); // Ruta de la imagen del logo
        JLabel fotoLabel = new JLabel(foto);

// Panell principal amb tota la informació del potenciador
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#F8F2F0"));
        panel.setLayout(null); // Establece el diseño a null para controlar el tamaño manualmente
        panel.setSize(365, 100);

// Agregar la foto del potenciador
        fotoLabel.setBounds(10, 10, 80, 80); // Ajusta la posición y el tamaño de la imagen
        panel.add(fotoLabel);

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbcInfo = new GridBagConstraints();
        gbcInfo.gridx = 1; // Cambia la posición X para el panel de información
        gbcInfo.gridy = 0;
        gbcInfo.insets = new Insets(10, 10, 0, 0); // Ajusta los márgenes
        panelInfo.add(nomLabel, gbcInfo);

        gbcInfo.gridx = 1;
        gbcInfo.gridy = 1;
        panelInfo.add(costLabel, gbcInfo);

        gbcInfo.gridx = 1;
        gbcInfo.gridy = 2;
        panelInfo.add(produccioLabel, gbcInfo);

        panel.add(panelInfo);

        return panel;



    }
    /*
    public static JPanel createPotenciadorPanel(String pathFoto, String nom, String cost, String produccio){
        //Crear els labels amb la informació del potenciador
        CustomLabel nomLabel = new CustomLabel(nom, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        CustomLabel costLabel = new CustomLabel(cost, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));
        CustomLabel produccioLabel = new CustomLabel(produccio, new Font("Segoe UI Black", Font.PLAIN, 10), Color.decode("#DB5C39"));

        ImageIcon foto = new ImageIcon(pathFoto); // Ruta de la imagen del logo
        JLabel fotoLabel = new JLabel(foto);

        //Panell principal amb tota la informació del potenciador
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#F8F2F0"));
        panel.setLayout(null); // Establece el diseño a null para controlar el tamaño manualmente
        panel.setSize(365, 100);
        panel.setLayout(new BorderLayout());



        //Afegir la foto del potenciador
        panel.add(fotoLabel, BorderLayout.WEST);

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
        panel.setSize(200, 200);
        panel.add(panelInfo, BorderLayout.EAST);




        return panel;
    }*/

    public static JTable createTable(){
        String[] columnNames = {"Quantity cafes generats", "Quantitat generadors"};
        Object[][] data = {
                {"Generador 1\nVar amb numero de cafes generats", "Var quantitat de generadors"},
                {"Generador 2\nVar amb numero de cafes generats", "Var quantitat de generadors"},
                {"Generado 3\nVar amb numero de cafes generats", "Var quantitat de generadors"},
        };

        JTable table = new JTable(data, columnNames);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setRowHeight(i, 70);
            table.getColumnModel().getColumn(i).setPreferredWidth(250);
        }


        // Cambiar la tipografía, tamaño y color del texto
        table.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        table.setForeground(Color.decode("#3B1211"));

        // Cambiar el color y grosor de los bordes
        table.setGridColor(Color.decode("#DB5C39"));


        // Personalizar el renderizador de celdas para centrar el texto
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);


        return table;
    }

    public GameView() {

        setTitle("Game View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);
        setLayout(new BorderLayout());  // Layout de la finestra principal per posar els dos subpanells

        JButton imageButton = new JButton();

        //Inicialitzem la imatge del logo
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        imageButton.setIcon(logoIcon);
        imageButton.setBorderPainted(false); // Elimina el borde del botón
        imageButton.setContentAreaFilled(false); // Hace que el área de contenido del botón sea transparente
        //imageButton.setFocusPainted(false); // Elimina el borde que aparece al hacer click
        JLabel logoLabel = new JLabel(logoIcon);

        //comptador
        CustomLabel contador = new CustomLabel("0000", new Font("Segoe UI Black", Font.PLAIN, 50), Color.decode("#F8F2F0"));


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

        JTable table = createTable();

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#F8F2F0"));
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setSize(750, 800);

        CustomLabel supTitleLabel = new CustomLabel("COFFEE", new Font("Bauhaus 93", Font.BOLD, 50), Color.decode("#DB5C39"));
        CustomLabel lowTitleLabel = new CustomLabel("CLICKER", new Font("Bauhaus 93", Font.BOLD, 50), Color.decode("#DB5C39"));

       GridBagConstraints gbcCent = new GridBagConstraints();
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(0, 0, 0, 0);
        centerPanel.add(supTitleLabel, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(10, 0, 0, 0);
        centerPanel.add(lowTitleLabel, gbcCent);
        add(centerPanel, BorderLayout.CENTER);

        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(0, 0, 0, 0);
        centerPanel.add(table, gbcCent);


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#DB5C39"));
        leftPanel.setSize(375, 800);

        leftPanel.setLayout(new GridBagLayout());



        GridBagConstraints gbcLeft = new GridBagConstraints();

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.insets = new Insets(0, 0, 0, 0);
        leftPanel.add(contador, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 1;
        gbcLeft.insets = new Insets(10, 0, 0, 0);
        leftPanel.add(imageButton, gbcLeft);
        add(leftPanel, BorderLayout.WEST);



        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#DB5C39"));
       rightPanel.setSize(375, 800);

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
        gbcRight.insets = new Insets(20, 5, 0, 0);
        rightPanel.add(potenciador1, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 4;
        gbcRight.insets = new Insets(10, 5, 0, 0);
        rightPanel.add(potenciador2, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 5;
        gbcRight.insets = new Insets(10, 5, 0, 0);
        rightPanel.add(potenciador3, gbcRight);




    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameView initialView = new GameView();
            initialView.setVisible(true);
        });
    }
}
