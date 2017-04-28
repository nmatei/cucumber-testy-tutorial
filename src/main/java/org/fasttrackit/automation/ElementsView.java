package org.fasttrackit.automation;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

public class ElementsView extends WebLocator {
    public ElementsView() {
        setTag("body");
    }

    public WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
    public WebLocator widthEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);
    public CheckBox stopProcessCheckbox = new CheckBox(stopProcessLabel);
    public CheckBox labelWidthEnterCheckbox = new CheckBox(widthEnterLabel);

    public WebLocator autoOption = new WebLocator().setText("Auto").setClasses("filter-option");
    public WebLocator menuDropDown = new WebLocator().setClasses("dropdown-menu");
    public WebLocator manualOption = new WebLocator(menuDropDown).setText("Manual");

    public DropDown techDropDown = new DropDown();

    public static void main(String[] args) {
        ElementsView test = new ElementsView();
//        System.out.println(test.autoOption.getSelector());
//        System.out.println(test.manualOption.getSelector());
//        System.out.println(test.stopProcessLabel.getSelector());
//        System.out.println(test.widthEnterLabel.getSelector());
//        System.out.println(test.stopProcessCheckbox.getSelector());
//        System.out.println(test.labelWidthEnterCheckbox.getSelector());

        WebLocatorUtils.getXPathScript(test);
    }

}
