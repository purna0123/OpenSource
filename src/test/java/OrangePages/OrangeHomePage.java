package OrangePages;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {
    WebDriver driver;


    private String userName ="Admin";
    private String password ="admin123";
    public OrangeHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void veryHomePage() {

//        assertEquals("App & Browser Testing Made Easy", getheadertext);
    }
}