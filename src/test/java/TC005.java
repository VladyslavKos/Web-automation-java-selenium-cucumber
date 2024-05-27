import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.AddressesPage;
import pages.LoginPage;
import pages.MainPage;
import Configuration.Configuration;
import pages.MyAccountPage;
import testData.TestData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TC005 {
    private static WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    Configuration configuration;
    MyAccountPage myAccountPage;
    AddressesPage addressesPage;
    public void setUp(){
        configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        addressesPage = new AddressesPage(driver);
    }
    @Given("TC005 user logs in with valid credentials")
    public void logIn(){
        mainPage.ClickSingInButton();
        loginPage.loginAs(TestData.email, TestData.password);
    }
    @When("TC005 user clicks on the \"Addresses\" button")
    public void clickOnAddresses(){
        myAccountPage.clickAddressesButton();
    }
    @And("TC005 user clicks on the  Create new address button")
    public void clickAddNewAddress(){
        addressesPage.createNewAddress();
    }
    @And("TC005 user fills in the New Address form with the following details:")
    public void addNewAddress(List<Map<String, String>> addressDetails){

    }
}
