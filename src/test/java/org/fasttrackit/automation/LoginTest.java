package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginTest extends TestBase {

    @Test
    public void validLoginTest() {
        doLogin(USER_NAME, PASSWORD);

        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test(dataProvider = "invalidUsers")
    public void invalidLoginText(String user, String pass, String expectedMessage) {
        doLogin(user, pass);

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println(message);

        assertThat(message, is(expectedMessage));
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
                {"wrong@user", "wrong.pass", "Invalid user or password!"},
                {"empty.pass@user", "", "Please enter your password!"},
                {"", "empty.user", "Please enter your email!"},
                {"", "", "Please enter your email!"}
        };
    }

}
