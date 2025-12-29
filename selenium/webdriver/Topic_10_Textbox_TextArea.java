package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_10_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_TechPanda() {
        driver.get("");

    }

    @Test
    public void TC_02_Enabled() {

    }

    @Test
    public void TC_03_Selected() {


    }
    @Test
    public void TC_04_Page_Source() {


    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}