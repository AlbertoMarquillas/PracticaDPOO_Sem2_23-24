package Business.Entities;

public interface ComptadorInterficie {

    double getQuantitatCoffe();

    void setGameTime(long time);

    long getGameTime();

    /**
     * Actualitza la quantitat de cafès
     * @param quantitatCafes quantitat de cafès
     * @param generator1 generador 1
     * @param generator2 generador 2
     * @param generator3 generador 3
     */
    void updateQuantitatCoffe(double quantitatCafes, Generator generator1, Generator generator2, Generator generator3);

    /**
     * Funció que actualitza la taula de la pantalla del jco
     * @param generador1 generador 1
     * @param generador2 generador 2
     * @param generador3 generador 3
     */
    void setTaulaContenido(Generator generador1, Generator generador2, Generator generador3);


    void setMillores(Millora millora1, Millora millora2, Millora millora3, Millora millora4);
}
