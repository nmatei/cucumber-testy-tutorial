package feature.util;

import com.sdl.selenium.web.Browser;
import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    protected boolean isLogged = false;
    private static boolean closeBrowserWhenFinish = true;

    public static void setCloseBrowserWhenFinish(boolean closeBrowserWhenFinish) {
        TestBase.closeBrowserWhenFinish = closeBrowserWhenFinish;
    }

    static {
        try {
            startSuite();
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }

    private static void startSuite() throws Exception {
        LOGGER.info("===============================================================");
        LOGGER.info("|          BeforeSuite START-SUITE >> enter                    |");
        LOGGER.info("=============================================================\n");
        initSeleniumStart();
    }

    private static void initSeleniumStart() throws Exception {
        LOGGER.info("===============================================================");
        LOGGER.info("|          Open Selenium Web Driver ");
        LOGGER.info("===============================================================\n");
        if (driver == null) {
            driver = WebDriverConfig.getWebDriver(Browser.CHROME);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(150, TimeUnit.MILLISECONDS);

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    if (closeBrowserWhenFinish) {
                        initSeleniumEnd();
                    }
                }
            });
        }
    }

    private static void initSeleniumEnd() {
        LOGGER.info("===============================================================");
        LOGGER.info("|          Stopping driver (closing browser)                   |");
        LOGGER.info("===============================================================");
        driver.quit();
        LOGGER.debug("===============================================================");
        LOGGER.debug("|         Driver stopped (browser closed)                     |");
        LOGGER.debug("===============================================================\n");
    }

    /**
     * fail if <blockquote><pre>element.ready()</pre></blockquote> return <blockquote><pre>false</pre></blockquote>
     * @param element expected web locator
     */
    protected void assertThatElementIsReady(WebLocator element) {
        assertThat("{ " +  element.toString() + " } was not found!", element.ready(), is(true));
    }
}
