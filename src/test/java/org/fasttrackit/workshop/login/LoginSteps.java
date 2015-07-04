package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    public LoginSteps() {
        initPage();
    }

    public void initPage() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("^I access the login page$")
    public void I_access_the_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @Given("^I insert valid credentials$")
    public void I_insert_valid_credentials() {
        I_enter_credentials("eu@fast.com", "eu.pass");
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        boolean successLoggedIn = false;
        try {
            WebElement logout = driver.findElement(By.linkText("Logout"));
            successLoggedIn = logout.isDisplayed();
        } catch (Exception e) {}

        assertThat("Could not find logout button", successLoggedIn, is(true));
    }

    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() {
        I_enter_credentials("aa@fast.com", "aa.pass");
    }

    @Then("^I expect invalid credential message$")
    public void I_Expect_invalid_credential_message() {
        errorMessageShouldBePresent("Invalid user or password!");
    }

    private void errorMessageShouldBePresent(String expectedMessage) {
        WebElement error = driver.findElement(By.className("error-msg"));
        assertThat(error.getText(), is(expectedMessage));
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailValue, String passValue) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailValue);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passValue);
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_error_message(String expectedMessage) {
        errorMessageShouldBePresent(expectedMessage);
    }

    @Given("^I successfully login$")
    public void I_successfully_login() {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_login_button();
        I_check_if_user_was_logged_in();
    }
}
