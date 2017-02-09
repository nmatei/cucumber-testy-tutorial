package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passField;
    @FindBy(className = "login-btn")
    //@FindBy(xpath = "//button[normalize-space(text())='Login']")
    private WebElement loginBtn;
    //private Button loginBtn = new Button().setText("Login");

    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();
    }
}
