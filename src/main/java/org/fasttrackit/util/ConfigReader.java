package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;

public class ConfigReader extends PropertiesReader{
    public ConfigReader() {
        super("src\\main\\resources\\config.properties");
    }

    public String getUrl() {
        return getProperty("test.url");
    }

    public String getUser() {
        return getProperty("valid.user");
    }

    public String getPass() {
        return getProperty("valid.pass");
    }
}
