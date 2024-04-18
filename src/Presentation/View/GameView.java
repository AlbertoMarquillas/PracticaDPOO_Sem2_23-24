
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

    /**
     * Funció que crea un JPanel pels potenciadors amb un layout i un color determinat.
     * @param pathFoto  Ruta de la imatge del potenciador
     * @param nom Nom del potenciador
     * @param cost Cost del potenciador
     * @param produccio Producció del potenciador
     * @return JPanel amb les dades del potenciador
     */
    public static JPanel createPotenciadorPanel(String pathFoto, String nom, String cost, String produccio) {

        //inicialitzar els labels amb les dades dels potenciadors
        CustomLabel nomLabel = new CustomLabel(nom, new Font("Segoe UI Black", Font.PLAIN, 18), Color.decode("#3B1211"));
        CustomLabel costLabel = new CustomLabel(cost, new Font("Segoe UI Black", Font.PLAIN, 18), Color.decode("#3B1211"));
        CustomLabel produccioLabel = new CustomLabel(produccio, new Font("Segoe UI Black", Font.PLAIN, 18), Color.decode("#3B1211"));

        //inicialitzar la imatge del potenciador
        ImageIcon foto = new ImageIcon(pathFoto);
        JLabel fotoLabel = new JLabel(foto);

        //crear el panel principal que cotindrá totes les dades del potenciador
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 170));
        panel.setBackground(Color.decode("#F8F2F0"));
        panel.setLayout(new BorderLayout());

        //crear el subpanell de la informació del potenciador (nom, cost i producció)
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.decode("#F8F2F0"));
        panelInfo.setLayout(new GridBagLayout());

        //crear el layout dels labels de la informació del subpanell
        GridBagConstraints gbcInfo = new GridBagConstraints();

        //afegir el nom
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 0;
        gbcInfo.insets = new Insets(10, 10, 0, 0);
        panelInfo.add(nomLabel, gbcInfo);

        //afegir el cost
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 1;
        gbcInfo.insets = new Insets(10, 10, 0, 0); // Ajusta los márgenes
        panelInfo.add(costLabel, gbcInfo);

        //afegir la producció
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 2;
        gbcInfo.insets = new Insets(10, 10, 0, 0); // Ajusta los márgenes
        panelInfo.add(produccioLabel, gbcInfo);

        //afegir la imatge i el subpanell amb la informació al panell principal
        panel.add(fotoLabel, BorderLayout.WEST);
        panel.add(panelInfo, BorderLayout.CENTER);

        return panel;
    }



    /**
     * Funció que crea una JTable amb les dades dels potenciadors.
     * @return JTable amb les dades dels generadors
     */
    public static JTable createTable(){
        String[] columnNames = {"Quantity cafes generats", "Quantitat generadors"};
        // Dades de la taula
        // Les dades de la taula farà falta canviarles per les variables
        Object[][] data = {
                {"<html>Generador 1<br>Var amb numero de cafes generats", "Var quantitat de generadors"},
                {"<html>Generador 2<br>Var amb numero de cafes generats", "Var quantitat de generadors"},
                {"<html>Generado 3<br>Var amb numero de cafes generats", "Var quantitat de generadors"},
        };

        // Crear la taula amb les dades
        JTable table = new JTable(data, columnNames);
        table.setBackground(Color.decode("#F8F2F0"));
        table.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        table.setForeground(Color.decode("#3B1211"));

        // Crear un renderitzador de celdas amb la classe CustomRenderer per afegir un borde interior
        CustomRenderer cellRenderer = new CustomRenderer(5);

        // Ajustar l'altura de les files i el borde exterior
        table.setRowHeight(100);
        table.setBorder(BorderFactory.createLineBorder(Color.decode("#DB5C39"), 5));

        // Ajustar l'amplada de les columnes i afegir el renderitzador de celdas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(300);
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);

        }

        // Centrar les dades de la taula amb un renderitzador de celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        return table;
    }


    public GameView() {

        //Crear la finestra i posar-li tamany i títol
        setTitle("Game View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);
        setLayout(new BorderLayout());  // Layout de la finestra principal per posar els dos subpanells


        //Crear els botons que contindran imatges a l'inerior
        JButton imageButton = new JButton();
        JButton settingsButton = new JButton();

        //Inicialitzem la imatge del logo i posar-la dintre del botó imageButton
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png");
        imageButton.setIcon(logoIcon);
        imageButton.setBorderPainted(false);            // Eliminar borde
        imageButton.setContentAreaFilled(false);        //Fer que l'àrea de contingut del botó sigui transparent

        // Inicialitzem la imatge del botó de configuració i posar-la dintre del botó settingsButton
        ImageIcon ajustesIcon = new ImageIcon("Imagenes/ajustes.png"); // Ruta de la imagen del logo
        settingsButton.setIcon(ajustesIcon);
        settingsButton.setBorderPainted(false);         // Eliminar borde
        settingsButton.setContentAreaFilled(false);     //Fer que l'àrea de contingut del botó sigui transparent

        //Crear els botons de cada millora fent us de la classe CustomButton
        CustomButton millora1 = new CustomButton("Millora 1", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 18));
        CustomButton millora2 = new CustomButton("Millora 2", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 18));
        CustomButton millora3 = new CustomButton("Millora 3", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 18));
        CustomButton millora4 = new CustomButton("Millora 4", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 18));

        //Comptador de cafès generats
        //Fara falta canviar el valor del contador per la variable
        CustomLabel contador = new CustomLabel("0000", new Font("Segoe UI Black", Font.PLAIN, 50), Color.decode("#F8F2F0"));
        //Crear els títols de la finestra
        CustomLabel supTitleLabel = new CustomLabel("COFFEE", new Font("Bauhaus 93", Font.BOLD, 80), Color.decode("#DB5C39"));
        CustomLabel lowTitleLabel = new CustomLabel("CLICKER", new Font("Bauhaus 93", Font.BOLD, 80), Color.decode("#DB5C39"));

        //Crear els panells dels potenciadors
        //El cost i la producció faran falta canviar-los per les variables
        JPanel potenciador1 = createPotenciadorPanel("Imagenes/potenciador1.png", "Potenciador 1", "Cost 1", "Producció 1");
        JPanel potenciador2 = createPotenciadorPanel("Imagenes/potenciador2.png", "Potenciador 2", "Cost 2", "Producció 2");
        JPanel potenciador3 = createPotenciadorPanel("Imagenes/potenciador3.png", "Potenciador 3", "Cost 3", "Producció 3");

        //Crear la taula amb les dades dels potenciadors
        JTable table = createTable();


        //Crear el panell central, que es el que contindrà el títol, la taula i el botó de configuració
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#F8F2F0"));
        centerPanel.setSize(750, 800);              // Tamany del panell central

        centerPanel.setLayout(new GridBagLayout());             // GridBagLayout al panell per afagir les coses en posicions concretes
        GridBagConstraints gbcCent = new GridBagConstraints();

        // Posar el botó de configuració a la part superior dreta
        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(0, 650, 0, 0);
        centerPanel.add(settingsButton, gbcCent);

        // Posar la primera paraula del títol a la part superior central
        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(1, 0, 0, 0);
        centerPanel.add(supTitleLabel, gbcCent);

        // Posar la segona paraula del títol a la part superior central
        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(0, 0, 30, 0);
        centerPanel.add(lowTitleLabel, gbcCent);

        // Posar la taula a la part central
        gbcCent.gridx = 0;
        gbcCent.gridy = 3;
        gbcCent.insets = new Insets(0, 0, 30, 0);
        centerPanel.add(table, gbcCent);


        //Crear el panell esquerre que contindrà el comptador i el botó de la imatge
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#DB5C39"));
        leftPanel.setSize(375, 800);

        leftPanel.setLayout(new GridBagLayout());       // GridBagLayout al panell per afagir les coses en posicions concretes
        GridBagConstraints gbcLeft = new GridBagConstraints();

        //Afeigir el comptador a la part superior del panell
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.insets = new Insets(0, 0, 0, 0);
        leftPanel.add(contador, gbcLeft);

        //Afegir el botó de la imatge a la part inferior del panell
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 1;
        gbcLeft.insets = new Insets(10, 0, 0, 0);
        leftPanel.add(imageButton, gbcLeft);


        //Crear el panell dret que contindrà les millores i els potenciadors
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#DB5C39"));
        rightPanel.setSize(375, 800);

        rightPanel.setLayout(new BorderLayout());       // BorderLayout al panell per afagir les coses en posicions concretes

        //Crear un subpanell que contindrà els quatre botons de les millores
        JPanel millores = new JPanel();
        millores.setBackground(Color.decode("#DB5C39"));

        millores.setLayout(new GridBagLayout());        // GridBagLayout al panell per afagir els botons en posicions concretes
        GridBagConstraints gbcMillores = new GridBagConstraints();

        //Afegir el botó de la millora 1 a la part superior
        gbcMillores.gridx = 0;
        gbcMillores.gridy = 0;
        gbcMillores.insets = new Insets(20, 15, 0, 0);
        millores.add(millora1, gbcMillores);

        //Afegir el botó de la millora 2 a la part superior al costat del de la millora 1
        gbcMillores.gridx = 1;
        gbcMillores.gridy = 0;
        gbcMillores.insets = new Insets(20, 10, 0, 15);
        millores.add(millora2, gbcMillores);

        //Afegir el botó de la millora 3 sota el botó de la millora 1
        gbcMillores.gridx = 0;
        gbcMillores.gridy = 1;
        gbcMillores.insets = new Insets(10, 15, 0, 0);
        millores.add(millora3, gbcMillores);

        //Afegir el botó de la millora 4 sota el botó de la millora 2
        gbcMillores.gridx = 1;
        gbcMillores.gridy = 1;
        gbcMillores.insets = new Insets(10, 10, 0, 15);
        millores.add(millora4, gbcMillores);


        //Crear un subpanell que contindrà els subpanells dels potenciadors
        JPanel potenciadors = new JPanel();
        potenciadors.setBackground(Color.decode("#DB5C39"));
        potenciadors.setLayout(new GridBagLayout());    //GridBagLayout al panell per afagir els potenciadors en posicions concretes

        //Afegir potenciador 1 a la part superior
        GridBagConstraints gbcPotenciadors = new GridBagConstraints();
        gbcPotenciadors.gridx = 0;
        gbcPotenciadors.gridy = 3;
        gbcPotenciadors.insets = new Insets(20, 15, 0, 15);
        potenciadors.add(potenciador1, gbcPotenciadors);

        //Afegir potenciador 2 sota el potenciador 1
        gbcPotenciadors.gridx = 0;
        gbcPotenciadors.gridy = 4;
        gbcPotenciadors.insets = new Insets(15, 15, 0, 15);
        potenciadors.add(potenciador2, gbcPotenciadors);

        //Afegir potenciador 3 sota el potenciador 2
        gbcPotenciadors.gridx = 0;
        gbcPotenciadors.gridy = 5;
        gbcPotenciadors.insets = new Insets(15, 15, 15, 15);
        potenciadors.add(potenciador3, gbcPotenciadors);

        //Afegir els subpanells de les millores i els potenciadors al panell dret
        rightPanel.add(potenciadors, BorderLayout.CENTER);
        rightPanel.add(millores, BorderLayout.NORTH);


        //Afegir els tres panells principals (esquerra, dreta, centre) a la finestra principal
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameView initialView = new GameView();
            initialView.setVisible(true);
        });
    }
}
