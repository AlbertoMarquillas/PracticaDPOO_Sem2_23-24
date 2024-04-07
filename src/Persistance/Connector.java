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
     * Constructor privado de la clase Connector.
     * @param username Nombre de usuario para la conexión a la base de datos.
     * @param password Contraseña para la conexión a la base de datos.
     * @param ip Dirección IP del servidor de la base de datos.
     * @param port Puerto del servidor de la base de datos.
     * @param database Nombre de la base de datos.
     */
    private Connector(String username, String password, String ip, String port, String database) {
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    }

    /**
     * Lee la configuración de la base de datos desde un archivo JSON.
     * @return Configuración de la base de datos leída desde el archivo JSON.
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
     * Obtiene una instancia única de Connector.
     * @return Instancia única de Connector.
     */
    public static Connector getInstance() {
        if (instance == null) {
            DBConfig config = readConfig();
            instance = new Connector(config.getUser(), config.getPassword(), config.getIp(), config.getPort(), "CoffeeClicker");
            instance.connect();
        }
        System.out.println("url: " + url);
        return instance;
    }

    /**
     * Establece una conexión con la base de datos.
     */
    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ejecuta una consulta de inserción en la base de datos.
     * @param query Consulta SQL de inserción.
     * @return true si la inserción fue exitosa, false en caso contrario.
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
     * Ejecuta una consulta de actualización en la base de datos.
     * @param query Consulta SQL de actualización.
     * @return true si la actualización fue exitosa, false en caso contrario.
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
     * Ejecuta una consulta de eliminación en la base de datos.
     * @param query Consulta SQL de eliminación.
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
     * Ejecuta una consulta de selección en la base de datos.
     * @param query Consulta SQL de selección.
     * @return Resultado de la consulta.
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
