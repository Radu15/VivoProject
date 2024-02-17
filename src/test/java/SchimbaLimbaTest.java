import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SchimbaLimbaTest {
    WebDriver driver;
    String url = "https://vivo-shopping.com/ro/cluj-napoca";

    @BeforeTest
    public void setup() {
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
    public void schimbaLimbaTest() {
        WebElement schimbaLimbaTest1 = driver.findElement(By.xpath("/html//header[@id='header']//ul[@class='site-header__meta__menu']//a[@title='Română']"));
        schimbaLimbaTest1.click();

        WebElement schimbaLimbaTest2 = driver.findElement(By.xpath("//*[@class='site-header__meta__menu__item__dropdown']"));
        schimbaLimbaTest2.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        WebElement noThanks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='push-notification-widget__button'][2]")));
        noThanks.click();
        WebElement messageLanguage= driver.findElement(By.xpath("//*[@class='pagecomponent-vivocollectionslider__headline']"));
        String messageLanguageStr="Love is celebrated in your style.";
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 50)
                .perform();
        Assert.assertTrue(messageLanguage.isDisplayed());
        Assert.assertEquals(messageLanguageStr, messageLanguage.getText());
    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        //driver.close();
    }
}
