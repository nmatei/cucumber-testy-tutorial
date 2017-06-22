package org.fasttrackit.automation;

import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.extjs6.grid.Grid;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ExamplesTest extends TestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExamplesTest.class);

    Table table = new Table().setClasses("table-striped");

    WebLocator firstName = new WebLocator().setText("John");
    WebLocator lastName = new WebLocator().setText("Moore");

    WebLocator email = new WebLocator().setText("nickwhite@mail.com");
    WebLocator row = new WebLocator().setTag("tr").setChildNodes(email);

    CheckBox select = new CheckBox(row);

    @Test
    public void selectRowTest() {
        doLogin(USER_NAME, PASSWORD);

        select.click();
        System.out.println(select.getSelector());

        row.setChildNodes(firstName, lastName);

        select.click();
        LOGGER.debug(select.getSelector().toString());
    }

    @Test
    public void selectRowFromTableTest() {
        doLogin(USER_NAME, PASSWORD);

        Row row = table.getRow(2);
        CheckBox select = new CheckBox(row);
        select.click();

        Row row2 = table.getRow("nickwhite@mail.com");
        CheckBox select2 = new CheckBox(row2);
        select2.click();

        Row row3 = table.getRow("bobsmith@", SearchType.STARTS_WITH);
        CheckBox select3 = new CheckBox(row3);
        select3.click();

        Row row4 = table.getRow(new Cell(2, "David"), new Cell(3, "Miller"));
        CheckBox select4 = new CheckBox(row4);
        select4.click();

        Row row5 = table.getRow(new Cell("Johnxxx"), new Cell("Moore"));
        CheckBox select5 = new CheckBox(row5);
        select5.click();
    }


    WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.CHILD_NODE);
    WebLocator enterLabel = new WebLocator().setText("Label with Enter.", SearchType.CHILD_NODE);

    CheckBox stopCheckBox = new CheckBox(stopProcessLabel);
    CheckBox enterCheckBox = new CheckBox(enterLabel);

    @Test
    public void checkboxLabelTest() {
        //doLogin();
        stopProcessLabel.click();
        enterLabel.click();

        stopCheckBox.click();
        enterCheckBox.click();
    }

    @Test
    public void checkboxTest() {
        //doLogin();
        CheckBox stopCheckBox = new CheckBox().setLabel("Stop the process?", SearchType.CHILD_NODE).setLabelPosition("//");
        CheckBox enterCheckBox = new CheckBox().setLabel("Label with Enter.", SearchType.CHILD_NODE).setLabelPosition("//");

        stopCheckBox.click();
        enterCheckBox.click();
    }

    @Test
    public void multiSelect() {
        doLogin();

        SelectPicker techPicker = new SelectPicker().setLabel("Tech:");
        techPicker.select("Manual");

        MultiSelect multiSelect = new MultiSelect().setLabel("Source:");
        multiSelect.select("Cheese", "Tomatoes");
    }


    // open http://examples.sencha.com/extjs/6.2.0/examples/
    // click - Grids
    // select one example (first)


    WebLocator iframe = new WebLocator().setTag("iframe");
    WebLocator gridsHeader = new WebLocator().setText("Grids").setRenderMillis(20000);
    WebLocator gridDataBinding = new WebLocator().setText("Grid Data Binding");
    WebLocator bufferedStore = new WebLocator().setText("Grid with Buffered Store");

    WebLocator expectedTitle = new WebLocator().setText("Data Binding Example");

    @Test
    public void senchaGridExampleTest() {
        driver.get("http://examples.sencha.com/extjs/6.2.0/examples/");

        iframe.waitToRender();
        driver.switchTo().frame(iframe.getWebElement());
        gridsHeader.click();
        gridDataBinding.click();

        WebDriverConfig.switchToLastTab();
        expectedTitle.assertReady();

        WebLocator cell = new WebLocator().setText("Are You Afraid of the Dark?");
        cell.click();

        driver.close();
        WebDriverConfig.switchToFirstTab();

        driver.switchTo().frame(iframe.getWebElement());
        bufferedStore.click();
        WebDriverConfig.switchToLastTab();
    }



    public static String i18n(String text) {
        String language = "en";
        if(text.equals("Current Password")) {
            text = "Parola Noua";
        }
        return text;
    }

    public static void main(String[] args) {
        ExamplesTest test = new ExamplesTest();

        TextField passwordField = new TextField().setLabel(i18n("Current Password"));
        System.out.println(passwordField.getSelector());
//        System.out.println(test.select.getSelector());
//
//        test.row.setChildNodes(test.firstName, test.lastName);
//
//        LOGGER.debug(test.select.getSelector().toString());

//        Row row4 = test.table.getRow(new Cell(2, "David"), new Cell(3, "Miller"));
//        CheckBox select4 = new CheckBox(row4);

//        LOGGER.debug(select4.getSelector().toString());
    }
}
