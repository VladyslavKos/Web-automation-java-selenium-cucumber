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
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;

public class TC003 {
    private WebDriver driver;

    public void setup() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
//        WebDriverWait wait = new WebDriverWait(driver,10);
    }
//    @FindBy(xpath = Products.MainPageTShirtXpath)
//    private WebElement MainPageTShirt;
//    @FindBy(xpath = Products.TShirtColorXpath)
//    private WebElement TShirtColor;
//    @FindBy(xpath = Products.TShirtSizeLXpath)
//    private WebElement TShirtSizeL;
//    @FindBy(xpath = PageElements.ProductViewAddToCartButtonXpath)
//    private WebElement ProductViewAddToCartButton;

    @Given("TC003 logged user on main page")
    public void loggIn() {
        setup();
        driver.get(Urls.mainPageUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickSingInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
        mainPage.ClickLogo();
    }

    @When("TC003 user search for products")
    public void searchForProduct() {
        MainPage mainPage = new MainPage(driver);
        System.out.println(mainPage.GetProducts());
        String element = String.valueOf(mainPage.GetProducts().get(1));

//        mainPage.clickOnProduct(element);
    }
}
