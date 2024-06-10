import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.IdentityPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import testData.TestData;
import urls.Urls;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class TC004 {
    private static WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    IdentityPage identityPage;
    String name;

    public void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        identityPage = new IdentityPage(driver);
    }

    public void tearDown() {
        driver.quit();
    }

    @Given("TC004 user log in with valid credentials")
    public void LoginWithWalidCredentials() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.clickSingInButton();
        loginPage.loginAs(TestData.email, TestData.password);
        name = loginPage.getLoggedUserName();
    }

    @And("TC004 user go to user details")
    public void goToUserDetails() {
        myAccountPage.ClickMyAccountInformation();
    }

    @And("TC004 user changes password")
    public void changePassword() {
        identityPage.changePassword(TestData.password, TestData.newPassword);
    }

    @And("TC004 user logout")
    public void logOut() {
        loginPage.logOut();
    }

    @Then("TC004 user log in with new password")
    public void logInWithNewP() {
        loginPage.loginAs(TestData.email, TestData.newPassword);
    }

    @And("TC004 user check username")
    public void assertUserName() {
        assertEquals("Name doesn't match previously username", name, loginPage.getLoggedUserName());
        identityPage.changePassword(TestData.newPassword, TestData.password);
        tearDown();
    }
}
