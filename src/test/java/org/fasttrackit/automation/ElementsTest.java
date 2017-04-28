package org.fasttrackit.automation;

import com.sdl.selenium.bootstrap.button.Upload;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ElementsTest extends TestBase {

    private ElementsView page = new ElementsView();

    @Test
    public void checkboxesTest() {
        openLoginPage();

        loginView.login(config.getUser(), config.getPass());

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

        //->
        // page.techDropDown.select("Manual");
    }

    @Test
    public void dropDownComponentTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        DatePicker datePicker = new DatePicker();
        datePicker.setDate("9", "Apr", "2017");
        Utils.sleep(1000);

        datePicker.select("03/11/2016", "MM/dd/yyyy", Locale.ENGLISH);
//        datePicker.select("11/03/2016");

        DropDown dropDown = new DropDown();
        dropDown.select("Manual");
        Utils.sleep(500);
        dropDown.select("Auto");

//        MultiSelect source = new MultiSelect().setClasses("multiselect");//.setLabel("Source:");
//        source.select("Tomatoes", "Mozzarella");
    }

    private Form form = new Form("Form Title");
    private UploadFile uploadFile = new UploadFile(form); //, "TPT Test:"

    @Test
    public void uploadTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        uploadFile.upload(PropertiesReader.RESOURCES_DIRECTORY_PATH + "\\feature\\login\\login.feature");
    }
}
