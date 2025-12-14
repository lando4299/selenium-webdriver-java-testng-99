package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Frame_Iframe {
    WebDriver driver;


   @BeforeClass
public void initialBrowser(){
    driver = new ChromeDriver();
    driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}

    @Test
    public void TC_01_Iframe_FormSite() throws InterruptedException {
       driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
       // Iframe là 1 ảnh cần click vào mới mở ra
       driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();
       Thread.sleep(3000);
        // Switch qua iframe: có 3 cách để chuyển
        //1.Dùng index: truyền vào index tương ứng của iframe bắt đầu từ 0, TH có nhiều iframe truyền đúng index
       // driver.switchTo().frame(0);
        //2. Dùng name/ id của ifram ===> có TH name/ id thay đổi khi load lại page
      //  driver.switchTo().frame("frame-one85593366");

        //3. Dùng WebElement=> tối ưu cover cả 2 cách dùng trên
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));


        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("North Dorm");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        Thread.sleep(3000);
        // từ B về A
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-kashmir")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");


        // từ B đến C
        driver.switchTo().frame("abc");
        // từ C về B ( về page cha)
        driver.switchTo().parentFrame();
        // từ B về A ( page chính )
        driver.switchTo().defaultContent();


    }

    @Test
    public void TC_02_Iframe_ToiDiCodeDao() throws InterruptedException {
       driver.get("https://toidicodedao.com/");
       driver.switchTo().frame(0);
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div._1drq")).getText(),"399,754 followers");
       

    }

    @Test
    public void TC_03_() {


    }
    @AfterClass
    public void afterClass() {

   // driver.quit();
    }
}