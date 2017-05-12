package org.fasttrackit.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    
    public static WebDriver driver;

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
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        driver.findElement(By.name("username")).sendKeys(user);

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(pass);

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();
    }
}
