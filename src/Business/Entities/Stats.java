package Business.Entities;

import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLUserDAO;

import java.util.LinkedList;
import java.util.List;

public class Stats {
    private long time;
    private double nCoffee;
    private SQLUserDAO sqlUserDAO;
    private SQLGameDAO sqlGameDAO;

    /**
     * Constructor de la clase Stats
     * @param time temps que dura la partida
     * @param nCoffee quantitat de café produit
     */
    public Stats(long time, double nCoffee) {
        this.time = time;
        this.nCoffee = nCoffee;
    }

    public Stats getStatsFromSQL() {
        List<Stats> stats = SQLStatsDAO.getMatchStats(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));
        return (Stats) stats;
    }


    public int getTimeint() {
        int timeInt = (int) this.time;
        return timeInt;
    }

    public int getnCoffeeint() {
        int nCoffeeInt = (int) this.nCoffee;
        return nCoffeeInt;
    }
}
