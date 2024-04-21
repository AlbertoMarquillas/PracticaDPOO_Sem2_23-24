package Presentation.Controller;

import Business.Managers.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController implements ActionListener {

    public final ChangeViewController changeViewController;
    private final UserManager userManager;
    public SettingsController(ChangeViewController changeViewController, UserManager userManager) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("delete")) {
            String user = userManager.getNameUserConnected();
            userManager.deleteConnectedUser(user);
        } else if (e.getActionCommand().equals("close")) {
            String user = userManager.getNameUserConnected();
            userManager.disconnectedUser(user);
        }

        changeViewController.changePan("login");
    }
}
