package Presentation.Controller;
import Business.Entities.DadesInterficie;
import Business.Entities.Generator;
import Business.Entities.Millora;
import Business.Managers.GameManager;
import Business.Managers.GeneratorManager;
import Presentation.View.GameView;
import Business.Managers.MilloraManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Classe que gestiona les accions de la vista de la partida.
 */
public class GameController implements ActionListener, DadesInterficie {

    public final ChangeViewController changeViewController;
    private final GameView gameView;
    private final GeneratorManager generatorManager;

    private final GameManager gameManager;

    private final MilloraManager milloraManager;
    private boolean cameFromGame = false;
    /**
     * Constructor de la clase GameController
     * @param changeViewController control de la vista del joc
     * @param gameView  vista de la pantalla principal del joc
     * @param generatorManager manager dels generadors
     * @param gameManager manager del joc
     */
    public GameController(ChangeViewController changeViewController, GameView gameView, GeneratorManager generatorManager, GameManager gameManager, MilloraManager milloraManager) {
        this.changeViewController = changeViewController;
        this.gameView = gameView;
        this.generatorManager = generatorManager;
        this.gameManager = gameManager;
        this.milloraManager = milloraManager;
    }


    /**
     * Comprova si l'usuari ha vingut des d'una partida.
     *
     * @return true si l'usuari ha vingut des d'una partida; false altrament.
     */
    public boolean isCameFromGame() {
        return cameFromGame;
    }


    /**
     * Estableix si l'usuari ha vingut des d'una partida.
     *
     * @param cameFromGame true si l'usuari ha vingut des d'una partida; false altrament.
     */
    public void setCameFromGame(boolean cameFromGame) {
        this.cameFromGame = cameFromGame;
    }

