package org.fasttrackit.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {
    @FindBy(name = "password")
    private WebElement currentPasswordField;
    @FindBy(name = "newPassword")
    private WebElement newPasswordField;
    @FindBy(name = "newPasswordRepeat")
    private WebElement repeatPasswordField;
    // TODO save button;

    public void changePassword(String currentPass, String newPass, String repeatNewPass) {
        currentPasswordField.sendKeys(currentPass);
        newPasswordField.sendKeys(newPass);
        repeatPasswordField.sendKeys(repeatNewPass);
        // TODO clic on save
    }
}
