package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.extjs3.form.Label;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

public class FirstFormView extends WebLocator {

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
        FirstFormView formView = new FirstFormView();

        System.out.println(formView.stopProcessCheckbox.getSelector());
    }
}
