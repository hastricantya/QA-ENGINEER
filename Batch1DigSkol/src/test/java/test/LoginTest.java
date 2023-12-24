package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends BaseWebTest{


    @Test
    public void successLogin() {
        LoginPage loginPage = new LoginPage(driver, explicitWait);
        HomePage homePage = new HomePage(driver,explicitWait);

        loginPage.login("tomsmith","SuperSecretPassword!");
        String txtExpectedBerhasilLogin = "Secure Area";
        Assert.assertEquals(txtExpectedBerhasilLogin,homePage.getHomeText());

    }

    @Test
    public void failedLogin() {
        LoginPage loginPage = new LoginPage(driver, explicitWait);
        HomePage homePage = new HomePage(driver,explicitWait);

        loginPage.login("tomsmith","SuperSecretPasswo");
        Assert.assertTrue(loginPage.getTextFailedLogin().contains("Your password is invalid!"));

    }

}
