package org.fasttrackit.workshop.login;

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

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I open login page$")
    public void I_open_login_page() {
        driver.get("file:///D:/Testy/src/test/functional/login.html");

        //loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
        System.out.println("the page is opened here");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I click on the login button$")
    public void I_click_on_the_login_button() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I check if the user is logged in$")
    public void I_check_if_the_user_is_logged_in() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I check if the invalid credentials error message is displayed$")
    public void I_check_if_the_invalid_credentials_error_message_is_displayed() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I check if the invalid credentials error message is$")
    public void I_check_if_the_invalid_credentials_error_message_is() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }


    @Then("^I send (\\d+) into search field$")
    public void I_send_into_search_field(int arg1) throws Throwable {
        System.out.println("5");
    }

    @Given("^I open url \"([^\"]*)\"$")
    public void I_open_url(String url) throws Throwable {
        driver.get(url);
    }
}
