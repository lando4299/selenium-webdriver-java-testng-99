package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Fixed_Popup {
    WebDriver driver;
String projectPath= System.getProperty("user.div");
String osName = System.getProperty("os.name");

   @BeforeClass
public void beforeClass(){
    driver = new FirefoxDriver();
    driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}

    @Test
    public void TC_01_NgoaiNgu() {
       // popup nayf fix luon enable trong code dù co hiển thị tren UI hay ko
       driver.get("https://ngoaingu24h.vn/");
      driver.findElement(By.xpath("//div[@class='action']//button[text()='Đăng nhập']")).click();
       // driver.findElement(By.cssSelector("button.login_")).click();

        By logInPopup = By.xpath("//div[@role=\"presentation\"]/div[@role=\"dialog\"]");
        Assert.assertTrue(driver.findElement(logInPopup).isDisplayed());

        driver.findElement(By.xpath("//input[@placeholder=\"Tài khoản đăng nhập\"]")).sendKeys("automationfc");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("automationfc");
        driver.findElement(By.xpath("//button[@type=\"submit\" and text()=\"Đăng nhập\"]")).click();

    }

    @Test
    public void TC_02_Kyna() throws InterruptedException {
       driver.get("https://skills.kynaenglish.vn/dang-nhap");
       By loginPopup= By.cssSelector("div#k-popup-account-login-mb>div.modal-dialog");
       Thread.sleep(3000);
       Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

       driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    // Fix popup neu close di thi ko nam trong DOM / HTML
    public void TC_03_Tiki() throws InterruptedException {
       driver.get("https://tiki.vn/");
       By loginPopupTiki= By.cssSelector("div#VIP_BUNDLE");

       Assert.assertTrue(driver.findElement(loginPopupTiki).isDisplayed());
       driver.findElement(By.cssSelector("div#VIP_BUNDLE img[alt='close-icon']")).click();
        Thread.sleep(3000);
        // Kiem tra popup ko hien thi sau khi dong
        //Voi popup sau khi close ko co trong DOM/ HTML nen ko tim dc ==> dung findElements va kiem tra size =0

        Assert.assertEquals(driver.findElements(loginPopupTiki).size(),0);

    }

    @Test
    public void TC_04_FB() {
       driver.get("https://www.facebook.com/");
       driver.findElement(By.cssSelector("div._6ltg>a#u_0_0_Bi")).click();
       By popupLogin = By.cssSelector("div._52lo");

       Assert.assertTrue(driver.findElement(popupLogin).isDisplayed());


    }
    @AfterClass
    public void afterClass() {

    driver.quit();
    }
}