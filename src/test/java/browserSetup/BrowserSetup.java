package browserSetup;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import OrangePages.OrangeHomePage;

public class BrowserSetup {
    String driverPath = "C:\\Users\\EI13238\\Sel\\chromedriver_win32\\chromedriver.exe";
    String applicationURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    OrangeHomePage objOrangeHomePage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test(priority = 0)
    public void navigate_to_homepage() {
        objOrangeHomePage = new OrangeHomePage(driver);
        driver.get(applicationURL);
        driver.manage().window().maximize();
    }

}