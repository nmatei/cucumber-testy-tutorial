package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreferencesTest extends TestBase {

    private PreferencesView page = new PreferencesView();

    @Test
    public void preferencesWindowShouldCloseTest() {
        doLogin(USER_NAME, PASSWORD);
        page.open();
        page.close();
    }

    @Test
    public void tryToChangePassWithInvalidPreviewPasswordTest() {
        changePassword("wrong.pass", "new.pass", "new.pass");

        String message = page.getStatusMsg();

        assertThat(message, is("Your preview password is incorrect!"));
    }

    @Test
    public void tryToChangePassWithInvalidConfirmPassTest() {
        changePassword("eu.pass", "new.pass", "new.pass.wrong");

        String message = page.getStatusMsg();

        assertThat(message, is("Password does not match the confirm password!"));
    }

    @Test
    public void successChangePassTest() {
        changePassword(PASSWORD, "new.pass", "new.pass");

        String message = page.getStatusMsg();

        assertThat(message, is("Your password has been successfully changed."));

        page.close();
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        PASSWORD = "new.pass";
        doLogin(USER_NAME, PASSWORD);
        logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        // revert to old pass
        changePassword("new.pass", "eu.pass", "eu.pass");
        message = page.getStatusMsg();
        assertThat(message, is("Your password has been successfully changed."));
        PASSWORD = "eu.pass";
    }

    private void changePassword(String pass, String newPass, String repeatPass) {
        doLogin(USER_NAME, PASSWORD);
        page.open();
        page.changePassword(pass, newPass, repeatPass);
    }


}
