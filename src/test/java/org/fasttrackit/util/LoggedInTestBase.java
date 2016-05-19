package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;
import org.fasttrackit.example.LoginView;
import org.testng.annotations.BeforeClass;

public class LoggedInTestBase extends TestBase {
    PropertiesReader appProperties = new PropertiesReader("src\\test\\resources\\app.properties");

    @BeforeClass(alwaysRun = true)
    public void login() throws Exception {
        LoginView loginPage = new LoginView();
        driver.get(appProperties.getProperty("app.login.url"));
        loginPage.doLogin("eu@fast.com", "eu.pass");
    }
}
