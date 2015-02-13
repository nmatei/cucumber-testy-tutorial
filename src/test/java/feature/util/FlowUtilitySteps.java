package feature.util;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.SimpleTextField;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlowUtilitySteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlowUtilitySteps.class);

    @Given("^I wait (\\d+) seconds$")
    public void wait_seconds(int seconds) {
        LOGGER.info("Waiting {} seconds", seconds);
        Utils.sleep(seconds * 1000);
    }

    @When("^I click on link with text \"([^\"]*)\"$")
    public void I_click_on_link_with_text(String text) throws Throwable {
        WebLink link = new WebLink().setText(text);
        link.assertClick();
    }

    @When("^I click on input button with text \"([^\"]*)\"$")
    public void I_click_on_input_button_with_text(String text) throws Throwable {
        InputButton button = new InputButton().setText(text);
        button.assertClick();
    }

    @Then("^I should see web element with text \"([^\"]*)\"$")
    public void assertHaveElementWithText(String text) throws Throwable {
        WebLocator element = new WebLocator().setText(text);
        assertThatElementIsReady(element);
    }

    @Then("^I should see following web elements with texts \"(.*)\"$")
    public void assertHaveElementsWithText(List<String> texts) throws Throwable {
        for (String text : texts) {
            assertHaveElementWithText(text);
        }
    }

    @When("^I open url \"([^\"]*)\"$")
    public void I_open_LC_path(String url) throws Throwable {
        AppUtils.openUrl(url);
    }

    @Given("^I set browser size to (\\d+), (\\d+)$")
    public void setBrowserSize(int width, int height) throws Throwable {
        LOGGER.info("I set browser size to ({}, {})", width, height);
        WebDriverConfig.getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Given("^I maximize browser$")
    public void maximizeBrowser() throws Throwable {
        WebDriverConfig.getDriver().manage().window().maximize();
    }

    @When("^I type \"([^\"]*)\" into text field with label \"([^\"]*)\"$")
    public void I_type_into_text_field_with_label(String value, String label) throws Throwable {
        SimpleTextField field = new SimpleTextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF)
                .setLabelPosition("//following-sibling::"); // until deploy is done
        field.setValue(value);
    }
}
