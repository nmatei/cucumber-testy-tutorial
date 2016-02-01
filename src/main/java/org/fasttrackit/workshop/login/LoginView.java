package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator loginButton = new WebLocator().setId("loginButton");

    private WebLocator logoutButton = new WebLocator().setText("Logout");

    private WebLocator email = new WebLocator().setId("email");

    private WebLocator password = new WebLocator().setId("password");

    private WebLocator errorMessage= new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void checkLogoutButton() {
        assertThat(logoutButton.isElementPresent(), is(true));
    }

    public void enterEmail(String expectedEmail) {
        email.sendKeys(expectedEmail);
    }

    public void enterPassword(String expectedPassword) {
        password.sendKeys(expectedPassword);
    }

    public void errorMessageShouldBePresent(String expectedMessage) {
        assertThat(errorMessage.getHtmlText(), is(expectedMessage));
    }
}