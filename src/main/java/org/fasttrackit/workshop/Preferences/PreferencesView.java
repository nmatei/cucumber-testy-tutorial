package org.fasttrackit.workshop.Preferences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class PreferencesView {

    private WebLocator window = new WebLocator().setId("preferences-win");
    private Button preferencesButton = new Button().setText("Preferences");
    private TextField currentPassword = new TextField(window).setLabel("Current Password");
    private TextField newPassword = new TextField(window).setLabel("New Password");
    private TextField confirmNewPassword = new TextField(window).setLabel("Repeat Password");
    private Button saveButton = new Button().setText("Save").setContainer(window);
    private Button closeButton = new Button().setText("Close").setContainer(window);
    private WebLocator statusMessage = new WebLocator(window).setClasses("status-msg");

    public static void main(String[] args) {
        PreferencesView preferencesWindow = new PreferencesView();

        System.out.println(preferencesWindow.window.getPath());
        System.out.println(preferencesWindow.saveButton.getPath());
        System.out.println(preferencesWindow.closeButton.getPath());

    }

    public void open() {
        preferencesButton.click();
        Utils.sleep(500);
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

    public void close() {
        closeButton.click();
    }

    public void isMessageDisplayed(String message) {
        assertThat(statusMessage.getHtmlText(), is(message));
    }
}