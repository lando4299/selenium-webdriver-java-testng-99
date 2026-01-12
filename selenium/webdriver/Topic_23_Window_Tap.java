package webdriver;

import org.bouncycastle.util.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Window_Tap {
    WebDriver driver;

   @BeforeClass
public void beforeClass(){
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(15));

}

    @Test
    public void TC_01_Github() throws InterruptedException {
       driver.get("https://automationfc.github.io/basic-form/index.html");
       // Lấy ra windowId/ tabId mà driver đang dứng tại do
        String githubWindowID = driver.getWindowHandle();
        System.out.println("Page ID = "  + driver.getWindowHandle());
        System.out.println("Page title = "  + driver.getTitle());
        System.out.println("Current URL hien tai = "  + driver.getCurrentUrl());

        // Click vao google link se mo sang tap moi ve mat business
        // Nhung driver vẫn đứng taại tap ban dau Github
        driver.findElement(By.xpath("//a[text()=\"GOOGLE\"]")).click();
        Thread.sleep(3000);

        // Switch qua tab Google
        switchToWindowById(githubWindowID); //DA EXTRACT THANH 1 HAM BEN DUOI

        // Kiem tra vi tri hien tai cua drive
        System.out.println("Page ID = "  + driver.getWindowHandle());
        System.out.println("Page title = "  + driver.getTitle());
        System.out.println("Current URL hien tai = "  + driver.getCurrentUrl());

        // Switch ve tap Github ban dau
        String googleWindowID = driver.getWindowHandle(); // Lay ra ID cua tab google de truyen vao ham Switch

        switchToWindowById(googleWindowID); //DA EXTRACT THANH 1 HAM BEN DUOI

        //Ve Github tiep tuc chon facebook
        driver.findElement(By.xpath("//a[text()=\"FACEBOOK\"]")).click();
        Thread.sleep(3000);

        //TH co 3 window
        //B1: lay ra tat ca window ID
        switchToWindowByTitle("Facebook – log in or sign up");
        Thread.sleep(3000);

        // Quay ve Github
        switchToWindowByTitle("Selenium WebDriver");
        Thread.sleep(3000);

        //Ve Github tiep tuc chon Tiki
        driver.findElement(By.xpath("//a[text()=\"TIKI\"]")).click();
        Thread.sleep(3000);
        //Switch to TIKI
        switchToWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        Thread.sleep(3000);

        //Lay ra het tat ca tap/window
        closeWindowWithoutParent(githubWindowID); //DA EXTRACT THANH 1 HAM BEN DUOI

        //switch vao tap cuoi cung con lai
        driver.switchTo().window(githubWindowID);
    }
        // chuyen 3 ham dung chung xuong cuoi cung ko nam trong test nao de dung chung

    @Test
    public void TC_02_TechPanda() throws InterruptedException {
       driver.get("https://live.techpanda.org/");
       driver.findElement(By.xpath("//a[text()='Mobile']")).click();

       // Click add to compare o san pham Sony Xperia
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/"
                + "following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "The product Sony Xperia has been added to comparison list.");

        // Click add to compare o san pham samsung
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/"
                + "following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        Thread.sleep(2000);

        // dung title de switch
        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Thread.sleep(2000);

        // verify URL cua tab compare
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/catalog/product_compare/index/");

        // click button Close
        driver.findElement(By.cssSelector("button[title='Close Window']")).click();
        Thread.sleep(2000);
        // switch driver ve trang mobille
        switchToWindowByTitle("Mobile");
        // click button Clear All
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(2000);

          // verify show alert
        Assert.assertEquals(driver.switchTo().alert().getText(),
                "Are you sure you would like to remove all products from your comparison?");
        // Click OK tren alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Verify thong bao sau khi OK tren alert
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "The comparison list was cleared.");

    }





    @Test
    public void TC_03_() {


    }

    private void closeWindowWithoutParent(String githubWindowID) throws InterruptedException {
        Set <String> allWindowIDs = driver.getWindowHandles();
        //Dung vong lap duyet qua tung ID
        for (String id : allWindowIDs){
            if (!id.equals(githubWindowID)){
                // id ko dund thi switch vao window do va close
                driver.switchTo().window(id);
                Thread.sleep(3000);
                driver.close();
            }
        }
    }
    // Dung voi tu 3 tab/window dung =2 van dung => dung luon cai nay
    private void switchToWindowByTitle(String expectedpageTitle) {
        Set <String> allWindowIDs = driver.getWindowHandles();

        //Dung vong lap duyet qua tung ID
        for (String id : allWindowIDs) {
            //Moi lan duyet se cho driver switch vao truoc roi get ra title va so sanh
            driver.switchTo().window(id);
            String pageTitle = driver.getTitle();

            // so sanh page title
            if (pageTitle.equals(expectedpageTitle)){
                break;
                // neu dung thi dung vong lap va driver dung o page do luon
            }
        }
    }

    // Chi dung TH handle voi 2 tab/ window, nhieu hon la sai
    private void switchToWindowById(String windowId) {
        //Lay ra tat ca window/ tab hien tai
        Set<String> allWindowIDs = driver.getWindowHandles();
        // Duyet lan luot tung id mot
        for (String id : allWindowIDs) {
            if (!id.equals(windowId)
            ) {

                driver.switchTo().window(id);
            }
        }
    }
    @AfterClass
    public void afterClass() {

    driver.quit();
    }
}