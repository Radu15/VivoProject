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

public class AllSiteVivoTest {
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
    public void AllSiteVivo() {

        WebElement allSiteVivo1= driver.findElement(By.xpath("//strong[normalize-space()='VIVO!']"));
        allSiteVivo1.click();
       for (int i = 0; i < 3; i++) {
        WebElement allSiteVivoUp = driver.findElement(By.xpath("//*[@class='scrollToTopSideButton']"));
        allSiteVivoUp.click();}

        sleep(6);
        for (int i = 0; i < 5; i++) {
            WebElement allSiteVivoZoom= driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M22.5,14H1')]"));
            allSiteVivoZoom.click();
        }
        WebElement allSiteTest= driver.findElement(By.xpath("//*[@class='pagecomponent-vivogooglemaps__body__content__box__headline']"));
        String allSiteTestStr="Bine ați venit la VIVO!";
        Assert.assertTrue(allSiteTest.isDisplayed());
        Assert.assertEquals(allSiteTestStr,allSiteTest.getText());
    }

    private void sleep(int second) {
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {

        // driver.close();
    }

}
