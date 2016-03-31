package org.fasttrackit.elements;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
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

    private void openPage() {
//        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");
        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/bootstrap/index.html");
    }
}
