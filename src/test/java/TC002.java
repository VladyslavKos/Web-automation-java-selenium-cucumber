import Configuration.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;
import pageNavigation.SuccessfulMessages;
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

    public void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
    }
    public void tearDown(){
        driver.quit();
    }

    @Given("TC002 user log in with valid credentials")
    public void logIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickSingInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @When("TC002 user go to information page")
    public void goToInformationPage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.ClickMyAccountInformation();
    }

    @And("TC002 user make changes in accordance with following data:")
    public void changeData(List<Map<String, String>> userDetails) {
        IdentityPage identityPage = new IdentityPage(driver);
        identityPage.changeFirstName(userDetails.get(0).get("First name"));
        identityPage.changeLastName(userDetails.get(0).get("Last name"));
        identityPage.inputPassword(TestData.password);
        identityPage.agreeDataPrivacy();
        identityPage.agreeTermsAndConditions();
        identityPage.clickSaveButton();
    }

    @Then("TC002 user get success message")
    public void checkSuccessMessage() {
        IdentityPage identityPage = new IdentityPage(driver);
        assertEquals("Wrong success message", SuccessfulMessages.ChangeUserInfoSuccessMessage, identityPage.checkSuccessMessage());
    }

    @And("TC002 user desktop info has been changed in accordance with following data:")
    public void checkUserDesktopInfo(List<Map<String, String>> userDetails) {
        LoginPage loginPage = new LoginPage(driver);
        String ExpectedName = userDetails.get(0).get("First name") + " " + userDetails.get(0).get("Last name");
        assertEquals("Wrong User name displayed", loginPage.getLoggedUserName(), ExpectedName);
        tearDown();
    }
}
