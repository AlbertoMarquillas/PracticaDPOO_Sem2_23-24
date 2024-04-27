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

        }else if (e.getActionCommand().equals("potenciador1")){

        }else if (e.getActionCommand().equals("potenciador2")){

        }else if (e.getActionCommand().equals("potenciador3")){

        }else if (e.getActionCommand().equals("millora1")){

        }else if (e.getActionCommand().equals("millora2")){

        }else if (e.getActionCommand().equals("millora3")){

        }else if (e.getActionCommand().equals("millora4")){

        }
    }
}
