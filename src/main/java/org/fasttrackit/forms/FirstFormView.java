package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.extjs3.form.Label;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstFormView extends WebLocator {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstFormView.class);

    public FirstFormView() {
        System.out.println("you have created a FirstFormView");
        setTag("form");

        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);
    }

    public DatePicker datePicker = new DatePicker(this);
    public WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");

    public WebLocator stopProcessLabel = new WebLocator(this).setTag("label").setText("Stop the process?", SearchType.TRIM);
    public WebLocator enterLabel = new WebLocator(this).setTag("label").setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);
    public CheckBox stopProcessCheckbox = new CheckBox(this).setLabel("Stop the process?", SearchType.TRIM).setLabelPosition("//");
    public CheckBox enterCheckbox = new CheckBox(enterLabel);

    public static void main(String[] args) {
        LOGGER.info("Eu astazi mananc {} {}, si maine {} {}.", 2, "mere", 3, "pere");
        //FirstFormView formView = new FirstFormView();

        //System.out.println(formView.stopProcessCheckbox.getSelector());

        //generateTDXpath();
    }

    public static void generateTDXpath() {
        WebLocator emailCell = new WebLocator().setText("peterparker@mail.com");
        WebLocator row = new WebLocator().setTag("tr").setChildNodes(emailCell);
        CheckBox select = new CheckBox(row);

        LOGGER.debug(select.getXPath());

        Table table = new Table();
        Row row1 = table.getRow(new Cell(4, "peterparker@mail.com"));
        CheckBox select1 = new CheckBox(row1);

        LOGGER.debug(select1.getXPath());
    }

    public static void moreClassesExample() {
        WebLocator nav = new WebLocator().setClasses("navbar navbar-default");
        WebLocator pref = new WebLocator(nav).setText("Preferences");
        System.out.println(nav.getSelector());
        System.out.println(pref.getSelector());
    }
}
