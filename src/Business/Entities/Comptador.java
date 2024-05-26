package Business.Entities;

import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;

import java.sql.Time;
import java.time.LocalTime;

/**
 * Classe que compta el temps i la producció de cafè
 */
public class Comptador {

    private final SQLGameDAO sqlGameDAO;
    private final SQLUserDAO sqlUserDAO;
    private final SQLGeneratorsDAO sqlGeneratorsDAO;
    private final SQLStatsDAO sqlStatsDAO;
    private DadesInterficie dadesInterficie;
    private Thread thread;
    private boolean running;


    /**
     * Constructor de la clase Comptador
     * @param sqlGameDAO DAO de la taula Game
     * @param sqlUserDAO DAO de la taula User
     * @param sqlGeneratorsDAO DAO de la taula Generators
     * @param sqlStatsDAO DAO de la taula Stats
     */
    public Comptador(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLGeneratorsDAO sqlGeneratorsDAO, SQLStatsDAO sqlStatsDAO) {
        this.sqlGameDAO = sqlGameDAO;
        this.sqlUserDAO = sqlUserDAO;
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
        this.sqlStatsDAO = sqlStatsDAO;
    }

    /**
     * Funcio que indica si el programa esta funcionant
     * @param running boolean que es true si el prgrama esta executant-se
     */
    public void setRunning(boolean running) {
        this.running = running;
    }


    /**
     * Funció que compta el temps i la producció de cafè
     * @param run booleà que indica si el thread està en execució
     */
    public void comptar(boolean run) {
        setRunning(run);


        this.thread = new Thread() {
            public void run() {

            while (running) {
                Generator generador1 = sqlGeneratorsDAO.getGenerator(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), "A");
                Generator generador2 = sqlGeneratorsDAO.getGenerator(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), "B");
                Generator generador3 = sqlGeneratorsDAO.getGenerator(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), "C");

                double nCoffee = sqlGameDAO.getNCoffees(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));
                double gen1 = generador1.getProduccioActual();
                double gen2 = generador2.getProduccioActual();
                double gen3 = generador3.getProduccioActual();

                generador1.setProduccioGlobal(gen1);
                generador2.setProduccioGlobal(gen2);
                generador3.setProduccioGlobal(gen3);

                //Incrementar la quantitat de café en funció de la producció dels generadors
                nCoffee = nCoffee + (gen1) + (gen2) + (gen3);

                //Actualizar la quantitat de cafes a la bbdd cada 1 seg
                Time savedTime = sqlGameDAO.getSavedTime(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));
                LocalTime localTime = savedTime.toLocalTime();
                localTime = localTime.plusSeconds(1);
                savedTime = Time.valueOf(localTime);
                sqlGameDAO.setGameTime(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), savedTime);

                //Guardar les estadístiques a la bbdd cada 1 seg
                if (localTime.getSecond() == 0 ) {
                    sqlStatsDAO.setSavedStats(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), savedTime, nCoffee);
                }

                //Actualitzar les dades dels generadors, les millores i el comptador de GameView cada 1 seg
                dadesInterficie.setTaulaContenido(generador1, generador2, generador3);
                dadesInterficie.setMillores(generador1.getMillora(), generador2.getMillora(), generador3.getMillora(), sqlGameDAO.getMilloraPowerUpClicker(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId())));
                dadesInterficie.updateQuantitatCoffe(nCoffee, generador1, generador2, generador3);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }

        };

        thread.start();
    }

    /**
     * Funció que setteja el comptador
     * @param dadesInterficie la interficie creada per enviar les dades desde la base cap a la vista
     */
    public void setComptadorInterficie(DadesInterficie dadesInterficie) {
        this.dadesInterficie = dadesInterficie;
    }

}
