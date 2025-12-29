package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_04_Relative_Locator {
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
    public void TC_01_Relative() {
driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03_() {


    }

    @AfterClass
    public void afterClass() {
    driver.quit();
    }
}