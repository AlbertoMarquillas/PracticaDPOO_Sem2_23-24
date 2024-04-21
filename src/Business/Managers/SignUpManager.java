package Business.Managers;

public class SignUpManager {

    private final UserManager userManager;

    /**
     * Constructor del SignUpManager
     *
     * @param userManager manager de usuarios
     */
    public SignUpManager(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * Getter de l'atribut genre
     *
     * @param username        nom d'usuari
     * @param email           email
     * @param password        contrasenya
     * @param confirmPassword confirmacio de la contrasenya
     * @return String que determina quins errors hi ha hagut
     */
    public String comprovarSignUp(String username, String email, String password, String confirmPassword){

        int uppercaseCounter = 0, lowercaseCounter = 0, digitCounter = 0, specialCounter = 0;


        //Comprovo que estigui tot omplert
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return "FillAll";
            //comprovo que la contrasenya de confirmació estigui ben posada
        } else if (!password.equals(confirmPassword)) {
            return "DifferentPass";
        } else{
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) //compto caractersen majuscules
                    uppercaseCounter++;
                else if (Character.isLowerCase(password.charAt(i))) //compto caracters amb minuscules
                    lowercaseCounter++;
                else if (Character.isDigit(password.charAt(i))) //compto digits
                    digitCounter++;
                if (!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {
                    specialCounter++;
                }
            }
            //miro la llargaria de la contrasenya i tota la resta de requisits
            if (password.length() < 8) {
                return "ContrasenyaLalarga";
            } else if (lowercaseCounter < 1) {
                return "FaltenCaractersLower";
            } else if (uppercaseCounter < 1) {
                return "FaltenCaractersUpper";
            } else if (digitCounter < 1) {
                return "FaltenDigits";
            } else if (specialCounter < 1) {
                return "FaltenCaractersEspecials";
            } else if (userManager.emailExist(email)) {
                return "JaExisteixEmail";
            } else if (userManager.existUser(username)) {
                return "JaExisteixUserName";
            } else if (!userManager.createUser(username, email, password)) { //es guarda a la base de dades
                return "UserNoCreat";
            } else {
                connectedUser(username);
                return "totBe";
            }
        }
    }

    /**
     * Metode que connecta a l'usuari
     * @param name nom d'usuari
     */
    private void connectedUser(String name) {
        userManager.connectedUser(name);
    }

}