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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;


    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("eu@fast.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("eu.pass");

    }

    @When("^I click on the login button$")
    public void I_click_on_the_login_button() throws Throwable {
        WebElement LoginButton = driver.findElement(By.id("loginButton"));
        LoginButton.click();
    }

    @Then("^I check if the user is logged in$")
    public void I_check_if_the_user_is_logged_in() throws Throwable {
        WebElement logout = driver.findElement(By.linkText("Logout"));
        Boolean successLoggedIn = logout.isDisplayed();
        assertThat(successLoggedIn, is(true));
    }

    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("eu1@fast.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("eu.pass");

    }

    @Then("^I check if the invalid credentials error message is displayed$")
    public void I_check_if_the_invalid_credentials_error_message_is_displayed() throws Throwable {
        WebElement error = driver.findElement(By.className("error-msg"));
        assertThat(error.getText(), is("Invalid user or password!"));

    }

    @Then("^I check if the invalid credentials error message is$")
    public void I_check_if_the_invalid_credentials_error_message_is() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }


}
