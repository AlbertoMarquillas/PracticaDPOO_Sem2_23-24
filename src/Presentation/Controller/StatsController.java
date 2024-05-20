package Presentation.Controller;

import Business.Entities.Stats;
import Business.Managers.StatsManager;
import Presentation.View.StatsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StatsController implements ActionListener {

    private final ChangeViewController changeViewController;
    private StatsView statsView;
    private StatsManager statsManager;
    private boolean cameFromStats = false;

    /**
     * Constructor de la classe StatsController.
     *
     * @param changeViewController Controlador per canviar de vistes.
     */
    public StatsController(ChangeViewController changeViewController, StatsManager statsManager, StatsView statsView) {
        this.statsManager = statsManager;
        this.changeViewController = changeViewController;
        this.statsView = statsView;
    }

    /**
     * Comprova si l'usuari ha vingut des de les estadístiques.
     *
     * @return true si l'usuari ha vingut des de les estadístiques; false altrament.
     */
    public boolean isCameFromStats() {
        return cameFromStats;
    }


    /**
     * Estableix si l'usuari ha vingut des de les estadístiques.
     *
     * @param cameFromStats true si l'usuari ha vingut des de les estadístiques; false altrament.
     */
    public void setCameFromStats(boolean cameFromStats) {
        this.cameFromStats = cameFromStats;
    }

    /**
     * Gestiona les accions de l'usuari en la pantalla d'estadístiques.
     *
     * @param e Event d'acció generat per l'usuari.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back")) {
            changeViewController.changePan("start");
        } else if(e.getActionCommand().equals("settings")){
            setCameFromStats(true);
            changeViewController.changePan("settings");

        } else if(e.getActionCommand().equals("Next Player")){
            statsManager.nextPlayerGraph();
            statsView.setStats(statsManager.getCurrentStats(), statsManager.getNameUserConnected(), statsManager.getCurrentGameIDSatats());

        } else if(e.getActionCommand().equals("Prevous Player")){
            statsManager.previousPlayerGraph();
            statsView.setStats(statsManager.getCurrentStats(), statsManager.getNameUserConnected(), statsManager.getCurrentGameIDSatats());

        } else if(e.getActionCommand().equals("Next Game")){
            statsManager.nextGameGraph();
            statsView.setStats(statsManager.getCurrentStats(), statsManager.getNameUserConnected(), statsManager.getCurrentGameIDSatats());

        } else if(e.getActionCommand().equals("Previous Game")) {
            statsManager.previousGameGraph();
            statsView.setStats(statsManager.getCurrentStats(), statsManager.getNameUserConnected(), statsManager.getCurrentGameIDSatats());

        }
    }

    public ArrayList<Stats> getCurrentGraph() {
        return statsManager.getCurrentStats();
    }
}