    /**
     * Metode que mostra un dialeg de confirmació
     * @param message missatge a mostrar
     * @return true si es vol sortir, false si no
     */
    private boolean showConfirmationDialog(String message) {
        int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    /**
     * Metode que gestiona les accions dels botons de la vista del joc
     * @param e accio de l'usuari
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int ID_P = gameManager.getConnectedUserId();
        int ID_G = gameManager.getCurrentGameId(gameManager.getConnectedUserId());
        gameView.setCostMillora1(milloraManager.getCostMillora("A"));

        //Habilitar o deshabilitar botons
        gameView.setGameViewButtonsEnabled(gameManager.comprobarHabilitarBotons(ID_P, ID_G));

        String type = null;
        if (e.getActionCommand().equals("settings")) {
            setCameFromGame(true);
            changeViewController.setComptador(false);
            changeViewController.changePan("settings");
        } else if (e.getActionCommand().equals("createcofee")) {
            double n_Caffee = 0;
            int value = gameManager.getQuantitatMillores(ID_P, ID_G);
            if(value == 0) {
                n_Caffee = gameManager.getCaffeeNumber() + 1;
            } else {
                n_Caffee = gameManager.getCaffeeNumber() + Math.pow(2, gameManager.getQuantitatMillores(ID_P, ID_G));
            }
            gameView.setGameViewButtonsEnabled(gameManager.comprobarHabilitarBotons(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId())));
            //Guardem en la BBDD la quantitat de cafes actualitzada.
            gameView.setComptador(String.valueOf(Math.round(n_Caffee)));
            gameManager.setQuantitatCafe(n_Caffee);

        }else if (e.getActionCommand().equals("potenciador1")){
            type = "A";

            //Generador nou en la bbdd
            boolean created = generatorManager.buyGenerator(ID_P, ID_G, type);
            if (created) {
                gameView.updateGenerator1(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProdActual(ID_P, ID_G, type), generatorManager.updateOverallProduction(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), "A"));
                gameView.updateCostGenerator1(generatorManager.getCostActual(ID_P, ID_G, type));
            }

            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("potenciador2")){
            type = "B";
            generatorManager.buyGenerator(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);

            //Update info generador 1
            gameView.updateGenerator2(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProdActual(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateCostGenerator2(generatorManager.getCostActual(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("potenciador3")){
            type = "C";
            generatorManager.buyGenerator(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);

            //Update info generador 1
            gameView.updateGenerator3(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProdActual(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateCostGenerator3(generatorManager.getCostActual(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("millora1")) {
            type = "A";

            double preu = generatorManager.buyMillora(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.updateCostMillora1(preu);
            gameView.updateGenerator1(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProdActual(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("millora2")){
            type = "B";
            generatorManager.buyMillora(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.updateGenerator2(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProdActual(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        } else if (e.getActionCommand().equals("millora3")){
            type = "C";
            generatorManager.buyMillora(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.updateGenerator3(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProdActual(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("millora4")){
            type = "D";
            gameManager.buyMilloresPowerUpClicker(ID_P, ID_G, type);
            gameView.updateComptadorSize(getSizeComp());

        } else if (e.getActionCommand().equals("finish")){
            changeViewController.setComptador(false);
            boolean exit = showConfirmationDialog("Do you want to finish the game?");
            if(exit){
                gameManager.setEndeGame();
                gameManager.disconnectUser();
                changeViewController.changePan("login");
            } else {
                changeViewController.setComptador(true);
                changeViewController.changePan("game");
            }

        } else if (e.getActionCommand().equals("save")){
            changeViewController.setComptador(false);
            boolean exit = showConfirmationDialog("Do you want to save the game?");
            if(exit){
                gameManager.disconnectUser();
                changeViewController.changePan("login");
            } else {
                changeViewController.setComptador(true);
                changeViewController.changePan("game");
            }
        }
    }


    /**
     * Actualitza la taula de contingut a la vista del joc amb les dades proporcionades pels generadors especificats.
     *
     * @param generador1 El primer generador a considerar.
     * @param generador2 El segon generador a considerar.
     * @param generador3 El tercer generador a considerar.
     */
    @Override
    public void setTaulaContenido(Generator generador1, Generator generador2, Generator generador3) {
        int ID_P = gameManager.getConnectedUserId();
        int ID_G = gameManager.getCurrentGameId(gameManager.getConnectedUserId());

        gameView.updateGenerator3(generatorManager.getQuantitatGenerados(ID_P, ID_G, "C"), generatorManager.getBaseProduction(ID_P, ID_G, "C"), generatorManager.getProdActual(ID_P, ID_G, "C"), generatorManager.updateOverallProduction(ID_P, ID_G, "C"));
        gameView.updateGenerator2(generatorManager.getQuantitatGenerados(ID_P, ID_G, "B"), generatorManager.getBaseProduction(ID_P, ID_G, "B"), generatorManager.getProdActual(ID_P, ID_G, "B"), generatorManager.updateOverallProduction(ID_P, ID_G, "B"));
        gameView.updateGenerator1(generatorManager.getQuantitatGenerados(ID_P, ID_G, "A"), generatorManager.getBaseProduction(ID_P, ID_G, "A"), generatorManager.getProdActual(ID_P, ID_G, "A"), generatorManager.updateOverallProduction(ID_P, ID_G, "A"));

        gameView.updateCostGenerator1(generatorManager.getCostActual(ID_P, ID_G, "A"));
        gameView.updateCostGenerator2(generatorManager.getCostActual(ID_P, ID_G, "B"));
        gameView.updateCostGenerator3(generatorManager.getCostActual(ID_P, ID_G, "C"));
    }

    /**
     * Actualitza les millores de la vista del joc amb les dades proporcionades.
     * @param millora1 primera millora
     * @param millora2 segona millora
     * @param millora3 tercera millora
     * @param millora4 cuarta millora
     */
    @Override
    public void setMillores(Millora millora1, Millora millora2, Millora millora3, Millora millora4) {

        gameView.updateCostMillora1(millora1.getPreu());
        gameView.updateCostMillora2(millora2.getPreu());
        gameView.updateCostMillora3(millora3.getPreu());
        gameView.updateCostMillora4(millora4.getPreu());
    }


    /**
     * Metode que actualitza la quantitat de cafes
     * @param quantitatCafes quantitat de cafes
     * @param generator1 generador1 del joc
     * @param generator2 generador2 del joc
     * @param generator3 generador3 del joc
     */
    @Override
    public void updateQuantitatCoffe(double quantitatCafes, Generator generator1, Generator generator2, Generator generator3) {
        gameView.setComptador(String.valueOf(Math.round(quantitatCafes)));
        gameManager.setQuantitatCafe(quantitatCafes);
        gameManager.updateCaffeeGenerators(generator1, generator2, generator3);
        gameView.setGameViewButtonsEnabled(gameManager.comprobarHabilitarBotons(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId())));
        gameView.updateComptadorSize(getSizeComp());

    }


    /**
     * Obté la mida de la competició.
     *
     * @return true si la mida de la competició és superior o igual a 1000; false altrament.
     */
    public boolean getSizeComp(){
        double tamany = gameManager.getCaffeeNumber();
        return tamany >= 1000;
    }


    /**
     * Estableix el comptador d'interfície per al gestor de jocs.
     *
     * @param dadesInterficie El comptador d'interfície a establir.
     */
    public void setComptadorInterficie(DadesInterficie dadesInterficie) {
        gameManager.setComptadorInterficie(dadesInterficie);
    }
}
