package org.fasttrackit.workshop.login;

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

    @Given("^I open login page$")
    public void I_open_login_page() {
        driver.get("file:///E:/Aplication/Testy/src/test/functional/login.html");

        //loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        enterEmail(email);
    }


    @Given("^I open app$")
    public void i_open_app() throws Throwable {
        driver.get("file:///C:/Cloud/Dropbox/Public/FastTrackIT/app-demo/login.html");
    }

    @When("^login into the app$")
    public void login_into_the_app() throws Throwable {
        login("eu@fast.com", "eu.pass");
    }

    @Then("^I'm logged in$")
    public void i_m_logged_in() throws Throwable {
        doLogout();
    }

    @When("^I insert invalid credentials$")
    public void i_insert_invalid_credentials() throws Throwable {
        login("noi@fast.com", "noi.pass");
    }

    @Then("^I won't be logged in$")
    public void i_won_t_be_logged_in() throws Throwable {
        String message = getErrorMessage();

        System.out.println("error: " + message);
        assertThat(message, is("Invalid user or password!"));
    }

    public String getErrorMessage() {
        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        return errorMsg.getText();
    }

    public void login(String email, String passValue) throws Throwable {
        enterEmail(email);

        System.out.println("set pass");
        WebElement pass = driver.findElement(By.xpath("//form/div[2]//input"));
        pass.sendKeys(passValue);

        System.out.println("click on login");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
    }

    public void enterEmail(String email) {
        System.out.println("set email" + email);
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void doLogout() {
        WebElement logoutButton = driver.findElement(By.xpath("//nav//a[normalize-space(text())='Logout']"));
        logoutButton.click();
    }
}
