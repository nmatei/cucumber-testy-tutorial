package org.fasttrackit.workshop.login;

import com.sdl.selenium.bootstrap.window.Window;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

public class ChangePasswordView {
    private Button preferencesButton = new Button().setText("Preferences");

    private Window preferencesWindow = new Window("Change Password").setElPathSuffix("dialog-visible", null);

    private TextField currentPassField = new TextField(preferencesWindow).setLabel("Current Password");
    private TextField newPassField = new TextField(preferencesWindow).setLabel("New Password");
    private TextField confirmPassField = new TextField(preferencesWindow).setLabel("Repeat Password");

    private Button saveButton = new Button(preferencesWindow).setText("Save");

    private WebLocator statusMsgElement = new WebLocator(preferencesWindow).setClasses("status-msg");

    public void clickPreferencesButton() {
        preferencesButton.assertClick();
    }

    public void changePassword(String currentPass, String newPass, String confirmPass) {
        currentPassField.setValue(currentPass);
        newPassField.setValue(newPass);
        confirmPassField.setValue(confirmPass);
        saveButton.assertClick();
    }

    public String getStatusMessage() {
        Utils.sleep(200);
        return statusMsgElement.getHtmlText();
    }
}
