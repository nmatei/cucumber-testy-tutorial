package org.fasttrackit.automation;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordView extends WebLocator {
    public ChangePasswordView() {
        setId("preferences-win");
    }

    private WebLocator currentPasswordField = new WebLocator().setName("password");
    private WebLocator newPasswordField = new WebLocator().setName("newPassword");
    private WebLocator repeatPasswordField = new WebLocator().setName("newPasswordRepeat");
    private WebLocator saveBtn = new WebLocator(this).setText("Save");
    private WebLocator close = new WebLocator(this).setClasses("btn-default");

    private WebLocator statusMsg = new WebLocator().setClasses("status-msg");

    public void changePassword(String currentPass, String newPass) {
        changePassword(currentPass, newPass, newPass);
    }

    public void changePassword(String currentPass, String newPass, String repeatNewPass) {
        currentPasswordField.sendKeys(currentPass);
        newPasswordField.sendKeys(newPass);
        repeatPasswordField.sendKeys(repeatNewPass);
        saveBtn.click();
    }

    public String getStatusMessage() {
        String msg = statusMsg.getText();
        System.out.println(msg);
        return msg;
    }

    public static void main(String[] args) {
        WebLocatorUtils.getXPathScript(new ChangePasswordView());
    }
}
