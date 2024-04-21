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
     * Constructor de la clase DBConfig.
     * @param user Nombre de usuario para la conexión a la base de datos.
     * @param password Contraseña para la conexión a la base de datos.
     * @param ip Dirección IP del servidor de la base de datos.
     * @param port Puerto del servidor de la base de datos.
     */
    public DBConfig(String user, String password, String ip, String port) {
        this.username = user;
        this.password = password;
        this.ip = ip;
        this.port = port;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getUser() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     * @param user El nombre de usuario.
     */
    public void setUser(String user) {
        this.username = user;
    }

    /**
     * Obtiene la contraseña.
     * @return La contraseña.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña.
     * @param password La contraseña.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la dirección IP.
     * @return La dirección IP.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Establece la dirección IP.
     * @param ip La dirección IP.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Obtiene el puerto.
     * @return El puerto.
     */
    public String getPort() {
        return port;
    }

    /**
     * Establece el puerto.
     * @param port El puerto.
     */
    public void setPort(String port) {
        this.port = port;
    }
}
