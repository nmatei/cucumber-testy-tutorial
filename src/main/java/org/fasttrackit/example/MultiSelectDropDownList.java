package org.fasttrackit.example;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

public class MultiSelectDropDownList extends DropDownList {

    public boolean select(String value) {
        return multiSelect(value);
    }

    public boolean multiSelect(String... values) {
        click();
        WebLocator select = new WebLocator().setClasses("btn-group", "open");
        for (String value : values) {
            WebLocator element = new WebLocator(select).withText(value, SearchType.CHILD_NODE);
            element.click();
        }
        //WebLocator shadow = new WebLocator().setClasses("dropdown-backdrop");
        //shadow.assertClick();
        click();
        return true;
    }
}
