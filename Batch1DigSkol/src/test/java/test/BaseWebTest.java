package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseWebTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

//    public WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get("https://the-internet.herokuapp.com/login");
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}
