package org.fasttrackit.util;

import com.sdl.selenium.web.Browser;
import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

    /**
     * fail if <blockquote><pre>element.ready()</pre></blockquote> return <blockquote><pre>false</pre></blockquote>
     * @param element expected web locator
     */
    protected void assertThatElementIsReady(WebLocator element) {
        assertThat("{ " +  element.toString() + " } was not found!", element.ready(), is(true));
    }
}
