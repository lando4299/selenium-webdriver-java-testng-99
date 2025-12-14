package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class Topic_15_Alert {
    WebDriver driver;


    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        // nhận driver là tham số thì khai báo ở đây

        driver.manage().window().maximize();

        // kích thước của browser là    1366 x 768
        //driver.manage().window().setSize(new Dimension(1366,768));
    }
    @Test
    public void TC_01_() {
        driver.get("https://www.fahasa.com/customer/account/create");

    }
    @Test
    public void TC_02_Multiple() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        // select tất cả checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span. form-checkbox-item>input"));


    }


    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }
}