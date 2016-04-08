package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.link.WebLink;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstLoginTest extends TestBase {

    private LoginView loginPage = new LoginView();

    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.passx");

        WebLink logoutBtn = new WebLink().setText("Logout");
        logoutBtn.assertClick();
    }

    @DataProvider
    public static Object[][] invalidLogin() {
        return new Object[][] {
                {"eu@fast.com", "wrong.pass",   "Invalid user or password!", true},
                {"eu@fast.com", "",             "Please enter your password!", false},
                {"",            "some.pass",    "Please enter your email!", false},
                {"",            "",             "Please enter your email!", false}
        };
    }

    @Test(dataProvider = "invalidLogin")
    public void invalidLoginTest(String email, String pass, String errorMsg, boolean hasCredentials) {
        System.out.println("invalid login test:" + email + " - " + pass + " - " + errorMsg);
        openLoginPage();
        loginPage.doLogin(email, pass);
        loginPage.assertThatErrorIs(errorMsg);
    }

    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
