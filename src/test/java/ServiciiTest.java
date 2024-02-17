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

public class ServiciiTest {
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
    public void srviciiTest() {

        WebElement serviciiTest = driver.findElement(By.xpath("//*[@title='Servicii']"));
        serviciiTest.click();

        WebElement cariereTest = driver.findElement(By.xpath("//*[@title='Cariere']"));
        cariereTest.click();
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 800)
                .perform();

        WebElement citesteMaiMultTest = driver.findElement(By.xpath("/html//div[@id='hash-']/div/div[@class='container']/div[2]/div[1]/div[@class='datacard']/div[2]/a[@title='Citește mai mult']"));
        citesteMaiMultTest.click();
        WheelInput.ScrollOrigin scrollOrigin1 = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin1, 0, 300)
                .perform();
        WebElement ofertaJob= driver.findElement(By.xpath("//h1[@class='pagecomponent-contentblock__headline']//h1[1]"));
        String ofertaJobStr="Cinema City - Ofertă de job";
        Assert.assertTrue(ofertaJob.isDisplayed());
        Assert.assertEquals(ofertaJobStr,ofertaJob.getText());


    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {

        //driver.close();
    }
}
