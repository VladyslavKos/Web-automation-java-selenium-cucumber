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
import testData.TestData;
import urls.Urls;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;

public class TC003 {
    private WebDriver driver;
    public TC003(){
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
//        WebDriverWait wait = new WebDriverWait(driver,10);
    }

    @FindBy(xpath = PageElements.MainPageSignInButtonXpath)
    private WebElement MainPageSignInButton;
    @FindBy(xpath = PageElements.LoginPageEmailLoginInputXpath)
    private WebElement LoginPageEmailInput;
    @FindBy(xpath = PageElements.LoginPagePasswordLoginInputXpath)
    private WebElement LoginPagePasswordInput;
    @FindBy(xpath = PageElements.LoginPageSingInButtonXpath)
    private WebElement LoginPageSingInButton;
    @FindBy(xpath = PageElements.MyStoreLogoButtonXpath)
    private WebElement MyStoreLogoButton;
    @FindBy(xpath = Products.MainPageTShirtXpath)
    private WebElement MainPageTShirt;
    @FindBy(xpath = Products.TShirtColorXpath)
    private WebElement TShirtColor;
    @FindBy(xpath = Products.TShirtSizeLXpath)
    private WebElement TShirtSizeL;
    @FindBy(xpath = PageElements.ProductViewAddToCartButtonXpath)
    private WebElement ProductViewAddToCartButton;

    @Given("TC003 logged user on main page")
    public void loggIn(){
        driver.get(Urls.mainPageUrl);
        MainPageSignInButton.click();
        assertTrue("Email input is not empty", LoginPageEmailInput.getText().isEmpty());
        assertTrue("Password input is not empty", LoginPageEmailInput.getText().isEmpty());
        LoginPageEmailInput.sendKeys(TestData.email);
        LoginPagePasswordInput.sendKeys(TestData.password);
        LoginPageSingInButton.click();
        MyStoreLogoButton.click();
    }
    @When("TC003 user search for products")
    public void searchForProduct(){
        MainPageTShirt.click();
        TShirtColor.click();
        TShirtSizeL.click();
//        ProductViewAddToCartButton = wait.untill(ExpectedConditions.elementToBeClickable(ProductViewAddToCartButton))
        ProductViewAddToCartButton.click();
        ProductViewAddToCartButton.click();
    }
}
