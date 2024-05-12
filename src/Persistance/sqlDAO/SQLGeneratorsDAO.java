package Persistance.sqlDAO;


import Persistance.Connector;
import Business.Entities.Generator;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLGeneratorsDAO{


    /**
     * Constructor de la clase SQLGeneratorsDAO
     */
    public SQLGeneratorsDAO() {
        //setGeneradorsPrincipals();
    }

    /**
     * Obté la quantitat de generadors de tipus especificat per a l'usuari i joc indicats.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del joc.
     * @param type El tipus de generador.
     * @return La quantitat de generadors del tipus especificat per a l'usuari i joc indicats.
     */
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
     * @param type El tipus de generador a actualizar.
     */
    public void actualitzarQuantitat(int quantitat, int ID_P, int ID_G, String type) {
        String query = "UPDATE generators SET Quantitat = " + quantitat + " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }

    /**
     * Obté el cost actual del generador del tipus especificat per a l'usuari i joc indicats.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del joc.
     * @param type El tipus de generador.
     * @return El cost actual del generador del tipus especificat per a l'usuari i joc indicats, o 0 si no es troba cap dada.
     */
    public double getCostActual(int ID_P, int ID_G, String type) {
        try {
            String query = "SELECT CostActual AS Cost FROM generators WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '"+ type + "'";
            ResultSet result = Connector.getInstance().selectQuery(query);
            double cost = 0;
            if (result.next()) { // Move the cursor to the first row
                cost = result.getDouble("Cost");
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

    /**
     * Obté la producció actual del tipus de generador especificat.
     *
     * @param type El tipus de generador.
     * @return La producció actual del generador del tipus especificat, o 0 si no es troba cap dada.
     */
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

    public void setProduccioActual(double produccioActual, String type) {
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


    /**
     * Obté el generador de l'usuari i joc especificats del tipus indicat.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del joc.
     * @param type El tipus de generador.
     * @return El generador corresponent a l'usuari, joc i tipus indicats, o null si no es troba cap generador.
     */
    public Generator getGenerator(int ID_P, int ID_G, String type) {
    String query = "SELECT * FROM generators WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
    ResultSet result = Connector.getInstance().selectQuery(query);
    try {
        if (result.next()) {
            Generator generator = new Generator(
                result.getString("Type"),
                result.getInt("Quantitat"),
                result.getDouble("ProduccioActual"),
                result.getDouble("ProduccioGlobal"),
                result.getInt("Num_Millores")
            );
            return generator;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Devolver null si no se encuentra el generador
}




    public void initGenerators(int ID_P, int ID_G) {
        String types[] = {"A", "B", "C"};
        int quantitats[] = {0, 0, 0};       //AIXO HO FEM MANUALMENT
        int costBase[] = {10, 150, 2000};
        double produccioInicial[] = {0.2,1,15};


        for (int i = 0; i < types.length; i++) {
            String query = "INSERT INTO generators(ID_P, ID_G, Type, Quantitat, CostActual, ProduccioActual, ProduccioGlobal, Num_Millores) VALUES " +
                    "('" + ID_P + "', '" + (ID_G - 1) + "', '" + types[i] + "', '" + quantitats[i] + "', '" + costBase[i] + "', '" + produccioInicial[i] + "', '" + 0 + "', '" + 0 + "');";

            Connector.getInstance().insertQuery(query);
        }
    }

    public void buyGenerator(int ID_P, int ID_G, String type, Generator generator) {
        generator.buyGenerator();
        String query = "UPDATE generators SET Quantitat = " + generator.getQuantitat() + ", " +
                "CostActual = " + generator.getCostActualString() + ", " +
                "ProduccioActual = " + generator.getProduccioActual() + ", " +
                "ProduccioGlobal = " + generator.getProduccioGlobalString() + ", " +
                "Num_Millores = " + generator.getNumMilloresString() +
                " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }

    public void updateCaffeeGenerators(int connectedUserId, int currentGameId, Generator generator) {
        String type = generator.getTypeString();
        String query = "UPDATE generators SET Quantitat = " + generator.getQuantitat() + ", " +
                "CostActual = " + generator.getCostActualString() + ", " +
                "ProduccioActual = " + generator.getProduccioActual() + ", " +
                "ProduccioGlobal = " + generator.getProduccioGlobalString() + ", " +
                "Num_Millores = " + generator.getNumMilloresString() +
                " WHERE ID_P = " + connectedUserId + " AND ID_G = " + currentGameId + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }
}