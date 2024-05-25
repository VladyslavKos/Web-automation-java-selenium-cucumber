import Configuration.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC001 {
    private WebDriver driver;
    public void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public void tearDown(){
        driver.quit();
    }
    @When("TC001 User log in with walid credentials")
    public void logIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickSingInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @And("TC001 User go to Clothes page")
    public void goToClothesPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickClothesButton();
        assertEquals("The current url does not match Clothes page url", Urls.clothesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Accessories page")
    public void goToAccessoriesPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickAccessoriesButton();
        assertEquals("The current url doesn't match accessories page url", Urls.accessoriesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Art page")
    public void goToArtPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickArtButton();
        assertEquals("The current url does not match Art page url", Urls.artPageUrl, driver.getCurrentUrl());
    }
    @And("TC001 User click on store logo")
    public void clickLogo(){
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickLogo();
        assertEquals("The current url doesn't match Main page usrl", Urls.mainPageUrl,driver.getCurrentUrl());
        tearDown();
    }
}
