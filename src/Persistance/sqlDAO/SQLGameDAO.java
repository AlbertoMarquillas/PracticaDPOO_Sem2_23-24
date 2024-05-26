package Persistance.sqlDAO;

import Business.Entities.Millora;
import Persistance.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;


/**
 * Classe que gestiona les dades del joc a la base de dades SQL.
 */
public class SQLGameDAO {

    /**
     * constructor de la clase SQLGameDAO
     */
    public SQLGameDAO() {

    }

    /**
     * Estableix el temps de joc per al jugador connectat i el joc actual amb el temps especificat.
     * @param connectedUserId El ID de l'usuari connectat.
     * @param currentGameId El ID del joc actual.
     * @param counter El temps a establir per al joc.
     */
    public static void setGameTime(int connectedUserId, int currentGameId, Time counter) {
        String query = "UPDATE game SET Time = '" + counter + "' WHERE ID_P = " + connectedUserId + " AND ID_G = " + currentGameId;
        Connector.getInstance().updateQuery(query);
    }

    /**
     * Busca el numero de partides que portes per generar el ID_G
     * @param userID the id of the user that will delete the data.
     * @return el numero de games
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

    /**
     * Inicia una nova partida per a l'usuari especificat.
     * @param userId L'ID de l'usuari per al qual es comença la nova partida.
     */
    public void startNewGame(int userId) {
        //Inicialitzar els valors de la nova partida
        int numGame = getGameCount(userId);
        int N_Coffees = 0;
        int PowerUpClicker = 0;
        String Time = "00:00:00";
        boolean Ended = false;

        // Crear la consulta SQL per a afegir la nova partida a la base de dades
        String query = "INSERT INTO `game`(`ID_P`, `ID_G`, `N_Coffees`, `PowerUpClicker`, `Time`, `Ended`) VALUES " +
                "(" + userId + ", " + numGame + ", " + N_Coffees + ", " + PowerUpClicker + ", '" + Time + "', " + Ended + ");";

        Connector.getInstance().insertQuery(query);
    }


    /**
     * Obté el nombre de cafès per a l'usuari i joc especificats.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del joc.
     * @return El nombre de cafès per a l'usuari i joc especificats.
     */
    public double getNCoffees(int ID_P, int ID_G) {
        double nCoffees = 0;
        String query = "SELECT N_Coffees FROM game WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                nCoffees = result.getDouble("N_Coffees");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double Nretrun = nCoffees;
        return Nretrun;
    }


