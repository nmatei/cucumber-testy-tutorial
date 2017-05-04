package org.fasttrackit.onlinelibrary.view;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView extends WebLocator {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);
    
    public LoginView() {
        setClasses("login");
    }

    private TextField userNameField1 = new TextField(this).setLabel("Username or email address", SearchType.DEEP_CHILD_NODE_OR_SELF)
            .setLabelPosition("//following-sibling::");
    private TextField userNameField = new TextField(this).setName("username");
    private TextField passwordField = new TextField(this).setName("password");

    public TextField fakePasswordField = new TextField(this).setLabel("Password", SearchType.CHILD_NODE)
            .setLabelPosition("//following-sibling::").setPosition(2);

    private InputButton loginButton = new InputButton(this, "Login");

    private WebLocator invalidUserErrorElement = new WebLocator().setText("Invalid username");
    private WebLocator userNotFoundErrorElement = new WebLocator().setText("A user could not be found with this email address.");

    public void login(String user, String pass) {
        userNameField.setValue(user);
        fakePasswordField.click(); // this is how ui is implemented
        passwordField.setValue(pass);
        loginButton.click();
    }

    public static void main(String[] args) {
        WebLocatorUtils.getXPathScript(new LoginView());
    }
}
