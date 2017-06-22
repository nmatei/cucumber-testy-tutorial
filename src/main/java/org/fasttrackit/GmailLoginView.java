package org.fasttrackit;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;

public class GmailLoginView extends WebLocator {

    public GmailLoginView() {
        setTag("form");
    }

    private TextField userNameField = new TextField(this).setAttribute("aria-label", "Email or phone");
    private WebLocator nextBtn = new WebLocator(this).setText("Next");
    private WebLocator backBtn = new WebLocator(this).setText("Back"); // should not be present


    public static void main(String[] args) {
        GmailLoginView view = new GmailLoginView();

        WebLocatorUtils.getXPathScript(view);
    }
}
