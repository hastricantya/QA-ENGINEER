package test;

import org.testng.annotations.Test;
import page.CommonPage;

public class CommonTest extends BaseWebTest{

    @Test
    public void testSwitching(){
        CommonPage commonPage = new CommonPage(driver,explicitWait);

        commonPage.openNewTab();
        commonPage.switchWindow(1);
        commonPage.openUrl("https://facebook.com");
        commonPage.openNewWindow();
        commonPage.switchWindow(2);
        commonPage.openUrl("https://twitter.com");
        commonPage.switchWindow(0);
    }
}
