package Presentation.Controller;

import Business.Managers.GameManager;
import Business.Managers.GeneratorManager;
import Business.Managers.UserManager;
import Presentation.View.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController implements ActionListener {

    private final ChangeViewController changeViewController;
    private final UserManager userManager;
    private final GameManager gameManager;
    private final StartView startView;
    private final GeneratorManager generatorManager;


    public StartController(ChangeViewController changeViewController, UserManager userManager, GameManager gameManager, GeneratorManager generatorManager , StartView startView) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.gameManager = gameManager;
        this.startView = startView;
        this.generatorManager = generatorManager;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //No es pot iniciar una partida si ja n'hi ha una activa
        if (e.getActionCommand().equals("newgame") && !gameManager.comprobarPartidesActives(gameManager.getConnectedUserId())) {
            userManager.setPartidaActiva();
            gameManager.initGame();
            generatorManager.initGeneratorPesistance(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()) + 1);
            changeViewController.setComptador(true);
            changeViewController.changePan("game");
            gameManager.comptar();
            

        } else if (e.getActionCommand().equals("resumegame")) {
            //Carregar la partida
            changeViewController.setComptador(true);
            changeViewController.changePan("game");
            gameManager.comptar();
        } else if (e.getActionCommand().equals("stats")) {
            changeViewController.changePan("stats");
        }
    }
}
