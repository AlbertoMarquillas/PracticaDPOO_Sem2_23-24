package Business.Entities;


import java.sql.Time;
import java.util.List;

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


    public int getTimeInMinutes() {
        return this.time.getMinutes();
    }

    public int getnCoffeeint() {
        int nCoffeeInt = (int) this.nCoffee;
        return nCoffeeInt;
    }
}
