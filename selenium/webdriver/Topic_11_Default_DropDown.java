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


public class Topic_11_Default_DropDown {
    WebDriver driver;
    Select select;
    Action actions;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        // nhận driver là tham số thì khai báo ở đây
    }
    @Test
    public void TC_01_Facebook_SignUp() {
        driver.get("https://www.facebook.com/r.php?entry_point=login");
        // dropdown xuất hiện
        select = new Select(driver.findElement(By.cssSelector("select#day")));
        //1. Index
        select.selectByVisibleText("04");
        // chọn xong vefify đã chọn đúng chưa
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"04");

// chọn tháng
        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("February");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"February");
// chọn Năm
        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("1999");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1999");


        //2. Value
       // select.selectByValue("9000");
        // ko bắt buộc phải có attribute value => ko có vẫn chạy đc
        // nhìn vào ko biết chạy manual

        //3. Text
        //select.selectByVisibleText("thành phố Hà Nội"); /// =? NÊN CHỌN TEXT
        // ko có text thì ko biết chọn giá trị nào ( vì ko hiển thị nên cho user chọn )
        // thường ko có các option trùng text
        // text ko thay đổi nếu đổi vị trí
        // đọc code có chạy manual đc ko => đc vì nhìn vào text và chạy lại






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