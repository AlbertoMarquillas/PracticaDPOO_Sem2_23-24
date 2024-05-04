package Business.Entities;

public class Generator {

    private String type;
    private int quantitat;
    private double increment; //Variable prescindible (incrementBase * quantitat) "Pendent de valorar"
    private double produccioActual; //cafes que genera cada generador!!!! (NO EL QUE GENEREN ENTRE TOTS els d'un mateix tipus)
    private double produccioGlobal; //produccioGlobal = produccio x quantitat de generadors
    private int numeroMillores;


    public Generator(){}

    public double getCostBase() {
        // Implementación por defecto (puede lanzar una excepción o devolver un valor por defecto)
        throw new UnsupportedOperationException();
    }

    public String getType() {
        return type;
    }

    public double getProduccioActual() {
        return produccioActual;
    }

    public double getIncrement() {
        return increment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProduccioActual(double produccioActual) {
        this.produccioActual = produccioActual;
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


    public void getCurrentCost() {
        //return costBase * Math.pow(increment, quantitat);
    }


}
