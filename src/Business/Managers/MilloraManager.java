package Business.Managers;


/**
 * Gestiona les operacions relacionades amb les millores, com ara obtenir el cost d'una millora.
 */
public class MilloraManager {

    /**
     * Crea un objecte MilloraManager.
     */
    public MilloraManager(){

    }

    /**
     * Obté el cost d'una millora del tipus especificat.
     *
     * @param type el tipus de millora.
     * @return el cost de la millora.
     */
    public double getCostMillora(String type) {
        return switch (type) {
            case "A" -> 10.0;
            case "B" -> 20.0;
            case "C" -> 30.0;
            case "D" -> 40.0;
            default -> -1;
        };
    }

}
