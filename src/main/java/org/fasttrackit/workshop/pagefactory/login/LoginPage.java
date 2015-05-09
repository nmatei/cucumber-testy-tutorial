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

    // TODO remove
    public static WebDriver driver;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailEl;

    public void enterEmail2(String email) {
        emailEl.sendKeys(email);
    }


    public String getErrorMessage() {
        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        return errorMsg.getText();
    }

    public void login(String email, String passValue) throws Throwable {
        enterEmail(email);

        System.out.println("set pass");
        WebElement pass = driver.findElement(By.xpath("//form/div[2]//input"));
        pass.sendKeys(passValue);

        System.out.println("click on login");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
    }

    public void enterEmail(String email) {
        System.out.println("set email" + email);
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void doLogout() {
        WebElement logoutButton = driver.findElement(By.xpath("//nav//a[normalize-space(text())='Logout']"));
        logoutButton.click();
    }
}
