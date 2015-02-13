package org.fasttrackit.examples;

import com.sdl.selenium.web.WebLocator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.example.views.MenuLinks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class ExamplesSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamplesSteps.class);
    
    private MenuLinks menuLinks = new MenuLinks();

    @When("^I click on About menu item$")
    public void i_click_on_About_menu_item() throws Throwable {
        LOGGER.debug(menuLinks.aboutLink.getPath());
        menuLinks.aboutLink.assertClick();
    }

    @Then("^breadcrumb text should be changed to \"(.*?)\"$")
    public void breadcrumb_text_should_be_changed_to(String text) throws Throwable {
        WebLocator breadcrumb = new WebLocator().setId("breadcrumb");
        breadcrumb.assertExists();

        assertEquals(text, breadcrumb.getHtmlText());
    }
}
