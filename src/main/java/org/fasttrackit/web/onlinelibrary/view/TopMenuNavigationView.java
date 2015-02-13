package org.fasttrackit.web.onlinelibrary.view;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.link.WebLink;

public class TopMenuNavigationView extends WebLocator {

    public TopMenuNavigationView() {
        setClasses("top-nav-bar");
    }
    
    public WebLink loginButton = new WebLink(this, "Log In");
}
