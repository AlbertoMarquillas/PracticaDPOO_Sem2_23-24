package Business.Entities;

public class Generator {
    private String type;
    private int quantitat;
    private double increment;
    private double produccioActual;
    private double produccioGlobal;
    private int numeroMillores;
    private double costActual;
    private double incrementCost; // Nueva variable
    private double baseCost; // Nueva variable
    private double baseProduction; // Nueva variable

    public Generator(String type, int quantitat, double produccioActual, double produccioGlobal, int numeroMillores) {
        this.type = type;
        this.quantitat = quantitat;
        this.produccioActual = produccioActual;
        this.produccioGlobal = produccioGlobal;
        this.numeroMillores = numeroMillores;
        this.incrementCost = setIncrement(type);
        this.baseCost = setBaseCost(type);
        this.costActual = setCostActual(type);
        this.baseProduction = setBaseProduction(type);

    }
    public double setIncrement(String type) {
        if (type.equals("A")) {
            return 1.07;
        } else if (type.equals("B")) {
            return 1.15;
        } else if (type.equals("C")) {
            return 1.12;
        } else {
            return 1000000.0;
        }
    }
    public double setBaseCost(String type) {
        if (type.equals("A")) {
            return 10.0;
        } else if (type.equals("B")) {
            return 150.0;
        } else if (type.equals("C")) {
            return 2000.0;
        } else {
            return 1000000.0;
        }
    }
    public double setCostActual(String type) {
        return Math.round(baseCost * Math.pow(incrementCost, quantitat));
    }

    public double setBaseProduction(String type) {
        if (type.equals("A")) {
            return 0.2;
        } else if (type.equals("B")) {
            return 1.0;
        } else if (type.equals("C")) {
            return 15.0;
        } else {
            return 1000000.0;
        }
    }

    public double getProduccioActual() {
        return this.produccioActual;
    }

    public double getQuantitat() {
        return quantitat;
    }

    public void setProduccioActual() {
        this.produccioActual = baseProduction * Math.pow(increment, quantitat);
    }

    public void buyGenerator() {
        this.quantitat++;
        this.costActual = baseCost * Math.pow(incrementCost, quantitat);
    }

    public String getCostActualString() {
        return String.valueOf(costActual);
    }

    public String getProduccioGlobalString() {
        return String.valueOf(produccioGlobal);
    }

    public String getNumMilloresString() {
        return String.valueOf(numeroMillores);
    }

    public double getGeneratorCost() {
        return this.costActual;
    }

    public double getProduccioTotal() {
        return this.produccioGlobal;
    }

    public void setProduccioTotal(double generat) {
        this.produccioGlobal = this.produccioGlobal + generat;
    }

    public String getTypeString() {
        return this.type;
    }

    /*
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
*/

}
