package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.example.ChangePasswordView;
import org.fasttrackit.example.LoginPage;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordView changePasswordPage = new ChangePasswordView();
    private NavigationBarPage navigationBarPage;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        navigationBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
    }

    @Test
    public void successChangePassword() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();

        changePasswordPage.changePassword("eu.pass", "eu.pass2", "eu.pass2");

        String statusElementText = changePasswordPage.getStatusMessage();

        System.out.println(statusElementText);
        assertThat(statusElementText, is("Your password has been successfully changed."));
        changePasswordPage.close();
    }

    @Test
    public void changeDateTest() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        FirstFormView form = new FirstFormView();
        //form.selectCalendar.assertClick();
        form.datePicker.select("25/9/2015", "dd/MM/yyyy", Locale.ENGLISH);
    }

    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
