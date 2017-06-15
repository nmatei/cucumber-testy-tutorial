package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.LoginView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    protected static PropertiesReader config = new PropertiesReader("src\\main\\resources\\config.properties");

    public static String USER_NAME = config.getProperty("valid.user");
    public static String PASSWORD = config.getProperty("valid.pass");

    public static WebDriver driver;

    protected LoginView loginPage = new LoginView();

    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            driver = WebDriverConfig.getWebDriver(Browser.CHROME);
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }

    public void doLogin(String user, String pass) {
        String url = config.getProperty("test.url");

        driver.get(url);

        loginPage.login(user, pass);
    }

    @AfterMethod
    public void end(ITestResult result){
        if(!result.isSuccess()) {
            LOGGER.warn("Test Failed: " + result.getName());
            Utils.getScreenShot(result.getName(), PropertiesReader.RESOURCES_PATH + "\\results\\screens\\");
        }
    }
}
