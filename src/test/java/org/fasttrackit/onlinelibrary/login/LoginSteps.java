package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.WebLocator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.onlinelibrary.view.LoginView;
import org.fasttrackit.onlinelibrary.view.TopMenuNavigationView;
import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    
    private TopMenuNavigationView topMenuNavigation = new TopMenuNavigationView();
    private LoginView loginView = new LoginView();

    @When("^I click on Login button from top navigation menu$")
    public void I_click_on_Login_button_from_top_navigation_menu() {
        topMenuNavigation.loginButton.click();
    }
    
    @When("^I login using \"([^\"]*)\"/\"([^\"]*)\"$")
    public void I_login_using(String user, String password) {
        loginView.login(user, password);
    }

    @Then("^I click on fake Password field$")
    public void fakePasswordClick() {
        loginView.fakePasswordField.click();
    }
    
    @Then("^login should fail$")
    public void loginShouldFail() {
        WebLocator error = new WebLocator().setTag("strong").setText("Error:");
        boolean ready = error.ready();
        Assert.assertTrue("Element is not found : " + error, ready);
    }
}
