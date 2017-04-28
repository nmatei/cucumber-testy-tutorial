package org.fasttrackit.automation;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.web.WebLocator;

public class LoginView extends WebLocator {
    public LoginView() {
        setTag("form");
    }

    private WebLocator emailField = new WebLocator().setId("email");
    private WebLocator passField = new WebLocator().setName("passwordxxx");
    private WebLocator loginBtn = new WebLocator().setClasses("login-btn");

    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        System.out.println(loginView.emailField.getSelector());
        System.out.println(loginView.passField.getSelector());
        System.out.println(loginView.loginBtn.getSelector());

        System.out.println("-------------------");

        WebLocatorUtils.getXPathScript(loginView);
    }
}
