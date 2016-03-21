package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.example.LoginPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstLoginTest extends TestBase {

    private LoginPage loginPage;

    public FirstLoginTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

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
        loginPage.doLogin("eu@fast.com", "wrong.pass");
        loginPage.assertThatErrorIs("Invalid user or password!");
    }

    @Test
    public void whenEnterOnlyEmailIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "");
        loginPage.assertThatErrorIs("Please enter your password!");
    }

    @Test
    public void whenEnterOnlyPassowrdIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("", "some.pass");
        loginPage.assertThatErrorIs("Please enter your email!");
    }

    @Test
    public void whenNoCretentialsIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("", "");
        loginPage.assertThatErrorIs("Please enter your email!");
    }

    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
