package org.fasttrackit.workshop.prefences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.workshop.menu.MainMenuView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PreferencesWindow {

    private WebLocator window = new WebLocator().setId("preferences-win");

    private TextField currentPassword = new TextField(window).setLabel("Current Password");
    private TextField newPassword = new TextField(window).setLabel("New Password");
    private TextField confirmNewPassword = new TextField(window).setLabel("Repeat Password");
    private Button saveButton = new Button(window).setText("Save");
    private Button closeButton = new Button(window).setText("Close");
    private WebLocator statusMessageEl = new WebLocator(window).setClasses("status-msg");

    public static void main(String[] args) {
        PreferencesWindow preferencesWindow = new PreferencesWindow();

        System.out.println(preferencesWindow.statusMessageEl.getPath());
    }

    public void open() {
        MainMenuView.preferences.assertClick();
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

    public void save() {
        saveButton.assertClick();
    }

    public void statusMessageShouldBePresent(String expectedMessage) {
        assertThat(statusMessageEl.getHtmlText(), is(expectedMessage));
    }

    public void close() {
        closeButton.assertClick();
        Utils.sleep(1000); // because of fading window
    }
}
