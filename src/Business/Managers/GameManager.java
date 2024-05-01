package Business.Managers;

import Business.Entities.Comptador;
import Business.Entities.ComptadorInterficie;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;

public class GameManager {
    private Comptador comptador;
    private SQLGameDAO sqlGameDAO;
    private SQLUserDAO sqlUserDAO;

    public GameManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO) {
        this.comptador = new Comptador(sqlGameDAO, sqlUserDAO);
        this.sqlGameDAO = sqlGameDAO;
        this.sqlUserDAO = sqlUserDAO;
    }
    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        comptador.setComptadorInterficie(comptadorInterficie);
    }
    public void comptar() {
        comptador.comptar();
    }

    public void setQuantitatCafe(double quantitatCoffee) {
        sqlGameDAO.setNCoffees(sqlUserDAO.getUserID("a"), quantitatCoffee);
    }
    public double getQuantitatCafe() {
        return sqlGameDAO.getNCoffees(sqlUserDAO.getUserID("a"));
    }
}
