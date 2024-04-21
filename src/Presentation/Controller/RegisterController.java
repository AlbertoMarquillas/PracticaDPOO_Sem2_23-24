package Presentation.Controller;

import Business.Managers.SignUpManager;
import Presentation.View.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    private final RegisterView registerView;
    private final SignUpManager signUpManager;
    public final ChangeViewController changeViewController;

    /**
     * Constructor del controller del registre
     *
     * @param registerView         : La vista del registre
     * @param signUpManager        : El manager del registre
     * @param changeViewController
     */
    public RegisterController(RegisterView registerView, SignUpManager signUpManager, ChangeViewController changeViewController) {
        this.registerView = registerView;
        this.signUpManager = signUpManager;
        this.changeViewController = changeViewController;
    }

    /**
     * Funcio per recuperar el username del field
     * @return el username que s'ha introduit al field
     */
    private String getUsernameFieldController() {
        return registerView.getUsernameField();
    }

    /**
     * Funcio per recuperar el mail del field
     * @return el mail que s'ha introduit al field
     */
    private String getEmailFieldController() {
        return registerView.getEmailField();
    }

    /**
     * Funcio per recuperar la contrasenya del field
     * @return la contrasenya que s'ha introduit al field
     */
    private String getPasswordFieldController() {
        return registerView.getPasswordField();
    }

    /**
     * Funcio per recuperar la contrasenya de confirmació del field
     * @return la contrasenya de confirmació que s'ha introduit al field
     */
    private String getConfirmPasswordFieldController() {
        return registerView.getConfirmPasswordField();
    }

    /**
     * Funció que es truca quan vols esborrar tota la info introduida als texts
     */
    public void borrarInfoRegister(){
        registerView.setUsernameField("");
        registerView.setEmailField("");
        registerView.setPasswordField("");
        registerView.setConfirmPasswordField("");
    }

    private void nameAlreadyExist() {
        JOptionPane.showMessageDialog(registerView, "El nom introduït ja el teu un altre usuari");
    }
    private void showEmailExist() {
        JOptionPane.showMessageDialog(registerView, "El correu introduït ja esta registrat");
    }
    private void showErrorLengthPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim ha de haver 8 caracters");
    }

    private void showErrorLowerCaseCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim una minuscula");
    }

    private void showErrorUpperCaseCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim una majúscula");
    }

    private void showErrorDigitCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim un numero");
    }

    private void showErrorSpecialCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim 1 caracter especial");
    }

    private void showErrorCreateUser() {
        JOptionPane.showMessageDialog(registerView, "No ha pogut connectar-se a la base de dades");
    }

    private void showDifferentPass() {
        JOptionPane.showMessageDialog(registerView, "Les contrasenyes no coincideixen");
    }

    private void showErrorFillAll() {
        JOptionPane.showMessageDialog(registerView, "Tots els camps son obligatoris");
    }

    private void panelChangeLog() {
        //changeViewController.changePan("login");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("next")) {

            switch (signUpManager.comprovarSignUp(getUsernameFieldController(), getEmailFieldController(), getPasswordFieldController(), getConfirmPasswordFieldController())) {
                case "FillAll" -> showErrorFillAll();
                case "DifferentPass" -> showDifferentPass();
                case "ContrasenyaLalarga" -> showErrorLengthPass();
                case "FaltenCaractersLower" -> showErrorLowerCaseCounterPass();
                case "FaltenCaractersUpper" -> showErrorUpperCaseCounterPass();
                case "FaltenDigits" -> showErrorDigitCounterPass();
                case "FaltenCaractersEspecials" -> showErrorSpecialCounterPass();
                case "UserNoCreat" -> showErrorCreateUser();
                case "totBe" -> {
                    changeViewController.changePan("start");
                    borrarInfoRegister();
                }
                case "JaExisteixEmail" -> showEmailExist();
                case "JaExisteixUserName" -> nameAlreadyExist();
            }


        }else if (e.getActionCommand().equals("login")) {
            changeViewController.changePan("login");
        }
    }
}
