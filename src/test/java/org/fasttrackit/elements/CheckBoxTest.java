package org.fasttrackit.elements;

import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.ChangePasswordView;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.LoggedInTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends LoggedInTestBase {

    @Test
    public void checkboxTest() {
        FirstFormView form = new FirstFormView();
        form.enterCheckbox.click();
        form.stopProcessCheckbox.click();
        Utils.sleep(3000);
        form.stopProcessLabel.click();
        form.enterLabel.click();

        NavigationBarPage.PREFERENCES.click();

        // possible errors
        WebLocator x = new WebLocator().setText("no existing button");
        x.click();

        ChangePasswordView changePasswordPage = new ChangePasswordView();
        changePasswordPage.close();
    }

    @Test
    public void selectTest() {
        SelectPicker picker = new SelectPicker().setLabel("Tech:");

        String v = picker.getValue();
        Assert.assertEquals(v, "Auto");

        picker.select("Manual");

        v = picker.getValue();
        Assert.assertEquals(v, "Manual");
    }
}
