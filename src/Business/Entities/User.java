package Business.Entities;


/**
 * Classe que representa un usuari
 */
public class User {
    private final int id;
    private final String email;
    private final String username;
    private final String password;
    private boolean connected;
    private boolean partidaActiva;

    /**
     * Constructor of the class User que conté informació sobre un usuari
     *
     * @param id       integer que conté l'identificador de l'usuari
     * @param email    string que conté l'email de l'usuari
     * @param username string del nom d'usuari per identificar-se
     * @param password string de la contrasenya de l'usuari
     */
    public User(int id, String username, String email, String password, boolean connected) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.connected = connected;
        this.partidaActiva = false;
    }

    /**
     * Getter que retorna la contrasenya de l'usuari
     * @return string de la contrasenya de l'usuari
     */
    public String getPassword() {
        return password;
    }


    /**
     * Getter que retorna el nom d'usuari
     * @return string del nom d'usuari
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter per indicar si l'usuari té una partida activa
     * @param partidaActiva boolean que indica si l'usuari té una partida activa
     */
    public void setPartidaActiva(boolean partidaActiva) {
        this.partidaActiva = partidaActiva;
    }
}