package Business.Entities;

public class Millora {

    private static final double INCREMENT_A = 100.0; // Incremento para el tipo A
    private static final double INCREMENT_B = 200.0; // Incremento para el tipo B
    private static final double INCREMENT_C = 300.0; // Incremento para el tipo C
    private static final double INCREMENT_D = 15.0; // Incremento para el tipo D

    private String type;
    private double preu; //cost del valor de millora
    private int quantitat;

    public Millora(String type, int quantitat) {
        this.type = type;
        this.preu = setPreu(type, quantitat);
        this.quantitat = quantitat;
    }

    public double setPreu(String type, int quantitat) {
        double increment;
        if (type.equals("A")) {
            increment = INCREMENT_A;
        } else if (type.equals("B")) {
            increment = INCREMENT_B;
        } else if (type.equals("C")) {
            increment = INCREMENT_C;
        } else if (type.equals("D")) {
            increment = INCREMENT_D;
        } else {
            return -1;
        }

        if (quantitat == 0) {
            return increment;
        } else {
            return increment + ((quantitat) * increment);

        }
    }


    public double getPreu(){
        return this.preu;
    }

    // Resto del código...
}