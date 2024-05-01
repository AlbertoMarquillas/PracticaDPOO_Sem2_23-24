package Business.Managers;

import Business.Entities.Comptador;
import Business.Entities.ComptadorInterficie;
import Business.Entities.Game;
import Persistance.sqlDAO.SQLGameDAO;

public class GameManager {
    private Comptador comptador;
    private SQLGameDAO sqlGameDAO;

    public GameManager(SQLGameDAO sqlGameDAO) {
        this.comptador = new Comptador();
        this.sqlGameDAO = sqlGameDAO;
    }
    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        comptador.setComptadorInterficie(comptadorInterficie);
    }
    public void comptar() {
        comptador.comptar();
    }

    public void setQuantitatCafe(double quantitatCoffee) {
        sqlGameDAO.setQuantitatCafes(quantitatCoffee);
    }
    public double getQuantitatCafe() {
        return sqlGameDAO.getQuantitatCafe();
    }
}
