package Presentation.Controller;

import Presentation.MainView;

public class ChangeViewController {

    private final MainView mainView;
    private HomeController homeController;


    public ChangeViewController(MainView mainView) {
        this.mainView = mainView;
    }
    public void setConstructors(HomeController homeController) {
        this.homeController = homeController;
    }
    public void changePan(String pantalla) {
        mainView.panelChange(pantalla);
    }
}