    /**
     * Estableix el nombre de cafès per a l'usuari i joc especificats.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del joc.
     * @param newNCoffees El nou nombre de cafès a establir.
     */
    public void setNCoffees(int ID_P, int ID_G, double newNCoffees) {
        String query = "UPDATE game SET N_Coffees = " + newNCoffees + " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Obté el valor de PowerUpClicker per a l'usuari especificat.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del game
     * @return El valor de PowerUpClicker per a l'usuari especificat.
     */
    public int getPowerUpClicker(int ID_P, int ID_G) {
        int powerUpClicker = 0;
        String query = "SELECT PowerUpClicker FROM game WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
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


    /**
     * Estableix el valor de PowerUpClicker per a l'usuari especificat.
     *
     * @param ID_P L'ID de l'usuari.
     * @param ID_G L'ID del game
     * @param newPowerUpClicker El nou valor de PowerUpClicker a establir.
     */
    public void setPowerUpClicker(int ID_P, int ID_G, int newPowerUpClicker) {
        String query = "UPDATE game SET PowerUpClicker = " + newPowerUpClicker + " WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Estableix l'estat de finalització del joc per a l'usuari especificat.
     *
     * @param id L'ID de l'usuari.
     * @param newEnded El nou estat de finalització del joc a establir.
     */
    public void setEnded(int id, boolean newEnded) {
        String query = "UPDATE game SET Ended = " + newEnded + " WHERE ID_P = " + id;
        Connector.getInstance().updateQuery(query);
    }


    /**
     * Obté l'ID del joc actual per a l'usuari connectat.
     *
     * @param connectedUserId L'ID de l'usuari connectat.
     * @return L'ID del joc actual per a l'usuari connectat.
     */
    public int getCurrentGameId(int connectedUserId) {
        return getGameCount(connectedUserId) - 1;
    }


    /**
     * Comprova si l'usuari té partides actives.
     *
     * @param userId L'ID de l'usuari.
     * @return Cert si l'usuari té almenys una partida activa; fals en cas contrari.
     */
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


    /**
     * Obté el temps guardat per a l'usuari connectat i el joc actual.
     *
     * @param connectedUserId L'ID de l'usuari connectat.
     * @param currentGameId L'ID del joc actual.
     * @return El temps guardat per a l'usuari i joc especificats, o null si no s'ha trobat cap resultat.
     */
    public Time getSavedTime(int connectedUserId, int currentGameId) {
        String query = "SELECT Time FROM game WHERE ID_P = " + connectedUserId + " AND ID_G = " + currentGameId;
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                Time time = result.getTime("Time");
                return time;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Comprova si hi ha alguna partida que hagi finalitzat, es considera finalitzada si el camp 'Ended' és igual a 1.
     *
     * @param connectedUserId L'ID de l'usuari connectat.
     * @param currentGameId L'ID del joc actual.
     * @return Cert si hi ha almenys una partida que ha finalitzat; fals en cas contrari.
     */
    public boolean comprobarPartidaFinalitzada(int connectedUserId, int currentGameId) {
        String query = "SELECT * FROM game WHERE ID_P = " + connectedUserId + " AND ID_G = " + currentGameId + " AND Ended = 1";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                return true; // Hi ha almenys una partida amb Ended = 1 per a aquest usuari
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //No hi ha partides amb Ended = 1 per a aquest usuari
    }

    /**
     * Obté la informacó sobre la millora de Clicks de l'usuari.
     * @param ID_P L'ID de l'usuari connectat.
     * @param ID_G L'ID del joc actual.
     * @return Retorna informacó sobre la millora de Clicks de l'usuari
     */
    public Millora getMilloraPowerUpClicker(int ID_P, int ID_G) {
        String query = "SELECT powerUpClicker FROM game WHERE ID_P = " + ID_P + " AND ID_G = " + ID_G;
        ResultSet result = Connector.getInstance().selectQuery(query);

        try {
            if (result.next()) {
                return new Millora("D", result.getInt("powerUpClicker"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Obté el màxim identificador de joc associat a un determinat identificador de jugador.
     *
     * @param ID_P L'identificador del jugador.
     * @return El màxim identificador de joc associat al jugador especificat.
     *         Si no es troba cap joc associat al jugador, es retorna -1.
     * @throws RuntimeException Si es produeix un error en executar la consulta SQL.
     */
    public int getMaxGameId(int ID_P) {
        try {
            String query = "SELECT MAX(ID_G) AS max_id FROM game WHERE ID_P = " + ID_P;
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
     * Comprova si existeix un identificador de joc per a un jugador determinat.
     *
     * @param idP L'identificador del jugador.
     * @param idG L'identificador del joc.
     * @return Cert si l'identificador de joc existeix per al jugador especificat i el joc no ha finalitzat; fals altrament.
     * @throws RuntimeException Si es produeix un error en executar la consulta SQL.
     */
    public boolean gameIdExist(int idP, int idG) {
        try {
            String query = "SELECT * FROM game WHERE ID_G = " + idG + " AND ID_P = " + idP;
            ResultSet result = Connector.getInstance().selectQuery(query);
            if (result.next()) {
                if (result.getInt("Ended") == 1){
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


     /**
     * Comprueba si hay alguna partida que haya finalizado.
     * Una partida se considera finalizada si el campo 'Ended' es igual a 1.
     *
     * @return true si hay al menos una partida que ha finalizado, false en caso contrario.
     */
    public boolean anyGameEnded() {
        String query = "SELECT 1 FROM game WHERE Ended = 1";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                return true; // Hay al menos una partida con Ended = 1
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // No hay partidas con Ended = 1
    }


     /**
     * Busca el primer usuario que tenga una partida finalizada.
     * Una partida se considera finalizada si el campo 'Ended' es igual a 1.
     *
     * @return El ID del primer usuario que tiene una partida finalizada, o -1 si no se encuentra ninguno.
     */
    public int getConnectedUserIdEndedGame() {
        String query = "SELECT ID_P FROM game WHERE Ended = 1 ORDER BY ID_P ASC LIMIT 1";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            if (result.next()) {
                return result.getInt("ID_P"); // Devuelve el ID del primer usuario con una partida finalizada
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Devuelve -1 si no se encuentra ningún usuario con una partida finalizada
    }
}