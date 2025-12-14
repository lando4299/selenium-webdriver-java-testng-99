package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Topic_16_authencationAlert {
    WebDriver driver;
    String username = "admin";
    String password = "admin";

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void TC_01_Authentication_Url() {
        // http/ https:// + username + ":" + password + "@" + Url
        driver.get("http://"+ username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),
                "Congratulations! You must have the proper credentials.");
    }
  //  @Test
//    public void TC_02_Authentication_Navigate() {
   //     driver.get("https://the-internet.herokuapp.com/");
   //     String basicAuthLink = driver.findElement(By.xpath("div.toll"));
         // học đến 1:33



   // }


    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }
}