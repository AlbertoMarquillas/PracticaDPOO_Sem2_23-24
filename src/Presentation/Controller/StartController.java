package Presentation.Controller;

import Business.Managers.GameManager;
import Business.Managers.UserManager;
import Presentation.View.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController implements ActionListener {

    private final ChangeViewController changeViewController;
    private final UserManager userManager;
    private final GameManager gameManager;
    private final StartView startView;


    public StartController(ChangeViewController changeViewController, UserManager userManager, GameManager gameManager, StartView startView) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.gameManager = gameManager;
        this.startView = startView;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newgame")) {
            userManager.setPartidaActiva();
            gameManager.comptar();
            changeViewController.changePan("game");
        } else if (e.getActionCommand().equals("resumegame")) {
            changeViewController.changePan("game");
        } else if (e.getActionCommand().equals("stats")) {
            changeViewController.changePan("stats");
        }
    }
}
