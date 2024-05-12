package Presentation.View.Custom;

import Business.Entities.Stats;
import Business.Managers.StatsManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomStatisticsGraph extends JPanel{
    private List<Stats> stats;

    public CustomStatisticsGraph() {
        //stats = StatsManager.getStatsFromSQL();


    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calcular el rango de valores en los datos
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (Stats stats : stats) {
            if (stats.getnCoffeeint() > maxY) {
                maxY = stats.getnCoffeeint();
            }
            if (stats.getTimeint() > maxX) {
                maxX = stats.getTimeint();
            }
        }

        // Calcular el tamaño de la ventana proporcional al rango de valores
        int windowHeight = Math.max(maxY * 5 + 100, 600);
        int windowWidth = Math.max(maxX * 5 + 100, 800);
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
        g2d.drawString("Number of Coffees", -getHeight() / 2 - 80, 20);
        g2d.rotate(Math.PI / 2);

        // Valores de los ejes
        g2d.setColor(Color.BLACK);
        for (int i = 0; i <= maxX; i++) {
            g2d.drawString(String.valueOf(i), i * (getWidth() - 100) / maxX + 45, getHeight() - 35); // Valores en el eje X
        }
        for (int i = 0; i <= maxY; i += 10) {
            g2d.drawString(String.valueOf(i), 20, getHeight() - i * (getHeight() - 100) / maxY - 45); // Valores en el eje Y
        }

        // Dibujar puntos y líneas
        g2d.setColor(Color.ORANGE);
        int prevX = 0;
        int prevY = 0;
        boolean first = true;
        for (Stats stat : stats) {
            int x = stat.getTimeint() * (getWidth() - 100) / maxX + 50;
            int y = getHeight() - (50 + stat.getnCoffeeint() * (getHeight() - 100) / maxY);
            g2d.fillOval(x - 3, y - 3, 6, 6);
            if (!first) {
                g2d.drawLine(prevX, prevY, x, y);
            } else {
                first = false;
            }
            prevX = x;
            prevY = y;
        }
    }

}
