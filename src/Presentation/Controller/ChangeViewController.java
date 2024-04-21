package Presentation.Controller;

import Presentation.View.MainView;

public class ChangeViewController {

    private final MainView mainView;



    public ChangeViewController(MainView mainView) {
        this.mainView = mainView;
    }

    public void changePan(String pantalla) {
        mainView.panelChange(pantalla);
    }
}
