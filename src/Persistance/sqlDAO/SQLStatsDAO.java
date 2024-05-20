package Persistance.sqlDAO;

import Business.Entities.Stats;
import Business.Entities.User;
import Persistance.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SQLStatsDAO {

    /**
     * Estableix les estadístiques guardades associades a un projecte i un generador i les insereix a la base de dades.
     *
     * @param ID_P      l'ID del projecte associat a les estadístiques guardades.
     * @param ID_G      l'ID del generador associat a les estadístiques guardades.
     * @param counter   l'objecte Time que representa el temps.
     * @param nCoffee   el nombre de cafès.
     */
    public static void setSavedStats(int ID_P, int ID_G, Time counter, double nCoffee) {
        String query = "INSERT INTO stats(ID_P, ID_G, Time, N_Cafe) VALUES " +
                "('" + ID_P + "', '" + (ID_G) + "', '" + counter + "', '" + nCoffee + "');";

        Connector.getInstance().insertQuery(query);
    }


    /**
     * Obté les estadístiques d'una partida associades a un projecte i un generador des de la base de dades.
     *
     * @param ID_P  l'ID del projecte associat a les estadístiques de la partida.
     * @param ID_G  l'ID del generador associat a les estadístiques de la partida.
     * @return una llista d'objectes Stats que conté les estadístiques de la partida.
     */
    public static ArrayList<Stats> getMatchStats(int ID_P, int ID_G) {
        ArrayList<Stats> stats = new ArrayList<>();
        String query = "SELECT Time, N_Cafe FROM stats WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
        ResultSet result = Connector.getInstance().selectQuery(query);

        try {
            while(result.next()) {

                Time time = result.getTime("Time");
                double nCoffee = result.getDouble("N_Cafe");

                stats.add(new Stats(time, nCoffee));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }


    /**
     * Comprova si un jugador té partides registrades a partir de l'ID del projecte.
     *
     * @param ID_P  l'ID del projecte associat al jugador.
     * @return true si el jugador té partides registrades; false altrament.
     */
    public boolean playerHasGames(int ID_P) {
        String query = "SELECT 1 FROM game WHERE ID_P = " + ID_P + " AND Ended = 1";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
