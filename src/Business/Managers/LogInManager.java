package Business.Managers;

/**
 * Classe per gestionar l'entrada d'usuaris al joc
 */
public class LogInManager {

    private final UserManager userManager;

    /**
     * Constructor de la clase LogInManager
     * @param userManager manager d'usuaris
     */
    public LogInManager(UserManager userManager){
        this.userManager = userManager;
    }

    /**
     * Metodo que comprueba si el usuario existe y si la contraseña es correcta
     * @param username nombre de usuario
     * @param password contraseña
     * @return "FillAll" si no se ha introducido un usuario o una contraseña, "WrongUser" si el usuario no existe, "WrongPass" si la contraseña es incorrecta, "ChangeLog" si el usuario y la contraseña son correctos
     */
    public String comprobarLogIn(String username, String password){

        if (username.isEmpty() || password.isEmpty() ) {
            return "FillAll";
        } else {
            if(userManager.existUser(username)) {
                return "WrongUser";
            }else if (userManager.password(username, password)) {
                return "WrongPass";
            }else {
                connectedUser(username); //Funcio per dir-li a la base de dades que l'usuari d'ha connectat
                return "ChangeLog";
            }
        }


    }

    /**
     * Metodo que activa un usuari, reflecta l'usuari conectat a la base de dades
     * @param name nom d'usuari
     */
    private void connectedUser(String name){
        userManager.connectedUser(name); //hem de poder dir que s'ha connectat l'usuari
    }


}
