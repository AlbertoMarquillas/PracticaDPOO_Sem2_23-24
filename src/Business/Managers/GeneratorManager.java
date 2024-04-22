package Business.Managers;

import Persistance.sqlDAO.SQLGeneratorsDAO;

public class GeneratorManager {

    private final SQLGeneratorsDAO sqlGeneratorsDAO;

    public GeneratorManager(SQLGeneratorsDAO sqlGeneratorsDAO) {
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
    }

}
