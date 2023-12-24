package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseWebTest;

import java.time.Duration;

public class SeleniumTest extends BaseWebTest {

    @Test
    public void loginTestSucces(){
        //open browser

        //login
        driver.get().findElement(By.id("username")).sendKeys("tomsmith");
        driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.get().findElement(By.xpath("//button[@class='radius']")).click();

        String txtActualBerhasilLogin = driver.get().findElement(By.xpath("//h2[contains(.,'Secure Area')]")).getText();
        String txtExpectedBerhasilLogin = "Secure Area";
//        System.out.println(txtActualBerhasilLogin);
        Assert.assertEquals(txtActualBerhasilLogin,txtExpectedBerhasilLogin);


    }

    @Test
    public void loginTestFailed(){
        //login page
        driver.get().findElement(By.id("username")).sendKeys("tomsmith");
        driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.get().findElement(By.xpath("//button[@class='radius']")).click();
        //Home Page
        String txtErrorFailedPassExpc = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertTrue(txtErrorFailedPassExpc.contains("Your password is invalid!"));


    }



}
