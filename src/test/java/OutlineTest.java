import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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

public class OutlineTest extends Main {

    String loginData;
    String result;

    @When("user login as {string}")
    public void userLoginAsLoginData(String loginData) {
        this.loginData = loginData;
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.clickSingInButton();
        loginPage.loginAs(loginData, loginData);
    }

    @Then("result is {string}")
    public void resultIsResult(String output) {
        if (driver.getCurrentUrl().endsWith("index.php?controller=my-account")) {
            result = "SingIn";
        } else {
            result = "NotSingIn";
        }
        assertEquals("Verification failed: ", result, output);
        driver.quit();
    }
}
