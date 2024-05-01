package Presentation.Controller;

import Business.Managers.GeneratorManager;
import Business.Managers.UserManager;
import Presentation.View.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController implements ActionListener {

    private final ChangeViewController changeViewController;
    private final UserManager userManager;
    private final StartView startView;


    public StartController(ChangeViewController changeViewController, UserManager userManager, StartView startView) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.startView = startView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newgame")) {
            userManager.setPartidaActiva();
            GeneratorManager.
            changeViewController.changePan("game");
        } else if (e.getActionCommand().equals("resumegame")) {
            changeViewController.changePan("game");
        } else if (e.getActionCommand().equals("stats")) {
            changeViewController.changePan("stats");
        }
    }
}
