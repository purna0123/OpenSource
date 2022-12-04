package OrangePages;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrangeLoginPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='orangehrm-login-footer']//p")
    WebElement Header;
    @FindBy(xpath = "//input[@name='username']")
    WebElement inputUserName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inoutPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonLogin;

    @FindBy(xpath = "//li[@class='oxd-userdropdown']//p")
    WebElement linkUserNameOnHomePage;


    public boolean isAlertPresent=false;

    public OrangeLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void veryHeader() {
        String getheadertext = Header.getText().trim();
        System.out.println(getheadertext);
        Assert.assertTrue(getheadertext.contains("OrangeHRM"));
    }

    public boolean isAlertPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            isAlertPresent = true;
        } catch (TimeoutException eTO) {
            isAlertPresent = false;
        }
        return isAlertPresent;
    }
    public void loginOrange(String userName, String password) {
        inputUserName.clear();
        inputUserName.sendKeys(userName);
        inoutPassword.clear();
        inoutPassword.sendKeys(password);
        buttonLogin.click();
        if(isAlertPresent) {
            driver.switchTo().alert().accept();
        }
        String getUserNameAfterlogin=linkUserNameOnHomePage.getText();
        assertEquals("Paul Collings", getUserNameAfterlogin);
    }
}