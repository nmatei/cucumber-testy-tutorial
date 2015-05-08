package org.fasttrackit.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBaseNative.class);

    public static WebDriver driver;

    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait((long) 150, TimeUnit.MILLISECONDS);

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    driver.quit();
                }
            });
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }
}
