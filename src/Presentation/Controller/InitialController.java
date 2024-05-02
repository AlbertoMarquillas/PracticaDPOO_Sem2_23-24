package Presentation.Controller;

import Business.Managers.LogInManager;
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

    public InitialController(InitialView initialView, LogInManager logInManager, ChangeViewController changeViewController, UserManager userManager, StartView startView, GameManager gameManager) {
        this.initialView = initialView;
        this.logInManager = logInManager;
        this.changeViewController = changeViewController;
        this.userManager = userManager;
        this.startView = startView;
        this.gameManager = gameManager;
    }

    // ... otros métodos ...

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

    private void borrarInfoInit() {
        initialView.setUsernameField("");
        initialView.setPasswordField("");
    }


    private String getUsernameFieldController() {
        return initialView.getUsernameField();
    }

    private String getPasswordFieldController() {
        return initialView.getPasswordField();
    }

    public boolean enable(){
        return logInManager.keyTyped(getUsernameFieldController().length(), getPasswordFieldController().length());
    }
    private void showWrongUser() {
        JOptionPane.showMessageDialog(initialView, "L'usuari o correu introduït no existeix");
    }

    private void showWrongPassword() {
        JOptionPane.showMessageDialog(initialView, "La contrasenya introduïda es incorrecta");
    }
    private void showErrorFillAll() {
        JOptionPane.showMessageDialog(initialView, "Tots els camps son obligatoris");
    }

}
