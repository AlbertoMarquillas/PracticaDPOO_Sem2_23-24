package Presentation.Controller;

import Business.Managers.SignUpManager;
import Presentation.View.RegisterView;

public class RegisterController {
    private final RegisterView registerView;
    private final SignUpManager signUpManager;

    public RegisterController(RegisterView registerView, SignUpManager signUpManager) {
        this.registerView = registerView;
        this.signUpManager = signUpManager;
    }
    /**private String getUsernameF() {
        return registerView.getUsername();
    }

    private String getEmailF() {
        return registerView.getEmail();
    }

    private String getPasswordF() {
        return registerView.getPassword();
    }

    private String getConfirmPasswordF() {
        return registerView.getConfirmPassword();
    }**/
}
