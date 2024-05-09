package Business.Entities;

public class Stats {
    private long time;
    private double nCoffee;

    /**
     * Constructor de la clase Stats
     * @param time temps que dura la partida
     * @param nCoffee quantitat de café produit
     */
    public Stats(long time, double nCoffee) {
        this.time = time;
        this.nCoffee = nCoffee;
    }

}
