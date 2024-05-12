package Business.Managers;

import Business.Entities.Generator;
import Business.Entities.Millora;


public class MilloraManager {
    Generator generator;
    private Millora[] millores;
    double[] costMillora = {10.0, 20.0, 30.0, 40.0};
    String[] types = {"A", "B", "C", "D"};
    int[] quanitatMillores = {0, 0, 0, 0};

    public MilloraManager () {
        millores = new Millora[4];
        millores[0] = new Millora("A", 10.0, 0);
        millores[1] = new Millora("A", 20.0, 0);
        millores[2] = new Millora("A", 30.0, 0);
        millores[3] = new Millora("A", 40.0, 0);
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

    public int getQuantitatMillores(String type) {
        if(type.equals("A")) {
            return quanitatMillores[0];
        } else if (type.equals("B")) {
            return quanitatMillores[1];
        } else if (type.equals("C")) {
            return quanitatMillores[2];
        } else if (type.equals("D")){
            return quanitatMillores[3];
        } else {
            return 0;
        }
    }

    public Millora[] getMillores() {
        return millores;
    }

    public void setMillores(Millora[] millores) {
        this.millores = millores;
    }

    public double getCostMillora(String type) {
        if(type.equals("A")){
            return costMillora[0];
        } else if (type.equals("B")){
            return costMillora[1];
        } else if (type.equals("C")){
            return costMillora[2];
        } else if (type.equals("D")){
            return costMillora[3];
        } else {
            return -1;
        }
    }

    public void setCostMillora(double[] costMillora) {
        this.costMillora = costMillora;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public int[] getQuanitatMillores() {
        return quanitatMillores;
    }

    public void setQuanitatMillores(int[] quanitatMillores) {
        this.quanitatMillores = quanitatMillores;
    }
}

