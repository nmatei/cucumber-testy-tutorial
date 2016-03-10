package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FistLoginTest extends TestBase {

    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        doLogin("eu@fast.com", "eu.pass");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Could not login. Logout button not found.");
        }
    }

    @Test
    public void whenEnterInvalidPasswordIGetErrorMessage() {
        openLoginPage();
        doLogin("eu@fast.com", "wrong.pass");
        assertThatErrorIs("Invalid user or password!");
    }

    @Test
    public void whenEnterOnlyEmailIGetErrorMessage() {
        openLoginPage();
        doLogin("eu@fast.com", "");
        assertThatErrorIs("Please enter your password!");
    }

    @Test
    public void whenEnterOnlyPassowrdIGetErrorMessage() {
        openLoginPage();
        doLogin("", "some.pass");
        assertThatErrorIs("Please enter your email!");
    }

    @Test
    public void whenNoCretentialsIGetErrorMessage() {
        openLoginPage();
        doLogin("", "");
        assertThatErrorIs("Please enter your email!");
    }

    private void assertThatErrorIs(String message) {
        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is(message));
    }

    private void doLogin(String userName, String password) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(userName);

        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
    }

    private void openLoginPage() {
        System.out.println("open login page");
//        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
