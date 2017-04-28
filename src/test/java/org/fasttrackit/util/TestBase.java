package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;
import org.fasttrackit.automation.LoginView;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    
    protected static WebDriver driver;
    protected LoginView loginView = new LoginView();

    protected ConfigReader config = new ConfigReader();

    static {
        startSuite();
    }

    private static void startSuite() {
//        String browser = "browser.properties";
        String browser = System.getProperty("browser", "CHROME").toUpperCase();
        Browser browser1 = Browser.valueOf(browser);
        try {
            driver = WebDriverConfig.getWebDriver(browser1);
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }

    protected void openLoginPage() {
        System.out.println("ready");
        driver.get(config.get("url"));
//        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
        System.out.println("------------------");
    }
}
