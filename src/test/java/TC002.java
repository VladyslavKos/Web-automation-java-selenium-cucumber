import Configuration.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;
import testData.TestData;
import urls.Urls;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TC002 {
    private final WebDriver driver;
    private String FirstName;
    private String LastName;

    public TC002() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = PageElements.MainPageSignInButtonXpath)
    private WebElement MainPageSignInButton;
    @FindBy(xpath = PageElements.LoginPageEmailLoginInputXpath)
    private WebElement LoginPageEmailInput;
    @FindBy(xpath = PageElements.LoginPagePasswordLoginInputXpath)
    private WebElement LoginPagePasswordInput;
    @FindBy(xpath = PageElements.LoginPageSingInButtonXpath)
    private WebElement LoginPageSingInButton;
    @FindBy(xpath = PageElements.ClothesButtonXpath)
    private WebElement ClothesButton;
    @FindBy(xpath = PageElements.AccessoriesButtonXpath)
    private WebElement AccessoriesButton;
    @FindBy(xpath = PageElements.ArtButtonXpath)
    private WebElement ArtButton;
    @FindBy(xpath =  PageElements.MyAccountPageInformationButtonXpath)
    private WebElement MyAccountPageInformationButton;
    @FindBy(xpath = PageElements.IdentityPageFirstNameInputXpath)
    private WebElement IdentityPageFirstNameInput;
    @FindBy(xpath = PageElements.IdentityPageLastNameInputXpath)
    private WebElement IdentityPageLastNameInput;
    @FindBy(xpath = PageElements.IdentityPagePasswordInputXpath)
    private WebElement IdentityPagePasswordInput;
    @FindBy(xpath = PageElements.IdentityPageDataPrivacyCheckBoxXpath)
    private WebElement IdentityPageDataPrivacyCheckBox;
    @FindBy(xpath = PageElements.IdentityPageTermsAndConditionsCheckBoxXpath)
    private WebElement IdentityPageTermsAndConditionsCheckBox;
    @FindBy(xpath = PageElements.IdentityPageSaveButtonXpath)
    private WebElement IdentityPageSaveButton;
    @FindBy(xpath = PageElements.IdentitySuccessMessageXpath)
    private WebElement IdentitySuccessMessage;
    @FindBy(xpath = PageElements.DesktopUserInfoXpath)
    private WebElement DesktopUserInfo;

//    @After
//    public void tearDown(){
//        driver.quit();
//    }

    @Given("TC002 user on store main page")
    public void given() {
        driver.get(Urls.mainPageUrl);
    }

    @And("TC002 user log in with valid credentials")
    public void logIn() {
        MainPageSignInButton.click();
//        assertEquals("The current url does not match expected Loin Page Url", Urls.loginPageUrl, driver.getCurrentUrl());
        assertTrue("Email input is not empty", LoginPageEmailInput.getText().isEmpty());
        assertTrue("Password input is not empty", LoginPageEmailInput.getText().isEmpty());
        LoginPageEmailInput.sendKeys(TestData.email);
        LoginPagePasswordInput.sendKeys(TestData.password);
        LoginPageSingInButton.click();
//        assertEquals("The current url does not match expected my account page url", Urls.myAccountPageUrl, driver.getCurrentUrl());
    }
    @When("TC002 user go to information page")
    public void goToInformationPage(){
        MyAccountPageInformationButton.click();
//        assertEquals("The current url does not match identity page url", Urls.identityPageUrl,driver.getCurrentUrl());
    }
    @And("TC002 user make changes in accordance with following data:")
    public void changeData(List<Map<String, String>> userDetails){
        assertNotNull("First name input is empty",IdentityPageFirstNameInput.getText());
        assertNotNull("Second name input is empty",IdentityPageLastNameInput.getText());
        IdentityPageFirstNameInput.clear();
        IdentityPageLastNameInput.clear();
        IdentityPageFirstNameInput.sendKeys(userDetails.get(0).get("First name"));
        FirstName=userDetails.get(0).get("First name");
        LastName=userDetails.get(0).get("Last name");
        IdentityPageLastNameInput.sendKeys(userDetails.get(0).get("Last name"));
        IdentityPagePasswordInput.sendKeys(TestData.password);
        IdentityPageDataPrivacyCheckBox.click();
        IdentityPageTermsAndConditionsCheckBox.click();
        IdentityPageSaveButton.click();
    }
    @Then("TC002 user get success message")
    public void checkSuccessMessage(){
        assertEquals("Wrong success message","Information successfully updated.",IdentitySuccessMessage.getText());
    }
    @And("TC002 user desktop info has been changed")
    public void checkUserDesktopInfo(){
        assertEquals("Wrong user desktop info", DesktopUserInfo.getText(),FirstName+" "+LastName);
    }
}
