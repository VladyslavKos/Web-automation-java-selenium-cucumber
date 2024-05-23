import Configuration.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
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
    @After
    public void tearDown(){
        driver.quit();
    }

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
    public void logIn() {
        MainPageSignInButton.click();
//        assertEquals("The current url does not match expected Loin Page Url", Urls.loginPageUrl, driver.getCurrentUrl());
        assertTrue("Email input is not empty", LoginPageEmailInput.getText().isEmpty());
        assertTrue("Password input is not empty", LoginPageEmailInput.getText().isEmpty());
        LoginPageEmailInput.sendKeys(email);
        LoginPagePasswordInput.sendKeys(password);
        LoginPageSingInButton.click();
        assertEquals("The current url does not match expected my account page url", Urls.myAccountPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Clothes page")
    public void goToClothesPage() {
        assertEquals("Clothes button text incorrect", "CLOTHES", ClothesButton.getText());
        ClothesButton.click();
//        assertEquals("The current url does not match clothes page url", Urls.clothesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Accessories page")
    public void goToAccessoriesPage() {
        assertEquals("Accessories button text incorrect", "ACCESSORIES", AccessoriesButton.getText());
        AccessoriesButton.click();
//        assertEquals("The current url doesn't match accessories page url", Urls.accessoriesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Art page")
    public void goToArtPage() {
        assertEquals("Art button text incorrect", "ART",ArtButton.getText());
        ArtButton.click();
//        assertEquals("The current url does not match Art page url", Urls.artPageUrl, driver.getCurrentUrl());
    }
}
