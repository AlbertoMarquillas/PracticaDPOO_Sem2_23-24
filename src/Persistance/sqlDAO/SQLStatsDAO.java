package Persistance.sqlDAO;

import Persistance.Connector;

import java.sql.*;


public class SQLStatsDAO {
    public static void setSavedStats(int ID_P, int ID_G, Time counter, double nCoffee) {

        String query = "INSERT INTO stats(ID_P, ID_G, Time, N_Cafe) VALUES " +
                "('" + ID_P + "', '" + (ID_G) + "', '" + counter + "', '" + nCoffee + "');";

        Connector.getInstance().insertQuery(query);
    }

}
