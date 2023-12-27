package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class automationadvance {
    WebDriver driver;

    @Test
    public void automationadvance() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));

        // Membuat automation kota asal dan memilih suggestion kota pertama
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement fromCityInput = driver.findElement(By.cssSelector("input[placeholder='From']"));
        fromCityInput.sendKeys("Jakarta");
        Thread.sleep (5000);
        fromCityInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep (5000);
        fromCityInput.sendKeys(Keys.ENTER);
        Thread.sleep (5000);

        // Membuat automation kota tujuan dan memilih suggestion kota pertama
        WebElement toCity = driver.findElement(By.id("toCity"));
        toCity.click();
        WebElement toCityInput = driver.findElement(By.cssSelector("input[placeholder='To']"));
        toCityInput.sendKeys("Singapore");
        Thread.sleep (5000);
        toCityInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep (5000);
        toCityInput.sendKeys(Keys.ENTER);
        Thread.sleep (5000);


        // Pilih tanggal keberangkatan
        WebElement departureDate = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
        departureDate.click();
        Thread.sleep (5000);

        // Klik tombol pencarian
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
        searchButton.click();
        Thread.sleep (15000);

        // Ekstrak nilai harga teratas
        WebElement topPriceElement = driver.findElement(By.xpath("//div[contains(@class, 'priceSection')]"));
        String topPriceValue = topPriceElement.getText();
        System.out.println("Top Price: " + topPriceValue);

        driver.quit();
    }
}
