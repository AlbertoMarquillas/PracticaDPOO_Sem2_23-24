package Persistance.sqlDAO;

import Business.Entities.GeneratorFactory;
import Business.Entities.HerenciasGeneradors.Generador1;
import Business.Entities.HerenciasGeneradors.Generador2;
import Business.Entities.HerenciasGeneradors.Generador3;
import Persistance.Connector;
import Business.Entities.Generator;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLGeneratorsDAO{


    public SQLGeneratorsDAO() {
        //setGeneradorsPrincipals();
    }

    // Getter and Setter for Quantitat
    public int getQuantitatGeneradors(int ID_P, int ID_G, String type) {
        String query = "SELECT Quantitat FROM generators WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        ResultSet result = Connector.getInstance().selectQuery(query);
        int quantitat = 0;
        try {
            if (result.next()) {
                quantitat = result.getInt("Quantitat");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quantitat;
    }

    /**
     * Actualiza la cantidad de generadores de un tipo específico en la base de datos.
     *
     * @param quantitat La nueva cantidad de generadores.
     * @param type El tipo de generador a actualizar.
     */
    public void actualitzarQuantitat(int quantitat, int ID_P, int ID_G, String type) {
        String query = "UPDATE generators SET Quantitat = " + quantitat + " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }

    // Getter and Setter for CostActual

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


    public void updateCost(double incrementarPotenciador, String type) {
        String query = "UPDATE generators SET CostActual = "+ incrementarPotenciador + "WHERE Type = '" + type + "';";
        Connector.getInstance().updateQuery(query);
    }

    // Getter and Setter for ProduccioActual
    public int getProduccioActual(String type) {
        String query = "SELECT ProduccioActual FROM generators WHERE Type = '" + type + "'";
        ResultSet result = Connector.getInstance().selectQuery(query);
        int produccioActual = 0;
        try {
            if (result.next()) {
                produccioActual = result.getInt("ProduccioActual");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produccioActual;
    }

    public void setProduccioActual(int produccioActual, String type) {
        String query = "UPDATE generators SET ProduccioActual = " + produccioActual + " WHERE Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }

    // Getter and Setter for ProduccioGlobal
    public int getProduccioGlobal(String type) {
        String query = "SELECT ProduccioGlobal FROM generators WHERE Type = '" + type + "'";
        ResultSet result = Connector.getInstance().selectQuery(query);
        int produccioGlobal = 0;
        try {
            if (result.next()) {
                produccioGlobal = result.getInt("ProduccioGlobal");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produccioGlobal;
    }

    public void setProduccioGlobal(int produccioGlobal, String type) {
        String query = "UPDATE generators SET ProduccioGlobal = " + produccioGlobal + " WHERE Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }

    // Getter and Setter for Num_Millores
    public int getNumMillores(String type) {
        String query = "SELECT Num_Millores FROM generators WHERE Type = '" + type + "'";
        ResultSet result = Connector.getInstance().selectQuery(query);
        int numMillores = 0;
        try {
            if (result.next()) {
                numMillores = result.getInt("Num_Millores");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numMillores;
    }

    public void setNumMillores(int numMillores, String type) {
        String query = "UPDATE generators SET Num_Millores = " + numMillores + " WHERE Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }




    /**
     * FUNCIO QUE SERA SUBSTITUIDA PER LÒGICA EN EL BUSINESS
     */
    public int getCost(String type){
        if (type.equals("A")) {
            return 10;
        } else if (type.equals("B")) {
            return 150;
        } else if (type.equals("C")) {
            return 2000;
        } else {
            return 0;
        }
    }

    public Generator getGenerator(int ID_P, int ID_G, String type) {
        String query = "SELECT * FROM generators WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                Generator generator;
                switch (type) {
                    case "A":
                        generator = new Generador1();
                        break;
                    case "B":
                        generator = new Generador2();
                        break;
                    case "C":
                        generator = new Generador3();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid type: " + type);
                }
                generator.setType(result.getString("Type"));
                generator.setProduccioActual(result.getDouble("ProduccioActual"));
                generator.setIncrement(result.getDouble("ProduccioGlobal"));
                // ... establecer el resto de los campos del generador ...
                return generator;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Devolver null si no se encuentra el generador
    }




    public void initGenerators(int ID_P, int ID_G) {
        String types[] = {"A", "B", "C"};
        int quantitats[] = {1, 1, 0};
        double produccioInicial[] = {0.2,1,15};

        for (int i = 0; i < types.length; i++) {
            String query = "INSERT INTO generators(ID_P, ID_G, Type, Quantitat, CostActual, ProduccioActual, ProduccioGlobal, Num_Millores) VALUES " +
                    "('" + ID_P + "', '" + ID_G + "', '" + types[i] + "', '" + quantitats[i] + "', '" + produccioInicial[i] + "', '" + 0 + "', '" + 0 + "', '" + 0 + "');";

            Connector.getInstance().insertQuery(query);
        }
    }
}