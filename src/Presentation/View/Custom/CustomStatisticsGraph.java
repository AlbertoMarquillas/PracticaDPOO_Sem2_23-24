package Presentation.View.Custom;

import Business.Entities.Stats;
import Business.Managers.StatsManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa un gràfic personalitzat per a les estadístiques.
 */
public class CustomStatisticsGraph extends JPanel{
    private ArrayList<Stats> stats;

    public CustomStatisticsGraph(ArrayList<Stats> stats) {
        this.stats = stats;
    }


    /**
     * Sobreescriu el mètode {@code paintComponent} per dibuixar un gràfic de dispersió amb línies connectades a partir de les dades d'estadístiques.
     *
     * @param g L'objecte {@code Graphics} utilitzat per dibuixar els components.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3.0f));

        // Calcular el rango de valores en los datos
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (Stats stats : stats) {
            if (stats.getnCoffeeint() > maxY) {
                maxY = stats.getnCoffeeint();
            }
            if (stats.getTimeInMinutes() > maxX) {
                maxX = stats.getTimeInMinutes();
            }
        }

        // Calcular el tamaño de la ventana proporcional al rango de valores
        int windowHeight = 600;
        int windowWidth = 1400;
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        revalidate();

        // Dibujar ejes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50); // Eje X
        g2d.drawLine(50, getHeight() - 50, 50, 50); // Eje Y

        // Títulos de los ejes
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Time (min)", getWidth() / 2 - 40, getHeight() - 10);
        g2d.rotate(-Math.PI / 2);
        g2d.drawString("Number of Coffees", -getHeight() / 2 - 90, 10);
        g2d.rotate(Math.PI / 2);

        // Calcular el intervalo de las marcas de los ejes
        int xInterval = calcularIntervalo(maxX);
        int yInterval = calcularIntervalo(maxY);

        // Valores de los ejes
        g2d.setColor(Color.BLACK);
        for (int i = 0; i <= maxX; i += xInterval) {
            g2d.drawString(String.valueOf(i), i * (getWidth() - 100) / maxX + 45, getHeight() - 35); // Valores en el eje X
        }
        for (int i = 0; i <= maxY; i += yInterval) {
            g2d.drawString(String.valueOf(i), 20, getHeight() - i * (getHeight() - 100) / maxY - 45); // Valores en el eje Y
        }

        // Dibujar puntos y líneas
        g2d.setColor(Color.ORANGE);
        int prevX = 0;
        int prevY = 0;
        boolean first = true;
        for (Stats stat : stats) {
            int x = stat.getTimeInMinutes() * (getWidth() - 100) / maxX + 50;
            int y = getHeight() - (50 + stat.getnCoffeeint() * (getHeight() - 100) / maxY);
            g2d.fillOval(x - 6, y - 6, 12, 12);  // Increase the size of the points
            if (!first) {
                g2d.drawLine(prevX, prevY, x, y);
            } else {
                first = false;
            }
            prevX = x;
            prevY = y;
        }
    }


    /**
     * Calcula l'interval de les marques de l'eix basat en el valor màxim especificat.
     *
     * @param max El valor màxim.
     * @return L'interval de les marques de l'eix.
     */
    private int calcularIntervalo(int max) {
        if (max <= 10) {
            return 1;
        } else if (max <= 100) {
            return 10;
        } else if (max <= 1000) {
            return 100;
        } else if (max <= 10000) {
            return 1000;
        } else if (max <= 100000) {
            return 10000;
        } else {
            return 100000;
        }
    }
}
