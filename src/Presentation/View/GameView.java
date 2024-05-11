
/*
#DB5C39 naranja
#3B1211 marron oscuro
#F8F2F0 blanco
#C3986A marron claro
 */

package Presentation.View;

import Presentation.View.Custom.CustomButton;
import Presentation.View.Custom.CustomLabel;
import Presentation.View.Custom.CustomRenderer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * Classe que crea la finestra principal de l'aplicació.
 */
public class GameView extends JPanel implements KeyListener, ActionListener {

    private static final String MILLORA1 = "millora1";
    private static final String MILLORA2 = "millora2";
    private static final String MILLORA3 = "millora3";
    private static final String MILLORA4 = "millora4";
    private static final String POTENCIADOR1 = "potenciador1";
    private static final String POTENCIADOR2 = "potenciador2";
    private static final String POTENCIADOR3 = "potenciador3";
    private static final String SETTINGS = "settings";
    private static final String FINISH = "finish";
    private static final String SAVE = "save";

    private static final String CREATECOFFE = "createcofee";
    private CustomButton millora1;
    private CustomButton millora2;
    private CustomButton millora3;
    private CustomButton millora4;
    private CustomButton potenciador1;
    private CustomButton potenciador2;
    private CustomButton potenciador3;
    private final CustomButton finishGame;
    private final CustomButton saveGame;

    private JButton imageButton;
    private JButton settingsButton;
    private JTable table;

    private String text = "0000";
    private final CustomLabel contador;
    private double cost1 = 10;
    private double cost2 = 150;
    private double cost3 = 2000;

    private JLabel labelPotCost1 = new JLabel(String.valueOf(cost1));
    private JLabel labelPotCost2 = new JLabel(String.valueOf(cost2));
    private JLabel labelPotCost3 = new JLabel(String.valueOf(cost3));
    private int quantitatPotenciadors1;
    private int quantitatPotenciadors2;
    private int quantitatPotenciadors3;
    private float produccioTotal1;
    private float produccioTotal2;
    private float produccioTotal3;
    private float overallPot1;
    private float overallPot2;
    private float overallPot3;
    private double produccioUnitat1;
    private double produccioUnitat2;
    private double produccioUnitat3;


