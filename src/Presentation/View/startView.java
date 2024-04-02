package Presentation.View;
/*
import javax.swing.*;
import java.awt.*;

public class startView extends JFrame {
    public static JButton createButton(String string) {
        JButton button = new JButton(string);
        button.setPreferredSize(new Dimension(250, 40));
        button.setBackground(Color.decode("#3B1211"));
        button.setForeground(Color.decode("#F8F2F0"));
        button.setFont(new Font("Bell MT", Font.PLAIN, 16));
        return button;
    }

    public static JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.decode("#DB5C39"));
        return label;
    }

    public startView() {

        JLabel titleLabel = createLabel("COFFEE CLICKER", new Font("Arial", Font.BOLD, 30), Color.decode("#DB5C39"));
        JButton newGameButton = createButton("New Game");
        JButton startGameButton = createButton("Start Game");
        JButton statisticsButton = createButton("Statistics");


        //PANTALLA GENERAL
        setTitle("Register View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450); // Tamaño de la ventana
        setLayout(new GridBagLayout()); // Layout de la ventana principal

        //PANELL ESQUERRA
        setLayout(new BorderLayout());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.decode("#F8F2F0"));
        ImageIcon logoIcon = new ImageIcon("Imagenes/logo.png"); // Ruta de la imagen del logo
        JLabel logoLabel = new JLabel(logoIcon);

        panelIzquierdo.setLayout(new GridBagLayout());
        GridBagConstraints gbcPri = new GridBagConstraints();
        gbcPri.gridx = 0;
        gbcPri.gridy = 0;
        gbcPri.insets = new Insets(20, 0, 20, 0);
        panelIzquierdo.add(logoLabel, gbcPri);

        //AÑADIR LA IMAGEN EN EL CENTO DEL PANEL
        add(panelIzquierdo, BorderLayout.WEST);


        //PANELL central
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbcCent = new GridBagConstraints();

        gbcCent.gridx = 0;
        gbcCent.gridy = 0;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(titleLabel, gbcCent);


        gbcCent.gridx = 0;
        gbcCent.gridy = 1;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(newGameButton, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 2;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(startGameButton, gbcCent);

        gbcCent.gridx = 0;
        gbcCent.gridy = 3;
        gbcCent.insets = new Insets(20, 0, 0, 0);
        panelInfo.add(statisticsButton, gbcCent);

        panelInfo.setBackground(Color.decode("#F8F2F0"));
        add(panelInfo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            startView StartView = new startView();
            StartView.setVisible(true);
        });
    }
}
*/



import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class startView extends JButton {
    public startView(String label) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,size.height);
        setPreferredSize(size);

        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
    }

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null ||
                !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            startView StartView = new startView("hola");
            StartView.setVisible(true);
            JButton button = new startView("Click");
            button.setBackground(Color.gray);

            JFrame frame = new JFrame();
            frame.getContentPane().add(button);
            frame.getContentPane().setLayout(new FlowLayout());
            frame.setSize(150, 150);
            frame.setVisible(true);
        });
    }
}