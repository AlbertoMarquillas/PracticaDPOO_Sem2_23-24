package Business.Managers;

import Business.Entities.Generator;
import Business.Entities.Millora;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLGameDAO;

import java.util.Objects;

/**
 * La classe GeneratorManager gestiona les operacions relacionades amb els generadors, com ara recuperar dades, actualitzar la producció, comprar generadors i millores.
 */
public class GeneratorManager {
    private final SQLGeneratorsDAO sqlGeneratorsDAO;
    private final SQLGameDAO sqlGameDAO;

    /**
     * Construeix un objecte GeneratorManager amb els SQLGeneratorsDAO i SQLGameDAO especificats.
     *
     * @param sqlGeneratorsDAO el DAO per gestionar les dades relacionades amb els generadors.
     * @param sqlGameDAO       el DAO per gestionar les dades relacionades amb el joc.
     */
    public GeneratorManager(SQLGeneratorsDAO sqlGeneratorsDAO, SQLGameDAO sqlGameDAO) {
        this.sqlGeneratorsDAO = sqlGeneratorsDAO;
        this.sqlGameDAO = sqlGameDAO;
    }

    /**
     * Recupera la quantitat de generadors del tipus especificat per al jugador i el joc donats.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de generador.
     * @return la quantitat de generadors del tipus especificat.
     */
    public int getQuantitatGenerados(int ID_P, int ID_G, String type) {
        if (Objects.equals(type, "A") || Objects.equals(type, "B") || Objects.equals(type, "C")) {
            return sqlGeneratorsDAO.getQuantitatGeneradors(ID_P, ID_G, type);
        } else {
            return 0;
        }
    }

    /**
     * Actualitza la producció global basada en la producció actual de tots els generadors.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de generador.
     * @return la producció global actualitzada.
     */
    public double updateOverallProduction(int ID_P, int ID_G, String type) {
        Generator generatorA = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, "A");
        Generator generatorB = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, "B");
        Generator generatorC = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, "C");

        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);

        double totalProduction = generatorA.getProduccioActual() + generatorB.getProduccioActual() + generatorC.getProduccioActual();
        return generator.getOverallProduction(totalProduction);
    }

    /**
     * Recupera el cost actual del tipus de generador especificat per al jugador i la sessió de joc donats.
     *
     * @param ID_p l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de generador.
     * @return el cost actual del generador.
     */
    public double getCostActual(int ID_p, int ID_G, String type) {
        return sqlGeneratorsDAO.getCostActual(ID_p, ID_G, type);
    }

    /**
     * Inicialitza la persistència dels generadors per al jugador i la sessió de joc donats.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     */
    public void initGeneratorPesistance(int ID_P, int ID_G) {
        sqlGeneratorsDAO.initGenerators(ID_P, ID_G);
    }

    /**
     * Compra un generador del tipus especificat per al jugador i la sessió de joc donats.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de generador a comprar.
     * @return true si el generador s'ha comprat amb èxit, false altrament.
     */
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

    /**
     * Recupera la producció actual del tipus de generador especificat per al jugador i la sessió de joc donats.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de generador.
     * @return la producció actual del generador.
     */
    public double getProdActual(int ID_P, int ID_G, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);
        return generator.getProduccioActual();
    }

    /**
     * Compra una millora per al tipus de generador especificat per al jugador i la sessió de joc donats.
     *
     * @param ID_P l'ID del jugador.
     * @param ID_G l'ID de la sessió de joc.
     * @param type el tipus de generador.
     * @return el cost de la millora si s'ha comprat amb èxit, -1 altrament.
     */
    public double buyMillora(int ID_P, int ID_G, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(ID_P, ID_G, type);
        int n_millores = generator.getNumeroMillores();
        Millora millora = new Millora(type, n_millores);

        if ((sqlGameDAO.getNCoffees(ID_P, ID_G) >= millora.getPreu())) {
            generator.setNewMillora();
            sqlGeneratorsDAO.updateMilloresAndProduccioActual(ID_P, ID_G, generator);
            sqlGameDAO.setNCoffees(ID_P, ID_G, sqlGameDAO.getNCoffees(ID_P, ID_G) - millora.getPreu());

            return millora.getPreu();
        } else {
            return -1;
        }
    }

    /**
     * Recupera la producció base del tipus de generador especificat.
     *
     * @param idP  l'ID del jugador.
     * @param idG  l'ID de la sessió de joc.
     * @param type el tipus de generador.
     * @return la producció base del generador.
     */

    public double getBaseProduction(int idP, int idG, String type) {
        Generator generator = sqlGeneratorsDAO.getGenerator(idP, idG, type);
        return generator.getBaseProduction();
    }
}
