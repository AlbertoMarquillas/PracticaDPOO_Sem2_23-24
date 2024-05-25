package Business.Managers;

import Business.Entities.User;
import Persistance.sqlDAO.SQLUserDAO;


/**
 * Classe que gestiona les operacions relacionades amb els usuaris, com ara crear un usuari, comprovar si existeix un usuari, comprovar si l'email existeix, comprovar si la contrasenya es correcte, etc.
 */
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
     * Metode que crida al metode deleteUser de la classe SQLUserDAO per eliminar l'usuari
     */
    public void deleteConnectedUser(String name){
        userDAO.deleteUser(name);
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

    /**
     * Mètode que crida al mètode disconnectedUser per poder indicar a la base de dades que l'usuari s'ha desconectat
     * @param name nom de l'usuari
     */
    public void disconnectedUser(String name) {
        userDAO.disconnectUser(name);
    }


    /**
     * Retorna el nom de l'usuari connectat actualment.
     *
     * @return el nom de l'usuari connectat.
     */
    public String getNameUserConnected() {
        User userConnected = userDAO.getUserConnected();
        return userConnected.getUsername();
    }

    /**
     * Comprova si el correu electrònic i la contrasenya coincideixen.
     *
     * @param username el nom d'usuari.
     * @param password la contrasenya.
     * @return true si el correu electrònic i la contrasenya coincideixen, false altrament.
     */
    public boolean mailPass(String username, String password) {
        return userDAO.checkPasswordMail(username, password);
    }

    /**
     * Estableix que l'usuari té una partida activa.
     */
    public void setPartidaActiva() {
        User user = userDAO.getUserConnected();
        user.setPartidaActiva(true);
    }

    /**
     * Estableix tots els usuaris connectats com a no actius.
     */
    public void setAllConnectedsOff() {
        userDAO.setAllUsersOff();
    }

    /**
     * Obté el nom de l'usuari connectat.
     * @param ID_P l'identificador de l'usuari.
     * @return el nom de l'usuari connectat.
     */
    public String getUserName(int ID_P) {
        return userDAO.getUserNameConnected(ID_P);
    }
}
