package Business.Managers;

import Business.Entities.Stats;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que gestiona les estadístiques dels jugadors.

 */
public class StatsManager {
    private int ID_G = 0;
    private int ID_P = 0;
    private SQLUserDAO sqlUserDAO;
    private SQLGameDAO sqlGameDAO;
    private SQLStatsDAO sqlStatsDAO;


    /**
     * Constructor per a la classe StatsManager.
     *
     * @param sqlGameDAO l'objecte SQLGameDAO utilitzat per gestionar les dades del joc.
     * @param sqlUserDAO l'objecte SQLUserDAO utilitzat per gestionar les dades dels usuaris.
     * @param sqlStatsDAO l'objecte SQLStatsDAO utilitzat per gestionar les estadístiques.
     */
    public StatsManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLStatsDAO sqlStatsDAO) {
        this.sqlUserDAO = sqlUserDAO;
        this.sqlGameDAO = sqlGameDAO;
        this.sqlStatsDAO = sqlStatsDAO;
    }


    /**
     * Obté les estadístiques del joc per a un usuari i un joc específics des de la base de dades SQL.
     *
     * @param ID_P l'identificador de l'usuari.
     * @param ID_G l'identificador del joc.
     * @return una llista d'objectes Stats que contenen les estadístiques del joc.
     */
    public ArrayList<Stats> getStatsFromSQL(int ID_P, int ID_G) {
        ArrayList<Stats> stats = SQLStatsDAO.getMatchStats(ID_P, ID_G);
        return stats;
    }


    /**
     * Actualitza els identificadors del jugador (ID_P) i del joc (ID_G) per mostrar les estadístiques del jugador anterior.
     *
     * Si el jugador anterior té jocs registrats, es mostrarà el primer joc d'aquest jugador. Si no, es continuarà buscant cap enrere fins a trobar un jugador amb jocs.
     * Si no existeixen jugadors anteriors amb jocs, es mostrarà el jugador amb el màxim ID i es continuarà buscant cap enrere fins a trobar un jugador amb jocs.
     */
    public void previousPlayerGraph() {
        if (sqlUserDAO.userIdExist(ID_P - 1)) {
            if(sqlStatsDAO.playerHasGames(ID_P - 1)){
                this.ID_P = ID_P - 1;
                this.ID_G = 0;
            }else {
                while (true) {
                    this.ID_P = ID_P - 1;
                    if (sqlStatsDAO.playerHasGames(ID_P)) {
                        this.ID_G = 0;
                        break;
                    }
                }
            }
        } else {
            this.ID_P = sqlUserDAO.getMaxUserId();
            while(true){
                if(sqlStatsDAO.playerHasGames(ID_P)){
                    this.ID_G = 0;
                    break;
                }
                this.ID_P = ID_P - 1;
            }
        }
    }


    /**
     * Actualitza els identificadors del jugador (ID_P) i del joc (ID_G) per mostrar les estadístiques del següent jugador.
     *
     * Si el següent jugador té jocs registrats, es mostrarà el primer joc d'aquest jugador. Si no, es continuarà buscant endavant fins a trobar un jugador amb jocs.
     * Si no existeixen jugadors següents amb jocs, es començarà des del primer jugador i es continuarà buscant endavant fins a trobar un jugador amb jocs.
     */
    public void nextPlayerGraph() {
        if (sqlUserDAO.userIdExist(ID_P + 1)) {
            if(sqlStatsDAO.playerHasGames(ID_P + 1)){
                this.ID_P = ID_P + 1;
                this.ID_G = 0;
            }else{
                while(true){
                    this.ID_P = ID_P + 1;
                    if(sqlStatsDAO.playerHasGames(ID_P)){
                        this.ID_G = 0;
                        break;
                    }
                }
            }
        }else{
            this.ID_P = 0;
            while(true){
                this.ID_P = ID_P + 1;
                if(sqlStatsDAO.playerHasGames(ID_P)){
                    this.ID_G = 0;
                    break;
                }
            }
        }
    }


    /**
     * Actualitza l'identificador del joc (ID_G) per mostrar les estadístiques del joc anterior del jugador actual.
     *
     * Si existeix un joc anterior per al jugador actual (ID_P), es mostrarà aquest joc.
     * Si no, es buscarà el màxim identificador de joc (ID_G) per al jugador actual, i es mostrarà aquest joc.
     */
    public void previousGameGraph() {
        if (sqlGameDAO.gameIdExist(this.ID_P, ID_G - 1)) {
            this.ID_G = ID_G - 1;
        } else {
            // You need to implement getMaxGameId() method in SQLGameDAO
            this.ID_G = sqlGameDAO.getMaxGameId(ID_P);
        }
    }


    /**
     * Actualitza l'identificador del joc (ID_G) per mostrar les estadístiques del següent joc del jugador actual.
     *
     * Si existeix un següent joc per al jugador actual (ID_P), es mostrarà aquest joc.
     * Si no, es reiniciarà l'ID del joc (ID_G) a 0.
     */
    public void nextGameGraph() {
        if (sqlGameDAO.gameIdExist(this.ID_P, ID_G + 1)) {
            this.ID_G = ID_G + 1;
        } else {
            this.ID_G = 0;
        }
    }


    /**
     * Estableix l'identificador del jugador (ID_P) i l'identificador del joc (ID_G) per a mostrar les estadístiques corresponents.
     *
     * @param ID_P L'identificador del jugador.
     * @param ID_G L'identificador del joc.
     */
    public void setCurrentGraph(int ID_P, int ID_G) {
        this.ID_G = ID_G;
        this.ID_P = ID_P;
    }


    /**
     * Obté les estadístiques actuals per al jugador i el joc actualment seleccionats.
     *
     * @return Una llista d'objectes {@code Stats} que conté les estadístiques del jugador (ID_P) i el joc (ID_G) actuals.
     */
    public ArrayList<Stats> getCurrentStats() {
        return getStatsFromSQL(this.ID_P, this.ID_G);
    }


    /**
     * Obté el nom de l'usuari actualment connectat basat en l'identificador del jugador (ID_P).
     *
     * @return El nom de l'usuari connectat com a {@code String}.
     */
    public String getNameUserConnected() {
        return sqlUserDAO.getUserNameConnected(this.ID_P);
    }


    /**
     * Obté l'identificador del joc actualment seleccionat (ID_G).
     *
     * @return L'identificador del joc actual.
     */
    public int getCurrentGameIDSatats() {
        return this.ID_G;
    }
}