package Business.Managers;

import Business.Entities.Stats;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;

import java.util.ArrayList;
import java.util.List;

public class StatsManager {
    private int ID_G = 0;
    private int ID_P = 0;
    private SQLUserDAO sqlUserDAO;
    private SQLGameDAO sqlGameDAO;
    private SQLStatsDAO sqlStatsDAO;

    public StatsManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLStatsDAO sqlStatsDAO) {
        this.sqlUserDAO = sqlUserDAO;
        this.sqlGameDAO = sqlGameDAO;
        this.sqlStatsDAO = sqlStatsDAO;
    }

    public ArrayList<Stats> getStatsFromSQL(int ID_P, int ID_G) {
        ArrayList<Stats> stats = SQLStatsDAO.getMatchStats(ID_P, ID_G);
        return stats;
    }

    public void previousPlayerGraph() {
        if (sqlUserDAO.userIdExist(ID_P - 1)) {
            this.ID_P = ID_P - 1;
        } else {
            // You need to implement getMaxUserId() method in SQLUserDAO
            this.ID_P = sqlUserDAO.getMaxUserId();
        }
    }

    public void nextPlayerGraph() {
        if (sqlUserDAO.userIdExist(ID_P + 1)) {
            if(sqlStatsDAO.playerHasGames(ID_P + 1)){
                this.ID_P = ID_P + 1;
            }
        }else{
        }
    }

    public void previousGameGraph() {
        if (sqlGameDAO.gameIdExist(ID_G - 1)) {
            this.ID_G = ID_G - 1;
        } else {
            // You need to implement getMaxGameId() method in SQLGameDAO
            this.ID_G = sqlGameDAO.getMaxGameId();
        }
    }

    public void nextGameGraph() {
        if (sqlGameDAO.gameIdExist(ID_G + 1)) {
            this.ID_G = ID_G + 1;
        } else {
            this.ID_G = 0;
        }
    }

    public void setCurrentGraph(int ID_P, int ID_G) {
        this.ID_G = ID_G;
        this.ID_P = ID_P;
    }

    public ArrayList<Stats> getCurrentStats() {
        return getStatsFromSQL(this.ID_P, this.ID_G);
    }

    public String getNameUserConnected() {
        return sqlUserDAO.getUserNameConnected(this.ID_P);
    }

    public int getConnectedUserId() {
        return sqlGameDAO.getCurrentGameId(this.ID_P);
    }

    public int getCurrentGameIDSatats() {
        return sqlGameDAO.getCurrentGameId(this.ID_P);
    }
}