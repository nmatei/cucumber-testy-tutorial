package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.Preferences.PreferencesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PreferencesSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreferencesSteps.class);
    public static final String VALID_EMAIL = "eu@fast.com";
    public static final String NEW_PASSWORD = "eu.p";
    public static String VALID_PASSWORD = "eu.pass";

    private PreferencesView preferencesWindow = new PreferencesView();

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() {
        preferencesWindow.open();
    }

    @And("^I input current password$")
    public void I_input_current_password() {
        preferencesWindow.typeCurrentPassword(VALID_PASSWORD);
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferencesWindow.typeNewPassword(NEW_PASSWORD);
    }

    @And("^I confirm the new password$")
    public void I_confirm_the_new_password() throws Throwable {
        preferencesWindow.typeConfirmPassword(NEW_PASSWORD);
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I close Preference window$")
    public void I_close_Preference_window() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I can re-login with new credentials$")
    public void I_can_re_login_with_new_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }


}