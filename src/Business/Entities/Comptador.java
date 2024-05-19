package Business.Entities;

import Business.Managers.GameManager;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Presentation.Controller.GameController;
import Presentation.View.GameView;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class Comptador {

    private final SQLGameDAO sqlGameDAO;
    private final SQLUserDAO sqlUserDAO;
    private final SQLGeneratorsDAO sqlGeneratorsDAO;
    private final SQLStatsDAO sqlStatsDAO;
    private ComptadorInterficie comptadorInterficie;
    private Thread thread;
    private boolean running;
    private double quantitatCoffee;

    private long startTime;
    private long currentTime;
    private long finalTime;

    private Game game;
    private Generator generador;
    private User user;

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

        GameManager gameManager = new GameManager(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO, sqlStatsDAO);

        this.thread = new Thread() {
            public void run() {
                boolean flag = false;
                // Inicializar la variable nCoffee en 0

                // Mientras la variable running sea true, el hilo seguirá en ejecución
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

                    // Incrementar nCoffee por la cantidad de café producido por cada generador
                    nCoffee = nCoffee + (gen1) + (gen2) + (gen3);

                    // Obtener savedTime de la base de datos
                    Time savedTime = sqlGameDAO.getSavedTime(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));

                    // Convertir el Time a LocalTime
                    LocalTime localTime = savedTime.toLocalTime();

                    // Incrementar el LocalTime en un segundo
                    localTime = localTime.plusSeconds(1);

                    // Convertir el LocalTime de nuevo a Time
                    savedTime = Time.valueOf(localTime);

                    // Actualizar el tiempo en la base de datos
                    sqlGameDAO.setGameTime(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), savedTime);

                    // Si ha pasado un minuto, ejecutar una función
                    if (localTime.getSecond() == 0 ) {
                        sqlStatsDAO.setSavedStats(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), savedTime, nCoffee);
                    }


                    comptadorInterficie.setTaulaContenido(generador1, generador2, generador3);
                    comptadorInterficie.setMillores(generador1.getMillora(), generador2.getMillora(), generador3.getMillora(), sqlGameDAO.getMilloraPowerUpClicker(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId())));
                    
                    // Actualizar la interfaz del contador con la cantidad actual de café y la producción total de los generadores
                    comptadorInterficie.updateQuantitatCoffe(nCoffee, generador1, generador2, generador3);

                    try {
                        // Hacer que el hilo duerma durante un segundo antes de continuar con la próxima iteración
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // Imprimir la traza de la pila si se produce una excepción
                        e.printStackTrace();
                    }
                }
            }

        };

        // Iniciar el hilo
        thread.start();
    }

    /**
     * Funció que setteja el comptador
     */
    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        this.comptadorInterficie = comptadorInterficie;
    }

}
