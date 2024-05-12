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


    public int getTimeint() {
        long timeInMillis = this.time.getTime();
        return (int) (timeInMillis / 1000);
    }

    public int getnCoffeeint() {
        int nCoffeeInt = (int) this.nCoffee;
        return nCoffeeInt;
    }
}
