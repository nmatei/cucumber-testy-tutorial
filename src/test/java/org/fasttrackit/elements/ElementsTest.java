package org.fasttrackit.elements;

import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.DropDownList;
import org.fasttrackit.example.SenchaExampleView;
import org.fasttrackit.example.MultiSelectDropDownList;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementsTest.class);

    private Form form = new Form("Form Title");
    private UploadFile uploadBtn = new UploadFile(form, "TPT Test:");
    //private WebLocator inputUpload = new WebLocator(uploadBtn).setTag("input");

    @Test
    public void uploadTest() {
        openPage();
        String resourcesPath = PropertiesReader.RESOURCES_DIRECTORY_PATH;
        System.out.println(resourcesPath);
        //uploadBtn.click();
        uploadBtn.upload(resourcesPath + "\\feature\\login\\login.feature");
    }

    private void openPage() {
//        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");
        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/bootstrap/index.html");
    }

    //@Test
    public void invalidGmailAddressTest() {
        driver.get("https://gmail.com");
        TextField emailField = new TextField().setPlaceholder("Enter your email");
        emailField.setValue("invalid.email@examples.com");

        emailField.sendKeys(Keys.ENTER);
        //emailField.sendKeys(Keys.CONTROL, Keys.ARROW_LEFT, Keys.ARROW_LEFT);
        //emailField.currentElement.sendKeys(Keys.CONTROL, Keys.ARROW_LEFT, Keys.ARROW_LEFT);

        WebLocator errorElement = new WebLocator().setText("Sorry, Google doesn't recognize that email. ");
        errorElement.assertExists();
        //LOGGER.debug(error.getXPath());
        //LOGGER.debug(error.getText());
    }

    @Test
    public void scrollToViewTest() {
        SenchaExampleView senchaExampleView = new SenchaExampleView();

        senchaExampleView.open();

        WebDriverConfig.switchToLastTab();

        WebLocator headerCt = new WebLocator().setClasses("x-grid-header-ct");
        WebLocator header = new WebLocator(headerCt).setText("Manufacturer");
        WebLocator header2 = new WebLocator(headerCt).setText("Title");
        //header2.findElement();

        header.click();

        (new Actions(driver)).dragAndDrop(header.currentElement, header2.currentElement).perform();
//        (new Actions(WebDriverConfig.getDriver())).dragAndDropBy(header.currentElement, -280, -35).build().perform();
    }

    @Test
    public void scrollTest(){
        SenchaExampleView exampleView = new SenchaExampleView();
        exampleView.open("Miscellaneous", "Resizable");
        WebDriverConfig.switchToLastTab();

        WebLocator basicPanel = new WebLocator().setId("basic");
        WebLocator resizableEast = new WebLocator(basicPanel).setClasses("x-resizable-handle-east");
        resizableEast.mouseOver();
        (new Actions(WebDriverConfig.getDriver())).dragAndDropBy(resizableEast.currentElement, 300, 0).build().perform();
    }

    @Test
    public void iterationThrouElements() {
        PropertiesReader appProperties = new PropertiesReader("src\\test\\resources\\app.properties");

        driver.get(appProperties.getProperty("app.url"));

        WebLocator dataview = new WebLocator().setId("dataview-example");
        WebLocator wrap = new WebLocator(dataview).setClasses("thumb-wrap");
        WebLocator img = new WebLocator(wrap).setTag("img");

        //img.click();
        for(WebElement image : img.findElements()) {
            String title = image.getAttribute("title");
            LOGGER.debug(title);
        }

        WebLocator selectWrap = new WebLocator().setClasses("thumb-wrap").setText(appProperties.getProperty("dataview.select.item"), SearchType.DEEP_CHILD_NODE);
//        WebLocator selectElement = new WebLocator().setText(appProperties.getProperty("dataview.select.item"));
//        WebLocator selectWrap = new WebLocator().setClasses("thumb-wrap").setChildNodes(selectElement);
        selectWrap.click();

        //wrap.setPosition(3);
        //LOGGER.debug(img.getSelector().toString());
        //wrap.click();

//        Utils.sleep(2000);
//        List<WebElement> images = driver.findElements(By.cssSelector("#dataview-example img"));
////        for (int i = 0; i < images.size(); i++) {
////            String title = images.get(i).getAttribute("title");
////            LOGGER.debug(title);
////        }
//        for(WebElement image : images) {
//            String title = image.getAttribute("title");
//            LOGGER.debug(title);
//        }
    }
}
