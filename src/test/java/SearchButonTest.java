import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void searchButonTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement searchButonTest = driver.findElement(By.xpath("/html//header[@id='header']//ul[@class='site-header__meta__menu']//a[@title='Caută']"));
        searchButonTest.click();
        WebElement searchCasutaTest = driver.findElement(By.xpath("//*[@placeholder='Caută informații aici']"));
        searchCasutaTest.click();
    }

}
