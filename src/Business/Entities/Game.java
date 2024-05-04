package Business.Entities;

import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;

public class Game {
    //game
    private double quantitatCafes;
    private int id_jugador;
    private int id_partida;
    private int powerUpClicker; //Millora 4
    private int tempspartida;
    private boolean ended;

    private final SQLGameDAO sqlGameDAO;
    private final SQLUserDAO sqlUserDAO;

    public Game(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO) {
        this.sqlGameDAO = sqlGameDAO;
        this.sqlUserDAO = sqlUserDAO;
        sqlGameDAO.startNewGame(sqlUserDAO.getUserID("a"));
    }


    public double getQuantitatCafes() {
        return sqlGameDAO.getGameCount(sqlUserDAO.getUserID("a"));
    }



    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getPowerUpClicker() {
        return powerUpClicker;
    }

    public void setPowerUpClicker(int powerUpClicker) {
        this.powerUpClicker = powerUpClicker;
    }

    public int getTempspartida() {
        return tempspartida;
    }

    public void setTempspartida(int tempspartida) {
        this.tempspartida = tempspartida;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
