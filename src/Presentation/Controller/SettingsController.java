package Presentation.Controller;

import Business.Managers.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController implements ActionListener {

    public final ChangeViewController changeViewController;
    private final UserManager userManager;
    public SettingsController(ChangeViewController changeViewController, UserManager userManager) {
        this.changeViewController = changeViewController;
        this.userManager = userManager;
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
        if (e.getActionCommand().equals("delete")) {
            boolean exit = showConfirmationDialog("Are you sure you want to delete your account");
            if(exit){
                String user = userManager.getNameUserConnected();
                userManager.deleteConnectedUser(user);
                changeViewController.changePan("login");
            } else {
                changeViewController.changePan("settings");
            }

        } else if (e.getActionCommand().equals("close")) {
            boolean exit = showConfirmationDialog("Are you sure you want to close your session?");
            if(exit){
                String user = userManager.getNameUserConnected();
                userManager.disconnectedUser(user);
                changeViewController.changePan("login");
            } else {
                changeViewController.changePan("settings");
            }
        } else if (e.getActionCommand().equals("back")) {
            changeViewController.changePan("game");
        }
    }
}
