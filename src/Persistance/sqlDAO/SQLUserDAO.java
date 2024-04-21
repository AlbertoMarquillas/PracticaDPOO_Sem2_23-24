package Persistance.sqlDAO;

import Business.Entities.User;
import Persistance.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class SQLUserDAO{

    /**
     * Receives nothing and does nothing
     */
    public SQLUserDAO() {
    }

    /**
     * function that adds a user into the database
     * @return boolean that indicates if the user has been added correctly
     */

    /*
    public boolean addUser(User user) {
        String name = user.getFullName();
        String query = "INSERT INTO users(UserName, Email, Password) VALUES ('" + name + "', '" + user.getEmail() + "', '" + user.getPassword() + "');";
        return Connector.getInstance().insertQuery(query);
    }
    */


    /**
     * function that returns all the users in the database
     * @return List of the type User that contains all the Users in our database
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
     * function that checks if the user entered while signing in already is registered
     * @return boolean that indicates if it exists or not
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
     * function that checks if the email entered while signing in already is registered
     * @return boolean that indicates if it exists or not
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
     * function that deletes a user from the database, deletes all game information
     * @return boolean that indicates if it has been deleted correctly
     */
    public boolean deleteUser (String name) {
        boolean check;
        String query = "DELETE * FROM user WHERE Connected = 'true';";
        Connector.getInstance().deleteQuery(query);
        return true;
    }

    /**
     * function that checks if the password entered by the user is valid
     * @param password is a string with the entered password by the user
     * @return boolean that indicates if the password introduced by the user is valid (follows the format in the statement)
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

    public boolean createUser(String name, String email, String password) {
        // Obtener el siguiente ID disponible para el nuevo usuario
        int id = getAllUsers().size() + 1;
        // El usuario no está conectado cuando se crea
        boolean connected = true;

        String query = "INSERT INTO user(id, UserName, Email, Password, Connected) VALUES " +
                "('" + id + "', '" + name + "', '" + email + "', '" + password + "', 1);";

    return Connector.getInstance().insertQuery(query);
}

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

    public void connectedUser(String name) {
        String query = "UPDATE user SET Connected = 1 WHERE User.UserName = '" + name + "';";
        Connector.getInstance().updateQuery(query);
    }

    public void disconnectUser(String name) {
        String query = "UPDATE user SET Connected = 0 WHERE User.UserName = '" + name + "';";
        Connector.getInstance().updateQuery(query);
    }

    public boolean checkPasswordMail(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE User.Email = '" + username + "' AND User.Password = '" + password + "';";
            ResultSet result = Connector.getInstance().selectQuery(query);
            return result.next();
        } catch (SQLException e) {
            return false;
        }
    }
}