package Persistance.sqlDAO;

import Persistance.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SQLGameDAO {

    /**
     * constructor of the class SQLGameDAO without parameters and does nothing
     */
    public SQLGameDAO() {

    }


    /**
     * method that deletes all data related to the games of the user.
     * @param id the id of the user that will delete the data.
     */
    public void deleteUserGameData(int id){
        String query = "DELETE FROM game WHERE id = "+id+";";
        Connector.getInstance().deleteQuery(query);
    }

    /**
     * method that updates all data related to the games of the user.
     * @param id the id of the user that will delete the data.
     */
    public void upadteUserGameData(int id){
        String query = "UPDATE FROM game WHERE id = "+id+";";
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Busca el numero de partides que portes per generar el ID_G
     * @param userID the id of the user that will delete the data.
     */
    public int getGameCount(int userID) {
        int gameCount = 0;
        String query = "SELECT * FROM game WHERE ID_P = " + userID + ";";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            while(result.next()) {
                gameCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameCount;
    }

    public void startNewGame(int userId) {
        // Establecer los valores iniciales para la nueva partida
        int numGame = getGameCount(userId);
        int N_Coffees = 0;
        int PowerUpClicker = 0;
        String Time = "00:00:00"; // Asume que el tiempo se almacena como una cadena en formato HH:MM:SS
        boolean Ended = false;

        // Crear la consulta SQL para insertar la nueva partida
        String query = "INSERT INTO `game`(`ID_P`, `ID_G`, `N_Coffees`, `PowerUpClicker`, `Time`, `Ended`) VALUES " +
                "(" + userId + ", " + numGame + ", " + N_Coffees + ", " + PowerUpClicker + ", '" + Time + "', " + Ended + ");";

        // Ejecutar la consulta y devolver si se realizó con éxito
        Connector.getInstance().insertQuery(query);
    }

    public int getNCoffees(int id) {
        int nCoffees = 0;
        String query = "SELECT N_Coffees FROM game WHERE ID_P = " + id;
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                nCoffees = result.getInt("N_Coffees");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nCoffees;
    }

    public void setNCoffees(int id, double newNCoffees) {
        String query = "UPDATE game SET N_Coffees = " + newNCoffees + " WHERE ID_P = " + id;
        Connector.getInstance().updateQuery(query);
    }

    public int getPowerUpClicker(int id) {
        int powerUpClicker = 0;
        String query = "SELECT PowerUpClicker FROM game WHERE ID_P = " + id;
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                powerUpClicker = result.getInt("PowerUpClicker");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return powerUpClicker;
    }

    public void setPowerUpClicker(int id, int newPowerUpClicker) {
        String query = "UPDATE game SET PowerUpClicker = " + newPowerUpClicker + " WHERE ID_P = " + id;
        Connector.getInstance().updateQuery(query);
    }

    public void setEnded(int id, boolean newEnded) {
        String query = "UPDATE game SET Ended = " + newEnded + " WHERE ID_P = " + id;
        Connector.getInstance().updateQuery(query);
    }

    public int getCurrentGameId(int connectedUserId) {
        return getGameCount(connectedUserId);
    }

    public boolean comprobarPartidesActives(int userId) {
        String query = "SELECT * FROM game WHERE ID_P = " + userId + " AND Ended = 0";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                return true; // Hay al menos una partida con Ended = 0 para este usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // No hay partidas con Ended = 0 para este usuario
    }

}
