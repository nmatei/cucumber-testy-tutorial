package org.fasttrackit.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginPage {
    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passField;

    @FindBy(how = How.CLASS_NAME, using = "login-btn")
    private WebElement loginBtn;

    @FindBy(how = How.CLASS_NAME, using = "error-msg")
    private WebElement errorMsg;

    public void enterEmail(String email) {
        System.out.println("enter email: " + email);
        emailField.sendKeys(email);
    }

    public void doLogin(String userName, String password) {
        enterEmail(userName);
        passField.sendKeys(password);
        loginBtn.click();
    }

    public void assertThatErrorIs(String message) {
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is(message));
    }
}
