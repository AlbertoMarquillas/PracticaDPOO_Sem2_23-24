package Business.Entities;

import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;

public class Game {
    private final SQLGameDAO sqlGameDAO;
    private final SQLUserDAO sqlUserDAO;

    /**
     * Constructor de la clase Game
     * @param sqlGameDAO DAO de la taula Game
     * @param sqlUserDAO DAO de la taula User
     */
    public Game(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO) {
        this.sqlGameDAO = sqlGameDAO;
        this.sqlUserDAO = sqlUserDAO;
        sqlGameDAO.startNewGame(sqlUserDAO.getUserID("a"));
    }

}
