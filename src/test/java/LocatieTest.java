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
        driver.get("https://www.google.com/maps/place/VIVO!%2BCluj-Napoca/@46.7528757,23.5282533,15.5z/data%3D!4m5!3m4!1s0x47490e47689260ed:0x941b29241ee14710!8m2!3d46.7505187!4d23.5333195&gl=RO&m=0&pc=m&uxe=eomtm&cm=2&hl=ro&src=1");

        WheelInput.ScrollOrigin scrollOrigin1 = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin1, 0, 400)
                .perform();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement locationMapFinish = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//body[@id='yDmH0d']/c-wiz[@class='SSPGKf']/div/div[@class='kFwPee']//div[@class='VtwTSb']/form[2]//button/span[@class='VfPpkd-vQzf8d']")));
        locationMapFinish.click();
        //Assert.assertTrue(locatieTest.isSelected());
    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {

       // driver.close();
    }
}
