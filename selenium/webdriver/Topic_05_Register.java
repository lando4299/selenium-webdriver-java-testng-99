package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_05_Register {
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
    public void Register_01_Empty_Data() {
       driver.get("");

    }

    @Test
    public void Register_02_Invalid_Email_Address() {

    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {


    }
    @Test
    public void Register_04_Invalid_Password() {


    }
    @Test
    public void Register_05_Incorrect_Confirm_Password() {


    }
    @Test
    public void Register_06_Incorrect_Confirm_Password() {


    }
    @AfterClass
    public void afterClass() {

    driver.quit();
    }
}