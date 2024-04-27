package Persistance.sqlDAO;

import Persistance.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLGeneratorsDAO{

    public SQLGeneratorsDAO() {
        //setGeneradorsPrincipals();
    }
    private void setGeneradorsPrincipals() {
        String query = "INSERT INTO generators(id_p, id_g, Type, Quantitat, CostBase) VALUES " +
                "('" + 1 + "', '" + 1 + "', '" + "A" + "', '" + 0 + "', " + 10 + ");";

        Connector.getInstance().insertQuery(query);

        query = "INSERT INTO generators(id_p, id_g, Type, Quantitat, CostBase) VALUES " +
                "('" + 2 + "', '" + 2 + "', '" + "B" + "', '" + 0 + "', " + 150 + ");";

        Connector.getInstance().insertQuery(query);

        query = "INSERT INTO generators(id_p, id_g, Type, Quantitat, CostBase) VALUES " +
                "('" + 3 + "', '" + 3 + "', '" + "C" + "', '" + 0 + "', " + 2000 + ");";

        Connector.getInstance().insertQuery(query);
    }

    public int getQuantitatGeneradors(String type) {
        try {
            String query = "SELECT Quantitat FROM generators WHERE Type = '"+type+"'";

            ResultSet result = Connector.getInstance().selectQuery(query);
            int quantitat = 0;
            if (result.next()) { // Move the cursor to the first row
                quantitat = result.getInt("Quantitat");
            } else {
                // Handle the case where no data is found
            }
            return quantitat;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualitzarQuantitat(int i, String type) {
        String query = "UPDATE generators SET Quantitat = " + i + " WHERE Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }

    public int getCost(String type) {
        try {
            String query = "SELECT CostBase AS Cost FROM generators WHERE Type = '"+ type +"'";
            ResultSet result = Connector.getInstance().selectQuery(query);
            int cost = 0;
            if (result.next()) { // Move the cursor to the first row
                cost = result.getInt("Cost");
            } else {
                // Handle the case where no data is found
            }
            return cost;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCost(double incrementarPotenciador, String type) {
        String query = "UPDATE generators SET CostActual = "+ incrementarPotenciador + "WHERE Type = '" + type + "';";
        Connector.getInstance().updateQuery(query);
    }

    public int getCostActual(String type) {
        try {
            String query = "SELECT CostActual AS Cost FROM generators WHERE Type = '"+ type + "'";
            ResultSet result = Connector.getInstance().selectQuery(query);
            int cost = 0;
            if (result.next()) { // Move the cursor to the first row
                cost = result.getInt("Cost");
            } else {
                // Handle the case where no data is found
            }
            return cost;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}