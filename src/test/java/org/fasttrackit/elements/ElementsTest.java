package org.fasttrackit.elements;

import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.DropDownList;
import org.fasttrackit.example.MultiSelectDropDownList;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ElementsTest extends TestBase {

    @Test
    public void checkboxTest() {
        openPage();

        FirstFormView form = new FirstFormView();
        form.enterCheckbox.assertClick();
        form.stopProcessCheckbox.assertClick();
        Utils.sleep(3000);
        form.stopProcessLabel.assertClick();
        form.enterLabel.assertClick();
    }

    @Test
    public void selectTest() {
        openPage();
        SelectPicker picker = new SelectPicker().setLabel("Tech:");

        String v = picker.getValue();
        Assert.assertEquals(v, "Auto");

        picker.select("Manual");

        v = picker.getValue();
        Assert.assertEquals(v, "Manual");
    }

    @Test
    public void dropDownTest() {
        openPage();
        DropDownList downList = new DropDownList().setLabel("Tech:");
        downList.select("Manual");

        DropDownList executeDownList = new DropDownList().setLabel("Execute");
        executeDownList.select("No");

        MultiSelectDropDownList sourceDownList = new MultiSelectDropDownList().setLabel("Source:");
        sourceDownList.multiSelect("Tomatoes", "Mushrooms");
    }

    private void openPage() {
//        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");
        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/bootstrap/index.html");
    }
}
