package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_09_WebElement_Excercise {
    WebDriver driver;
   @BeforeClass
public void initialBrowser(){
        driver = new FirefoxDriver();
   }

    @Test
    public void TC_01_Displayed() {
driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));
        
    }

    @Test
    public void TC_02_Enabled() {

    }

    @Test
    public void TC_03_() {


    }
    @AfterClass
    public void afterClass() {

    driver.quit();
    }
}