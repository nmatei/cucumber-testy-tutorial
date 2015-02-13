package feature.examples;

import com.sdl.selenium.web.WebLocator;
import org.fasttrackit.web.example.views.MenuLinks;
import feature.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class ExamplesSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamplesSteps.class);
    
    private MenuLinks menuLinks = new MenuLinks();
    public static final String TEST_URL = "file:///C:/Cloud/Dropbox/Public/FastTrackIT/simple-webapp/index.html";
    
    public void testApp() {
        driver.get(TEST_URL);

        System.out.println(menuLinks.aboutLink.getPath());
        menuLinks.aboutLink.assertClick();

        WebLocator breadcrumb = new WebLocator().setId("breadcrumb");

        breadcrumb.assertExists();

        assertEquals(breadcrumb.getHtmlText(), "About");
    }
}
