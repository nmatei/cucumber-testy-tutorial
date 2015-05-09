package org.fasttrackit.workshop.login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordSteps extends TestBase {

    private ChangePasswordView changePasswordView = new ChangePasswordView();

    @When("^I change my password$")
    public void I_change_my_password() throws Throwable {
        changePasswordView.clickPreferencesButton();
        changePasswordView.changePassword("eu.pass", "eu.new", "eu.new");
    }

    @Then("^my password is successfully changed$")
    public void my_password_is_successfully_changed() throws Throwable {
        String message = changePasswordView.getStatusMessage();

        assertThat(message, is("Your password has been successfully changed."));


    }
}
