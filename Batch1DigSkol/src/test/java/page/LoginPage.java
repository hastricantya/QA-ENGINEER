package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }

    @FindBy(id="username")
    WebElement columnUName;

    @FindBy(name = "password")
    WebElement columnPass;

    @FindBy(xpath = "//button[@class='radius']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement txtFailedLogin;

    public void login(String uName, String pass){
        setText(columnUName,uName);
        setText(columnPass,pass);
        clickAndWait(btnLogin);
    }

    public String getTextFailedLogin(){
        return getText(txtFailedLogin);
    }
}
