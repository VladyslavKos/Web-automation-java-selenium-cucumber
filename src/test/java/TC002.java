import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.Messages;
import pages.IdentityPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import testData.TestData;
import urls.Urls;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TC002 {
    private WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    IdentityPage identityPage;

    public void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        identityPage = new IdentityPage(driver);
    }

    public void tearDown() {
        driver.quit();
    }

    @Given("TC002 user log in with valid credentials")
    public void logIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.ClickSingInButton();
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @When("TC002 user go to information page")
    public void goToInformationPage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.ClickMyAccountInformation();
    }

    @And("TC002 user make changes in accordance with following data:")
    public void changeData(List<Map<String, String>> userDetails) {
        identityPage.changeFirstName(userDetails.get(0).get("First name"));
        identityPage.changeLastName(userDetails.get(0).get("Last name"));
        identityPage.inputPassword(TestData.password);
        identityPage.agreeDataPrivacy();
        identityPage.agreeTermsAndConditions();
        identityPage.clickSaveButton();
    }

    @Then("TC002 user get success message")
    public void checkSuccessMessage() {
        assertEquals("Wrong success message", Messages.ChangeUserInfoSuccessMessage, identityPage.checkSuccessMessage());
    }

    @And("TC002 user desktop info has been changed in accordance with following data:")
    public void checkUserDesktopInfo(List<Map<String, String>> userDetails) {
        String ExpectedName = userDetails.get(0).get("First name") + " " + userDetails.get(0).get("Last name");
        assertEquals("Wrong User name displayed", loginPage.getLoggedUserName(), ExpectedName);
        tearDown();
    }
}
