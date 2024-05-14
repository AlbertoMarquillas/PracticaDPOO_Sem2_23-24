package Presentation.Controller;
import Business.Entities.ComptadorInterficie;
import Business.Entities.Generator;
import Business.Managers.GameManager;
import Business.Managers.GeneratorManager;
import Presentation.View.GameView;
import Business.Managers.MilloraManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameController implements ActionListener, ComptadorInterficie {

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

    public boolean isCameFromGame() {
        return cameFromGame;
    }

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
        if (respuesta == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metode que gestiona les accions dels botons de la vista del joc
     * @param e accio de l'usuari
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int ID_P = gameManager.getConnectedUserId();
        int ID_G = gameManager.getCurrentGameId(gameManager.getConnectedUserId());


        //Habilitar o deshabilitar botons
        gameView.setGameViewButtonsEnabled(gameManager.comprobarHabilitarBotons(ID_P, ID_G));

        String type = null;
        if (e.getActionCommand().equals("settings")) {
            setCameFromGame(true);
            changeViewController.setComptador(false);
            changeViewController.changePan("settings");
        } else if (e.getActionCommand().equals("createcofee")) {
            //if(gameManager.)
            double n_Caffee = 0;
            int value = gameManager.getQuantitatMillores(ID_P, ID_G);
            if(value == 0) {
                n_Caffee = gameManager.getCaffeeNumber() + 1;
            } else {
                n_Caffee = gameManager.getCaffeeNumber() + Math.pow(2, gameManager.getQuantitatMillores(ID_P, ID_G));
            }
            //Guardem en la BBDD la quantitat de cafes actualitzada.
            gameView.setComptador(String.valueOf(Math.round(n_Caffee)));
            gameManager.setQuantitatCafe(n_Caffee);

        }else if (e.getActionCommand().equals("potenciador1")){
            type = "A";

            //Generador nou en la bbdd
            boolean created = generatorManager.buyGenerator(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            if (created) {
                //Update info generador 1
                gameView.updateGenerator1(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProduccioGlobal(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_P, type));
                gameView.updateCostGenerator1(generatorManager.getCostActual(ID_P, ID_G, type));
            }

            gameView.updateComptadorSize(getSizeComp());



            //produccio total de cafes generats

        }else if (e.getActionCommand().equals("potenciador2")){
            type = "B";
            generatorManager.buyGenerator(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            //Update info generador 1
            gameView.updateGenerator2(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getProduccioTotal(ID_P, ID_G, type), generatorManager.getProduccioGlobal(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateCostGenerator2(generatorManager.getCostActual(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());


        }else if (e.getActionCommand().equals("potenciador3")){
            type = "C";
            generatorManager.buyGenerator(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);

            //Update info generador 1
            gameView.updateGenerator3(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getProduccioTotal(ID_P, ID_G, type), generatorManager.getProduccioGlobal(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateCostGenerator3(generatorManager.getCostActual(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("millora1")) {
            type = "A";

            double preu = generatorManager.buyMillora(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.updateCostMillora1(preu);
            gameView.updateGenerator1(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProduccioGlobal(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        }else if (e.getActionCommand().equals("millora2")){
            type = "B";
            generatorManager.buyMillora(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.updateGenerator2(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProduccioGlobal(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());

        } else if (e.getActionCommand().equals("millora3")){
            type = "C";
            generatorManager.buyMillora(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.updateGenerator3(generatorManager.getQuantitatGenerados(ID_P, ID_G, type), generatorManager.getBaseProduction(ID_P, ID_G, type), generatorManager.getProduccioGlobal(ID_P, ID_G, type), generatorManager.updateOverallProduction(ID_P, ID_G, type));
            gameView.updateComptadorSize(getSizeComp());


        }else if (e.getActionCommand().equals("millora4")){
            type = "D";
            gameManager.buyMillores(ID_P, ID_G, type);
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
     * Metode que retorna la quantitat de cafes
     * @return quantitat de cafes
     */
    @Override
    public double getQuantitatCoffe() {
        return 0;
    }

    /**
     * Setter del temps que dura la partida
     * @param time temps que dura la partida
     */
    @Override
    public void setGameTime(long time) {

    }

    /**
     * Getter del temps que dura la partida
     * @return temps que dura la partida
     */
    @Override
    public long getGameTime() {
        return 0;
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

        gameView.updateGenerator3(generatorManager.getQuantitatGenerados(ID_P, ID_G, "C"), generatorManager.getBaseProduction(ID_P, ID_G, "C"), generatorManager.getProduccioGlobal(ID_P, ID_G, "C"), generatorManager.updateOverallProduction(ID_P, ID_G, "C"));
        gameView.updateGenerator2(generatorManager.getQuantitatGenerados(ID_P, ID_G, "B"), generatorManager.getBaseProduction(ID_P, ID_G, "B"), generatorManager.getProduccioGlobal(ID_P, ID_G, "B"), generatorManager.updateOverallProduction(ID_P, ID_G, "B"));
        gameView.updateGenerator1(generatorManager.getQuantitatGenerados(ID_P, ID_G, "A"), generatorManager.getBaseProduction(ID_P, ID_G, "A"), generatorManager.getProduccioGlobal(ID_P, ID_G, "A"), generatorManager.updateOverallProduction(ID_P, ID_G, "A"));

        gameView.updateCostGenerator1(generatorManager.getCostActual(ID_P, ID_G, "A"));
        gameView.updateCostGenerator2(generatorManager.getCostActual(ID_P, ID_G, "B"));
        gameView.updateCostGenerator3(generatorManager.getCostActual(ID_P, ID_G, "C"));
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
        System.out.println("DESDE UPDATE: " + generator1.getProduccioGlobal());
        gameManager.setQuantitatCafe(quantitatCafes);
        gameManager.updateCaffeeGenerators(generator1, generator2, generator3);
        gameView.setGameViewButtonsEnabled(gameManager.comprobarHabilitarBotons(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId())));
        //comprovar si el string tiene mas de cinco caracteres

        gameView.updateComptadorSize(getSizeComp());
        //gameView.updateProduccioTotal(1, generator1.getProduccioActual());
        //gameView.updateProduccioTotal(2, generator2.getProduccioActual());
        //gameView.updateProduccioTotal(3, generator3.getProduccioActual());
        //gameView.updateOverall(1, generatorManager.updateOverallProduction("A"));
        //gameView.updateOverall(2, generatorManager.updateOverallProduction("B"));
        //gameView.updateOverall(3, generatorManager.updateOverallProduction("C"));

    }

    public boolean getSizeComp(){
        double tamany = gameManager.getCaffeeNumber();
        if(tamany >= 1000){
            return true;
        } else {
            return false;
        }

    }

    /**
     * Estableix el comptador d'interfície per al gestor de jocs.
     *
     * @param comptadorInterficie El comptador d'interfície a establir.
     */
    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        gameManager.setComptadorInterficie(comptadorInterficie);
    }
}
