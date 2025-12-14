package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_13_Button {
    WebDriver driver;
    Select select;
    Action actions;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        // nhận driver là tham số thì khai báo ở đây
    }
    @Test
    public void TC_01_Fahasa() {
        driver.get("https://www.fahasa.com/customer/account/create");

driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
By loginButton = By.cssSelector("button.fhs-btn-login");

// isFalse vi dang can button la disable
Assert.assertFalse(driver.findElement(loginButton).isEnabled());
// lay ra ma mau
         driver.findElement(loginButton).getCssValue("");

    }
    @Test
    public void TC_02_NopCommerce() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");

driver.findElement(By.cssSelector("a.ico-register")).click();
driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Lan");
driver.findElement(By.cssSelector("input#LastName")).sendKeys("Do");
driver.findElement(By.cssSelector("input#Email")).sendKeys("lando99@gmail.com");


// khai báo biến -> gán giá trị -> chọn giá trị cho dropdown list
new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("");
new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("");
new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("");


driver.findElement(By.cssSelector("input#Password")).sendKeys("429910");
driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("429910");
driver.findElement(By.cssSelector("button#register-button")).click();

// verify đăng ki thanh cong
Assert.assertEquals(driver.findElement(By.cssSelector("div.page registration-result-page div.result")).getText(), "Your registration completed");

    }


    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }
}