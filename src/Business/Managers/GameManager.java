package Business.Managers;

import Business.Entities.Comptador;
import Business.Entities.DadesInterficie;
import Business.Entities.Generator;
import Business.Entities.Millora;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLUserDAO;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * El GameManager gestiona la lògica de negoci del joc, incloent-hi el seguiment de les estadístiques, la compra de millores i altres funcionalitats relacionades amb el joc.
 */
public class GameManager {
    private Comptador comptador;
    private SQLGameDAO sqlGameDAO;
    private SQLUserDAO sqlUserDAO;
    private SQLGeneratorsDAO sqlGeneratorsDAO;
    private SQLStatsDAO sqlStatsDAO;

    /**
     * Construeix un objecte GameManager amb els DAO proporcionats i inicialitza un comptador (Comptador) amb ells.
     *
     * @param sqlGameDAO       el DAO per gestionar les dades relacionades amb el joc.
     * @param sqlUserDAO       el DAO per gestionar les dades relacionades amb l'usuari.
     * @param sqlGeneratorsDAO el DAO per gestionar les dades relacionades amb els generadors.
     * @param sqlStatsDAO      el DAO per gestionar les dades relacionades amb les estadístiques.
     */
    public GameManager(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLGeneratorsDAO sqlGeneratorsDAO, SQLStatsDAO sqlStatsDAO) {
        this.sqlGameDAO = sqlGameDAO;
        this.sqlUserDAO = sqlUserDAO;
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
        this.sqlStatsDAO = sqlStatsDAO;
        this.comptador = new Comptador(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO, sqlStatsDAO);
    }

    /**
     * Estableix la interfície del comptador (Comptador) que s'utilitzarà per comptar els esdeveniments del joc.
     *
     * @param dadesInterficie la interfície del comptador que s'ha d'establir.
     */
    public void setComptadorInterficie(DadesInterficie dadesInterficie) {
        comptador.setComptadorInterficie(dadesInterficie);
    }

    /**
     * Inicia el procés de comptatge basat en el paràmetre run especificat.
     *
     * @param run un booleà que indica si s'ha d'executar el procés de comptatge o no.
     */
    public void comptar(boolean run) {
        comptador.comptar(run);
    }

