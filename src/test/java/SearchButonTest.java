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

public class SearchButonTest {
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

        WebElement nuMultumesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"push-notification-widget__button\"][2]")));
        nuMultumesc.click();

    }

    @Test
    public void SearchButonTest() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement searchTest1 = driver.findElement(By.xpath("/html//header[@id='header']//ul[@class='site-header__meta__menu']//a[@title='Caută']"));
        searchTest1.click();
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 4000)
                .perform();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement searchTest = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Caută informații aici']")));
        searchTest.click();
        searchTest.sendKeys("Zara");

        WebElement searchButtonTest2 = driver.findElement(By.xpath("/html//div[@id='hash-']//div[@class='input-field input-field--custom']/button"));
        searchButtonTest2.click();

        WheelInput.ScrollOrigin scrollOrigin1 = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin1, 0, 400)
                .perform();

        WebElement zaraHome= driver.findElement(By.xpath("//h3[normalize-space()='ZARA Home']"));
        String zaraHomeStr="ZARA HOME";
        Assert.assertTrue(zaraHome.isDisplayed());
        Assert.assertEquals(zaraHomeStr, zaraHome.getText());


    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {

        // driver.close();
    }

}
