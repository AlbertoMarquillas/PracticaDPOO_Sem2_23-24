package Persistance.sqlDAO;

import Business.Entities.Stats;
import Business.Entities.User;
import Persistance.Connector;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class SQLStatsDAO {
    public static void setSavedStats(int ID_P, int ID_G, Time counter, double nCoffee) {

        String query = "INSERT INTO stats(ID_P, ID_G, Time, N_Cafe) VALUES " +
                "('" + ID_P + "', '" + (ID_G) + "', '" + counter + "', '" + nCoffee + "');";

        Connector.getInstance().insertQuery(query);
    }

    public static List<Stats> getMatchStats(int ID_P, int ID_G) {
        List<Stats> stats = new LinkedList<Stats>();
        String query = "SELECT N_Coffees FROM game WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
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

}