    /**
     * Estableix la quantitat de cafè per a la sessió de joc actual.
     *
     * @param quantitatCoffee la quantitat de cafè que s'ha d'establir.
     */
    public void setQuantitatCafe(double quantitatCoffee) {
        sqlGameDAO.setNCoffees(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), quantitatCoffee);
    }

    /**
     * Inicialitza una nova sessió de joc per a l'usuari actual.
     * Inicia un nou joc i estableix les estadístiques inicials per al joc.
     */
    public void initGame() {
        sqlGameDAO.startNewGame(sqlUserDAO.getConnectedUserId());
        LocalTime midnight = LocalTime.MIDNIGHT;
        Time time = Time.valueOf(midnight);
        sqlStatsDAO.setSavedStats(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), time, 0);
    }

    /**
     * Recupera l'ID de l'usuari connectat.
     *
     * @return l'ID de l'usuari connectat.
     */
    public int getConnectedUserId() {
        return sqlUserDAO.getConnectedUserId();
    }

    /**
     * Recupera la quantitat de cafè per a la sessió de joc actual.
     *
     * @return la quantitat de cafè per a la sessió de joc actual.
     */
    public double getCaffeeNumber() {
        return sqlGameDAO.getNCoffees(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));
    }

    /**
     * Recupera l'ID de la sessió de joc actual per a l'usuari especificat.
     *
     * @param connectedUserId l'ID de l'usuari connectat.
     * @return l'ID de la sessió de joc actual.
     */
    public int getCurrentGameId(int connectedUserId) {
        return sqlGameDAO.getCurrentGameId(connectedUserId);
    }

    /**
     * Comprova si hi ha sessions de joc actives per a l'usuari especificat.
     *
     * @param connectedUserId l'ID de l'usuari connectat.
     * @return true si hi ha sessions de joc actives, false altrament.
     */
    public boolean comprobarPartidesActives(int connectedUserId) {
        return sqlGameDAO.comprobarPartidesActives(connectedUserId);
    }

    /**
     * Estableix el final de la sessió de joc actual per a l'usuari connectat.
     */
    public void setEndeGame() {
        sqlGameDAO.setEnded(sqlUserDAO.getConnectedUserId(), true);
    }

    /**
     * Desconnecta tots els usuaris.
     */
    public void disconnectUser() {
        sqlUserDAO.setAllUsersOff();
    }

    /**
     * Actualitza les dades dels generadors de cafè per a l'usuari connectat i la sessió de joc actual.
     *
     * @param generator1 el primer generador de cafè.
     * @param generator2 el segon generador de cafè.
     * @param generator3 el tercer generador de cafè.
     */
    public void updateCaffeeGenerators(Generator generator1, Generator generator2, Generator generator3) {
        sqlGeneratorsDAO.updateCaffeeGenerators(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()), generator1);
        sqlGeneratorsDAO.updateCaffeeGenerators(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()), generator2);
        sqlGeneratorsDAO.updateCaffeeGenerators(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()), generator3);
    }

    /**
     * Compra power-ups per a la funcionalitat de clics.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de power-up a comprar.
     */
    public void buyMilloresPowerUpClicker(int ID_P, int ID_G, String type) {
        int n_millores = sqlGameDAO.getPowerUpClicker(ID_P, ID_G);
        Millora millora = new Millora(type, n_millores);

        // Verifica si el jugador té prou cafè per comprar el power-up
        if (sqlGameDAO.getNCoffees(ID_P, ID_G) >= millora.getPreu()) {
            // Incrementa el nombre de millores del power-up
            sqlGameDAO.setPowerUpClicker(ID_P, ID_G, (n_millores + 1));
            // Redueix la quantitat de cafè segons el preu del power-up comprat
            sqlGameDAO.setNCoffees(ID_P, ID_G, sqlGameDAO.getNCoffees(ID_P, ID_G) - millora.getPreu());
        }
    }

    /**
     * Recupera la quantitat de millores del power-up per a la funcionalitat de clics.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @return la quantitat de millores del power-up per a la funcionalitat de clics.
     */
    public int getQuantitatMillores(int ID_P, int ID_G) {
        // Retorna la quantitat de millores del power-up
        return sqlGameDAO.getPowerUpClicker(ID_P, ID_G);
    }

    /**
     * Verifica quins botons s'han d'habilitar en funció de la quantitat actual de cafè i els costos dels generadors.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @return una llista de booleans que indica si cada botó s'ha d'habilitar o no.
     */
    public ArrayList<Boolean> comprobarHabilitarBotons(int ID_P, int ID_G) {
        ArrayList<Boolean> botonsEnables = new ArrayList<>();

        double currentCafe = sqlGameDAO.getNCoffees(ID_P, ID_G);

        // Obté la informació dels generadors de cafè
        Generator generatorA = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, "A");
        Generator generatorB = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, "B");
        Generator generatorC = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, "C");

        // Verifica si els generadors es poden comprar amb la quantitat actual de cafè
        if (currentCafe >= generatorA.getGeneratorCost()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        if (currentCafe >= generatorB.getGeneratorCost()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        if (currentCafe >= generatorC.getGeneratorCost()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        // Obtenir informació sobre les millores del power-up
        Millora millora1 = new Millora("A", generatorA.getNumeroMillores());
        Millora millora2 = new Millora("B", generatorB.getNumeroMillores());
        Millora millora3 = new Millora("C", generatorC.getNumeroMillores());
        Millora millora4 = new Millora("D", getQuantitatMillores(ID_P, ID_G));

        // Verifica si les millores del power-up es poden comprar amb la quantitat actual de cafè
        if (currentCafe >= millora1.getPreu()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        if (currentCafe >= millora2.getPreu()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        if (currentCafe >= millora3.getPreu()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        if (currentCafe >= millora4.getPreu()) {
            botonsEnables.add(true);
        } else {
            botonsEnables.add(false);
        }

        return botonsEnables;
    }

    /**
     * Comprova si en tota la base de dades hi ha minim una partida acabada.
     *
     * @return un boolea que indica si hi ha minim una partida acabada.
     */
    public boolean anyGameEnded() {
        return sqlGameDAO.anyGameEnded();
    }

     /**
     * Obté l'ID de l'usuari connectat si la seva partida ha finalitzat.
     * Si la partida de l'usuari connectat no ha finalitzat, obté l'ID del primer usuari amb una partida finalitzada.
     *
     * @return L'ID de l'usuari connectat si la seva partida ha finalitzat, o l'ID del primer usuari amb una partida finalitzada si la partida de l'usuari connectat no ha finalitzat.
     */
    public int getConnectedUserIdEndedGame() {
        if (sqlGameDAO.comprobarPartidaFinalitzada(sqlUserDAO.getConnectedUserId(), getCurrentGameId(sqlUserDAO.getConnectedUserId()))){
            return sqlUserDAO.getConnectedUserId();
        }else{
            return sqlGameDAO.getConnectedUserIdEndedGame();
        }
    }
}
