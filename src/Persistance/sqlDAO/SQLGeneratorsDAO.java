package Persistance.sqlDAO;


import Persistance.Connector;
import Business.Entities.Generator;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe que gestiona les operacions relacionades amb els generadors a la base de dades SQL.
 */
public class SQLGeneratorsDAO{


    /**
     * Constructor de la clase SQLGeneratorsDAO
     */
    public SQLGeneratorsDAO() {

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


    /**
     * Inicialitza els generadors amb els valors especificats i els insereix a la base de dades.
     *
     * @param ID_P  l'ID del projecte al qual estan associats els generadors.
     * @param ID_G  l'ID del generador.
     */
    public void initGenerators(int ID_P, int ID_G) {
        String types[] = {"A", "B", "C"};
        int quantitats[] = {0, 0, 0};       //AIXO HO FEM MANUALMENT
        int costBase[] = {10, 150, 2000};
        double produccioInicial[] = {0.2,1,15};


        for (int i = 0; i < types.length; i++) {
            String query = "INSERT INTO generators(ID_P, ID_G, Type, Quantitat, CostActual, ProduccioActual, ProduccioGlobal, Num_Millores) VALUES " +
                    "('" + ID_P + "', '" + (ID_G - 1) + "', '" + types[i] + "', '" + quantitats[i] + "', '" + costBase[i] + "', '" + produccioInicial[i] + "', '" + 0 + "', '" + 0.0 + "');";

            Connector.getInstance().insertQuery(query);
        }
    }


    /**
     * Compra un generador específic i actualitza la informació a la base de dades.
     *
     * @param ID_P      l'ID del projecte al qual està associat el generador.
     * @param ID_G      l'ID del generador.
     * @param type      el tipus del generador a comprar.
     * @param generator l'objecte Generador que representa el generador a comprar.
     */
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


    /**
     * Actualitza la producció dels generadors de cafè i actualitza la informació a la base de dades.
     *
     * @param connectedUserId  l'ID de l'usuari connectat.
     * @param currentGameId    l'ID del joc actual.
     * @param generator        l'objecte Generador que representa el generador de cafè a actualitzar.
     */
    public void updateCaffeeGenerators(int connectedUserId, int currentGameId, Generator generator) {
        String type = generator.getTypeString();
        String query = "UPDATE generators SET ProduccioActual = " + generator.getProduccioActual() + ", "+ " ProduccioGlobal = " + generator.getProduccioGlobal() +
                " WHERE ID_P = " + connectedUserId + " AND ID_G = " + currentGameId + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Actualitza el nombre de millores i la producció actual d'un generador i actualitza la informació a la base de dades.
     *
     * @param ID_P      l'ID del projecte al qual està associat el generador.
     * @param ID_G      l'ID del generador.
     * @param generator l'objecte Generador que representa el generador a actualitzar.
     */
    public void updateMilloresAndProduccioActual(int ID_P, int ID_G, Generator generator) {
        int numMillores = generator.getNumeroMillores();
        double produccioActual = generator.getProduccioActual();
        String type = generator.getTypeString();

        //Actualitzar el nombre de millores
        String queryMillores = "UPDATE generators SET Num_Millores = " + numMillores + " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(queryMillores);

        //Actualitzar la producció actual
        String queryProduccioActual = "UPDATE generators SET ProduccioActual = " + produccioActual + " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G + " AND Type = '" + type + "'";
        Connector.getInstance().updateQuery(queryProduccioActual);
    }
}