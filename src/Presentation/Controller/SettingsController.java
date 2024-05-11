package Presentation.Controller;

import Business.Managers.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController implements ActionListener {

    public final ChangeViewController changeViewController;
    private final UserManager userManager;
    private final StartController startController;
    private final StatsController statsController;
    private final GameController gameController;


    /**
     * Constructor de la classe SettingsController.
     *
     * @param changeViewController Controlador per a gestionar els canvis de pantalla.
     * @param userManager Gestor d'usuari per a realitzar operacions relacionades amb els usuaris.
     */
    public SettingsController(ChangeViewController changeViewController, UserManager userManager, StartController startController, StatsController statsController, GameController gameController) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.startController = startController;
        this.statsController = statsController;
        this.gameController = gameController;
    }


    /**
     * Mostra un diàleg de confirmació amb el missatge especificat i opcions Sí i No.
     *
     * @param message El missatge a mostrar en el diàleg de confirmació.
     * @return true si l'usuari fa clic a Sí, false si fa clic a No.
     */
    private boolean showConfirmationDialog(String message) {
        int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * Gestiona les accions de l'usuari en resposta a esdeveniments d'acció.
     *
     * @param e L'esdeveniment d'acció que ha tingut lloc.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("delete")) {
            boolean exit = showConfirmationDialog("Are you sure you want to delete your account");
            if(exit){
                String user = userManager.getNameUserConnected();
                userManager.deleteConnectedUser(user);
                changeViewController.changePan("login");
            } else {
                changeViewController.changePan("settings");
            }

        } else if (e.getActionCommand().equals("close")) {
            boolean exit = showConfirmationDialog("Are you sure you want to log out?");
            if(exit){
                String user = userManager.getNameUserConnected();
                userManager.disconnectedUser(user);
                changeViewController.changePan("login");
            } else {
                changeViewController.changePan("settings");
            }
        } else if (e.getActionCommand().equals("back")) {
            if(gameController.isCameFromGame()){
                changeViewController.setComptador(true);
                changeViewController.changePan("game");
                gameController.setCameFromGame(false);
            } else if(startController.isCameFromStart()){
                changeViewController.changePan("start");
                startController.setCameFromStart(false);
            } else if(statsController.isCameFromStats()){
                changeViewController.changePan("stats");
                statsController.setCameFromStats(false);
            }

        }
    }
}
