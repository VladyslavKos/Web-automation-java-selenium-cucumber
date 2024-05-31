import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.Messages;
import pages.*;
import Configuration.Configuration;
import testData.TestData;
import urls.Urls;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TC005 {
    private static WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    Configuration configuration;
    MyAccountPage myAccountPage;
    AddressesPage addressesPage;
    NewAddressPage newAddressPage;
    EditAddressPage editAddressPage;

    public void setUp() {
        configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        addressesPage = new AddressesPage(driver);
        newAddressPage = new NewAddressPage(driver);
        editAddressPage = new EditAddressPage(driver);
    }
    public void tearDown() {
        driver.quit();
    }

    @Given("TC005 user logs in with valid credentials")
    public void logIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.ClickSingInButton();
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @When("TC005 user clicks on the \"Addresses\" button")
    public void clickOnAddresses() {
        myAccountPage.clickAddressesButton();
    }

    @And("TC005 user clicks on the  Create new address button")
    public void clickAddNewAddress() {
        addressesPage.createNewAddress();
    }

    @And("TC005 user fills in the New Address form with the following details:")
    public void addNewAddress(List<Map<String, String>> addressDetails) {
        newAddressPage.inputAlias(addressDetails.get(0).get("Alias"));
        newAddressPage.inputAddress(addressDetails.get(0).get("Address"));
        newAddressPage.inputCity(addressDetails.get(0).get("City"));
        newAddressPage.inputZipCode(addressDetails.get(0).get("Zip/Postal Code"));
        newAddressPage.inputPhone(addressDetails.get(0).get("Phone"));
    }

    @And("TC005 user submits the form")
    public void submitForm() {
        newAddressPage.clickSaveButton();
    }

    @Then("TC005 user should see a success message")
    public void checkSuccessMessage() {
        assertEquals("Wrong success message", Messages.AddNewAddressSuccessMessage, newAddressPage.getSuccessMessage());
    }
    @And("TC005 user verifies that the added address details are correct:")
    public void verifyAddressData(List<Map<String, String>> details){
        //need to solve way to check if every record is correct
        System.out.println(newAddressPage.getAddressDataText());
        System.out.println(newAddressPage.getAddressDataText().get(6));
        editAddressPage.goToEdit();
        System.out.println(editAddressPage.getAlias());
//        tearDown();
    }

}
