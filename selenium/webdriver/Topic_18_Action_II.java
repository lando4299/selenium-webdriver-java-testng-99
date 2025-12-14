package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.grid.graphql.OsInfo;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//// Online 30- topic 33
public class Topic_18_Action_II {
    WebDriver driver;
    Actions action;   // dùng cho interface/// khai báo
    Keys keys;
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        action = new Actions(driver);  // lưu ý số nhiều /// 2. Khởi tạo
        if (osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        }
         else { keys = Keys.COMMAND;
        }
         keys = osName.startsWith("Windows") ? Keys.CONTROL : Keys.COMMAND;
         System.out.println("HDH là " + osName);
    }
    @Test
    public void TC_01_Click_And_Hold_Block()  {

        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber= driver.findElements(By.cssSelector("ol#selectable>li")); // lấy ra chuỗi allNumber chứa nhiều phần tử
        // Kiểm tra số phần tử của chuỗi vừa get
        Assert.assertEquals(allNumber.size(),30);
        //System.out .println(allNumber.get(0).getText());  // get(0) => lấy ra element đầu tieen cos index =0

        action.clickAndHold(allNumber.get(0))   // click vào element đầu tiền có index =0 và giữ chuột
                .moveToElement(allNumber.get(3)) // kéo đến vị trí index =3
                .release()                      // thả chuột  kết thúc sự kiện clickAndHold
                .perform();                     // thực thi các câu lệnh trên, nếu ko có thì ko thực thi
        // Sau đó kiểm tra lại có đúng đã chọn được 4 vị trí trên
        // Kiểm tra số phần tử dược chọn = 4

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")); // sau khi được chọn css thay đổi thành ui-selected
        Assert.assertEquals(allNumberSelected.size(),4);
    }
    @Test
    public void TC_02_Click_And_Hold_Random()  {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber= driver.findElements(By.cssSelector("ol#selectable>li")); // lấy ra chuỗi allNumber chứa nhiều phần tử
        Assert.assertEquals(allNumber.size(),30);

        // Nhấn và giữ phím Ctrl
        action.keyDown(Keys.CONTROL).perform();
        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(7))
                .click(allNumber.get(10))
                .click(allNumber.get(15))
                .click(allNumber.get(20))
                .pause(Duration.ofSeconds(3)) // chọn và dừng lại
                .perform();


        // nhả phím Ctrl
        action.keyUp(keys).perform();    // truyền vào keys chạy theo window / ios

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")); // khai báo list
        Assert.assertEquals(allNumberSelected.size(),6);
    }
@Test
    public void TC_03_Double_Click()  {
    driver.get("https://automationfc.github.io/jquery-selectable/");
    action.doubleClick(driver.findElement(By.xpath(""))).perform();
    // Gọi hàm --> thao tác với element vào thì truyên vào --> thực thi
}
@Test
    public void TC_07_Right_Click()  {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        // click chuột phải vào button
    action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
    By quitContextBy = By.cssSelector("li.context-menu-icon-quit");
    Assert.assertTrue(driver.findElement(quitContextBy).isDisplayed()); // verify hiển thị button quite trên popup

    //Hover mouse vaò 1 button
    action.moveToElement(driver.findElement(quitContextBy)).perform();
    Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-icon.context-menu-hover"))
                                    .isDisplayed()); // verify khi hover vào button -> thay đổi css
    // Click button QUite
    action.click(driver.findElement(quitContextBy)).perform();
    // show alert --> chọn Oke trên alert
    driver.switchTo().alert().accept();

    }

    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }
}