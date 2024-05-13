package Business.Managers;

import Business.Entities.Generator;
import Business.Entities.Millora;


public class MilloraManager {
    Generator generator;
    private Millora millores;
    double costMillora;
    String type;
    int quanitatMillores;

    public MilloraManager(){

    }



    /*public void buyMillora(String type) {
        if(type.equals("A")) {
            quanitatMillores[0]++;
            generator.setNumeroMillores(quanitatMillores[0]);
        } else if (type.equals("B")) {
            quanitatMillores[1]++;
            generator.setBaseProduction(type);
        } else if (type.equals("C")) {
            quanitatMillores[2]++;
            generator.setBaseProduction(type);
        } else {
            quanitatMillores[3]++;
            generator.setBaseProduction(type);
        }
    }*/





    public double getCostMillora(String type) {
        if(type.equals("A")){
            return 10.0;
        } else if (type.equals("B")){
            return 20.0;
        } else if (type.equals("C")){
            return 30.0;
        } else if (type.equals("D")){
            return 40.0;
        } else {
            return -1;
        }
    }


    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public Millora getMillores() {
        return millores;
    }

    public void setMillores(Millora millores) {
        this.millores = millores;
    }

    public double getCostMillora() {
        return costMillora;
    }

    public void setCostMillora(double costMillora) {
        this.costMillora = costMillora;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuanitatMillores() {
        return quanitatMillores;
    }

    public void setQuanitatMillores(int quanitatMillores) {
        this.quanitatMillores = quanitatMillores;
    }
}

