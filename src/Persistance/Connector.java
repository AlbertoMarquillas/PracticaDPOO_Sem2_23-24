package Persistance;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

/**
 * Esta clase proporciona una conexión a la base de datos y métodos para ejecutar consultas SQL.
 */
public class Connector {

    private static Connector instance = null;

    private final String username;

    private final String password;

    private static String url;

    private Connection connection;

    /**
     * Constructor privat de la classe Connector.
     * @param username Nom d'usuari per a la connexió a la base de dades.
     * @param password Contrasenya per a la connexió a la base de dades.
     * @param ip Adreça IP del servidor de la base de dades.
     * @param port Port del servidor de la base de dades.
     * @param database Nom de la base de dades.
     */
    private Connector(String username, String password, String ip, String port, String database) {
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    }

    /**
     * Llegeix la configuració de la base de dades des d'un fitxer JSON.
     * @return Configuració de la base de dades llegida des del fitxer JSON.
     */
    private static DBConfig readConfig() {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader("file/config.json"));
            DBConfig config = gson.fromJson(reader, DBConfig.class);
            return config;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo de configuración");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obté una instància única de Connector.
     * @return Instància única de Connector.
     */
    public static Connector getInstance() {
        if (instance == null) {
            DBConfig config = readConfig();
            instance = new Connector(config.getUser(), config.getPassword(), config.getIp(), config.getPort(), "coffeeclickerdb");
            instance.connect();
        }
        //System.out.println("url: " + url);
        return instance;
    }

    /**
     * Estableix una connexió amb la base de dades.
     */
    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executa una consulta d'inserció a la base de dades.
     * @param query Consulta SQL d'inserció.
     * @return true si la inserció ha estat exitosa, false en cas contrari.
     */
    public boolean insertQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Executa una consulta d'actualització a la base de dades.
     * @param query Consulta SQL d'actualització.
     * @return true si l'actualització ha estat exitosa, false en cas contrari.
     */
    public boolean updateQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Executa una consulta d'eliminació a la base de dades.
     * @param query Consulta SQL d'eliminació.
     */
    public void deleteQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executa una consulta de selecció a la base de dades.
     * @param query Consulta SQL de selecció.
     * @return Resultat de la consulta.
     */
    public ResultSet selectQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
