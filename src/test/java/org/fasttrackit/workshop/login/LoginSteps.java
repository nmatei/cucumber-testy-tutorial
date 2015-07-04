package org.fasttrackit.workshop.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.menu.MainMenuView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    public static final String VALID_EMAIL = "eu@fast.com";
    public static String VALID_PASSWORD = "eu.pass";

    private LoginView loginPage = new LoginView();

    @Given("^I access the login page$")
    public void I_access_the_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @Given("^I insert valid credentials$")
    public void I_insert_valid_credentials() {
        I_enter_credentials(VALID_EMAIL, VALID_PASSWORD);
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        MainMenuView.logout.assertExists();
    }

    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() {
        I_enter_credentials("aa@fast.com", "aa.pass");
    }

    @Then("^I expect invalid credential message$")
    public void I_Expect_invalid_credential_message() {
        loginPage.errorMessageShouldBePresent("Invalid user or password!");
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailValue, String passValue) {
        loginPage.enterCredentials(emailValue, passValue);
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_error_message(String expectedMessage) {
        loginPage.errorMessageShouldBePresent(expectedMessage);
    }

    @Given("^I successfully login$")
    public void I_successfully_login() {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_login_button();
        I_check_if_user_was_logged_in();
    }
}
