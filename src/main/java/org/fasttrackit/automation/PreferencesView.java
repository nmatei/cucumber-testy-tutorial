package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferencesView {
    private Button preferencesBtn = new Button().setElCssSelector(".navbar-header button");

    private WebLocator xBtn = new WebLocator().setElCssSelector("#preferences-win button.close");

    private TextField passwordField = new TextField().setElPath("//*[@id='preferences-win']//input[@name='password']");
    private TextField newPasswordField = new TextField().setElPath("//*[@id='preferences-win']//input[@name='newPassword']");
    private TextField confirmPasswordField = new TextField().setElPath("//*[@id='preferences-win']//input[@name='newPasswordRepeat']");
    private Button saveBtn = new Button().setElPath("//*[@id='preferences-win']//button[text()='Save']");

    private WebLocator statusMsg = new WebLocator().setElPath("//*[@id='preferences-win']//*[@class='status-msg']");

    private Button closeBtn = new Button().setElCssSelector("#preferences-win .modal-footer button");

    public void changePassword(String pass, String newPass, String repeatPass) {
        passwordField.sendKeys(pass);
        newPasswordField.sendKeys(newPass);
        confirmPasswordField.sendKeys(repeatPass);
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
