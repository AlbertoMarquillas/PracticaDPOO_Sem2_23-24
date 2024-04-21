package Persistance;

/**
 * Esta clase proporciona métodos para la creación de la base de datos y tablas.
 */
public class DataBaseDAO {

    /**
     * Crea la base de datos "CoffeeClicker" si no existe.
     * @return true si la base de datos se creó correctamente, false en caso contrario.
     */
    public boolean createDataBase() {
        String query = "CREATE DATABASE IF NOT EXISTS coffeeclickerdb";
        return Connector.getInstance().insertQuery(query);
    }

    /**
     * Crea las tablas necesarias en la base de datos.
     * @return true si las tablas se crearon correctamente, false en caso contrario.
     */
    public boolean createTables() {
        boolean ok;
            String query = "CREATE TABLE IF NOT EXISTS User " +
                            "(Id INT(11) NOT NULL, " +
                            "UserName VARCHAR(255) NOT NULL, " +
                            "email VARCHAR(255) NOT NULL, " +
                            "password VARCHAR(255) NOT NULL, " +
                            "connected tinyint(1) NOT NULL DEFAULT '0');";
        ok = Connector.getInstance().insertQuery(query);
        return ok;
    }
}
