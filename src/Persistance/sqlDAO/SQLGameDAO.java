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
     * method that gets a matrix of strings with the gameName and data from a specific user
     * is surrounded in try-catch if something goes wrong when reading our sql
     * @param id contains the user id used to return just its games
     * @return string matrix with the positions of the ships
     */
    public String[][] getAllGames(int id) {
        List<String> game = new ArrayList<>();
        List<String> data = new ArrayList<>();

        String query = "SELECT GameName, Data FROM game WHERE id = '"+ id+"' AND Ended = false;";
        ResultSet result = Connector.getInstance().selectQuery(query);

        try {
            while(result.next()) {
                String gameName = result.getString("GameName");
                String time = String.valueOf(result.getDate("Data"));
                game.add(gameName);
                data.add(time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[][] games=new String[2][game.size()];
        for (int i = 0; i < game.size(); i++) {
            games[0][i]=game.get(i);
            games[1][i]=data.get(i);
        }
        return games;
    }

    /**
     * method that gets a list of the attacks per each game of the user
     * is surrounded in try-catch if something goes wrong when reading our sql
     * @param id contains the arraylist of players and data of the last game
     * @return list of integers with all the attacks
     */
    public List<Integer> getAllAttacks(int id) {
        List<Integer> totalAtacks = new ArrayList<>();
        String query = "SELECT TotalAtacks, Ended FROM game WHERE id = '"+ id+"';";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            while(result.next()) {
                boolean ended = result.getBoolean("Ended");
                int atacks = result.getInt("TotalAtacks");

                if (ended) {
                    totalAtacks.add(atacks);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalAtacks;
    }

    /**
     * method that gets a list of wins per rate for each game of the user
     * is surrounded in try-catch if something goes wrong when reading the sql
     * @param id contains the user id to get its wins
     * @return a list of integers that represent the number of wins
     */
    public int getWinRate(int id) {
        int winPlays = 0;
        String query = "SELECT Ended, Win FROM game WHERE id = '"+ id+"';";
        ResultSet result = Connector.getInstance().selectQuery(query);
        try {
            while(result.next()) {
                boolean ended = result.getBoolean("Ended");
                boolean win = result.getBoolean("Win");
                if(ended && win){
                    winPlays++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return winPlays;
    }

    /**
     * method that gets a list of the attacks per each game of the user
     * is surrounded in try-catch if something goes wrong when reading our sql
     * @param id contains the identification of the user that played that game
     * @param gameName String that indicates the name of the game
     * @param ended boolean that indicates if the game has ended
     * @param time  the duration of the actual game
     * @param totalAttacks the total alacks that is made in the game
     * @param win if the match has been won.
     * @return a boolean condition that represent if the game was done without problems
     */
    public boolean saveGame(int id, String gameName, boolean ended, String time, int totalAttacks, boolean win) {
        String query = "INSERT INTO game(id, GameName, Ended, Time, TotalAtacks, Win) VALUES " +
                "("+id+", '"+gameName+"', "+ended+", '"+time+"', "+totalAttacks+", "+win+");";
        boolean check = Connector.getInstance().insertQuery(query);
        System.out.println(check);
        return check;
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

    public int getGameCount(int userId) {
        int gameCount = 0;
        String query = "SELECT * FROM game WHERE ID_P = " + userId + ";";
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

    public boolean startNewGame(int userId) {
        // Establecer los valores iniciales para la nueva partida
        int numGame = 0;
        int N_Coffees = 0;
        int PowerUpClicker = 0;
        boolean Ended = false;
        String Time = "00:00:00"; // Asume que el tiempo se almacena como una cadena en formato HH:MM:SS

        //Encontrar el numero de partidas que lleva ejecutadas el usuario
        numGame = getGameCount(userId);

        // Crear la consulta SQL para insertar la nueva partida
        String query = "INSERT INTO game(ID_P, ID_G, N_Coffees, PowerUpClicker, Time, Ended) VALUES " +
                "("+userId+", "+numGame+", "+N_Coffees+", "+PowerUpClicker+", '"+Time+"', "+Ended+");";

        // Ejecutar la consulta y devolver si se realizó con éxito
        return Connector.getInstance().insertQuery(query);
    }

}
