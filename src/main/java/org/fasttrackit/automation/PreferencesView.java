package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

public class PreferencesView extends WebLocator {
    private Button preferencesBtn = new Button().setText("Preferences");

    public PreferencesView(){
        setId("preferences-win");
    }

    private Button xBtn = new Button(this).setClasses("close");

    private TextField passwordField = new TextField(this).setName("password");
    private TextField newPasswordField = new TextField(this).setName("newPassword");
    private TextField confirmPasswordField = new TextField(this).setName("newPasswordRepeat");
    private Button saveBtn = new Button(this).setText("Save");

    private WebLocator statusMsg = new WebLocator(this).setClasses("status-msg");

    private Button closeBtn = new Button(this).setText("Close");

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

    public String getStatusMsg() {
        return statusMsg.getText();
    }
}
