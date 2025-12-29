package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {
    // Webdriver chứa các hàm để tướng tác với browser,  driver.xxx để gọi haàm
    WebDriver driver;
WebElement element;

   @BeforeClass
public void initialBrowser() throws MalformedURLException {
    driver = new FirefoxDriver();

}
    @Test
    public void TC_01_WebElement () {
//DÙng 1 lần
        driver.findElement(By.xpath("")).click();
        element = driver.findElement(By.xpath(""))   ;
        // click vào các element dạng: button, checkbox, radio, link,image,...
        element.click(); ///**
        // sendKey: nhập liệu vào element textBox, textarea , droplist ( edit)
        element.clear();// xóa dữ liệu trước khi sendKey vào
        element.sendKeys(""); // **
        element.sendKeys(Keys.ALT); // các phím trên bàn phím
        // tác dung với các form như
        element.submit();
        // kiểm tra element bất kì có hiển thị hay ko

        element.isDisplayed(); //
        element.isSelected();
        element.isEnabled();
        element.getText();
        element.getAttribute("kKK");

   }


    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {


    }
    @AfterClass
    public void afterClass() {

    driver.quit();
    }
}