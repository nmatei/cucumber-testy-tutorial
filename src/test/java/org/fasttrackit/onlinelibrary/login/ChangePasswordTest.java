package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.example.ChangePasswordPage;
import org.fasttrackit.example.LoginPage;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;
    private NavigationBarPage navigationBarPage;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navigationBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
    }

    @Test
    public void successChangePassword() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();

        changePasswordPage.changePassword("eu.pass", "eu.pass2");

        String statusElementText = changePasswordPage.getStatusMessage();

        System.out.println(statusElementText);
        assertThat(statusElementText, is("Your password has been successfully changed."));
    }

    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
