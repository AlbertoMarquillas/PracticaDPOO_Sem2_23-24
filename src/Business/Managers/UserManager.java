package Business.Managers;

import Business.Entities.User;
import Persistance.sqlDAO.SQLUserDAO;

public class UserManager {

    private final SQLUserDAO userDAO;

    /**
     * Constructor de la classe UserManager
     *
     * @param userDAO     classe SQLUserDAO
     */
    public UserManager(SQLUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Mètode que s'encarrega de cridar al mètode createUser de la classe SQLUserDAO per crear un usaru
     * @param name nom de l'usuari
     * @param email email de l'usuari
     * @param password contrasenya de l'usuari
     * @return true si s'ha creat correctament l'usuari
     */

    public boolean createUser(String name, String email, String password) {
        return userDAO.createUser(name, email, password);
    }

    /**
     * Metode que comprova quines dades estan malament introduides i demana les que falten
     * @param username nom de l'usuari
     * @param password contrasenya de l'usuari
     * @return retorna un string que indica si s'ha de fer un canvi de pantalla o no
     */
    public String comprovarDades(String username, String password){
        if (username.isEmpty() || password.isEmpty() ) {
            return "FillAll";
        } else {
            if(existUser(username)) {
                return "WrongUser";
            }else if (password(username, password)) {
                return "WrongPass";
            }else {
                return "ChangeLog";
            }
        }}

    /**
     * Metode que crida al metode deleteUser de la classe SQLUserDAO per eliminar l'usuari
     */
    public void deleteConnectedUser(String name){
        userDAO.deleteUser(name);
    }

    /**
     * Funció que comprova si es la mateixa contrasenya i elimina el user si ho es
     * @param password contrasenya introduida
     * @return true si s'ha eliminat l'usuari, false si no
     */
    public boolean confirmPassword(String password){
        if(samePassword(password)){
            //deleteConnectedUser();
            return true;
        }
        return false;
    }

    /**
     * Mètode que crida al metode emailExist de la classe UserDAO per saber si existeix l'email
     * @param email email de l'usuari
     * @return true si l'email existeix, false si no
     */
    public boolean emailExist(String email){
        return userDAO.emailExist(email);
    }

    /**
     * Mètode que crida al metode existUser de la classe UserDAO per saber si l'usuari existeix
     * @param name nom de l'usuari
     * @return true si l'usuari existeix, false si no
     */
    public boolean existUser(String name){
        return userDAO.userExist(name);
    }

    /**
     * Mètode que crida al metode correctPassword de la classe UserDAO
     * Comprova si la contrasenya introduida es correcte
     * @param username nom de l'usuari
     * @param password contrasenya de l'usuari
     * @return true si la contrasenya es correcte, false si no
     */
    public boolean password(String username, String password){
        //Comprobes si existeix un usuari amb aquesta contrasenya, si no existeix retorna false
        return userDAO.checkPassword(username, password);
    } //necessito saber la contrasenya si correspon al nom d'usuari

    /**
     * Mètode que crida al mètode activeUser per poder indicar a la base de dades que l'usuari s'ha conectat
     * @param name nom de l'usuari
     */
    public void connectedUser(String name){
        userDAO.connectedUser(name);
    }

    public void disconnectedUser(String name) {
        userDAO.disconnectUser(name);
    }

    /**
     * Mètode per saber si es la mateixa contrasenya
     */
    public boolean samePassword(String password){
        return getPasswordUserConnected().equals(password);
    }

    /**
     * Mètode que recupera la contrasenya dels usuaris conectats
     */
    public String getPasswordUserConnected() {
        User userConnected = userDAO.getUserConnected();
        return userConnected.getPassword();
    }
    public String getNameUserConnected() {
        User userConnected = userDAO.getUserConnected();
        return userConnected.getUsername();
    }

    public boolean mailPass(String username, String password) {
        return userDAO.checkPasswordMail(username, password);
    }

    public void setPartidaActiva() {
        User user = userDAO.getUserConnected();
        user.setPartidaActiva(true);
    }



    /*public boolean comprobarPartidesActives() {
        User user = userDAO.partidaActiva();
        if (user.isPartidaActiva()) {
            return true;
        }else {
            return false;
        }
    }*/

}
