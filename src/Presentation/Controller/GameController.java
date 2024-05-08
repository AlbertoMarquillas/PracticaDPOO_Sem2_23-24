package Presentation.Controller;
import Business.Entities.ComptadorInterficie;
import Business.Managers.GameManager;
import Business.Managers.GeneratorManager;
import Presentation.View.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener, ComptadorInterficie {

    public final ChangeViewController changeViewController;
    private final GameView gameView;
    private final GeneratorManager generatorManager;

    private final GameManager gameManager;

    public GameController(ChangeViewController changeViewController, GameView gameView, GeneratorManager generatorManager, GameManager gameManager) {
        this.changeViewController = changeViewController;
        this.gameView = gameView;
        this.generatorManager = generatorManager;
        this.gameManager = gameManager;
    }

    private boolean showConfirmationDialog(String message) {
        int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type = null;
        if (e.getActionCommand().equals("settings")) {
            changeViewController.setComptador(false);
            changeViewController.changePan("settings");
        } else if (e.getActionCommand().equals("createcofee")) {
            double n_Caffee = gameManager.getCaffeeNumber() + 1;
            //Guardem en la BBDD la quantitat de cafes actualitzada.
            updateQuantitatCoffe(n_Caffee);

            System.out.println("Cafes Actuals: " + gameView.getComptador());
        }else if (e.getActionCommand().equals("potenciador1")){
            type = "A";
            //generatorManager.updateCost(generatorManager.incrementarPotenciador(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type);
            gameView.setQuantitatPotenciador1(generatorManager.updateQuantitatGeneradors(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type));
            //gameView.setCostPotenciador1(generatorManager.getCost(1));
            gameView.setCostPotenciador1(generatorManager.updateCost(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), "A"));
            System.out.println("Quantitat Potenciadors 1: " + gameView.getQuantitatPotenciadors1());
            System.out.println("Cost potenciador 1: " + gameView.getCost1());
            System.out.println("CostActual potenciador 1: " + generatorManager.getCostActual(1));

            //produccio total de cafes generats

        }else if (e.getActionCommand().equals("potenciador2")){
            //generatorManager.updateCost(2,generatorManager.incrementarPotenciador(2));
            gameView.setQuantitatPotenciador2(generatorManager.getQuantitatGenerados(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type));
            gameView.setCostPotenciador2(generatorManager.getCost(2));

            System.out.println("Quantitat Potenciadors 2: "  + gameView.getQuantitatPotenciadors2());
            System.out.println("Cost potenciador 2: " + gameView.getCost2());
            System.out.println("CostActual potenciador 2: " + generatorManager.getCostActual(2));


        }else if (e.getActionCommand().equals("potenciador3")){
            //generatorManager.updateCost(3, generatorManager.incrementarPotenciador(3));
            gameView.setQuantitatPotenciador3(generatorManager.getQuantitatGenerados(gameManager.getConnectedUserId(), gameManager.getCurrentGameId(gameManager.getConnectedUserId()), type));
            gameView.setCostPotenciador3(generatorManager.getCost(3));

            System.out.println("Quantitat Potenciadors 3: " + gameView.getQuantitatPotenciadors3());
            System.out.println("Cost potenciador 3: " + gameView.getCost3());
            System.out.println("CostActual potenciador 3: " + generatorManager.getCostActual(3));

        }else if (e.getActionCommand().equals("millora1")){

        }else if (e.getActionCommand().equals("millora2")){

        }else if (e.getActionCommand().equals("millora3")){

        }else if (e.getActionCommand().equals("millora4")){

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

    @Override
    public double getQuantitatCoffe() {
        return 0;
    }

    @Override
    public void setGameTime(long time) {

    }

    @Override
    public long getGameTime() {
        return 0;
    }

    @Override
    public void updateQuantitatCoffe(double quantitatCafes) {
        gameView.setComptador(String.valueOf(Math.round(quantitatCafes)));
        gameManager.setQuantitatCafe(quantitatCafes);
        System.out.println(quantitatCafes);
    }

    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        gameManager.setComptadorInterficie(comptadorInterficie);
    }
}
