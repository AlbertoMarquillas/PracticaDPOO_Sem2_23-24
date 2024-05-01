package Business.Entities;

public class Generator {

    private String type;
    private double costBase;
    private double costActual;
    private double produccio; //cafes / segon
    private double produccioGlobal; //cafes / segon
    private double increment; //increment del cost
    private int quantitat;
    private int numeroMillores;


    public Generator(){}


    public String getType() {
        return type;
    }

    public double getCostBase() {
        return costBase;
    }

    public double getProduccio() {
        return produccio;
    }

    public double getIncrement() {
        return increment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCostBase(double cost) {
        this.costBase = cost;
    }

    public void setProduccio(double produccio) {
        this.produccio = produccio;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public int getQuantitat() {
        return this.quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public double seguentGenerador() {
        setQuantitat(this.quantitat+1);
        return Math.round(getCostBase() * Math.pow(getIncrement(), getQuantitat()));
    }

    public double getCostActual() {
        return costActual;
    }

    public void setCostActual(double costActual) {
        this.costActual = costActual;
    }

    public double getProduccioGlobal() {
        return produccioGlobal;
    }

    public void setProduccioGlobal(double produccioGlobal) {
        this.produccioGlobal = produccioGlobal;
    }

    public int getNumeroMillores() {
        return numeroMillores;
    }

    public void setNumeroMillores(int numeroMillores) {
        this.numeroMillores = numeroMillores;
    }
}
