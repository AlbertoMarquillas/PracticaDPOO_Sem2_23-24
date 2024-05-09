package Persistance;

/**
 * Esta clase representa la configuración de la base de datos.
 */
public class DBConfig {

    private String username;
    private String password;
    private String ip;
    private String port;

    /**
     * Constructor de la classe DBConfig.
     * @param user Nom d'usuari per a la connexió a la base de dades.
     * @param password Contrasenya per a la connexió a la base de dades.
     * @param ip Adreça IP del servidor de la base de dades.
     * @param port Port del servidor de la base de dades.
     */
    public DBConfig(String user, String password, String ip, String port) {
        this.username = user;
        this.password = password;
        this.ip = ip;
        this.port = port;
    }

    /**
     * Obté el nom d'usuari.
     * @return El nom d'usuari.
     */
    public String getUser() {
        return username;
    }

    /**
     * Estableix el nom d'usuari.
     * @param user El nom d'usuari.
     */
    public void setUser(String user) {
        this.username = user;
    }

    /**
     * Obté la contrasenya.
     * @return La contrasenya.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Estableix la contrasenya.
     * @param password La contrasenya.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obté la direcció IP.
     * @return La direcció IP.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Estableix la direcció IP.
     * @param ip La direcció IP.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Obté el port.
     * @return El port.
     */
    public String getPort() {
        return port;
    }

    /**
     * Estableix el port.
     * @param port El port.
     */
    public void setPort(String port) {
        this.port = port;
    }
}
