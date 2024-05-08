package Presentation.Controller;

import Presentation.View.MainView;
import Business.Managers.GameManager;

public class ChangeViewController {

    private final MainView mainView;

    private final GameManager gameManager;

    public ChangeViewController(MainView mainView, GameManager gameManager) {
        this.mainView = mainView;
        this.gameManager = gameManager;
    }

    public void changePan(String pantalla) {
        mainView.panelChange(pantalla);
    }

    public void setComptador (boolean run) {
        gameManager.comptar(run);
    }

}