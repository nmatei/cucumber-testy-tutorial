package org.fasttrackit.workshop.pagefactory.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = "//form/div[2]//input")
    private WebElement passwordField;
    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//nav//a[normalize-space(text())='Logout']")
    private WebElement logoutButton;

    @FindBy(how = How.CLASS_NAME, using = "error-msg")
    private WebElement errorMsg;

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    public void login(String email, String pass) throws Throwable {
        enterEmail(email);

        System.out.println("set pass");
        passwordField.sendKeys(pass);

        System.out.println("click on login");
        loginButton.click();
    }

    public void enterEmail(String email) {
        System.out.println("set email" + email);
        emailField.sendKeys(email);
    }

    public void doLogout() {
        logoutButton.click();
    }
}
