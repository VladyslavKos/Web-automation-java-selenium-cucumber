import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CreateAccountPage;
import pages.MainPage;
import urls.Urls;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TC006 {
    private static WebDriver driver;
    MainPage mainPage;
    CreateAccountPage createAccountPage;
    public void SetUp(){
        Configuration configuration = new Configuration();
       driver =  configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        driver.get(Urls.mainPageUrl);
        createAccountPage = new CreateAccountPage(driver);
    }
    @When("TC006 user create account using data:")
    public void createAccount(List<Map<String, String>> userDetails){
        SetUp();
        mainPage.ClickSingInButton();
        mainPage.clickCreateAccountButton();
        createAccountPage.firstNameFill(userDetails.get(0).get("First name"));
        createAccountPage.lastNameFill(userDetails.get(0).get("Last name"));
        createAccountPage.emailFill(userDetails.get(0).get("Email"));
        createAccountPage.passwordFill(userDetails.get(0).get("Password"));
    }
    @And("TC006 user log in")
    public void logIn(){
        System.out.println("test");

    }
    @Then("TC006 user check if user data is correct:")
    public void checkData(List<Map<String, String>> userDetails){
        System.out.println("test");
    }
}
