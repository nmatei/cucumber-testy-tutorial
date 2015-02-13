package org.fasttrackit.util;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.SimpleTextField;
import com.sdl.selenium.web.link.WebLink;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestyUtilitySteps  extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestyUtilitySteps.class);

    @When("^I click on link with text \"([^\"]*)\"$")
    public void I_click_on_link_with_text(String text) throws Throwable {
        WebLink link = new WebLink().setText(text, SearchType.EQUALS);
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

    @When("^I type \"([^\"]*)\" into text field with label \"([^\"]*)\"$")
    public void I_type_into_text_field_with_label(String value, String label) throws Throwable {
        SimpleTextField field = new SimpleTextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        field.setValue(value);
    }

    @And("^text field with label \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_label_should_have_value(String label, String value) throws Throwable {
        SimpleTextField field = new SimpleTextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        assertThat(field.getValue(), is(value));
    }
}
