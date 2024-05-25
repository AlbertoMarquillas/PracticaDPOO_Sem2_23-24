package Business.Entities;

/**
 * Classe que representa un generador
 */
public class Generator {
    private String type;
    private int quantitat;
    private double produccioActual;
    private double produccioGlobal;
    private int numeroMillores;
    private double costActual;
    private double incrementCost; // Nueva variable
    private double baseCost; // Nueva variable
    private double baseProduction; // Nueva variable

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
        this.costActual = setCostActual();
        this.baseProduction = setBaseProduction(type);
    }

    /**
     * Setter que setteja l'increment del cost del generador
     * @param type tipus de generador
     * @return increment de cost
     */
    public double setIncrement(String type) {
        return switch (type) {
            case "A" -> 1.07;
            case "B" -> 1.15;
            case "C" -> 1.12;
            default -> 1000000.0;
        };
    }

    /**
     * Setter que setteja el cost base del generador
     * @param type tipus de generador
     * @return cost base
     */
    public double setBaseCost(String type) {
        return switch (type) {
            case "A" -> 10.0;
            case "B" -> 150.0;
            case "C" -> 2000.0;
            default -> 1000000.0;
        };
    }

    /**
     * Setter que indica el cost actual del generador
     * @return cost actual
     */
    public double setCostActual() {
        return Math.round(baseCost * Math.pow(incrementCost, quantitat));
    }


    /**
     * Setter que indica la producció base del generador
     * @param type tipus de generador
     * @return producció base
     */
    public double setBaseProduction(String type) {
        double baseProduction = switch (type) {
            case "A" -> 0.2;
            case "B" -> 1.0;
            case "C" -> 15.0;
            default -> -1;
        };

        if (numeroMillores > 0) {
            baseProduction = baseProduction * Math.pow(2, numeroMillores);
        }

        this.baseProduction = baseProduction;
        return this.baseProduction;
    }

    /**
     * Funció que retorna la produccio base del generador
     * @return produccio base del generador
     */
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

    /**
     * Funcio que retorna la producció global del generador
     * @return double produccio del generador
     */
    public double getProduccioGlobal() {
        return this.produccioGlobal;
    }

    /**
     * Funcio per indicar quina es la produccio global del generador
     * @param produccioGlobal un double que indica la produccio global del generador
     */
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

    /**
     * Getter que retorna el número de millores que té un generador
     * @return int amb el número de millores
     */
    public int getNumeroMillores() {
        return numeroMillores;
    }


    /**
     * Getter per obtenir el cost actual del generador
     * @return cost actual
     */
    public double getGeneratorCost() {
        return this.costActual;
    }

    /**
     * Getter que retorna el tipus de generador
     * @return tipus de generador
     */
    public String getTypeString() {
        return this.type;
    }

    /**
     * Fucnio que aumenta les millores en una
     */
    public void setNewMillora() {
        this.numeroMillores = this.numeroMillores + 1;
        this.baseProduction = setBaseProduction(this.type);
        this.produccioActual = setProduccioActual();
    }

    /**
     * Funcio que serveix per retornar la produccio global del generador, si la produccio  acutal es 0 retorna 0
     * @param totalProduction la produccio total del generador
     * @return int que indica la produccio global
     */
    public int getOverallProduction(double totalProduction) {
        if (this.produccioActual == 0){
            return 0;
        }
        else{
            return (int) Math.round((this.produccioActual / totalProduction) * 100);
        }

    }

    /**
     * Crea una nova millora
     * @return una millora
     */
    public Millora getMillora() {
        return new Millora(this.type, this.numeroMillores);
    }
}
