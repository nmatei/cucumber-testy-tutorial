package org.fasttrackit.example;

import com.sdl.selenium.web.button.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBarPage {
    public static Button PREFERENCES = new Button().setText("Preferences");

    @FindBy(how = How.XPATH, using = "//nav//button")
    private WebElement preferencesButton;

    public void openPreferencesWindow() {
        preferencesButton.click();
    }
}
