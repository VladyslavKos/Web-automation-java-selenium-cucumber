import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;
import testData.TestData;
import urls.Urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC002 {
    private WebDriver driver;
    private String email = TestData.email;
    private String password = TestData.password;

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

    @Given("TC002 user on store main page")
    public void given() {
        driver.get(Urls.mainPageUrl);
    }

    @And("TC002 user log in with valid credentials")
    public void logIn() {
        assertTrue("Sign-in button is not displayed on the main page.", MainPageSignInButton.isDisplayed());
        MainPageSignInButton.click();
        assertEquals("The current url does not match expected Loin Page Url", Urls.mainPageUrl, driver.getCurrentUrl());
        assertTrue("Email input is not displayed on the login page.", LoginPageEmailInput.isDisplayed());
        assertTrue("Password input is not displayed on the login page.", LoginPagePasswordInput.isDisplayed());
        LoginPageEmailInput.sendKeys(email);
        LoginPagePasswordInput.sendKeys(password);

    }

}
