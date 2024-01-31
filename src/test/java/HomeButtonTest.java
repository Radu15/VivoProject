import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeButtonTest {
    WebDriver driver;
    String url = "https://vivo-shopping.com/ro/cluj-napoca";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement allCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        allCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text =alert.getText();
        System.out.println((text));
        alert.accept();

        WebElement nuMultumesc = driver.findElement(By.id("push-notification-widget__button"));
        nuMultumesc.click();
    }

    @Test
    public void buttonHome() {

        WebElement buttonHome = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/nav[1]/div[1]/ul[2]/li[1]/a[1]"));
           buttonHome.click();
        Assert.assertTrue(buttonHome.isSelected());
    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {
       //driver.close();
    }
//    public static void sleep(int milisecond){
//        try {
//            Thread.sleep(9000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
