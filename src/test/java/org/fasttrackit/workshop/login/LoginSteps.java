package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginView loginView = new LoginView();

    @Given("^I access login page$")
    public void I_access_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_insert_credentials(String emailValue, String passwordValue) {
        loginView.enterEmail(emailValue);
        loginView.enterPassword(passwordValue);
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        loginView.clickOnLoginButton();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        loginView.checkLogoutButton();
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_message(String expectedMessage) {
        loginView.errorMessageShouldBePresent(expectedMessage);
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String expectedEmail, String expectedPassword) {
        loginView.enterEmail(expectedEmail);
        loginView.enterPassword(expectedPassword);
    }

    @Given("^I successfully login$")
    public void I_successfully_login() throws Throwable {
        I_access_login_page();
        I_enter_credentials(PreferencesSteps.VALID_EMAIL, PreferencesSteps.VALID_PASSWORD);
        I_click_login_button();
    }
}