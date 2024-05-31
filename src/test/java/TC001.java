import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class TC001 {
    private WebDriver driver;
    MainPage mainPage;

    public void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    public void tearDown() {
        driver.quit();
    }

    @When("TC001 User log in with walid credentials")
    public void logIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.ClickSingInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @And("TC001 User go to Clothes page")
    public void goToClothesPage() {
        mainPage.ClickClothesButton();
//        assertions were temporary switched off because of provider of WebPage which change urls to often
//        assertEquals("The current url does not match Clothes page url", Urls.clothesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Accessories page")
    public void goToAccessoriesPage() {
        mainPage.ClickAccessoriesButton();
//        assertEquals("The current url doesn't match accessories page url", Urls.accessoriesPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User go to Art page")
    public void goToArtPage() {
        mainPage.ClickArtButton();
//        assertEquals("The current url does not match Art page url", Urls.artPageUrl, driver.getCurrentUrl());
    }

    @And("TC001 User click on store logo")
    public void clickLogo() {
        mainPage.ClickLogo();
//        assertEquals("The current url doesn't match Main page usrl", Urls.mainPageUrl, driver.getCurrentUrl());
//        tearDown();
    }
}
