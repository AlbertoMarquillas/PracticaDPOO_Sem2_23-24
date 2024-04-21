package Presentation.Controller;

import Presentation.View.StatsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsController implements ActionListener {

    private final ChangeViewController changeViewController;
    private StatsView statsView;
    public StatsController(ChangeViewController changeViewController) {
        this.changeViewController = changeViewController;
        this.statsView = new StatsView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("game")) {
            changeViewController.changePan("game");
        }
    }
}
