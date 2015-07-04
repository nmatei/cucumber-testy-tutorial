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
    private WebElement emailEl;

    public void enterEmail(String email) {
        emailEl.sendKeys(email);
    }

    public void clickOnLoginButton(WebDriver driver) {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }
}
