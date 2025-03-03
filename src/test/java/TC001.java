import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TC001 extends Main {

    @When("TC001 User log in with walid credentials")
    public void logIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.clickSingInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @And("TC001 User go to Clothes page")
    public void goToClothesPage() {
        mainPage.ClickClothesButton();
        assertTrue("The current url does not match Clothes page url", driver.getCurrentUrl().endsWith(Urls.clothesPageUrlShort));
    }

    @And("TC001 User go to Accessories page")
    public void goToAccessoriesPage() {
        mainPage.ClickAccessoriesButton();
        assertTrue("The current url doesn't match accessories page url", driver.getCurrentUrl().endsWith(Urls.accessoriesPageUrlShort));
    }

    @And("TC001 User go to Art page")
    public void goToArtPage() {
        mainPage.ClickArtButton();
        assertTrue("The current url does not match Art page url", driver.getCurrentUrl().endsWith(Urls.artPageUrlShort));
    }

    @And("TC001 User click on store logo")
    public void clickLogo() {
        mainPage.ClickLogo();
        assertTrue("The current url doesn't match Main page url", driver.getCurrentUrl().endsWith(Urls.mainPageUrlShort));
        tearDown();
    }
}
