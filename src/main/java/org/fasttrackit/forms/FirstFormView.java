package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.web.WebLocator;

public class FirstFormView extends WebLocator {

    public FirstFormView() {
        System.out.println("you have created a FirstFormView");
        setTag("form");

        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);
    }

    public DatePicker datePicker = new DatePicker(this);
    public WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");

    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();

        System.out.println(formView.selectCalendar.getSelector());
    }
}
