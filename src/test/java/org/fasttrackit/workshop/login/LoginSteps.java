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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("eu@fast.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("eu.pass");
    }

    @When("^I click login button$")
    public void I_click_login_button() throws Throwable {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() throws Throwable {
        boolean successLoggedIn = false;
        try {
            WebElement logout = driver.findElement(By.linkText("Signout"));
            successLoggedIn = logout.isDisplayed();
        } catch (Exception e) {}

        assertThat("Could not find logout button", successLoggedIn, is(true));
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I Expect invalid credential message$")
    public void I_Expect_invalid_credential_message() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^I open this url \"([^\"]*)\"$")
    public void I_open_this_url(String url) throws Throwable {
        driver.get(url);
    }

    @Then("^I send (\\d+) into search field$")
    public void I_send_into_search_field(int arg1) throws Throwable {
        System.out.println("numarul este: " + arg1);
    }
}
