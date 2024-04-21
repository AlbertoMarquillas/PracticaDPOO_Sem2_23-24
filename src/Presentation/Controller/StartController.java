package Presentation.Controller;

import Presentation.View.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController implements ActionListener {

    private final ChangeViewController changeViewController;

    public StartController(ChangeViewController changeViewController) {
        this.changeViewController = changeViewController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newgame")) {
            changeViewController.changePan("game");
        } else if (e.getActionCommand().equals("resumegame")) {
            changeViewController.changePan("game");
        } else if (e.getActionCommand().equals("stats")) {
            changeViewController.changePan("stats");
        }
    }
}
