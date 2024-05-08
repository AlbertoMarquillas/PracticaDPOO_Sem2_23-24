package Business.Entities;

import Business.Managers.GameManager;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Presentation.Controller.GameController;
import Presentation.View.GameView;

public class Comptador {

    private final SQLGameDAO sqlGameDAO;
    private final SQLUserDAO sqlUserDAO;
    private final SQLGeneratorsDAO sqlGeneratorsDAO;
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

    public Comptador(SQLGameDAO sqlGameDAO, SQLUserDAO sqlUserDAO, SQLGeneratorsDAO sqlGeneratorsDAO) {
        this.sqlGameDAO = sqlGameDAO;
        this.sqlUserDAO = sqlUserDAO;
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
    }


    /*public ComptadorInterficie getComptadorInterficie() {
        return comptadorInterficie;
    }*/
    /*
    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        this.comptadorInterficie = comptadorInterficie;
    }*/

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public double getQuantitatCoffee() {
        return quantitatCoffee;
    }

    public void setQuantitatCoffee(int quantitatCoffee) {
        this.quantitatCoffee = quantitatCoffee;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(long finalTime) {
        this.finalTime = finalTime;
    }

    /**
     * Funció que seteja el comptador segons el player
     *//*
    public void setPlayer() {
        startTime = System.currentTimeMillis();
        this.currentTime = 0;
        this.finalTime = 0;
        this.running = false; //User activate

        this.quantitatCoffee = game.getQuantitatCafes();
        comptadorInterficie.setQuantitatCoffe(quantitatCoffee);
    }*/


    /*
    //Revisar comptatge ID_Coffe.
    public void comptar() {
    // Establecer la variable running en true para indicar que el hilo debe estar en ejecución
        setRunning(true);

        // Guardar el tiempo actual en milisegundos como el tiempo de inicio
        startTime = System.currentTimeMillis();

        // Crear una nueva instancia de Generador1, que es una clase que determina la cantidad de café producido
        this.generador = new Generador1();

        // Crear un nuevo hilo
        this.thread = new Thread() {
            public void run() {
                // Inicializar la variable nCoffee en 0
                double nCoffee = 0;

                // Mientras la variable running sea true, el hilo seguirá en ejecución
                while (running) {
<<<<<<< HEAD
                    nCoffee = sqlGameDAO.getNCoffees(sqlUserDAO.getConnectedUserId()) + generador.getProduccio();
                    comptadorInterficie.updateQuantitatCoffe(nCoffee, generador.getProduccio());
=======
                    // Incrementar nCoffee por la cantidad de café producido por el generador
                    nCoffee = nCoffee + generador.getProduccio();

                    // Actualizar la interfaz del contador con la cantidad actual de café y la producción del generador
                    comptadorInterficie.updateQuantitatCoffe(nCoffee, generador.getProduccio());

                    // Obtener la cantidad actual de café del usuario "a" en la base de datos y sumarle la producción del generador
                    double n_cafes =  nCoffee;

                    // Actualizar la cantidad de café del usuario "a" en la base de datos
                    sqlGameDAO.setNCoffees(sqlUserDAO.getUserID("a"), n_cafes);

>>>>>>> PersistenciaBBDDUnificada
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
    }*/

    public void comptar(boolean run) {
        // Establecer la variable running en true para indicar que el hilo debe estar en ejecución
        setRunning(run);

        // Crear nuevas instancias de tus tres generadores
        GameManager gameManager = new GameManager(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO);



        // Crear un nuevo hilo
        this.thread = new Thread() {
            public void run() {
                // Inicializar la variable nCoffee en 0

                // Mientras la variable running sea true, el hilo seguirá en ejecución
                while (running) {

                    Generator generador1 = sqlGeneratorsDAO.getGenerator(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), "A");
                    Generator generador2 = sqlGeneratorsDAO.getGenerator(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), "B");
                    Generator generador3 = sqlGeneratorsDAO.getGenerator(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()), "C");


                    double nCoffee = sqlGameDAO.getNCoffees(sqlUserDAO.getConnectedUserId(), sqlGameDAO.getCurrentGameId(sqlUserDAO.getConnectedUserId()));

                    double Gen1 = generador1.getProduccioActual() * generador1.getQuantitat();
                    double Gen2 = generador2.getProduccioActual() * generador2.getQuantitat();
                    double Gen3 = generador3.getProduccioActual() * generador3.getQuantitat();

                    // Incrementar nCoffee por la cantidad de café producido por cada generador
                    nCoffee = nCoffee + (Gen1) + (Gen2) + (Gen3);

                    // Actualizar la interfaz del contador con la cantidad actual de café y la producción total de los generadores
                    comptadorInterficie.updateQuantitatCoffe(nCoffee);

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

    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        this.comptadorInterficie = comptadorInterficie;
    }
}
