package Presentation.Controller;

import Business.Managers.SignUpManager;

import Presentation.View.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Classe que gestiona les accions de la vista de registre de l'aplicació.
 */
public class RegisterController implements ActionListener {
    private final RegisterView registerView;
    private final SignUpManager signUpManager;
    public final ChangeViewController changeViewController;

    /**
     * Constructor del controller del registre
     *
     * @param registerView         La vista del registre
     * @param signUpManager        El manager del registre
     * @param changeViewController El controlador del canvi de vistes
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


    /**
     * Mostra un missatge indicant que el nom introduït ja està sent utilitzat per un altre usuari.
     */
    private void nameAlreadyExist() {
        JOptionPane.showMessageDialog(registerView, "El nom introduït ja el teu un altre usuari");
    }

    /**
     * Mostra un missatge indicant que el correu introduït ja està sent utilitzat per un altre usuari.
     */
    private void showEmailExist() {
        JOptionPane.showMessageDialog(registerView, "El correu introduït ja esta registrat");
    }

    /**
     * Mostra un missatge indicant que la contrasenya ha de tenir com a mínim 8 caràcters.
     */
    private void showErrorLengthPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim ha de haver 8 caracters");
    }


    /**
     * Mostra un missatge indicant que la contrasenya ha de tenir com a mínim una lletra minúscula.
     */
    private void showErrorLowerCaseCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim una minuscula");
    }

    /**
     * Mostra un missatge indicant que la contrasenya ha de tenir com a mínim una lletra majusula.
     */
    private void showErrorUpperCaseCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim una majúscula");
    }


    /**
     * Mostra un missatge indicant que la contrasenya ha de tenir com a mínim un número.
     */
    private void showErrorDigitCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim un numero");
    }

    /**
     * Mostra un missatge indicant que la contrasenya ha de tenir com a mínim un caràcter especial.
     */
    private void showErrorSpecialCounterPass() {
        JOptionPane.showMessageDialog(registerView, "Com a minim 1 caracter especial");
    }


    /**
     * Mostra un missatge indicant que no ha sigut possible connectar-se a la base de dades
     */
    private void showErrorCreateUser() {
        JOptionPane.showMessageDialog(registerView, "No ha pogut connectar-se a la base de dades");
    }


    /**
     * Mostra un missatge indicant que les contrasenyes no coincideixen.
     */
    private void showDifferentPass() {
        JOptionPane.showMessageDialog(registerView, "Les contrasenyes no coincideixen");
    }


    /**
     * Mostra un missatge indicant que tots els camps són obligatoris.
     */
    private void showErrorFillAll() {
        JOptionPane.showMessageDialog(registerView, "Tots els camps son obligatoris");
    }


    /**
     * Gestiona les accions de l'usuari en resposta a esdeveniments d'acció.
     *
     * @param e El esdeveniment d'acció que ha tingut lloc.
     */
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
                    //AQUI
                    changeViewController.changePan("start");
                    borrarInfoRegister();
                }
                case "JaExisteixEmail" -> showEmailExist();
                case "JaExisteixUserName" -> nameAlreadyExist();
            }

        } else if (e.getActionCommand().equals("login")) {
            changeViewController.changePan("login");
        }
    }
}
