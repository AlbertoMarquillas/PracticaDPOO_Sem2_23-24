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

    public int updateCost(int ID_P, int ID_G, String type) {
        int i;
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
        }


    }

    public int getCostActual(int i) {
        switch (i) {
            case 1 -> {
                return sqlGeneratorsDAO.getCostActual("A");
            }
            case 2 -> {
                return sqlGeneratorsDAO.getCostActual("B");
            }
            case 3 -> {
                return sqlGeneratorsDAO.getCostActual("C");
            }
            default -> {
                return 0;
            }
        }
    }

    public void initGeneratorPesistance(int ID_P, int ID_G){
        //sqlGeneratorsDAO.initGenerators(ID_P, ID_G);
    }
}
