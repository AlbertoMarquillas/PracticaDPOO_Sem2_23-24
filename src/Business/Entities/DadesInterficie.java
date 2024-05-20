package Business.Entities;

public interface DadesInterficie {

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

    /**
     * Funcio que seteja les millores
     * @param millora1 primera millora
     * @param millora2 segona millora
     * @param millora3 tercera millora
     * @param millora4 cuarta millora
     */
    void setMillores(Millora millora1, Millora millora2, Millora millora3, Millora millora4);
}
