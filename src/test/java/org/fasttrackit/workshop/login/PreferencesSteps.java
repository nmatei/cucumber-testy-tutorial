package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.menu.MainMenuView;
import org.fasttrackit.workshop.prefences.PreferencesWindow;

public class PreferencesSteps extends TestBase {

    public static final String NEW_PASSWORD = "eu.p";

    private PreferencesWindow preferencesWindow = new PreferencesWindow();

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() {
        preferencesWindow.open();
    }

    @And("^I input current password$")
    public void I_input_current_password() {
        preferencesWindow.typeCurrentPassword(LoginSteps.VALID_PASSWORD);
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferencesWindow.typeNewPassword(NEW_PASSWORD);
    }

    @And("^I confirm the new password$")
    public void I_confirm_the_new_password() {
        preferencesWindow.typeConfirmPassword(NEW_PASSWORD);
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button() throws Throwable {
        preferencesWindow.save();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String message) throws Throwable {
        preferencesWindow.statusMessageShouldBePresent(message);
        LoginSteps.VALID_PASSWORD = NEW_PASSWORD;
    }

    @And("^I close Preferences window$")
    public void I_close_Preferences_window() throws Throwable {
        preferencesWindow.close();
    }

    @And("^I logout$")
    public void I_logout() throws Throwable {
        MainMenuView.logout();
    }
}
