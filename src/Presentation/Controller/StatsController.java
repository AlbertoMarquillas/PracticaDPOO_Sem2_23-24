package Presentation.Controller;

import Presentation.View.StatsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsController implements ActionListener {

    private final ChangeViewController changeViewController;
    private StatsView statsView;

    /**
     * Constructor de la classe StatsController.
     *
     * @param changeViewController Controlador per canviar de vistes.
     */
    public StatsController(ChangeViewController changeViewController) {
        this.changeViewController = changeViewController;
        this.statsView = new StatsView();
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
        }
    }
}
