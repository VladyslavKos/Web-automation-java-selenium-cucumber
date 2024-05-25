import Configuration.Configuration;
import io.cucumber.java.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import testData.TestData;
import urls.Urls;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;
    @Before
    public void setUp(){
//        Configuration configuration = new Configuration();
//        driver = configuration.getDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/Drivers/chromedriver");
//        driver = new ChromeDriver();
//        PageFactory.initElements(driver, this);
        driver.get(Urls.loginPageUrl);

    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
    @Test
    public void LoginWithWalidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
        assertEquals("Jan Pawel", loginPage.getLoggedUserName());
    }

}
