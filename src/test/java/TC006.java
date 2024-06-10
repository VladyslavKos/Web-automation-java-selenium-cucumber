import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.MainPage;
import testData.TestData;
import urls.Urls;
import utils.GenerateTestData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TC006 {
    private static WebDriver driver;
    private String email;
    MainPage mainPage;
    CreateAccountPage createAccountPage;
    GenerateTestData generateTestData;
    LoginPage loginPage;

    public void SetUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        driver.get(Urls.mainPageUrl);
        createAccountPage = new CreateAccountPage(driver);
        generateTestData = new GenerateTestData();
        loginPage = new LoginPage(driver);
    }

    @When("TC006 user create account using data")
    public void createAccount() {
        SetUp();
        mainPage.clickSingInButton();
        mainPage.clickCreateAccountButton();
        email = generateTestData.generateEmail();
        createAccountPage.registerAs(TestData.FirstName, TestData.LastName, email, email);
    }

    @And("TC006 user log in")
    public void logIn() {
        mainPage.clickSingOutButton();
        mainPage.clickSingInButton();
        loginPage.loginAs(email, email);
    }

    @Then("TC006 user check if user data is correct")
    public void checkData() {
       String data = loginPage.getLoggedUserName();
        System.out.println(data);

    }
}
