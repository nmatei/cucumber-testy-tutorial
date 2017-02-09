package org.fasttrackit.automation;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ElementsTest extends TestBase {

    private LoginView loginView = new LoginView();

    @Test
    public void checkboxesTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        CheckBox stopProcessCheckbox = new CheckBox().setElPath("/html/body/form[1]/div[3]/label/input");
        CheckBox labelWidthEnterCheckbox = new CheckBox().setElPath("/html/body/form[1]/div[4]/label/input");

        WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
        WebLocator widthEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);

        stopProcessCheckbox.click();
        labelWidthEnterCheckbox.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        widthEnterLabel.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        widthEnterLabel.click();

        assertThat("Stop the process is not selected!", stopProcessCheckbox.isSelected(), is(true));
    }
}
