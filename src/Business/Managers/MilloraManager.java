package Business.Managers;

import Business.Entities.Millora;

public class MilloraManager {

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
    

    public void buyMillora(String type) {
        if(type.equals("A")) {
            quanitatMillores[0]++;
        } else if (type.equals("B")) {
            quanitatMillores[1]++;
        } else if (type.equals("C")) {
            quanitatMillores[2]++;
        } else {
            quanitatMillores[3]++;
        }
    }

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

    public double[] getCostMillora() {
        return costMillora;
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

