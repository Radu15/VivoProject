import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;

public class LocatieTest {
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
    public void locatieTest() {

        WebElement locatieTest1 = driver.findElement(By.xpath("//*[@class='site-header__quickinfo__item__label'][1]"));
        locatieTest1.click();
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 4000)
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement locationMap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/footer[1]/div[2]/ul[1]/li[1]/a[1]/span[1]/span[1]/*[name()='svg'][1]")));
        locationMap.click();

            sleep(5);


      driver.get("https://consent.google.com/m?continue=https://www.google.com/maps/place/VIVO!%2BCluj-Napoca" +
                 "/@46.7528757,23.5282533,15.5z/data%3D!4m5!3m4!1s0x47490e47689260ed:0x941b29241ee14710!8m2!3d46.7505187" +
                 "!4d23.5333195&gl=RO&m=0&pc=m&uxe=eomtm&cm=2&hl=ro&src=1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement iframe = driver.findElement(By.xpath("/html//body[@id='yDmH0d']/c-wiz[@class='SSPGKf']/div/div[@class='kFwPee']//div[@class='VtwTSb']"));
        driver.switchTo().frame(iframe);

        try {
           WebElement acceptButton = driver.findElement(By.id("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div[1]/div[1]/button[1]/div[3]"));
           acceptButton.click();} catch (Exception e) {

            e.printStackTrace();
        }

        driver.switchTo().defaultContent();

    }

    private void sleep(int second) {
    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {

       // driver.close();
    }
}
