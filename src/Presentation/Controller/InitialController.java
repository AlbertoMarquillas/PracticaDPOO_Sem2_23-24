package Presentation.Controller;

import Business.Managers.LogInManager;
import Presentation.View.InitialView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialController implements ActionListener{

    private final InitialView initialView;
    private final LogInManager logInManager;
    private final ChangeViewController changeViewController;

    public InitialController(InitialView initialView, LogInManager logInManager, ChangeViewController changeViewController) {
        this.initialView = initialView;
        this.logInManager = logInManager;
        this.changeViewController = changeViewController;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            String cas = logInManager.comprobarLogIn(getUsernameFieldController(), getPasswordFieldController());
            switch (cas) {
                case "FillAll" -> showErrorFillAll();
                case "WrongPass" -> showWrongPassword();
                case "WrongUser" -> showWrongUser();
                case "potsPassar" -> {
                    borrarInfoInit();
                    changeViewController.changePan("start");
                }
            }

        } else if (e.getActionCommand().equals("register")) {
            changeViewController.changePan("register");
            borrarInfoInit();

        }
    }
}
