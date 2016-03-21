package org.fasttrackit.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage {
    // css selector: $$("#preferences-win input[name=password]")
    @FindBy(how = How.XPATH, using = "//div[@id='preferences-win']//input[@name='password']")
    private WebElement currentPassField;

    @FindBy(how = How.XPATH, using = "//input[@name='newPassword']")
    private WebElement newPassField;

    @FindBy(how = How.XPATH, using = "//input[@name='newPasswordRepeat']")
    private WebElement repeatPassField;

    @FindBy(how = How.CSS, using = "#preferences-win button.btn-warning")
    private WebElement saveBtn;

    @FindBy(how = How.CSS, using = "#preferences-win .status-msg")
    private WebElement statusElement;

    public void changePassword(String password, String newPassword) {
        currentPassField.sendKeys(password);
        newPassField.sendKeys(newPassword);
        repeatPassField.sendKeys("eu.pass2");
        saveBtn.click();
    }

    public String getStatusMessage() {
        return statusElement.getText();
    }
}
