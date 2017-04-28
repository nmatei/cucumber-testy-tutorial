package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;

public class ConfigReader extends PropertiesReader {
    public ConfigReader() {
        super("src\\test\\resources\\config.properties");
    }

    public String getUser() {
        return getProperty("valid.user");
    }
    public String getPass() {
        return getProperty("valid.pass");
    }
}
