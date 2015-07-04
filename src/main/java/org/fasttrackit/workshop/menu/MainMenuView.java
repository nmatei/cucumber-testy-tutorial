package org.fasttrackit.workshop.menu;

import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;

public class MainMenuView {
    public static Button preferences = new Button().setText("Preferences");
    public static WebLink logout = new WebLink().setText("Logout");

    public static void logout(){
        logout.assertClick();
    }
}
