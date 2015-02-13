package org.fasttrackit.web.onlinelibrary.view;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.SimpleTextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView extends WebLocator {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);
    
    public LoginView() {
        setClasses("login");
    }

    public SimpleTextField userNameField1 = new SimpleTextField(this).setLabel("Username or email address", SearchType.DEEP_CHILD_NODE_OR_SELF)
            .setLabelPosition("//following-sibling::");
    public SimpleTextField userNameField = new SimpleTextField(this).setName("username");
    public SimpleTextField passwordField = new SimpleTextField(this).setName("password");

    public SimpleTextField fakePasswordField = new SimpleTextField(this).setLabel("Password", SearchType.CHILD_NODE)
            .setLabelPosition("//following-sibling::").setPosition(2);

    public InputButton loginButton = new InputButton(this, "Login");

    public WebLocator invalidUserErrorElement = new WebLocator().setText("Invalid username");
    public WebLocator userNotFoundErrorElement = new WebLocator().setText("A user could not be found with this email address.");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        fakePasswordField.click(); // this is how ui is implemented
        passwordField.setValue(pass);
        loginButton.assertClick();
    }

    public static void main(String[] args) {
        LOGGER.debug(new LoginView().userNameField1.getPath());
    }
}
