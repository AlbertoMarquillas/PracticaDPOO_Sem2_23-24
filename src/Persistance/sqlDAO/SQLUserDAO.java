package Persistance.sqlDAO;

import Business.Entities.User;
import Persistance.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class SQLUserDAO{

    /**
     * Constructor de la clase SQLUserDAO
     */
    public SQLUserDAO() {
    }


    /**
     * Funció que retorna tots els usuaris de la base de dades.
     * @return Llista del tipus User que conté tots els usuaris de la nostra base de dades.
     */
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<>();
        String query = "SELECT User.id, User.UserName, User.Email, User.Password, User.Connected FROM user;";
        ResultSet result = Connector.getInstance().selectQuery(query);

        try {
            while(result.next()) {
                int id = result.getInt("id");
                String username = result.getString("UserName");
                String email = result.getString("Email");
                String password = result.getString("Password");
                boolean connected = result.getBoolean("Connected");
                users.add(new User(id, username, email, password, connected));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    
    /**
     * Obté l'ID de l'usuari connectat.
     *
     * @return L'ID de l'usuari connectat, o -1 si no hi ha cap usuari connectat.
     */
    public int getConnectedUserId() {
        try {
            String query = "SELECT id FROM user WHERE Connected = 1;";
            ResultSet result = Connector.getInstance().selectQuery(query);
            if (result.next()) {
                int id = result.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no hay ningún usuario conectado
    }

    /**
     * Comprova si l'usuari existeix a la base de dades.
     *
     * @param user El nom d'usuari a comprovar.
     * @return Cert si l'usuari existeix; fals en cas contrari o si hi ha algun error de connexió.
     */
    public boolean userExist(String user) {
        try {
            String query = "SELECT * FROM user WHERE User.UserName = '" + user + "';";
            ResultSet result = Connector.getInstance().selectQuery(query);
            return result.next();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Comprova si l'email existeix a la base de dades.
     *
     * @param email L'email a comprovar.
     * @return Cert si l'email existeix; fals en cas contrari o si hi ha algun error de connexió.
     */
    public boolean emailExist(String email) {
        try {
            String query = "SELECT * FROM user WHERE User.Email = '" + email + "';";
            ResultSet result = Connector.getInstance().selectQuery(query);
            return result.next();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Esborra un usuari de la base de dades segons el nom d'usuari proporcionat.
     *
     * @param name El nom d'usuari de l'usuari a esborrar.
     * @return Cert si l'usuari s'ha esborrat amb èxit; fals en cas contrari o si hi ha algún error.
     */
    public boolean deleteUser (String name) {
        boolean check;
        String query = "DELETE FROM user WHERE User.username LIKE '" + name + "'";
        Connector.getInstance().deleteQuery(query);
        return true;
    }

    /**
     * Comprova si la contrasenya correspon al nom d'usuari especificat.
     *
     * @param userName El nom d'usuari de l'usuari.
     * @param password La contrasenya a comprovar.
     * @return Cert si la contrasenya correspon al nom d'usuari; fals en cas contrari o si hi ha algun error de connexió.
     */
    public boolean checkPassword(String userName, String password) {
        try {
            String query = "SELECT * FROM user WHERE User.UserName = '" + userName + "' AND User.Password = '" + password + "';";
            ResultSet result = Connector.getInstance().selectQuery(query);
            return result.next();
        } catch (SQLException e) {
            return false;
        }
    }


    /**
     * Crea un nou usuari a la base de dades amb les dades proporcionades.
     *
     * @param name El nom de l'usuari.
     * @param email El correu electrònic de l'usuari.
     * @param password La contrasenya de l'usuari.
     * @return Cert si l'usuari s'ha creat amb èxit; fals en cas contrari o si hi ha algún error.
     */
    public boolean createUser(String name, String email, String password) {
        // Obtener el siguiente ID disponible para el nuevo usuario
        int id = getAllUsers().size() + 1;
        // El usuario no está conectado cuando se crea
        boolean connected = true;

        String query = "INSERT INTO user(id, UserName, Email, Password, Connected) VALUES " +
                "('" + id + "', '" + name + "', '" + email + "', '" + password + "', 1);";

        return Connector.getInstance().insertQuery(query);
    }


    /**
     * Obté l'usuari connectat des de la base de dades.
     *
     * @return L'usuari connectat, o null si cap usuari està connectat o hi ha algún error.
     */
    public User getUserConnected() {
        try {
            String query = "SELECT * FROM user WHERE User.Connected = 1;";
            ResultSet result = Connector.getInstance().selectQuery(query);
            if (result.next()) {
                int id = result.getInt("id");
                String userName = result.getString("UserName");
                String email = result.getString("Email");
                String password = result.getString("Password");
                boolean connected = result.getBoolean("Connected");
                return new User(id, userName, email, password, connected);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Connecta l'usuari especificat.
     *
     * @param name El nom de l'usuari a connectar.
     */
    public void connectedUser(String name) {
        String query = "UPDATE user SET Connected = 1 WHERE User.UserName = '" + name + "';";
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Desconnecta l'usuari especificat.
     *
     * @param name El nom de l'usuari a desconnectar.
     */
    public void disconnectUser(String name) {
        String query = "UPDATE user SET Connected = 0 WHERE User.UserName = '" + name + "';";
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Comprova si la contrasenya correspon al correu electrònic especificat.
     *
     * @param username El correu electrònic de l'usuari.
     * @param password La contrasenya a comprovar.
     * @return Cert si la contrasenya correspon al correu electrònic; fals en cas contrari o si hi ha algun error de connexió.
     */
    public boolean checkPasswordMail(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE User.Email = '" + username + "' AND User.Password = '" + password + "';";
            ResultSet result = Connector.getInstance().selectQuery(query);
            return result.next();
        } catch (SQLException e) {
            return false;
        }
    }


    /**
     * Obté l'ID de l'usuari a partir del seu nom d'usuari.
     *
     * @param userName El nom d'usuari de l'usuari.
     * @return L'ID de l'usuari corresponent al nom d'usuari proporcionat, o -1 si no es troba cap usuari amb el nom d'usuari donat.
     */
    public int getUserID(String userName) {
        try {
            String query = "SELECT id FROM user WHERE UserName = '" + userName + "'";
            ResultSet result = Connector.getInstance().selectQuery(query);
            if (result.next()) {
                return result.getInt("id");
            } else {
                // Handle the case where no user with the given username is found
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Desconnecta tots els usuaris, establint el seu estat de connexió a 0.
     */
    public void setAllUsersOff() {
        String query = "UPDATE user SET Connected = 0";
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Comprova si un identificador d'usuari existeix a la base de dades.
     *
     * @param idP  l'ID de l'usuari a comprovar.
     * @return true si l'ID d'usuari existeix; false altrament.
     */
    public boolean userIdExist(int idP) {
        try {
            String query = "SELECT * FROM user WHERE id = " + idP;
            ResultSet result = Connector.getInstance().selectQuery(query);
            return result.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Obté el valor màxim de l'identificador d'usuari a partir de la base de dades.
     *
     * @return el valor màxim de l'identificador d'usuari; -1 si no es troba cap valor.
     */
    public int getMaxUserId() {
        try {
            String query = "SELECT MAX(id) AS max_id FROM user";
            ResultSet result = Connector.getInstance().selectQuery(query);
            if (result.next()) {
                return result.getInt("max_id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Obté el nom d'usuari connectat a partir de l'ID d'usuari especificat.
     *
     * @param idP  l'ID de l'usuari.
     * @return el nom d'usuari connectat; null si no es troba cap resultat.
     */
    public String getUserNameConnected(int idP) {
        try {
            String query = "SELECT UserName FROM user WHERE id = " + idP;
            ResultSet result = Connector.getInstance().selectQuery(query);
            if (result.next()) {
                return result.getString("UserName");
            } else {
                return null; // Devuelve null si no se encuentra ningún resultado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}