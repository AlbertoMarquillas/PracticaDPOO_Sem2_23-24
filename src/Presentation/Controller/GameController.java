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
        if (e.getActionCommand().equals("settings")) {
            changeViewController.changePan("settings");
        } else if (e.getActionCommand().equals("createcofee")) {

            double cafesBBDD = gameManager.getQuantitatCafe();
            double caffesClcik = gameManager.quantitatCoffeClick();
            double cafesTotal = cafesBBDD + caffesClcik;
            setQuantitatCoffe(cafesTotal);
            gameView.setComptador(String.valueOf(cafesTotal));
            gameView.setVisible(false);
            gameView.setVisible(true);
            gameView.setSize(gameView.getWidth(), gameView.getHeight());

        }else if (e.getActionCommand().equals("potenciador1")){
            generatorManager.updateCost(1, generatorManager.incrementarPotenciador(1));
            gameView.setQuantitatPotenciador1(generatorManager.getQuantitatGenerados(1));
            gameView.setCostPotenciador1(generatorManager.getCost(1));

            System.out.println("Quantitat Potenciadors 1: " + gameView.getQuantitatPotenciadors1());
            System.out.println("Cost potenciador 1: " + gameView.getCost1());
            System.out.println("CostActual potenciador 1: " + generatorManager.getCostActual(1));

            //produccio total de cafes generats

        }else if (e.getActionCommand().equals("potenciador2")){
            generatorManager.updateCost(2,generatorManager.incrementarPotenciador(2));
            gameView.setQuantitatPotenciador2(generatorManager.getQuantitatGenerados(2));
            gameView.setCostPotenciador2(generatorManager.getCost(2));

            System.out.println("Quantitat Potenciadors 2: "  + gameView.getQuantitatPotenciadors2());
            System.out.println("Cost potenciador 2: " + gameView.getCost2());
            System.out.println("CostActual potenciador 2: " + generatorManager.getCostActual(2));


        }else if (e.getActionCommand().equals("potenciador3")){
            generatorManager.updateCost(3, generatorManager.incrementarPotenciador(3));
            gameView.setQuantitatPotenciador3(generatorManager.getQuantitatGenerados(3));
            gameView.setCostPotenciador3(generatorManager.getCost(3));

            System.out.println("Quantitat Potenciadors 3: " + gameView.getQuantitatPotenciadors3());
            System.out.println("Cost potenciador 3: " + gameView.getCost3());
            System.out.println("CostActual potenciador 3: " + generatorManager.getCostActual(3));

        }else if (e.getActionCommand().equals("millora1")){

        }else if (e.getActionCommand().equals("millora2")){

        }else if (e.getActionCommand().equals("millora3")){

        }else if (e.getActionCommand().equals("millora4")){

        } else if (e.getActionCommand().equals("finish")){
            boolean exit = showConfirmationDialog("Do you want to finish the game?");
            if(exit){
                gameManager.setEndeGame();
                changeViewController.changePan("login");
            } else {
                changeViewController.changePan("game");
            }

        } else if (e.getActionCommand().equals("save")){
            boolean exit = showConfirmationDialog("Do you want to save the game?");
            if(exit){
                changeViewController.changePan("login");
            } else {
                changeViewController.changePan("game");
            }
        }
    }

    @Override
    public void setQuantitatCoffe(double quantitatCoffee) {
        gameManager.setQuantitatCafe(quantitatCoffee);
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
    public void updateQuantitatCoffe(double quantitatCafes, double produccio) {
        double nCafes = quantitatCafes + produccio;
        setQuantitatCoffe(nCafes);
        gameView.setComptador(String.valueOf(nCafes));
        gameManager.setQuantitatCafe(nCafes);
        System.out.println(nCafes);
        gameView.setVisible(false);
        gameView.setVisible(true);
        gameView.setSize(gameView.getWidth(), gameView.getHeight());

    }

    public void setComptadorInterficie(ComptadorInterficie comptadorInterficie) {
        gameManager.setComptadorInterficie(comptadorInterficie);
    }
}
