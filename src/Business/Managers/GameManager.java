package Business.Managers;

import Business.Entities.Comptador;
import Business.Entities.ComptadorInterficie;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Presentation.View.GameView;

    public class GameManager {
        private Comptador comptador;
        private SQLGameDAO sqlGameDAO;
        private SQLUserDAO sqlUserDAO;
        private SQLGeneratorsDAO sqlGeneratorsDAO;

        public GameManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLGeneratorsDAO sqlGeneratorsDAO){
            this.sqlGameDAO = sqlGameDAO;
            this.sqlUserDAO = sqlUserDAO;
            this.sqlGeneratorsDAO = sqlGeneratorsDAO;
            this.comptador = new Comptador(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO);
        }

        // ... el resto del código ...

    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        comptador.setComptadorInterficie(comptadorInterficie);
    }
    public void comptar() {
        comptador.comptar();
    }

    public void setQuantitatCafe(double quantitatCoffee) {
        sqlGameDAO.setNCoffees(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), quantitatCoffee);
    }

    public void initGame() {
        sqlGameDAO.startNewGame(sqlUserDAO.getConnectedUserId());
    }
    public int getConnectedUserId(){
        return sqlUserDAO.getConnectedUserId();
    }

    public double getCaffeeNumber() {
        return sqlGameDAO.getNCoffees(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));
    }

    public int getCurrentGameId(int connectedUserId) {
        return (sqlGameDAO.getCurrentGameId(connectedUserId) - 1);
    }

    public boolean comprobarPartidesActives(int connectedUserId) {
        return sqlGameDAO.comprobarPartidesActives(connectedUserId);
    }

    public void setEndeGame() {
        sqlGameDAO.setEnded(sqlUserDAO.getConnectedUserId(),true);
    }



    public String getComptadorCafe() {
        double coffeeCount = sqlGameDAO.getNCoffees(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()));
        long roundedCoffeeCount = Math.round(coffeeCount);
        return String.valueOf(roundedCoffeeCount);
    }
    }
