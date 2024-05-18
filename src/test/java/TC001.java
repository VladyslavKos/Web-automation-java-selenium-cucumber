import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

import static org.junit.Assert.assertTrue;

public class TC001 {
    private String email="test734@test.com";
    private String password="test734@test.com";
    private static final long PAGE_LOAD_THRESHOLD = 6000;
    private WebDriver driver;

    @FindBy(xpath = PageElements.MainPageSignInButtonXpath)
    private WebElement MainPageSignInButton;
    @FindBy(xpath = PageElements.LoginPageEmailLoginInputXpath)
    private WebElement LoginPageEmailInput;
    @FindBy(xpath = PageElements.LoginPagePasswordLoginInputXpath)
    private WebElement LoginPagePasswordInput;
    @FindBy(xpath = PageElements.LoginPageSingInButtonXpath)
    private WebElement LoginPageSingInButton;
    @FindBy(xpath = PageElements.MyAccountPageClothesButtonXpath)
    private WebElement MyAccountPageClothesButton;
    public TC001() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Given("TC001 User on store home web page")
    public void given() {
        long startTime = System.currentTimeMillis();
        driver.get("https://mystore-testlab.coderslab.pl");
        long endTime = System.currentTimeMillis();
        long pageLoadTime = endTime - startTime;
        System.out.println("Page load time: "+pageLoadTime+" ms");
        //possibility to set threshold if needed
//        assertTrue("Page load time exceeds threshold", pageLoadTime <= PAGE_LOAD_THRESHOLD);
    }
    @When("TC001 User log in with walid credentials")
    public void loggIn(){
        assertTrue("Sign-in button is not displayed on the main page.", MainPageSignInButton.isDisplayed());
        MainPageSignInButton.click();
        assertTrue("Email input is not displayed on the login page.",LoginPageEmailInput.isDisplayed());
        LoginPageEmailInput.sendKeys(email);

        LoginPagePasswordInput.sendKeys(password);
        LoginPageSingInButton.click();
    }
    @And("TC001 User go to Clothes page")
    public void goToClothesPage(){
        MyAccountPageClothesButton.click();
    }
}
