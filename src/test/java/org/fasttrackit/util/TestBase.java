package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    
    public static WebDriver driver;

    public static int TEST_RUNS = 0;
    public static int TEST_FAILED = 0;

    static {
        startSuite();
    }

    @BeforeClass(alwaysRun = true)
    public void startTest() throws Exception {
        LOGGER.debug("===============================================================");
        LOGGER.debug("|         BeforeClass START-TEST >> enter                     |");
        LOGGER.debug("===============================================================\n");
    }

    @AfterClass(alwaysRun = true)
    public void stopTest() {
        LOGGER.debug("==============================================================");
        LOGGER.debug("|         AfterClass STOP-TEST >> enter                       |");
        LOGGER.debug("==============================================================\n");
    }

    @BeforeMethod
    public void bm(Method method) throws Exception {
        LOGGER.info("===============================================================");
        LOGGER.info("|    Start Test (" + (++TEST_RUNS) + ") => " + method.getName());
        LOGGER.info("|    " + method.getDeclaringClass());
        LOGGER.info("===============================================================");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        LOGGER.debug("tearDown >> enter");
        String testName = result.getName(); // TODO class name
        boolean isFailed = !result.isSuccess();
        LOGGER.info(result.getName() + " is " + (isFailed ? "FAILED" : "SUCCESS"));
        if (isFailed) {
            LOGGER.warn("tests message: " + result.getThrowable().getMessage());
            String args = "";
            if (result.getParameters() != null) {
                for (Object o : result.getParameters()) {
                    args += o.toString() + "; ";
                }
            }
            LOGGER.warn("tests arguments: " + args);
            String fileName = testName + "-failed";
            LOGGER.error("tests. screen: " + Utils.getScreenShot(fileName, getScreensPath()));

            LOGGER.info("TOTAL FAILED TESTS: " + (++TEST_FAILED) + " of " + TEST_RUNS);
            LOGGER.info("Refresh page to clean up page for next tests.");
            driver.navigate().refresh();
        }
        LOGGER.debug("tearDown << exit");
        LOGGER.info("\n");
    }

    public static String getScreensPath() {
        return PropertiesReader.RESOURCES_DIRECTORY_PATH + "\\..\\..\\..\\reports\\screens\\";
    }

    private static void startSuite() {
        String browser = System.getProperty("browser", "chrome");

        browser = browser.toUpperCase();
        LOGGER.debug("browser: {}", browser);
        try {
            driver = WebDriverConfig.getWebDriver(Browser.valueOf(browser));
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }
}
