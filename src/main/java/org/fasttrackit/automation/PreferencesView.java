package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

public class PreferencesView {
    private Button preferencesBtn = new Button().setText("Preferences");

    private WebLocator win = new WebLocator().setId("preferences-win");

    private Button xBtn = new Button(win).setClasses("close");

    private TextField passwordField = new TextField(win).setName("password");
    private TextField newPasswordField = new TextField(win).setName("newPassword");
    private TextField confirmPasswordField = new TextField(win).setName("newPasswordRepeat");
    private Button saveBtn = new Button(win).setText("Save");

    private WebLocator statusMsg = new WebLocator(win).setClasses("status-msg");

    private Button closeBtn = new Button(win).setText("Close");

    public void changePassword(String pass, String newPass, String repeatPass) {
        passwordField.setValue(pass);
        newPasswordField.setValue(newPass);
        confirmPasswordField.setValue(repeatPass);
        saveBtn.click();
    }

    public void open() {
        preferencesBtn.click();
        Utils.sleep(400);
    }

    public void close() {
        xBtn.click();
        Utils.sleep(400);
    }
}
