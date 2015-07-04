package org.fasttrackit.workshop.login;


import com.sdl.selenium.web.WebLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator emailEl = new WebLocator().setId("email");

    private WebLocator loginButton = new WebLocator().setId("loginButton");

    private WebLocator password = new WebLocator().setId("password");

    private WebLocator error = new WebLocator().setClasses("error-msg");

    public void enterEmail(String email) {
        emailEl.sendKeys(email);
    }

    public void clickOnLoginButton() {
        loginButton.click();

    }

    public void enterCredentials(String emailValue, String passValue) {
        emailEl.sendKeys(emailValue);

        password.sendKeys(passValue);
    }

    public void errorMessageDisplayed(String expectedMessage) {
        assertThat(error.getHtmlText(), is(expectedMessage));
    }
}
