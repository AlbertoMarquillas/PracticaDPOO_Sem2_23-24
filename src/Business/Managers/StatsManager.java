package Business.Managers;

import Business.Entities.Stats;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;

import java.util.ArrayList;
import java.util.List;

public class StatsManager {

    private SQLUserDAO sqlUserDAO;
    private SQLGameDAO sqlGameDAO;

    public StatsManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO) {
        this.sqlUserDAO = sqlUserDAO;
        this.sqlGameDAO = sqlGameDAO;
    }

    public ArrayList<Stats> getStatsFromSQL() {
        ArrayList<Stats> stats = SQLStatsDAO.getMatchStats(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));
        return stats;
    }
}