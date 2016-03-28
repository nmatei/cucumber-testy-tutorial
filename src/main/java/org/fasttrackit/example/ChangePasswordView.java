package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordView {
    private WebLocator currentPassField = new WebLocator().setElPath("//div[@id='preferences-win']//input[@name='password']");
    private WebLocator newPassField = new WebLocator().setElPath("//input[@name='newPassword']");
    private WebLocator repeatPassField = new WebLocator().setElPath("//input[@name='newPasswordRepeat']");
    private WebLocator saveBtn = new WebLocator().setElCssSelector("#preferences-win button.btn-warning");
    private WebLocator statusElement = new WebLocator().setElCssSelector("#preferences-win .status-msg");

    public void changePassword(String password, String newPassword, String repeatPassword) {
        currentPassField.sendKeys(password);
        newPassField.sendKeys(newPassword);
        repeatPassField.sendKeys(repeatPassword);
        saveBtn.click();
    }

    public String getStatusMessage() {
        return statusElement.getHtmlText();
    }
}
