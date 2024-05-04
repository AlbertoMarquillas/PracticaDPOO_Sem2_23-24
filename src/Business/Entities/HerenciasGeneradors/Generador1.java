package Business.Entities.HerenciasGeneradors;

import Business.Entities.Generator;

public class Generador1 extends Generator {
    private static final double COST_BASE = 10.0; // Define el costo base como una constante

    public Generador1() {
        setType("A");
        setProduccioActual(1);
        setIncrement(1.15);
    }

    public double calculateNextGeneratorCost(int currentNumberOfGenerators) {
        return Math.round(COST_BASE * Math.pow(getIncrement(), currentNumberOfGenerators));
    }

    @Override
    public double getCostBase() {
        return COST_BASE; // Devuelve el costo base constante
    }
}