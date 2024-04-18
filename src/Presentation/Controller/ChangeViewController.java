package Presentation.Controller;

public class ChangeViewController {

    private final MainView mainView; //fa falta una mainview

    public ChangeViewController(MainView mainView) {
        this.mainView = mainView;
    }
    public void changePan(String pantalla) {
        mainView.panelChange(pantalla);
    } //la pantalla es farà mitjançant un switch amb diferents casos com login o register
}
