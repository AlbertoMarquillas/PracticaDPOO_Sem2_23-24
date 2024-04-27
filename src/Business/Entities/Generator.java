package Business.Entities;

public class Generator {

    private String type;
    private int cost;
    private float produccio; //cafes / segon
    private float increment; //increment del cost
    private int quantitat;

    public Generator(String type, int cost, float produccio, float increment) {
        this.type = type;
        this.cost = cost;
        this.produccio = produccio;
        this.increment = increment;
        this.quantitat = 0;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public float getProduccio() {
        return produccio;
    }

    public float getIncrement() {
        return increment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setProduccio(float produccio) {
        this.produccio = produccio;
    }

    public void setIncrement(float increment) {
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
