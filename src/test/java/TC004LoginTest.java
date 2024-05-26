import Configuration.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class TC004LoginTest {
    private static WebDriver driver;
    public void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    public void tearDown() {
        driver.quit();
    }

    @When("test1")
    public void LoginWithWalidCredentials() {
        setUp();
        driver.get(Urls.mainPageUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickSingInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
        assertEquals(TestData.FirstName+" "+TestData.LastName, loginPage.getLoggedUserName());
    }
    @Then("test2")
    public void LogOut(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.logOut();

    }


}
