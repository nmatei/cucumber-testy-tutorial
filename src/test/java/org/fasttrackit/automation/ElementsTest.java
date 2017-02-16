package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ElementsTest extends TestBase {

    private ElementsView page = new ElementsView();

    @Test
    public void checkboxesTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        page.stopProcessCheckbox.click();
        page.labelWidthEnterCheckbox.click();

        Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.widthEnterLabel.click();

        Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.widthEnterLabel.click();

        assertThat("Stop the process is not selected!", page.stopProcessCheckbox.isSelected(), is(true));
        assertThat("Label with Enter.", page.labelWidthEnterCheckbox.isSelected(), is(true));
    }

    @Test
    public void dropDownTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        page.autoOption.click();
        page.manualOption.click();
    }
}
