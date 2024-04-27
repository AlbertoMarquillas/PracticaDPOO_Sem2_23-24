package Business.Entities;

public abstract class Generator {

    private String type;
    private double cost;
    private double produccio; //cafes / segon
    private double increment; //increment del cost
    private int quantitat;

    public Generator() {

    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
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

    public void setCost(double cost) {
        this.cost = cost;
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
        return Math.round(getCost() * Math.pow(getIncrement(), getQuantitat()));
    }
}
