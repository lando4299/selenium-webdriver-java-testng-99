package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;
String projectPath= System.getProperty("user.div");
String osName = System.getProperty("os.name");

   @BeforeClass
public void beforeClass(){
    if (osName.contains("Windows")) {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browerDrivers\\geckodriver.exe");
    } else {
        System.setProperty("webdriver.gecko.driver", projectPath + "/browerDrivers/geckodriver");
    }
    driver = new FirefoxDriver();
    driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}

    @Test
    public void TC_01_() {
       // dữ liệu dùng 1 lần thì ko khai báo biến, dùng từ 2 lần trở nên mới khai báo để tái s dụng lại
        // Lấy ra tilte của page hiện tại
        //C1: Lưu dữ liệu lại rồi kiểm tra sau
        String homePageTilte = driver.getTitle();
        Assert.assertEquals(homePageTilte,"abcd");
        Assert.assertTrue(homePageTilte.contains("a"));

        //C2 Kiểm tra trực tiếp
        Assert.assertEquals(driver.getTitle(),"abcd");


        //Lấy ra ULR của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(),"efgh");

        // Lấy ra page Source code
        String homePageSourceCode = driver.getPageSource();
        Assert.assertTrue(homePageSourceCode.contains("abc"));

        // Lấy ra ID của tab, window đang active
        driver.getWindowHandle();

        // Lấy ra ID của tab, window đang có
        driver.getWindowHandles();

        //Tìm 1 element **
        driver.findElement(By.xpath(""));

        //Tìm n element
        driver.findElements(By.xpath(""));

        // Dùng để chờ cho việc tìm element ( findElement/ findElements)**
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //dùng để chờ cho page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // chờ khi chạy xong 1 đoạn script ( JSscript)
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        //QUản lý window
        driver.manage().window().maximize(); // full màn hình có taskbar **
        driver.manage().window().fullscreen(); // full màn ko có taskbar, ttuowng tự như nhấn F11
        driver.manage().window().setPosition(new Point(0,3)); // set vị trí khi mở browser sẽ ở vị trí nào
        driver.manage().window().setSize(new Dimension(123,456)); // dùng khi check kích thước màn hình giống responsive

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

