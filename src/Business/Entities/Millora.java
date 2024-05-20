package Business.Entities;

public class Millora {

    private static final double INCREMENT_A = 100.0; // Incremento para el tipo A
    private static final double INCREMENT_B = 200.0; // Incremento para el tipo B
    private static final double INCREMENT_C = 300.0; // Incremento para el tipo C
    private static final double INCREMENT_D = 15.0; // Incremento para el tipo D

    private String type;
    private double preu; //cost del valor de millora
    private int quantitat;

    /**
     * Constructor de la classe Millora.
     *
     * @param type       el tipus de millora a aplicar.
     * @param quantitat  la quantitat de la millora.
     */
    public Millora(String type, int quantitat) {
        this.type = type;
        this.preu = setPreu(type, quantitat);
        this.quantitat = quantitat;
    }


    /**
     * Estableix el preu de la millora basant-se en el tipus i la quantitat especificats.
     *
     * @param type       el tipus de millora.
     * @param quantitat  la quantitat de la millora.
     * @return el preu de la millora.
     */
    public double setPreu(String type, int quantitat) {
        double increment;
        switch (type) {
            case "A":
                increment = INCREMENT_A;
                break;
            case "B":
                increment = INCREMENT_B;
                break;
            case "C":
                increment = INCREMENT_C;
                break;
            case "D":
                increment = INCREMENT_D;
                break;
            default:
                return -1;
        }

        if (quantitat == 0) {
            return increment;
        } else {
            return increment + ((quantitat) * increment);

        }
    }

    /**
     * Funcio que retorna el preu de la millora
     * @return un double amb el preu de la millora
     */
    public double getPreu(){
        return this.preu;
    }

}