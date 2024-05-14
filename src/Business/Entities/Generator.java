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
    private Millora millora;

    /**
     * Constructor de la clase Generator
     * @param type tipo de generador
     * @param quantitat quantitat de generadors
     * @param produccioActual producció actual del generador
     * @param produccioGlobal producció global del generador
     * @param numeroMillores número de millores comprades pel generador
     */
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

    /**
     * Setter que setteja l'increment del cost del generador
     * @param type tipus de generador
     * @return increment de cost
     */
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

    /**
     * Setter que setteja el cost base del generador
     * @param type tipus de generador
     * @return cost base
     */
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

    /**
     * Setter que indica el cost actual del generador
     * @param type tipus de generador
     * @return cost actual
     */
    public double setCostActual(String type) {
        return Math.round(baseCost * Math.pow(incrementCost, quantitat));
    }


    /**
     * Setter que indica la producció base del generador
     * @param type tipus de generador
     * @return producció base
     */
    public double setBaseProduction(String type) {
        double baseProduction;
        if (type.equals("A")) {
            baseProduction = 0.2;
        } else if(type.equals("B")) {
            baseProduction = 1.0;
        } else if (type.equals("C")) {
            baseProduction = 15.0;
        } else {
            baseProduction = -1;
        }

        if (numeroMillores > 0) {
            baseProduction = baseProduction * Math.pow(2, numeroMillores);
        }

        this.baseProduction = baseProduction;
        return this.baseProduction;
    }

    public double getBaseProduction() {
        return this.baseProduction;
    }


    /**
     * Getter que retorna la producció actual del generador
     * @return producció actual
     */
    public double getProduccioActual() {
        this.produccioActual = baseProduction * quantitat;
        return produccioActual;
    }

    /**
     * Getter que retorna la quantitat de generadors
     * @return quantitat
     */
    public double getQuantitat() {
        return quantitat;
    }


    /**
     * Setter que calcula la producció actual del generador
     * @return cost actual
     */
    public double setProduccioActual() {
        this.produccioActual = baseProduction * quantitat;
        return this.produccioActual;
    }

    public double getProduccioGlobal() {
        return this.produccioGlobal;
    }

    public void setProduccioGlobal(double produccioGlobal) {
        this.produccioGlobal = produccioGlobal;
    }

    /**
     * Funció que incrementa la quantitat de generadors i el cost actual quan es compra un
     */
    public void buyGenerator() {
        this.quantitat++;
        this.costActual = baseCost * Math.pow(incrementCost, quantitat);
    }

    /**
     * Getter que retorna el cost actual del generador
     * @return cost actual
     */
    public String getCostActualString() {
        return String.valueOf(costActual);
    }


    /**
     * Getter que retorna la producció global del generador
     * @return producció global
     */
    public String getProduccioGlobalString() {
        return String.valueOf(produccioGlobal);
    }


    /**
     * Getter que retorna el número de millores associades al generador
     * @return número de millores
     */
    public String getNumMilloresString() {
        return String.valueOf(numeroMillores);
    }

    public int getNumeroMillores() {
        return numeroMillores;
    }

    public void setNumeroMillores(int numeroMillores) {
        this.numeroMillores = numeroMillores;
    }


    /**
     * Getter per obtenir el cost actual del generador
     * @return cost actual
     */
    public double getGeneratorCost() {
        return this.costActual;
    }


    /**
     * Getter per obtenir la producció global del generador
     * @return producció global
     */
    public double getProduccioTotal() {
        return this.produccioGlobal;
    }


    /**
     * Setter per incrementar la producció global del generador
     * @param generat quantitat de cafes que el generador ja ha generat
     */
    public void setProduccioTotal(double generat) {
        this.produccioGlobal = this.produccioGlobal + generat;
    }

    /**
     * Getter que retorna el tipus de generador
     * @return tipus de generador
     */
    public String getTypeString() {
        return this.type;
    }

    public void setNewMillora() {
        this.numeroMillores = this.numeroMillores + 1;
        this.baseProduction = setBaseProduction(this.type);
        this.produccioActual = setProduccioActual();
    }


    public int getOverallProduction(double totalProduction) {
        if (this.produccioActual == 0){
            return 0;
        }
        else{
            return (int) Math.round((this.produccioActual / totalProduction) * 100);
        }

    }
}
