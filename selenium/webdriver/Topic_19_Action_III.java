package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//// Online 30- topic 33
public class Topic_19_Action_III {
    WebDriver driver;
    Actions action;   // dùng cho interface/// khai báo


    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        action = new Actions(driver);  // lưu ý số nhiều /// 2. Khởi tạo

    }
    @Test
    public void TC_01_Drag_Drop_HTML() throws InterruptedException {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        WebElement sourceCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));

        action.dragAndDrop(sourceCircle,targetCircle).perform();
        Thread.sleep(3000);
        Assert.assertEquals(targetCircle.getText(),"You did great!");
        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toUpperCase(),"#03A9F4");


    }
    @Test
    public void TC_02_Scroll_To_Element() throws InterruptedException {
        driver.get("");
        Thread.sleep(3000);
        action.scrollToElement(driver.findElement(By.cssSelector(""))).perform();
        Thread.sleep(3000);
        // Lưu ý: hàm scroll to element chạy oke với chrome và edge, firefox bị lỗi nếu element năằm ngoài viewport




    }
@Test
    public void TC_03_Double_Click()  {

}
@Test
    public void TC_07_Right_Click()  {



    }

    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }
}