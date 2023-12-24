package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class CommonPage extends BasePage{
    public CommonPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(),this);
    }

    public void openUrl(String url){
        driver.get().get(url);
    }

    public void openNewTab(){
        driver.get().switchTo().newWindow(WindowType.TAB);
    }

    public void openNewWindow(){
        driver.get().switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchWindow(int index){
        Set<String> handles =driver.get().getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(handles);
        driver.get().switchTo().window(tabs.get(index));
    }

}
