package org.fasttrackit.workshop.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        loginPage.enterEmail(email);
    }


    @Given("^I open app$")
    public void i_open_app() throws Throwable {
        driver.get("file:///C:/Cloud/Dropbox/Public/FastTrackIT/app-demo/login.html");

        loginPage = PageFactory.initElements(driver, LoginPage.class);

        // TODO remove (shortcut to driver)
        LoginPage.driver = driver;
    }

    @When("^login into the app$")
    public void login_into_the_app() throws Throwable {
        loginPage.login("eu@fast.com", "eu.pass");
    }

    @Then("^I'm logged in$")
    public void i_m_logged_in() throws Throwable {
        loginPage.doLogout();
    }

    @When("^I insert invalid credentials$")
    public void i_insert_invalid_credentials() throws Throwable {
        loginPage.login("noi@fast.com", "noi.pass");
    }

    @Then("^I won't be logged in$")
    public void i_won_t_be_logged_in() throws Throwable {
        String message = loginPage.getErrorMessage();

        System.out.println("error: " + message);
        assertThat(message, is("Invalid user or password!"));
    }
}
