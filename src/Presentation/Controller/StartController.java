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
    private boolean cameFromStart = false;

    /**
     * Constructor de la classe StartController.
     *
     * @param changeViewController Controlador per a gestionar els canvis de pantalla.
     * @param userManager Gestor d'usuaris per a realitzar operacions relacionades amb els usuaris.
     * @param gameManager Gestor de jocs per a realitzar operacions relacionades amb els jocs.
     * @param generatorManager Gestor de generadors per a realitzar operacions relacionades amb els generadors.
     * @param startView Vista d'inici per a mostrar la interfície d'usuari i rebre interaccions de l'usuari.
     */
    public StartController(ChangeViewController changeViewController, UserManager userManager, GameManager gameManager, GeneratorManager generatorManager , StartView startView) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.gameManager = gameManager;
        this.startView = startView;
        this.generatorManager = generatorManager;
    }


    public boolean isCameFromStart() {
        return cameFromStart;
    }

    public void setCameFromStart(boolean cameFromStart) {
        this.cameFromStart = cameFromStart;
    }

    /**
     * Gestiona les accions de l'usuari en la vista d'inici.
     *
     * @param e Event d'acció generat per l'usuari.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //No es pot iniciar una partida si ja n'hi ha una activa
        if (e.getActionCommand().equals("newgame") && !gameManager.comprobarPartidesActives(gameManager.getConnectedUserId())) {
            userManager.setPartidaActiva();
            gameManager.initGame();
            generatorManager.initGeneratorPesistance(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()) + 1);
            changeViewController.setComptador(true);
            changeViewController.changePan("game");

        } else if (e.getActionCommand().equals("resumegame")) {
            //Carregar la partida
            changeViewController.setComptador(true);
            changeViewController.changePan("game");

        } else if (e.getActionCommand().equals("stats")) {
            changeViewController.changePan("stats");
        }

        if(e.getActionCommand().equals("settings")){
            setCameFromStart(true);
            changeViewController.changePan("settings");
        }
    }
}
