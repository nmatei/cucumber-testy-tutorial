package org.fasttrackit.onlinelibrary.account;

import com.sdl.selenium.web.link.WebLink;
import cucumber.api.java.en.Given;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountSteps.class);

    @Given("^I click on edit Billing Address$")
    public void I_click_on_edit_Billing_Address() {
        WebLink edit = new WebLink().setText("Edit").setLabel("Billing Address").setLabelTag("*");
        edit.click();
    }

    @Given("^I click on edit Shipping Address$")
    public void I_click_on_edit_Shipping_Address() {
        WebLink edit = new WebLink().setText("Edit").setLabel("Shipping Address").setLabelTag("*");
        edit.click();
    }
    
}
