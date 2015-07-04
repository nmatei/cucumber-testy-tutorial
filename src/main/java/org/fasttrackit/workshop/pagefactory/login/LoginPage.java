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

    @FindBy(how = How.ID, using = "loginButton")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterCredentials(String emailValue, String passValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passValue);
    }
}
