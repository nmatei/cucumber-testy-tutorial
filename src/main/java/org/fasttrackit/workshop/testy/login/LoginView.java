package org.fasttrackit.workshop.testy.login;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.link.WebLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private TextField emailField = new TextField().setLabel("Email:");
    private TextField passwordField = new TextField().setLabel("Password:");
    private Button loginButton = new Button().setText("Login");
    private WebLocator errorMsg = new WebLocator().setClasses("error-msg");

    private WebLocator havMenu = new WebLocator().setTag("nav");
    private WebLink logoutButton = new WebLink(havMenu).setText("Logout");

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        System.out.println(loginView.logoutButton.getPath());
    }

    public String getErrorMessage() {
        return errorMsg.getHtmlText();
    }

    public void login(String email, String pass) throws Throwable {
        enterEmail(email);

        passwordField.setValue(pass);
        loginButton.assertClick();
    }

    public boolean enterEmail(String email) {
        return emailField.setValue(email);
    }

    public void doLogout() {
        logoutButton.assertClick();
    }
}
