package TestScenarios;

import OrangePages.OrangeHomePage;
import OrangePages.OrangeLoginPage;
import browserSetup.BrowserSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginTest extends BrowserSetup {

    OrangeHomePage objOrangeHomePage;
    OrangeLoginPage objOrangeLoginPage;



    String userName="Admin";
    String password="admin123";

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        objOrangeLoginPage = new OrangeLoginPage(driver);
        objOrangeLoginPage.veryHeader();
        objOrangeLoginPage.loginOrange(userName, password);
    }

}
