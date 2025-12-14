package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
//// Online 30- topic 32
public class Topic_17_Action_I {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        action = new Actions(driver);  // lưu ý số nhiều
    }
    @Test
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTextBox = driver.findElement(By.cssSelector("input#age"));
        action.moveToElement(ageTextBox).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");
        Thread.sleep(2000);
    }
    @Test
    public void TC_02_Hover_Myntra() throws InterruptedException {
    driver.get("https://www.myntra.com/");
    action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text() = 'Kids']"))).perform();
    Thread.sleep(2000);

    driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text() = 'Home & Bath']")).click();


    }
@Test
    public void TC_03_Hover_Fahasa() throws InterruptedException {
    driver.get("https://www.fahasa.com/");
    action.moveToElement(driver.findElement(By.xpath("//div[@class='fhs_center_right fhs_mouse_point fhs_dropdown_hover fhs_dropdown_click']"))).perform(); // hover
    Thread.sleep(2000);

    action.moveToElement(driver.findElement(By.xpath("//span[text()='FOREIGN BOOKS']"))).perform(); // hover
    Thread.sleep(2000);

    driver.findElement(By.xpath("//div[@class='fhs_menu_content fhs_column_left']//a[text()='Fantasy']")).click(); // cha --> con
    Thread.sleep(2000);

    Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Fantasy']")).isDisplayed());
}

    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }
}