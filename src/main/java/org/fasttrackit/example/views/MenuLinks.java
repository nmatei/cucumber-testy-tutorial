package org.fasttrackit.example.views;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.link.WebLink;

public class MenuLinks extends WebLocator {

    public MenuLinks() {
        setId("top-menu");
    }

    public WebLink homeLink = new WebLink(this, "HOME");
    public WebLink projectsLink = new WebLink(this, "Projects");
    public WebLink aboutLink = new WebLink(this, "About");
    public WebLink contactLink = new WebLink(this, "Contact");
}
