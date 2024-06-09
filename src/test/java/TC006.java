import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CreateAccountPage;
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
    public void SetUp(){
        Configuration configuration = new Configuration();
       driver =  configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        driver.get(Urls.mainPageUrl);
        createAccountPage = new CreateAccountPage(driver);
        generateTestData = new GenerateTestData();
    }
    @When("TC006 user create account using data")
    public void createAccount(){
        SetUp();
        mainPage.ClickSingInButton();
        mainPage.clickCreateAccountButton();
        email = generateTestData.generateEmail();
        createAccountPage.firstNameFill(TestData.FirstName);
        createAccountPage.lastNameFill(TestData.LastName);
        createAccountPage.emailFill(email);
        createAccountPage.passwordFill(email);
        createAccountPage.clickAgreePrivacyPolicy();
        createAccountPage.clickCustomerDataPrivacy();
        createAccountPage.clickSaveButton();
    }
    @And("TC006 user log in")
    public void logIn(){
        System.out.println("test");

    }
    @Then("TC006 user check if user data is correct")
    public void checkData(){
        System.out.println("test");
    }
}
