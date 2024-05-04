package Business.Managers;

import Business.Entities.Generator;
import Persistance.sqlDAO.SQLGeneratorsDAO;

public class GeneratorManager {

    private final SQLGeneratorsDAO sqlGeneratorsDAO;

    String[] types = {"A", "B", "C"};
    int[] costBase = {10, 150, 2000};
    double[] baseProduction = {0.2, 1.0, 15.0};
    double[] incrementDeCost = {1.07, 1.15, 1.12};

    public GeneratorManager(SQLGeneratorsDAO sqlGeneratorsDAO) {
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
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
        switch (type) {
            case "A" -> {
                return sqlGeneratorsDAO.getQuantitatGeneradors(ID_P, ID_P, type);
            }
            case "B" -> {
                return sqlGeneratorsDAO.getQuantitatGeneradors(ID_P, ID_P, type);
            }
            case "C" -> {
                return sqlGeneratorsDAO.getQuantitatGeneradors(ID_P, ID_P, type);
            }
            default -> {
                return 0;
            }
        }
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

    public void updateCost(int i, double incrementarPotenciador) {
        switch (i) {
            case 1 -> {
                sqlGeneratorsDAO.updateCost(incrementarPotenciador, "A");
            }
            case 2 -> {
                sqlGeneratorsDAO.updateCost(incrementarPotenciador, "B");
            }
            case 3 -> {
                sqlGeneratorsDAO.updateCost(incrementarPotenciador, "C");
            }
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
        sqlGeneratorsDAO.initGenerators(ID_P, ID_G);
    }
}
