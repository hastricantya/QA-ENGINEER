package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class emailautomation{
    WebDriver driver;
@Test
    public void emailautomation(){

        // Inisialisasi WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
            // Buka Yopmail.com
            driver.get("https://www.yopmail.com");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
            // mencari email autommationtest
            WebElement emailSearchField = driver.findElement(By.id("login"));
            emailSearchField.sendKeys("automationtest");
            emailSearchField.submit();

            WebElement iFrame = driver.findElement(By.xpath("xpath_of_reCaptcha_iFrame"));
            driver.switchTo().frame(iFrame);

            WebElement iFrame_checkbox =
            driver.findElement(By.xpath("xpath_of_reCaptcha_checkbox"));
            iFrame_checkbox.click();

            driver.findElement(By.xpath("//button[@class='md']")).click(); //klik tombol

             //pilih email
            driver.switchTo().frame("ifinbox"); //switch iframe chat
            driver.findElement(By.xpath("//div[@class='mctn']/div[2]/button[@class='lm']")).click(); //Klik email dipilih
            driver.switchTo().defaultContent(); //keluar iframe

            //cek email yang dipilih
            driver.switchTo().frame("ifmail"); //masuk iframe bagian isi email
            String extractContent = driver.findElement(By.xpath("//div[@id='mail']")).getText(); //mengambil kata dari Xpath
            System.out.println(extractContent);
            System.out.println("sukses");
            driver.quit();
        }
    }


