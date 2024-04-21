package Presentation.Controller;
import Presentation.View.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    public final ChangeViewController changeViewController;
    private final GameView gameView;

    public GameController(ChangeViewController changeViewController, GameView gameView) {
        this.changeViewController = changeViewController;
        this.gameView = gameView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("settings")) {
            changeViewController.changePan("settings");
        } else if (e.getActionCommand().equals("createcofee")) {
            int compt = Integer.parseInt(gameView.getComptador());
            compt += 1;
            gameView.setComptador(String.valueOf(compt));

        }
    }
}
