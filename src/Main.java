import Business.Entities.Comptador;
import Business.Entities.Millora;
import Business.Managers.*;
import Persistance.DataBaseDAO;
import Persistance.sqlDAO.SQLGameDAO;
import Persistance.sqlDAO.SQLGeneratorsDAO;
import Persistance.sqlDAO.SQLStatsDAO;
import Persistance.sqlDAO.SQLUserDAO;
import Presentation.Controller.*;
import Presentation.View.MainView;
import Presentation.View.*;


/**
 * Classe Main que conté el mètode main per a executar el programa.
 */
public class Main {

    /**
     * Mètode main per a executar el programa.
     *
     * @param args Arguments de la línia de comandes.
     */
    public static void main(String[] args){

        DataBaseDAO dataBaseDAO = new DataBaseDAO();

        SQLGameDAO sqlGameDAO = new SQLGameDAO();
        SQLGeneratorsDAO sqlGeneratorsDAO = new SQLGeneratorsDAO();
        SQLUserDAO sqlUserDAO = new SQLUserDAO();
        SQLStatsDAO sqlStatsDAO = new SQLStatsDAO();


        StatsManager statsManager = new StatsManager(sqlGameDAO, sqlUserDAO, sqlStatsDAO);
        Comptador comptador = new Comptador(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO, sqlStatsDAO);
        UserManager userManager = new UserManager(sqlUserDAO);
        LogInManager logInManager = new LogInManager(userManager);
        SignUpManager signUpManager = new SignUpManager(userManager);
        GeneratorManager generatorManager = new GeneratorManager(sqlGeneratorsDAO, sqlGameDAO);
        GameManager gameManager = new GameManager(sqlGameDAO, sqlUserDAO, sqlGeneratorsDAO, sqlStatsDAO);
        MilloraManager milloraManager = new MilloraManager();

        StartView startView = new StartView();
        StatsView statsView = new StatsView();
        SettingsView settingsView = new SettingsView();
        RegisterView registerView = new RegisterView();
        MainView mainView = new MainView();
        InitialView initialView = new InitialView();
        GameView gameView = new GameView();

        mainView.mainView(initialView, registerView, gameView, settingsView, startView,statsView);

        ChangeViewController changeViewController = new ChangeViewController(mainView, gameManager);
        InitialController initialController = new InitialController(initialView, logInManager, changeViewController, userManager, startView, gameManager, milloraManager);
        RegisterController registerController = new RegisterController(registerView, signUpManager, changeViewController);
        StartController startController = new StartController(changeViewController, userManager, gameManager, generatorManager ,startView, statsManager, statsView);
        StatsController statsController = new StatsController(changeViewController, statsManager, statsView);
        GameController gameController = new GameController(changeViewController, gameView, generatorManager, gameManager, milloraManager);
        SettingsController settingsController = new SettingsController(changeViewController, userManager, startController, statsController, gameController );

        startView.buttonController(startController);
        //startView.setButtonsEnabled(userManager.comprobarPartidesActives());
        statsView.buttonController(statsController);
        settingsView.buttonController(settingsController);
        registerView.buttonController(registerController);
        initialView.buttonController(initialController);
        gameView.buttonController(gameController);

        gameController.setComptadorInterficie(gameController);
        comptador.setComptadorInterficie(gameController);

        sqlUserDAO.setAllUsersOff();

        mainView.panelChange("login");
    }

}