package Business.Entities;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Comptador {

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

    public ComptadorInterficie getComptadorInterficie() {
        return comptadorInterficie;
    }

    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        this.comptadorInterficie = comptadorInterficie;
    }

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
     */
    public void setPlayer() {
        startTime = System.currentTimeMillis();
        this.currentTime = 0;
        this.finalTime = 0;
        this.running = false; //User activate

        this.quantitatCoffee = game.getQuantitatCafes();
        comptadorInterficie.setQuantitatCoffe(quantitatCoffee);
    }

    void comptar() {
        setRunning(true); // Asegúrate de establecer running en true antes de iniciar el hilo
        startTime = System.currentTimeMillis();
        this.thread = new Thread() {
            public void run() {
                while (running) {
                    comptadorInterficie.setQuantitatCoffe(quantitatCoffee);
                    comptadorInterficie.updateQuantitatCoffe(game.getQuantitatCafes(), generador.getProduccio());
                    try {
                        Thread.sleep(1000); // Esperar un segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

}
