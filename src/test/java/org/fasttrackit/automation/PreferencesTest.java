package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreferencesTest extends TestBase {

    @Test
    public void preferencesWindowShouldCloseTest() {
        doLogin("eu@fast.com", "eu.pass");

        WebElement preferencesBtn = driver.findElement(By.cssSelector(".navbar-header button"));
        preferencesBtn.click();

        Utils.sleep(400);
//        WebElement closeBtn = driver.findElement(By.cssSelector("#preferences-win .modal-footer button"));
        WebElement xBtn = driver.findElement(By.cssSelector("#preferences-win button.close"));
        xBtn.click();
    }


    @Test
    public void tryToChangePassWithInvalidPreviewPasswordTest() {
        changePassword("wrong.pass", "new.pass", "new.pass");

        WebElement statusMsg = driver.findElement(By.xpath("//*[@id='preferences-win']//*[@class='status-msg']"));
        String message = statusMsg.getText();
        assertThat(message, is("Your preview password is incorrect!"));
    }

    @Test
    public void tryToChangePassWithInvalidConfirmPassTest() {
        changePassword("eu.pass", "new.pass", "new.pass.wrong");

        WebElement statusMsg = driver.findElement(By.xpath("//*[@id='preferences-win']//*[@class='status-msg']"));
        String message = statusMsg.getText();
        assertThat(message, is("Password does not match the confirm password!"));
    }

    @Test
    public void successChangePassTest() {
        changePassword("eu.pass", "new.pass", "new.pass");

        WebElement statusMsg = driver.findElement(By.xpath("//*[@id='preferences-win']//*[@class='status-msg']"));
        String message = statusMsg.getText();
        assertThat(message, is("Your password has been successfully changed."));

        WebElement xBtn = driver.findElement(By.cssSelector("#preferences-win button.close"));
        xBtn.click();

        Utils.sleep(400);
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        doLogin("eu@fast.com", "new.pass");
        logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    private void changePassword(String pass, String newPass, String repeatPass) {
        doLogin("eu@fast.com", "eu.pass");
        WebElement preferencesBtn = driver.findElement(By.cssSelector(".navbar-header button"));
        preferencesBtn.click();

        WebElement passwordField = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name='password']"));
        WebElement newPasswordField = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name='newPassword']"));
        WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name='newPasswordRepeat']"));
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id='preferences-win']//button[text()='Save']"));

        passwordField.sendKeys(pass);
        newPasswordField.sendKeys(newPass);
        confirmPasswordField.sendKeys(repeatPass);
        saveBtn.click();
    }


}
