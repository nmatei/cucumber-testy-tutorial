package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TablesTest extends TestBase {

    @Test
    public void selectTableRowTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        //WebElement checkbox = driver.findElement(By.xpath("//table//input"));
        WebLocator checkbox = new WebLocator().setElPath("//table//input");

        checkbox.click();
    }

    Table table = new Table();

    @Test
    public void selectRowByEmail() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        Row row = table.getRow(new Cell(4, "davidmiller@mail.com"));

        CheckBox checkbox = new CheckBox(row);
        checkbox.click();

        WebLocator tableLocator = new WebLocator().setTag("table");
        WebLocator firstNameLocator = new WebLocator().setText("Bob");
        WebLocator lastNameLocator = new WebLocator().setText("Smith");
        WebLocator rowLocator = new WebLocator(tableLocator).setTag("tr").setChildNodes(firstNameLocator, lastNameLocator);
        WebLocator checkboxLocator = new WebLocator().setContainer(rowLocator).setTag("input");
        checkboxLocator.click();
    }

    @Test
    public void selectRowByEmailsSetup(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");
    }

    @Test(dependsOnMethods = "selectRowByEmailsSetup", dataProvider = "emailsProvider")
    public void selectRowByEmails(String firstName, String email) {
        Row row = table.getRow(new Cell(2, firstName), new Cell(4, email));
        CheckBox checkbox = new CheckBox(row);
        checkbox.click();
    }

    @DataProvider
    public static Object[][] emailsProvider() {
        return new Object[][]{
                {"Nick", "nickwhite@mail.com"},
                {"David", "davidmiller@mail.com"},
                {"Peter", "peterparker@mail.com"}
        };
    }
}
