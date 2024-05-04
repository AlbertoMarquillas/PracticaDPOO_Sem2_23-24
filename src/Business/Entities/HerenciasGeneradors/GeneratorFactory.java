package Business.Entities;

import Business.Entities.HerenciasGeneradors.Generador1;
import Business.Entities.HerenciasGeneradors.Generador2;
import Business.Entities.HerenciasGeneradors.Generador3;

public class GeneratorFactory {
    public static Generator createGenerator(String type) {
        switch (type) {
            case "A":
                return new Generador1();
            case "B":
                return new Generador2();
            case "C":
                return new Generador3();
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}