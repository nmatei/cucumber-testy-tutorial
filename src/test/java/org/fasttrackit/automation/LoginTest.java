package org.fasttrackit.automation;

import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginTest extends TestBase {

//    private LoginPage page;

//    public LoginTest() {
//        page = PageFactory.initElements(driver, LoginPage.class);
//    }

    @Test
    public void validLoginTest() {
        openLoginPage();

        Table users = new Table();

        String user = users.getText(1, 1);
        String pass = users.getText(1, 2);

        loginView.login(user, pass);

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException er) {
            Assert.fail("Could not login. Logout button was not present!");
        }
    }

    @Test
    public void invalidPasswordTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is("Invalid user or password!"));
    }
}