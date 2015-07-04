package org.fasttrackit.workshop.prefences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

public class PreferencesWindow {

    private WebLocator window = new WebLocator().setId("preferences-win");

    private Button preferencesButton = new Button().setText("Preferences");
    private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField newPassword = new TextField().setLabel("New Password");
    private TextField confirmNewPassword = new TextField().setLabel("Repeat Password");
    private Button saveButton = new Button().setText("Save").setContainer(window);
    private Button closeButton = new Button().setText("Close").setContainer(window);

    public static void main(String[] args) {
        PreferencesWindow preferencesWindow = new PreferencesWindow();

        System.out.println(preferencesWindow.closeButton.getPath());
    }

    public void open() {
        preferencesButton.click();
        Utils.sleep(1000); // because of fading window
    }

    public void typeCurrentPassword(String password) {
        currentPassword.setValue(password);
    }

    public void typeNewPassword(String password) {
        newPassword.setValue(password);
    }

    public void typeConfirmPassword(String password) {
        confirmNewPassword.setValue(password);
    }
}
