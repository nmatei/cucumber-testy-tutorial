package org.fasttrackit.example;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;

public class SenchaExampleView {

    public void open() {
        open("Grids", "Grid Data Binding");
    }

    public void open(String title, String example) {
        WebDriverConfig.getDriver().get("http://examples.sencha.com/extjs/6.0.2/examples/");

        WebLocator gridTab = new WebLocator().setText(title);
        WebLocator gridDataBinding = new WebLocator().setText(example);
        // mouse over - because element is not visible and must scroll to it
        gridTab.mouseOver();
        gridTab.click();
        gridDataBinding.click();
    }
}
