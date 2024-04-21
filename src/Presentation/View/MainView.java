package Presentation.View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    CardLayout cardLayout;

    public void mainView(InitialView initialView, RegisterView registerView, GameView gameView, SettingsView settingsView, StartView startView, StatsView statsView){

        cardLayout = new CardLayout();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(750,500,750,500);
        getContentPane().setLayout(cardLayout);

        this.getContentPane().add(initialView, "login");
        this.getContentPane().add(registerView,"register");
        this.getContentPane().add(settingsView,"settings");
        this.getContentPane().add(startView,"start");
        this.getContentPane().add(gameView,"game");
        this.getContentPane().add(statsView,"stats");

    }
    public void panelChange(String index){
        switch (index) {
            case "login" -> {
                this.cardLayout.show(getContentPane(), "login");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "register" -> {
                this.cardLayout.show(getContentPane(), "register");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "settings" -> {
                this.cardLayout.show(getContentPane(), "settings");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "start" -> {
                this.cardLayout.show(getContentPane(), "start");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "game" -> {
                this.cardLayout.show(getContentPane(), "game");
                setLocationRelativeTo(null);
                setVisible(true);
            }
            case "stats" -> {
                this.cardLayout.show(getContentPane(), "stats");
                setLocationRelativeTo(null);
                setVisible(true);
            }
        }

    }
}

