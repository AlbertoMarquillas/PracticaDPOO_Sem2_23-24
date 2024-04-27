import Business.Managers.LogInManager;
import Business.Managers.SignUpManager;
import Business.Managers.UserManager;
import Persistance.DataBaseDAO;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Presentation.Controller.*;
import Presentation.View.MainView;
import Presentation.View.*;

public class Main {
    public static void main(String[] args){

        DataBaseDAO dataBaseDAO = new DataBaseDAO();
        dataBaseDAO.createDataBase();
        dataBaseDAO.createTables();

        SQLGameDAO sqlGameDAO = new SQLGameDAO();
        SQLGeneratorsDAO sqlGeneratorsDAO = new SQLGeneratorsDAO();
        SQLUserDAO sqlUserDAO = new SQLUserDAO();

        UserManager userManager = new UserManager(sqlUserDAO);
        LogInManager logInManager = new LogInManager(userManager);
        SignUpManager signUpManager = new SignUpManager(userManager);

        StartView startView = new StartView();
        StatsView statsView = new StatsView();
        SettingsView settingsView = new SettingsView();
        RegisterView registerView = new RegisterView();
        MainView mainView = new MainView();
        InitialView initialView = new InitialView();
        GameView gameView = new GameView();

        mainView.mainView(initialView, registerView, gameView, settingsView, startView, statsView);

        ChangeViewController changeViewController = new ChangeViewController(mainView);
        InitialController initialController = new InitialController(initialView, logInManager, changeViewController, userManager);
        RegisterController registerController = new RegisterController(registerView, signUpManager, changeViewController);
        SettingsController settingsController = new SettingsController(changeViewController, userManager);
        StartController startController = new StartController(changeViewController, userManager, startView);
        StatsController statsController = new StatsController(changeViewController);
        GameController gameController = new GameController(changeViewController, gameView);

        startView.buttonController(startController);
        //startView.setButtonsEnabled(userManager.comprobarPartidesActives());
        statsView.buttonController(statsController);
        settingsView.buttonController(settingsController);
        registerView.buttonController(registerController);
        initialView.buttonController(initialController);
        gameView.buttonController(gameController);

        mainView.panelChange("login");
    }
}
