package Business.Managers;

import Business.Entities.Comptador;
import Business.Entities.ComptadorInterficie;
import Business.Entities.Generator;
import Business.Entities.Millora;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Presentation.View.GameView;

    public class GameManager {
        private Comptador comptador;
        private SQLGameDAO sqlGameDAO;
        private SQLUserDAO sqlUserDAO;
        private SQLGeneratorsDAO sqlGeneratorsDAO;
        private SQLStatsDAO sqlStatsDAO;

        public GameManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLGeneratorsDAO sqlGeneratorsDAO, SQLStatsDAO sqlStatsDAO){
            this.sqlGameDAO = sqlGameDAO;
            this.sqlUserDAO = sqlUserDAO;
            this.sqlGeneratorsDAO = sqlGeneratorsDAO;
            this.sqlStatsDAO = sqlStatsDAO;
            this.comptador = new Comptador(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO, sqlStatsDAO);
        }

        // ... el resto del código ...

    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        comptador.setComptadorInterficie(comptadorInterficie);
    }
    public void comptar(boolean run) {
        comptador.comptar(run);
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
        return (sqlGameDAO.getCurrentGameId(connectedUserId));
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

    public void disconnectUser() {
        sqlUserDAO.setAllUsersOff();
    }

    public void updateCaffeeGenerators(Generator generator1, Generator generator2, Generator generator3) {
        sqlGeneratorsDAO.updateCaffeeGenerators(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()), generator1);
        sqlGeneratorsDAO.updateCaffeeGenerators(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()), generator2);
        sqlGeneratorsDAO.updateCaffeeGenerators(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()), generator3);
    }

    public void buyMillores(int ID_P, int ID_G, String type){
        int n_millores = sqlGameDAO.getPowerUpClicker(ID_P, ID_G) + 1;
        System.out.println("N_MILLORES: " + n_millores);
        Millora millora = new Millora(type, n_millores);

        if(sqlGameDAO.getNCoffees(ID_P, ID_G) >= millora.getPreu()) {
            sqlGameDAO.setPowerUpClicker(ID_P, ID_G, n_millores);
            sqlGameDAO.setNCoffees(ID_P, ID_G, sqlGameDAO.getNCoffees(ID_P, ID_G) - millora.getPreu());
        }
    }

    public int getQuantitatMillores(int ID_P, int ID_G){
        return sqlGameDAO.getPowerUpClicker(ID_P, ID_G);
    }
}
