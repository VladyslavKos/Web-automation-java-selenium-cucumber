import Configuration.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageNavigation.PageElements;
import pageNavigation.Products;
import pages.IdentityPage;
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;

public class TC003 {
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
//    @FindBy(xpath = Products.MainPageTShirtXpath)
//    private WebElement MainPageTShirt;
//    @FindBy(xpath = Products.TShirtColorXpath)
//    private WebElement TShirtColor;
//    @FindBy(xpath = Products.TShirtSizeLXpath)
//    private WebElement TShirtSizeL;
//    @FindBy(xpath = PageElements.ProductViewAddToCartButtonXpath)
//    private WebElement ProductViewAddToCartButton;

    @Given("TC003 logged in user on main page")
    public void loggIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.ClickSingInButton();
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @When("TC003 user click logo and click product {int}")
    public void searchForProduct(int productIndex) {
        mainPage.ClickLogo();
        mainPage.clickOnProduct(productIndex);
    }

}
