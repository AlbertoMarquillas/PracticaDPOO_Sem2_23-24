package Business.Entities;

public class Millora {

    private String type;
    private double preu; //cost del valor de millora
    private int quantitat;

    public Millora(String type, int quantitat) {
        this.type = type;
        this.preu = setPreu(type);
        this.quantitat = quantitat;
    }

    public double setPreu(String type){
        if (type.equals("A")) {
            return 10.0;
        } else if (type.equals("B")) {
            return 20.0;
        } else if (type.equals("C")) {
            return 30.0;
        } else if(type.equals("D")){
            return 40.0;
        } else {
            return -1;
        }
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat() {
        this.quantitat = 0;
    }

    public void buyMillora(){
        this.quantitat++;
    }

}
