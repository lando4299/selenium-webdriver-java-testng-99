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

public class Topic_22_Random_Popup {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe"); // khác
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(35));

    }

    @Test
    public void TC_01_JavaCodeGeeks_NOT_IN_DOM() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By popupJavaCodeGeeks = By.xpath("//div[@data-title='Newsletter-Books Anime Brief - NEW'" +
                "and not(contains(@style, 'display:none'))]");
// Hiêển thị popup thì close
        if (driver.findElements(popupJavaCodeGeeks).size() > 0
                && driver.findElements(popupJavaCodeGeeks).get(0).isDisplayed()) // có trong  list popup và get ra cái đầu tiên có hiển thi trên UI

        { System.out.println("_____________GO TO IF_________");
            driver.findElement(By.xpath("//div[@data-title='Newsletter-Books Anime Brief - NEW' " +
                    "and not(contains(@style,'display:none'))]//a[contains(@onclick, 'return lepopup_close')]")).click();
            Thread.sleep(3000);
            Assert.assertEquals(driver.findElements(popupJavaCodeGeeks).size(), 0);
            // Popup sau khi click đóng ko còn trong HTML thì phải dùng  findElements va kiem tra size =0, nếu còn trong HTML thì dùng isDisplayed
        }

// Ko hiển thị thì đi tiếp
        System.out.println("_____________NOTTTT GO TO IF_________");
        driver.findElement(By.cssSelector("form#search>input#search-input")).sendKeys("Agile");
        driver.findElement(By.cssSelector("button#search-submit>span.tie-icon-search")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());

    }

    @Test
    public void TC_02_Withpopup_random_popup_IN_DOM() throws InterruptedException {
        driver.get("https://dehieu.vn/");
        By popupDeHieu = By.cssSelector("div.modal-content");
        if (driver.findElements(popupDeHieu).size() > 0 && driver.findElements(popupDeHieu).get(0).isDisplayed())

        { System.out.println("__________GO To IF__________");
            driver.findElement(By.cssSelector("div.modal-content button.close")).click();

            // Verify popup ko con hien thi
            Assert.assertFalse(driver.findElement(popupDeHieu).isDisplayed());

        }
        System.out.println("_____________NOTTTT GO TO IF_________");
        driver.findElement(By.cssSelector("")).click();


    }

    @Test
    public void TC_03_() {


    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}