package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    CardLayout cardLayout;

    /**
     * Constructor de la clase MainView
     * @param initialView vista inicial
     * @param registerView vista de registro
     * @param gameView vista del juego
     * @param settingsView vista de ajustes
     * @param startView vista de inicio
     * @param statsView vista de estadisticas
     */
    public void mainView(InitialView initialView, RegisterView registerView, GameView gameView, SettingsView settingsView, StartView startView, StatsView statsView){

        cardLayout = new CardLayout();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(750,500,800,450);
        getContentPane().setLayout(cardLayout);

        this.getContentPane().add(initialView, "login");
        this.getContentPane().add(registerView,"register");
        this.getContentPane().add(settingsView,"settings");
        this.getContentPane().add(startView,"start");
        this.getContentPane().add(gameView,"game");
        this.getContentPane().add(statsView,"stats");

    }

    /**
     * Canvia el panell mostrat a la finestra principal segons l'índex proporcionat.
     *
     * @param index l'índex del panell a mostrar
     *              Pot ser "login", "register", "settings", "start", "game" o "stats"
     */
    public void panelChange(String index){
        switch (index) {
            case "login" -> {
                setBounds(750,500,800,450);
                this.cardLayout.show(getContentPane(), "login");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "register" -> {
                setBounds(750,500,800,450);
                this.cardLayout.show(getContentPane(), "register");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "settings" -> {
                setBounds(750,500,800,450);
                this.cardLayout.show(getContentPane(), "settings");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "start" -> {
                setBounds(750,500,800,450);
                //AQUI

                this.cardLayout.show(getContentPane(), "start");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "game" -> {
                setBounds(750,500,1500,800);
                this.cardLayout.show(getContentPane(), "game");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "stats" -> {
                setBounds(750,500,800,450);
                this.cardLayout.show(getContentPane(), "stats");
                setLocationRelativeTo(null);
                setVisible(true);
            }
        }

    }
}

