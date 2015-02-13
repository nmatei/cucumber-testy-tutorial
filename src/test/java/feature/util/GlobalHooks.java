package feature.util;

import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class GlobalHooks {
    private static final Logger LOGGER = Logger.getLogger(GlobalHooks.class);

    @After("@screen")
    public void screen(Scenario scenario) {
        String scenarioName = scenario.getName(); // TODO class name

        boolean isFailed = scenario.isFailed();
        if (isFailed) {
            LOGGER.warn(scenarioName + " Scenario has failed! Embed the screenshot in the report!--- ");
            byte[] screenshot = ((TakesScreenshot) WebDriverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    public void takeScreenShot(String screenShotName) {
        // trim screenshot name because deleting files from jenkins cannot delete files that have a long name
        if (screenShotName.length() > 80) {
            screenShotName = screenShotName.substring(0, 80);
        }
        screenShotName = screenShotName.replaceAll(" ", "_");
        String resultPath, screenShotsResultsPath;
        resultPath = new File("test-output").getAbsolutePath();
        LOGGER.debug("resultPath: " + resultPath);
        screenShotsResultsPath = new File(resultPath + File.separator + this.getClass().getSimpleName() + File.separator + screenShotName).getAbsolutePath();
        screenShotName = Utils.getScreenShot(screenShotName, resultPath + "\\" + this.getClass().getSimpleName() + "\\");
        LOGGER.info(screenShotsResultsPath);
    }

}
