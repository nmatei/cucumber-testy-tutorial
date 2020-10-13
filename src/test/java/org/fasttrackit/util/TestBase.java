package org.fasttrackit.util;

import com.sdl.selenium.utils.config.WebDriverConfig;
//import com.sdl.selenium.web.Browser;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    
    public static WebDriver driver;

    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            String browser = "browser.properties";
            driver = WebDriverConfig.getWebDriver(browser);
//            driver = WebDriverConfig.getWebDriver(Browser.CHROME);
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }
}
