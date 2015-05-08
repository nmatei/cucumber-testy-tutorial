package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;

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
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
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
        WebElement logoutButton = driver.findElement(By.xpath("//nav//a[normalize-space(text())='Logout']"));

        logoutButton.click();
    }

    @When("^I insert invalid credentials$")
    public void i_insert_invalid_credentials() throws Throwable {
        login("noi@fast.com", "noi.pass");
    }

    @Then("^I won't be logged in$")
    public void i_won_t_be_logged_in() throws Throwable {
        //WebElement errorMsg = driver.findElement(By.xpath("//*[normalize-space(text())='Invalid user or password!']"));

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();

        System.out.println("error: " + message);
        assertThat(message, is("Invalid user or password!"));
    }


    private void login(String emailValue, String passValue) throws Throwable {
        System.out.println("set email");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailValue);

        System.out.println("set pass");
        WebElement pass = driver.findElement(By.xpath("//form/div[2]//input"));
        pass.sendKeys(passValue);

        System.out.println("click on login");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
    }
}
