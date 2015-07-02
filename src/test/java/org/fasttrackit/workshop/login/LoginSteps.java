package org.fasttrackit.workshop.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.testy.login.LoginView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginView loginView = new LoginView();

    @Given("^I open app$")
    public void i_open_app() throws Throwable {
        driver.get("file:///C:/Producs/Testy/src/test/functional/login.html");
    }

    @When("^login into the app$")
    public void login_into_the_app() throws Throwable {
        loginView.login("eu@fast.com", "eu.pass");
    }

    @Then("^I'm logged in$")
    public void i_m_logged_in() throws Throwable {
        loginView.doLogout();
    }

    @When("^I insert invalid credentials$")
    public void i_insert_invalid_credentials() throws Throwable {
        loginView.login("noi@fast.com", "noi.pass");
    }

    @Then("^I won't be logged in$")
    public void i_won_t_be_logged_in() throws Throwable {
        String message = loginView.getErrorMessage();

        System.out.println("error: " + message);
        assertThat(message, is("Invalid user or password!"));
    }

    @When("^I login with \"([^\"]*)\"/\"([^\"]*)\"$")
    public void I_can_login_with_(String email, String pass) throws Throwable {
        loginView.login(email, pass);
    }

    @Then("^I get the error \"([^\"]*)\"$")
    public void I_get_the_error(String error) throws Throwable {
        String message = loginView.getErrorMessage();
        assertThat(message, is(error));
    }
}
