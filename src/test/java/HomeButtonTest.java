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

import static org.testng.Assert.*;

public class HomeButtonTest {
    WebDriver driver;
    String url = "https://vivo-shopping.com/ro/cluj-napoca";

    @BeforeTest
    public void setup() {
       // System.setProperty("webdriver.chrome.driver",
                //"src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement allCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        allCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        WebElement nuMultumesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"push-notification-widget__button\"][2]")));
        nuMultumesc.click();
    }

    @Test
    public void buttonHome() {

        WebElement buttonHome = driver.findElement(By.xpath("//*[@class='site-header__menubar__nav__item']"));
        buttonHome.click();

        WebElement messageHome= driver.findElement(By.xpath("//*[@class='pagecomponent-vivocollectionslider__headline']"));
        String messageHomeStr="Iubirea se sărbătorește în stilul vostru";
        Assert.assertTrue(messageHome.isDisplayed());
        Assert.assertEquals(messageHomeStr, messageHome.getText());

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}