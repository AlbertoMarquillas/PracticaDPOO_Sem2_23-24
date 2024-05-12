package Business.Managers;

import Business.Entities.Generator;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLGameDAO; //NO SE SI AIXO ES POT FEEER !!!!!!!!!!!!!

import java.util.Objects;

public class GeneratorManager {
    private final SQLGeneratorsDAO sqlGeneratorsDAO;
    private final SQLGameDAO sqlGameDAO; //NO SE SI AIXO ES POR FER !!!!!!!!!!!!!!!

    String[] types = {"A", "B", "C"};
    int[] costBase = {10, 150, 2000};
    double[] baseProduction = {0.2, 1.0, 15.0};
    double[] incrementDeCost = {1.07, 1.15, 1.12};

    public GeneratorManager(SQLGeneratorsDAO sqlGeneratorsDAO, SQLGameDAO sqlGameDAO) {
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
        this.sqlGameDAO = sqlGameDAO; //!!!!!!!!!!!!!!!!!!!!!
    }

    /*
    public double incrementarPotenciador(int ID_P, int ID_G, String type) {
        int quantitat = 0;
        Generator generator = null;
        sqlGeneratorsDAO.getQuantitatGeneradors(ID_P, ID_G, type);
        sqlGeneratorsDAO.actualitzarQuantitat(quantitat + 1, ID_P, ID_G, type);
        generator = GeneratorFactory.createGenerator(type);

        generator.setQuantitat(quantitat);

        double cost = generator.seguentGenerador();
        generator.setCostBase(cost);
        return cost;
    }
    */

    public int getQuantitatGenerados(int ID_P, int ID_G, String type) {
        if(Objects.equals(type, "A") || Objects.equals(type, "B") || Objects.equals(type, "C")) {
            return sqlGeneratorsDAO.getQuantitatGeneradors(ID_P, ID_G, type);
        } else {
            return 0;
        }
    }

    public int updateQuantitatGeneradors(int ID_P, int ID_G, String type){
        int quantitat = getQuantitatGenerados(ID_P, ID_G, type) +1;
        sqlGeneratorsDAO.actualitzarQuantitat(quantitat, ID_P, ID_G, type);
        return quantitat;
    }


    public float updateOverallProduction(int ID_P, int ID_G, String type){
        //Editar a la base de dades el valor overall -> Falten totes les funcions
        return (float) (100 * (sqlGeneratorsDAO.getProduccioActual(type) / sqlGameDAO.getNCoffees(ID_P, ID_G)));

    }



    public int getCost(int i) {
        switch (i) {
            case 1 -> {
                return costBase[0];
            }
            case 2 -> {
                return costBase[1];
            }
            case 3 -> {
                return costBase[2];
            }
            default -> {
                return 0;
            }
        }
    }

    public double getCostGenerator(int ID_P, int ID_G, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);
        double costGenerator = generator.getGeneratorCost();
        costGenerator = Math.round(costGenerator * 100.0) / 100.0;
        return costGenerator;

        /*int i;
        double increment;
        if(Objects.equals(type, "A")){
            i = 0;
        } else if (Objects.equals(type, "B")){
            i = 1;
        } else if (Objects.equals(type, "C")){
            i = 2;
        } else {
            i = 3;
        }

        if(i < 3) {
            increment = costBase[i] * Math.pow(incrementDeCost[i], getQuantitatGenerados(ID_P, ID_G, type));
            sqlGeneratorsDAO.updateCost(increment, type);
            return (int) Math.round(increment);
        } else {
            return 0;
        }*/


    }

    public double getCostActual(int ID_p, int ID_G, String type) {
        return sqlGeneratorsDAO.getCostActual(ID_p, ID_G, type);
    }

    public void initGeneratorPesistance(int ID_P, int ID_G){
        sqlGeneratorsDAO.initGenerators(ID_P, ID_G);
    }

    public boolean buyGenerator(int ID_P, int ID_G, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);
        double costGenerator = generator.getGeneratorCost();
        if (sqlGameDAO.getNCoffees(ID_P, ID_G) >= costGenerator) {
            sqlGeneratorsDAO.buyGenerator(ID_P, ID_G, type, generator);
            sqlGameDAO.setNCoffees(ID_P, ID_G, sqlGameDAO.getNCoffees(ID_P, ID_G) - costGenerator);
            return true;
        } else {
            return false;
        }
    }

    public double getProduccioTotal(int ID_P, int ID_G, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);
        return generator.getProduccioActual();
    }

    public double getProdActual(int ID_P, int ID_G, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);
        return generator.getProduccioTotal();
    }

    public int getQuantitatMillores(int ID_P, int ID_G, String type) {
        return sqlGeneratorsDAO.getNumMillores(type);
    }


    public void buyMillora(int ID_P, int ID_G, String type){
        int n_millores = sqlGeneratorsDAO.getNumMillores(type) + 1;
        sqlGeneratorsDAO.setNumMillores(n_millores, type);


        if(n_millores != 0) {
            if (type.equals("A")) {
                double produccioActualiztada = costBase[0] * 2 * n_millores;
                sqlGeneratorsDAO.setProduccioActual(produccioActualiztada, type);
            } else if (type.equals("B")) {
                double produccioActualiztada = costBase[1] * 2 * n_millores;
                sqlGeneratorsDAO.setProduccioActual(produccioActualiztada, type);
            } else if (type.equals("C")) {
                double produccioActualiztada = costBase[2] * 2 * n_millores;
                sqlGeneratorsDAO.setProduccioActual(produccioActualiztada, type);
            }
        }
    }
}
