package org.fasttrackit.onlinelibrary.login;

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

    @When("^I login using \"([^\"]*)\"/\"([^\"]*)\"$")
    public void I_login_using_(String user, String password) throws Throwable {
        topMenuNavigation.loginButton.assertClick();

        loginView.login(user, password);
    }

    @Then("^I click on fake Password field$")
    public void fakePasswordClick() {
        loginView.fakePasswordField.assertClick();
    }
    
    @Then("^login should fail$")
    public void loginShouldFail() {
        boolean ready = loginView.userNotFoundErrorElement.ready();
        Assert.assertTrue("Element is not found : " + loginView.invalidUserErrorElement, ready);
    }

}
