package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.DatePicker;
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

    private WebLocator stopProcessContainer = new WebLocator(this).setElPath("/div[3]");
    private WebLocator enterContainer = new WebLocator(this).setElPath("/div[4]");
    public CheckBox stopProcessCheckbox = new CheckBox(stopProcessContainer);
    public CheckBox enterCheckbox = new CheckBox(enterContainer);

    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();

        System.out.println(formView.stopProcessCheckbox.getSelector());
    }
}
