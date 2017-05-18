package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferencesPage {
    @FindBy(css = ".navbar-header button")
    private WebElement preferencesBtn;

    @FindBy(css = "#preferences-win button.close")
    private WebElement xBtn;

    @FindBy(xpath = "//*[@id='preferences-win']//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='preferences-win']//input[@name='newPassword']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//*[@id='preferences-win']//input[@name='newPasswordRepeat']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//*[@id='preferences-win']//button[text()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//*[@id='preferences-win']//*[@class='status-msg']")
    private WebElement statusMsg;

    @FindBy(css = "#preferences-win .modal-footer button")
    private WebElement closeBtn;

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
