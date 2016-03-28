package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordView {
    private WebLocator win = new WebLocator().setId("preferences-win").setClasses("in");

    private WebLocator currentPassField = new WebLocator(win).setName("password");
    private WebLocator newPassField = new WebLocator(win).setName("newPassword");
    private WebLocator repeatPassField = new WebLocator(win).setName("newPasswordRepeat");
    private WebLocator saveBtn = new WebLocator(win).setText("Save");
    private WebLocator statusElement = new WebLocator(win).setClasses("status-msg");

    public static void main(String[] args) {
        ChangePasswordView view = new ChangePasswordView();
        System.out.println(view.saveBtn.getSelector());
    }

    public void changePassword(String password, String newPassword, String repeatPassword) {
        currentPassField.sendKeys(password);
        newPassField.sendKeys(newPassword);
        repeatPassField.sendKeys(repeatPassword);
        saveBtn.click();
    }

    public String getStatusMessage() {
        return statusElement.getHtmlText();
    }
}
