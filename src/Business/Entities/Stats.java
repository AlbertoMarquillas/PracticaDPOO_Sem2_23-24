package Business.Entities;

import java.sql.Time;


/**
 * Classe que representa les estadístiques d'una partida.
 */
public class Stats {
    private Time time;
    private double nCoffee;

    /**
     * Constructor de la clase Stats
     * @param time temps que dura la partida
     * @param nCoffee quantitat de café produit
     */
    public Stats(Time time, double nCoffee) {
        this.time = time;
        this.nCoffee = nCoffee;
    }

    /**
     * Funcio que retorna el temps de partida
     * @return un int que indica temps en minuts
     */
    public int getTimeInMinutes() {
        return this.time.getMinutes();
    }

    /**
     * Funció que retorna el numero de cafés
     * @return int amb el numero de cafés
     */
    public int getnCoffeeint() {
        return (int) this.nCoffee;
    }
}