    /**
     * Constructor de la classe GameView.
     */
    public GameView() {

        //Crear la finestra i posar-li tamany i títol
        //setTitle("Game View");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);
        setLayout(new BorderLayout());  // Layout de la finestra principal per posar els dos subpanells


        //Crear els botons que contindran imatges a l'inerior
        imageButton = new JButton();
        settingsButton = new JButton();

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
        millora1 = new CustomButton("<html><div style='text-align: center;'>Double the efficiency in BARISTA BOOST</div></html>", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 14));
        millora2 = new CustomButton("<html><div style='text-align: center;'>Double the efficiency in WAFFLE WIZARD</div></html>", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 14));
        millora3 = new CustomButton("<html><div style='text-align: center;'>Double the efficiency in STEAMY BREW</div></html>", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 14));
        millora4 = new CustomButton("<html><div style='text-align: center;'>Double the efficiency in clicks</div></html>", 170, 75, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 14));

        //hacer que si se pulsa el boton millora 1, quantitatPotenciadors1 sume +1

        //Comptador de cafès generats
        //Fara falta canviar el valor del contador per la variable


        this.contador = new CustomLabel(this.text, new Font("Segoe UI Black", Font.PLAIN, 50), Color.decode("#F8F2F0"));


        //Crear els títols de la finestra
        CustomLabel supTitleLabel = new CustomLabel("COFFEE", new Font("Bauhaus 93", Font.BOLD, 80), Color.decode("#DB5C39"));
        CustomLabel lowTitleLabel = new CustomLabel("CLICKER", new Font("Bauhaus 93", Font.BOLD, 80), Color.decode("#DB5C39"));

        //Crear els panells dels potenciadors
        //El string producció fara falta canviar-los per les variables
        potenciador1 = createPotenciadorButton("Imagenes/potenciador1.png", "BARISTA BOOST", "Cost:" + this.cost1 +" Coffes", "<html><div style='text-align: center;'>Elevate your brew game<br>with lightning speed</div></html>");
        this.potenciador1.setEnabled(true);
        potenciador2 = createPotenciadorButton("Imagenes/potenciador2.png", "WAFFLE WIZARD", "Cost: " + this.cost2 +" Coffes", "<html><div style='text-align: center;'>Master the art of waffle<br>making with prowess.</div></html>");
        this.potenciador2.setEnabled(true);
        potenciador3 = createPotenciadorButton("Imagenes/potenciador3.png", "STEAMY BREW", "Cost: " + this.cost3 +" Coffes", "<html><div style='text-align: center;'>Experience the power<br>of a perfect brew cup.</div></html>");
        this.potenciador3.setEnabled(true);

        finishGame = new CustomButton("Finish Game", 230, 50, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 14));
        saveGame = new CustomButton("Save Game", 230, 50, Color.decode("#F8F2F0"), Color.decode("#3B1211"), new Font("Segoe UI Black", Font.PLAIN, 14));

        //Crear la taula amb les dades dels potenciadors
       table = createTable(quantitatPotenciadors1, quantitatPotenciadors2, quantitatPotenciadors3, produccioTotal1, produccioTotal2, produccioTotal3, overallPot1, overallPot2, overallPot3);


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

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 2;
        gbcLeft.insets = new Insets(60, 0, 0, 0);
        leftPanel.add(finishGame, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        gbcLeft.insets = new Insets(10, 0, 0, 0);
        leftPanel.add(saveGame, gbcLeft);


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




    /**
     * Funció que crea un JPanel pels potenciadors amb un layout i un color determinat.
     * @param pathFoto  Ruta de la imatge del potenciador
     * @param nom Nom del potenciador
     * @param cost Cost del potenciador
     * @param produccio Producció del potenciador
     * @return JPanel amb les dades del potenciador
     */
    public CustomButton createPotenciadorButton(String pathFoto, String nom, String cost, String produccio) {

        //inicialitzar els labels amb les dades dels potenciadors
        CustomLabel nomLabel = new CustomLabel(nom, new Font("Segoe UI Black", Font.PLAIN, 19), Color.decode("#3B1211"));
        if (nom.equals("BARISTA BOOST")){
            labelPotCost1 = new JLabel(cost);
        } else if (nom.equals("WAFFLE WIZARD")) {
            labelPotCost2 = new JLabel(cost);
        } else if (nom.equals("STEAMY BREW")) {
            labelPotCost3 = new JLabel(cost);

        }

        labelPotCost1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        labelPotCost1.setForeground(Color.decode("#3B1211"));
        labelPotCost2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        labelPotCost2.setForeground(Color.decode("#3B1211"));
        labelPotCost3.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        labelPotCost3.setForeground(Color.decode("#3B1211"));

        CustomLabel produccioLabel = new CustomLabel(produccio, new Font("Segoe UI Black", Font.PLAIN, 12), Color.decode("#3B1211"));

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
        gbcInfo.insets = new Insets(10, 0, 0, 0);
        panelInfo.add(nomLabel, gbcInfo);

        //afegir el cost
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 1;
        gbcInfo.insets = new Insets(10, 0, 0, 5); // Ajusta los márgenes

        if (nom.equals("BARISTA BOOST")){
            panelInfo.add(labelPotCost1, gbcInfo);
        } else if (nom.equals("WAFFLE WIZARD")) {
            panelInfo.add(labelPotCost2, gbcInfo);

        } else if (nom.equals("STEAMY BREW")) {
            panelInfo.add(labelPotCost3, gbcInfo);

        }
        //afegir la producció
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 2;
        gbcInfo.insets = new Insets(10, 0, 0, 20); // Ajusta los márgenes
        panelInfo.add(produccioLabel, gbcInfo);

        //afegir la imatge i el subpanell amb la informació al panell principal
        panel.add(fotoLabel, BorderLayout.WEST);
        panel.add(panelInfo, BorderLayout.CENTER);

        CustomButton potenciadorButton = new CustomButton(350, 170, Color.decode("#F8F2F0"));
        potenciadorButton.add(panel);
        potenciadorButton.setBorderPainted(false);            // Eliminar borde
        potenciadorButton.setContentAreaFilled(false);        //Fer que l'àrea de contingut del botó sigui transparent

        return potenciadorButton;
    }


    /**
     * Funció que crea una JTable amb les dades dels potenciadors.
     * @return JTable amb les dades dels generadors
     */
    public static JTable createTable(int quantitatPotenciadors1, int quantitatPotenciadors2, int quantitatPotenciadors3,
    float produccioTotal1, float produccioTotal2, float produccioTotal3, float overallPot1, float overallPot2, float overallPot3){
        String[] columnNames = {"Name", "Quantity", "Production unit", "Total production", "% overall production"};
        // Crear el modelo de tabla no editable
        DefaultTableModel tableModel = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };

        // Afegir les files de capçalera al model de la taula
        Vector<Object> row0 = new Vector<>();
        row0.add("Name");
        row0.add("Quantity");
        row0.add("Production unit");
        row0.add("Total production");
        row0.add("% overall");
        tableModel.addRow(row0);

        // Afegir les dades de cada potenciador al model de la taula
        Vector<Object> row1 = new Vector<>();
        row1.add("Barista Boost");
        row1.add(quantitatPotenciadors1);
        row1.add("0,2 c/s");
        row1.add(String.format("%.2f", produccioTotal1) + " c/s");
        row1.add(String.format("%.2f", overallPot1) + " %");
        tableModel.addRow(row1);

        Vector<Object> row2 = new Vector<>();
        row2.add("Waffle Wizard");
        row2.add(quantitatPotenciadors2);
        row2.add("1 c/s");
        row2.add(String.format("%.2f", produccioTotal2) + " c/s");
        row2.add(String.format("%.2f", overallPot2) + " %");
        tableModel.addRow(row2);

        Vector<Object> row3 = new Vector<>();
        row3.add("Steamy Brew");
        row3.add(quantitatPotenciadors3);
        row3.add("5 c/s");
        //mostrar produccioTotal3 con dos decimales
        row3.add(String.format("%.2f", produccioTotal3) + " c/s");
        row3.add(String.format("%.2f", overallPot3) + " %");
        tableModel.addRow(row3);

        // Crear la taula amb les dades
        JTable table = new JTable(tableModel);
        table.setBackground(Color.decode("#F8F2F0"));
        table.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        table.setForeground(Color.decode("#3B1211"));

        // Crear un renderitzador de celdas amb la classe CustomRenderer per afegir un borde interior
        CustomRenderer cellRenderer = new CustomRenderer(5);

        // Ajustar l'altura de les files i el borde exterior
        table.setRowHeight(80);
        table.setBorder(BorderFactory.createLineBorder(Color.decode("#DB5C39"), 5));

        // Ajustar l'amplada de les columnes i afegir el renderitzador de celdas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150);
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);

        }

        // Centrar les dades de la taula amb un renderitzador de celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        return table;
    }




    /**
     * Mètode per controlar els botons de la vista.
     * @param rvc ActionListener
     */
    public void buttonController(ActionListener rvc){
        potenciador1.addActionListener(rvc);
        potenciador1.setActionCommand(POTENCIADOR1);
        potenciador2.addActionListener(rvc);
        potenciador2.setActionCommand(POTENCIADOR2);
        potenciador3.addActionListener(rvc);
        potenciador3.setActionCommand(POTENCIADOR3);
        millora1.addActionListener(rvc);
        millora1.setActionCommand(MILLORA1);
        millora2.addActionListener(rvc);
        millora2.setActionCommand(MILLORA2);
        millora3.addActionListener(rvc);
        millora3.setActionCommand(MILLORA3);
        millora4.addActionListener(rvc);
        millora4.setActionCommand(MILLORA4);
        settingsButton.addActionListener(rvc);
        settingsButton.setActionCommand(SETTINGS);
        imageButton.addActionListener(rvc);
        imageButton.setActionCommand(CREATECOFFE);
        finishGame.addActionListener(rvc);
        finishGame.setActionCommand(FINISH);
        saveGame.addActionListener(rvc);
        saveGame.setActionCommand(SAVE);
    }

    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton de la millora 1
     */
    public CustomButton getMillora1() {
        return millora1;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton del botó de guardar el joc
     */
    public CustomButton getSaveGame() {
        return saveGame;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton del botó de finalitzar la partida
     */
    public CustomButton getFinishGame(){
        return finishGame;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton de la millora 2
     */
    public CustomButton getMillora2() {
        return millora2;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton de la millora 3
     */
    public CustomButton getMillora3() {
        return millora3;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton de la millora 4
     */
    public CustomButton getMillora4() {
        return millora4;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton potenciador 1
     */
    public CustomButton getPotenciador1() {
        return potenciador1;
    }



    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton potenciador 2
     */
    public CustomButton getPotenciador2() {
        return potenciador2;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton del potenciador 3
     */
    public CustomButton getPotenciador3() {
        return potenciador3;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton de la imatge que genera cafes
     */
    public JButton getImageButton() {
        return imageButton;
    }


    /**
     * Mètode per obtenir el botó de la imatge.
     * @return JButton de settings
     */
    public JButton getSettingsButton() {
        return settingsButton;
    }


    /**
     * Mètode per rebre la millora 1
     * @param millora1 CustomButton de la millora 1
     */
    public void setMillora1(CustomButton millora1) {
        this.millora1 = millora1;
    }

    /**
     * Mètode per rebre la millora 2
     * @param millora2 CustomButton de la millora 2
     */
    public void setMillora2(CustomButton millora2) {
        this.millora2 = millora2;
    }


    /**
     * Mètode per rebre la millora 3
     * @param millora3 CustomButton de la millora 3
     */
    public void setMillora3(CustomButton millora3) {
        this.millora3 = millora3;
    }


    /**
     * Mètode per rebre la millora 4
     * @param millora4 CustomButton de la millora 4
     */
    public void setMillora4(CustomButton millora4) {
        this.millora4 = millora4;
    }


    /**
     * Mètode per rebre el potenciador 1
     * @param potenciador1 CustomButton del potenciador 1
     */
    public void setPotenciador1(CustomButton potenciador1) {
        this.potenciador1 = potenciador1;
    }


    /**
     * Mètode per rebre el potenciador 2
     * @param potenciador2 CustomButton del potenciador 2
     */
    public void setPotenciador2(CustomButton potenciador2) {
        this.potenciador2 = potenciador2;
    }


    /**
     * Mètode per rebre el potenciador 3
     * @param potenciador3 CustomButton del potenciador 3
     */
    public void setPotenciador3(CustomButton potenciador3) {
        this.potenciador3 = potenciador3;
    }


    /**
     * Mètode per rebre la imatge que genera cafes
     * @param imageButton JButton de la imatge que genera cafes
     */
    public void setImageButton(JButton imageButton) {
        this.imageButton = imageButton;
    }


    /**
     * Mètode per rebre el botó de settings
     * @param settingsButton JButton de settings
     */
    public void setSettingsButton(JButton settingsButton) {
        this.settingsButton = settingsButton;
    }


    /**
     * Estableix el text del comptador i actualitza la seva aparença.
     *
     * @param text Text per al comptador.
     */
    public void setComptador(String text) {
        this.text = text;
        this.contador.setText(this.text);
        this.contador.setHorizontalAlignment(JLabel.CENTER);
        Dimension size = new Dimension(300, 100);
        this.contador.setMinimumSize(size);
        this.contador.setMaximumSize(size);
        this.contador.setPreferredSize(size);

        // Cambiar el color del borde
        //Color borderColor = Color.RED; // Cambia esto al color que desees
        //this.contador.setBorder(new LineBorder(borderColor));

        this.contador.repaint();
    }

    /**
     * Mètode per obtenir el comptador
     * @return String del comptador
     */
    public String getComptador() {
        return contador.getText();
    }

    /**
     * Mètode per obtenir el cost del generador1
     * @return Cost del generador1
     */
    public double getCost1() {
        return cost1;
    }


    /**
     * Mètode per obtenir el cost del generador2
     * @return Cost del generador2
     */
    public double getCost2() {
        return cost2;
    }


    /**
     * Mètode per obtenir el cost del generador3
     * @return Cost del generador3
     */
    public double getCost3() {
        return cost3;
    }


    /**
     * Estableix el cost del generador 1
     * @param cost1 El cost a establir per al generador 1.
     */
    public void setCostPotenciador1(double cost1) {
        this.cost1 = (int) Math.round(cost1);
    }

    /**
     * Estableix el cost del generador 2
     * @param cost2 El cost a establir per al generador 2.
     */
    public void setCostPotenciador2(int cost2) {
        this.cost2 = cost2;
    }


    /**
     * Estableix el cost del generador 3
     * @param cost3 El cost a establir per al generador 3.
     */
    public void setCostPotenciador3(int cost3) {
        this.cost3 = cost3;
    }

    /**
     * Mètode per obtenir la quantitat de potenciadors 1
     * @return Quantitat de potenciadors 1
     */
    public int getQuantitatPotenciadors1() {
        return quantitatPotenciadors1;
    }


    /**
     * Estableix la quantitat de potenciadors 1 que hi ha i edita la variable
     * @param quantitatPotenciadors1 La quantitat a establir per al potenciador 1
     */
    public void setQuantitatPotenciador1(int quantitatPotenciadors1) {
        this.quantitatPotenciadors1 = quantitatPotenciadors1;
        //voler a printar la celda 2,2 de table
        //this.table.remove(quantitatPotenciadors1);
        this.table.repaint();

    }


    /**
     * Mètode per obtenir la quantitat de potenciadors 2
     * @return Quantitat de potenciadors 2
     */
    public int getQuantitatPotenciadors2() {
        return quantitatPotenciadors2;
    }


    /**
     * Estableix la quantitat de potenciadors 2 que hi ha i edita la variable
     * @param quantitatPotenciadors2 La quantitat a establir per al potenciador 2
     */
    public void setQuantitatPotenciador2(int quantitatPotenciadors2) {
        this.quantitatPotenciadors2 = quantitatPotenciadors2;
        this.table.repaint();
    }


    /**
     * Mètode per obtenir la quantitat de potenciadors 3
     * @return Quantitat de potenciadors 3
     */
    public int getQuantitatPotenciadors3() {
        return quantitatPotenciadors3;
    }


    /**
     * Estableix la quantitat de potenciadors 3 que hi ha i edita la variable
     * @param quantitatPotenciadors3 La quantitat a establir per al potenciador 3
     */
    public void setQuantitatPotenciador3(int quantitatPotenciadors3) {
        this.quantitatPotenciadors3 = quantitatPotenciadors3;
        this.table.repaint();
    }

    /**
     * Mètode per obtenir la producció total del generador 1
     * @return Producció total del generador 1
     */
    public float getProduccioTotal1() {
        return produccioTotal1;
    }


    /**
     * Estableix la producció total del generador 1 i repinta la taula per mostrar el nou valor
     * @param produccioTotal1 La producció total a establir per al generador 1
     */
    public void setProduccioTotal1(float produccioTotal1) {
        this.produccioTotal1 = produccioTotal1;
        this.table.repaint();
    }


    /**
     * Mètode per obtenir la producció total del generador 2
     * @return Producció total del generador 2
     */
    public float getProduccioTotal2() {
        return produccioTotal2;
    }


    /**
     * Estableix la producció total del generador 2 i repinta la taula per mostrar el nou valor
     * @param produccioTotal2 La producció total a establir per al generador 2
     */
    public void setProduccioTotal2(float produccioTotal2) {
        this.produccioTotal2 = produccioTotal2;
        this.table.repaint();
    }


    /**
     * Mètode per obtenir la producció total del generador 3
     * @return Producció total del generador 3
     */
    public float getProduccioTotal3() {
        return produccioTotal3;
    }


    /**
     * Estableix la producció total del generador 3 i repinta la taula per mostrar el nou valor
     * @param produccioTotal3 La producció total a establir per al generador 3
     */
    public void setProduccioTotal3(float produccioTotal3) {
        this.table.repaint();
        this.produccioTotal3 = produccioTotal3;
    }

    public float getOverallPot1() {
        return overallPot1;
    }

    public void setOverallPot1(float overallPot1) {
        this.overallPot1 = overallPot1;
        this.table.repaint();
    }

    public float getOverallPot2() {
        return overallPot2;
    }

    public void setOverallPot2(float overallPot2) {
        this.overallPot2 = overallPot2;
        this.table.repaint();
    }

    public float getOverallPot3() {
        return overallPot3;
    }

    public void setOverallPot3(float overallPot3) {
        this.overallPot3 = overallPot3;
        this.table.repaint();
    }



    /**
     * Estableix la producció per unitat
     */
    private void setProduccioUnitat(double produccio) {
        this.produccioUnitat1 = produccio;
    }
    public void setPotenciador1Enabled(boolean isEnabled) {
        this.potenciador1.setEnabled(isEnabled);
    }
    public void setPotenciador2Enabled(boolean isEnabled) {
        this.potenciador2.setEnabled(isEnabled);
    }
    public void setPotenciador3Enabled(boolean isEnabled) {
        this.potenciador3.setEnabled(isEnabled);
    }


    /**
     * Actualitza les dades del generador 1 a la taula.
     *
     * @param quantitatGenerados La quantitat de generadors 1.
     * @param produccioTotal La producció total del generador 1.
     * @param prodActual La producció actual del generador 1 per unitat de temps.
     */
    public void updateGenerator1(int quantitatGenerados, double produccioTotal, double prodActual) {
        // Obtener el modelo de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();

        // Actualizar los valores de la fila correspondiente al generador 1
        tableModel.setValueAt(quantitatGenerados, 1, 1); // Actualizar la cantidad
        tableModel.setValueAt(String.format("%.2f", prodActual) + " c/s", 1, 2); // Actualizar la producción por unidad
        tableModel.setValueAt(produccioTotal, 1, 3); // Actualizar la producción total
        tableModel.setValueAt(String.format("%.2f", overallPot1) + " %", 1, 4); // Actualizar el porcentaje de producción total

        // Notificar al modelo de la tabla que los datos han cambiado, lo que provocará que la tabla se actualice
        tableModel.fireTableDataChanged();
    }


    /**
     * Actualitza les dades del generador 2 a la taula.
     *
     * @param quantitatGenerados La quantitat de generadors 2.
     * @param produccioTotal La producció total del generador 2.
     * @param prodActual La producció actual del generador 2 per unitat de temps.
     */
    public void updateGenerator2(int quantitatGenerados, double produccioTotal, double prodActual) {
        // Obtener el modelo de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();

        // Actualizar los valores de la fila correspondiente al generador 2
        tableModel.setValueAt(quantitatGenerados, 2, 1); // Actualizar la cantidad
        tableModel.setValueAt(String.format("%.2f", prodActual) + " c/s", 2, 2); // Actualizar la producción por unidad
        tableModel.setValueAt(produccioTotal, 2, 3); // Actualizar la producción total
        tableModel.setValueAt(String.format("%.2f", overallPot2) + " %", 2, 4); // Actualizar el porcentaje de producción total

        // Notificar al modelo de la tabla que los datos han cambiado, lo que provocará que la tabla se actualice
        tableModel.fireTableDataChanged();
    }


    /**
     * Actualitza la producció total d'un generador a la taula.
     *
     * @param generatorRow La fila de la taula corresponent al generador.
     * @param produccioTotal La nova producció total del generador.
     */
    public void updateProduccioTotal(int generatorRow, double produccioTotal) {
        // Obtener el modelo de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();

        // Actualizar el valor de produccioTotal en la fila correspondiente al generador
        tableModel.setValueAt(String.format("%.2f", produccioTotal), generatorRow, 3); // Actualizar la producción total

        // Notificar al modelo de la tabla que los datos han cambiado, lo que provocará que la tabla se actualice
        tableModel.fireTableDataChanged();
    }


    /**
     * Actualitza les dades del generador 3 a la taula.
     *
     * @param quantitatGenerados La quantitat de generadors 3.
     * @param produccioTotal La producció total del generador 3.
     * @param prodActual La producció actual del generador 3 per unitat de temps.
     */
    public void updateGenerator3(int quantitatGenerados, double produccioTotal, double prodActual) {
        // Obtener el modelo de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();

        // Actualizar los valores de la fila correspondiente al generador 3
        tableModel.setValueAt(quantitatGenerados, 3, 1); // Actualizar la cantidad
        tableModel.setValueAt(String.format("%.2f", prodActual) + " c/s", 3, 2); // Actualizar la producción por unidad
        tableModel.setValueAt(produccioTotal, 3, 3); // Actualizar la producción total
        tableModel.setValueAt(String.format("%.2f", overallPot3) + " %", 3, 4); // Actualizar el porcentaje de producción total

        // Notificar al modelo de la tabla que los datos han cambiado, lo que provocará que la tabla se actualice
        tableModel.fireTableDataChanged();
    }



    /**
     * Actualitza el cost del generador 1.
     *
     * @param costActual El cost actual del generador 1.
     */
    public void updateCostGenerator1(double costActual) {
        this.cost1 = Math.round(costActual * 100.0) / 100.0;
        this.labelPotCost1.setText("Cost: " + String.valueOf(this.cost1));
    }
    public void updateCostGenerator2(double costActual) {
        this.cost2 = Math.round(costActual * 100.0) / 100.0;
        this.labelPotCost2.setText("Cost: " + String.valueOf(this.cost2));
    }
    public void updateCostGenerator3(double costActual) {
        this.cost3 = Math.round(costActual * 100.0) / 100.0;
        this.labelPotCost3.setText("Cost: " + String.valueOf(this.cost3));
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
