import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;
import testData.TestData;
import urls.Urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC001 {
    private String email = TestData.email;
    private String password = TestData.password;
    private WebDriver driver;

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


    public TC001() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Given("TC001 User on store home web page")
    public void given() {
        long startTime = System.currentTimeMillis();
        driver.get(Urls.mainPageUrl);
        long endTime = System.currentTimeMillis();
        long pageLoadTime = endTime - startTime;
        System.out.println("Page load time: " + pageLoadTime + " ms");
    }

    @When("TC001 User log in with walid credentials")
    public void loggIn() {
        assertTrue("Sign-in button is not displayed on the main page.", MainPageSignInButton.isDisplayed());
        MainPageSignInButton.click();
        String expectedLoginPageUrl = Urls.loginPageUrl;
        assertEquals("The current url does not match expected Loin Page Url", expectedLoginPageUrl, driver.getCurrentUrl());
        assertTrue("Email input is not displayed on the login page.", LoginPageEmailInput.isDisplayed());
        LoginPageEmailInput.sendKeys(email);
        LoginPagePasswordInput.sendKeys(password);
        LoginPageSingInButton.click();
        String expectedMyAccountPageUrl = Urls.myAccountPageUrl;
        assertEquals("The current url does not match expected my account page url", expectedMyAccountPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Clothes page")
    public void goToClothesPage() {
        assertTrue("Clothes button is not displayed", ClothesButton.isDisplayed());
        ClothesButton.click();
        String expectedClothesPageUrl = Urls.clothesPageUrl;
        assertEquals("The current url does not match clothes page url", expectedClothesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Accessories page")
    public void goToAccessoriesPage() {
        assertTrue("Accessories button is not displayed", AccessoriesButton.isDisplayed());
        AccessoriesButton.click();
        String expectedAccessoriesUrl = Urls.accessoriesPageUrl;
        assertEquals("The current url doesn't match accessories page url", expectedAccessoriesUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Art page")
    public void goToArtPage() {
        assertTrue("Art button not displayed", ArtButton.isDisplayed());
        ArtButton.click();
        String expectedArtPageUrl = Urls.artPageUrl;
        assertEquals("The current url does not match Art page url", expectedArtPageUrl, driver.getCurrentUrl());
        driver.quit();
    }
}
