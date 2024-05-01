package Business.Managers;

import Business.Entities.Generator;
import Business.Entities.HerenciasGeneradors.Generador1;
import Business.Entities.HerenciasGeneradors.Generador2;
import Business.Entities.HerenciasGeneradors.Generador3;
import Persistance.sqlDAO.SQLGeneratorsDAO;

public class GeneratorManager {

    private final SQLGeneratorsDAO sqlGeneratorsDAO;


    public GeneratorManager(SQLGeneratorsDAO sqlGeneratorsDAO) {
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
    }

    public double incrementarPotenciador(int i) {
        int quantitat = 0;
        Generator generator = null;
        if (i == 1) {
            quantitat = sqlGeneratorsDAO.getQuantitatGeneradors("A");
            sqlGeneratorsDAO.actualitzarQuantitat(quantitat + 1, "A");
            generator = new Generador1();
        }else if (i == 2) {
            quantitat = sqlGeneratorsDAO.getQuantitatGeneradors("B");
            sqlGeneratorsDAO.actualitzarQuantitat(quantitat + 1, "B");
            generator = new Generador2();
        }else if (i == 3) {
            quantitat = sqlGeneratorsDAO.getQuantitatGeneradors("C");
            sqlGeneratorsDAO.actualitzarQuantitat(quantitat + 1, "C");
            generator  = new Generador3();
        }
        generator.setQuantitat(quantitat);
        double cost = generator.seguentGenerador();
        generator.setCost(cost);
        return cost;
    }

    public int getQuantitatGenerados(int i) {
        switch (i) {
            case 1 -> {
                return sqlGeneratorsDAO.getQuantitatGeneradors("A");
            }
            case 2 -> {
                return sqlGeneratorsDAO.getQuantitatGeneradors("B");
            }
            case 3 -> {
                return sqlGeneratorsDAO.getQuantitatGeneradors("C");
            }
            default -> {
                return 0;
            }
        }
    }



    public int getCost(int i) {
        switch (i) {
            case 1 -> {
                return sqlGeneratorsDAO.getCost("A");
            }
            case 2 -> {
                return sqlGeneratorsDAO.getCost("B");
            }
            case 3 -> {
                return sqlGeneratorsDAO.getCost("C");
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

    public void initGeneratorPesistance(int ID_P, int ID_U){
        sqlGeneratorsDAO.initGenerators(ID_P, ID_U);
    }
}
