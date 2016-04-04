package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginView {
    // .setElPath("//input")
    private TextField emailField = new TextField().setLabel("Email:");
    private TextField passField = new TextField().setName("password");
    private Button loginBtn = new Button().setText("Login");
//    private WebLocator loginBtn = new WebLocator().setTag("button").setText("Login");
    private WebLocator errorMsg = new WebLocator("error-msg");

    public static void main(String[] args) {
        LoginView view = new LoginView();

        System.out.println(view.emailField.getXPath());
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void doLogin(String userName, String password) {
        enterEmail(userName);
        passField.sendKeys(password);
        loginBtn.click();
    }

    public void assertThatErrorIs(String message) {
        System.out.println(errorMsg.getHtmlText());
        assertThat(errorMsg.getHtmlText(), is(message));
    }
}
