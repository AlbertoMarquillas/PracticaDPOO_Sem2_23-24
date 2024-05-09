package Presentation.Controller;

import Presentation.View.MainView;
import Business.Managers.GameManager;

public class ChangeViewController {

    private final MainView mainView;

    private final GameManager gameManager;


    /**
     * Constructor de la classe ChangeViewController.
     *
     * @param mainView    La vista principal de l'aplicació.
     * @param gameManager El gestor de jocs de l'aplicació.
     */
    public ChangeViewController(MainView mainView, GameManager gameManager) {
        this.mainView = mainView;
        this.gameManager = gameManager;
    }


    /**
     * Canvia el panell actual per un altre.
     *
     * @param pantalla El nom del panell a canviar.
     */
    public void changePan(String pantalla) {
        mainView.panelChange(pantalla);
    }


    /**
     * Estableix si el comptador ha de funcionar o no.
     *
     * @param run Indica si el comptador ha de funcionar (true) o no (false).
     */
    public void setComptador (boolean run) {
        gameManager.comptar(run);
    }

}