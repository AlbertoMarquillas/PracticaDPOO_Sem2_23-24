package Presentation.Controller;

import Business.Managers.LogInManager;
import Business.Managers.MilloraManager;
import Business.Managers.UserManager;
import Business.Managers.GameManager;
import Presentation.View.InitialView;
import Presentation.View.StartView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialController implements ActionListener{

    private final InitialView initialView;
    private final LogInManager logInManager;
    private final ChangeViewController changeViewController;
    private final UserManager userManager;
    private final StartView startView;
    private final GameManager gameManager;
    private final MilloraManager milloraManager;


    /**
     * Constructor de la classe InitialController.
     *
     * @param initialView          La vista inicial de l'aplicació.
     * @param logInManager         El gestor d'inici de sessió de l'aplicació.
     * @param changeViewController El controlador de canvi de vistes de l'aplicació.
     * @param userManager          El gestor d'usuaris de l'aplicació.
     * @param startView            La vista d'inici de l'aplicació.
     * @param gameManager          El gestor de jocs de l'aplicació.
     */
    public InitialController(InitialView initialView, LogInManager logInManager, ChangeViewController changeViewController, UserManager userManager, StartView startView, GameManager gameManager, MilloraManager milloraManager) {
        this.initialView = initialView;
        this.logInManager = logInManager;
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.startView = startView;
        this.gameManager = gameManager;
        this.milloraManager = milloraManager;
    }


    /**
     * Acció que es realitza quan es produeix un esdeveniment d'acció.
     *
     * @param e El esdeveniment d'acció que ha ocorregut.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        userManager.setAllConnectedsOff();
        if (e.getActionCommand().equals("login")) {
            String cas = logInManager.comprobarLogIn(getUsernameFieldController(), getPasswordFieldController());
            switch (cas) {
                case "FillAll" -> showErrorFillAll();
                case "WrongPass" -> showWrongPassword();
                case "WrongUser" -> showWrongUser();
                case "potsPassar" -> {
                    borrarInfoInit();

                    // Calcular el estado de los botones
                    boolean enabledNewGame = !gameManager.comprobarPartidesActives(gameManager.getConnectedUserId());
                    boolean enabledResumeGame = gameManager.comprobarPartidesActives(gameManager.getConnectedUserId());
                    boolean enabledStatistics = gameManager.comprobarPartidesActives(gameManager.getConnectedUserId()) || gameManager.getCurrentGameId(gameManager.getConnectedUserId()) > 0;

                    // Actualizar el estado de los botones en StartView
                    startView.setButtonsEnabled(enabledNewGame, enabledResumeGame, enabledStatistics);

                    changeViewController.changePan("start");
                }
            }

        } else if (e.getActionCommand().equals("register")) {
            changeViewController.changePan("register");
            borrarInfoInit();
        }
    }


    /**
     * Esborra la informació dels camps de nom d'usuari i contrasenya a la vista inicial.
     */
    private void borrarInfoInit() {
        initialView.setUsernameField("");
        initialView.setPasswordField("");
    }


    /**
     * Obté el contingut del camp de nom d'usuari de la vista inicial.
     *
     * @return El contingut del camp de nom d'usuari.
     */
    private String getUsernameFieldController() {
        return initialView.getUsernameField();
    }

    /**
     * Obté el contingut del camp de contrasenya de la vista inicial.
     *
     * @return El contingut del camp de contrasenya.
     */
    private String getPasswordFieldController() {
        return initialView.getPasswordField();
    }


    /**
     * Habilita o deshabilita la funcionalitat segons la longitud dels camps de nom d'usuari i contrasenya.
     *
     * @return Cert si s'ha d'habilitar la funcionalitat, fals si s'ha de deshabilitar.
     */
    public boolean enable(){
        return logInManager.keyTyped(getUsernameFieldController().length(), getPasswordFieldController().length());
    }

    /**
     * Mostra un missatge d'error indicant que l'usuari introduit no és válid.
     */
    private void showWrongUser() {
        JOptionPane.showMessageDialog(initialView, "L'usuari o correu introduït no existeix");
    }

    /**
     * Mostra un missatge d'error indicant que la contrasenya introduïda és incorrecta.
     */
    private void showWrongPassword() {
        JOptionPane.showMessageDialog(initialView, "La contrasenya introduïda es incorrecta");
    }

    /**
     * Mostra un missatge d'error indicant que cal omplir tots els camps.
     */
    private void showErrorFillAll() {
        JOptionPane.showMessageDialog(initialView, "Tots els camps son obligatoris");
    }

}
