package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreferencesTest extends TestBase {

    private PreferencesPage page;
    public PreferencesTest(){
        page = PageFactory.initElements(driver, PreferencesPage.class);
    }

    @Test
    public void preferencesWindowShouldCloseTest() {
        doLogin("eu@fast.com", "eu.pass");
        page.open();
        page.close();
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
        page.open();

        page.changePassword(pass, newPass, repeatPass);
    }


}
