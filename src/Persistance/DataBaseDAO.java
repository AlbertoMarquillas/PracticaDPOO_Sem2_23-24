package Persistance;

/**
 * Esta clase proporciona métodos para la creación de la base de datos y tablas.
 */
public class DataBaseDAO {

    /**
     * Crea la base de dades "CoffeeClicker" si no existeix.
     */
    public void createDataBase() {
        String query = "CREATE DATABASE IF NOT EXISTS coffeeclickerdb";
        Connector.getInstance().insertQuery(query);
    }

    /**
     * Crea les taules necessàries a la base de dades.
     */
    public void createTables() {


        String query = "CREATE TABLE IF NOT EXISTS User " +
                        "(Id INT(11) NOT NULL, " +
                        "UserName VARCHAR(255) NOT NULL, " +
                        "email VARCHAR(255) NOT NULL, " +
                        "password VARCHAR(255) NOT NULL, " +
                        "connected tinyint(1) NOT NULL DEFAULT '0');";
        Connector.getInstance().insertQuery(query);

        query = "CREATE TABLE IF NOT EXISTS generators " +
                "(ID_P INT(11) NOT NULL, " +
                "ID_G INT(11) NOT NULL, " +
                "Type VARCHAR(255) NOT NULL, " +
                "ProduccioBase FLOAT(11) NOT NULL, " +
                "Quantitat INT(11) NOT NULL, " +
                "CostBase INT(11) NOT NULL, " +
                "CostActual INT(11) NOT NULL, " +
                "ProduccioActual FLOAT(11) NOT NULL, " +
                "ProduccioGlobal FLOAT(11) NOT NULL);";
        Connector.getInstance().insertQuery(query);

        query = "CREATE TABLE IF NOT EXISTS millores " +
                "(ID_P INT(11) NOT NULL, " +
                "ID_G INT(11) NOT NULL, " +
                "Type VARCHAR(255) NOT NULL, " +
                "Quantitat INT(11) NOT NULL, " +
                "CostBase int(11) NOT NULL);";
        Connector.getInstance().insertQuery(query);

        query = "CREATE TABLE IF NOT EXISTS game " +
                "(ID_P INT(11) NOT NULL, " +
                "ID_G INT(11) NOT NULL, " +
                "N_Coffees FLOAT(11) NOT NULL," +
                "PowerUpClicker INT(11) NOT NULL, " +
                "Time timestamp NOT NULL, " +
                "Connected tinyint(1) NOT NULL DEFAULT '0');";
        Connector.getInstance().insertQuery(query);
    }

}
