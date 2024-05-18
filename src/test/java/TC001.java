import Configuration.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

import static org.junit.Assert.assertTrue;

public class TC001 {
    private String email="test@example.com";
    private String password="";
    private static final long PAGE_LOAD_THRESHOLD = 6000;
    private WebDriver driver;

    @FindBy(xpath = PageElements.signInButtonXpath)
    private WebElement signInButton;
    @FindBy(xpath = PageElements.emailLoginInputXpath)
    private WebElement emailLoginInput;
    @FindBy(xpath = PageElements.passwordLoginInputXpath)
    private WebElement passwordLoginInput;
    public TC001() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Given("User on store home web page")
    public void given() {
        long startTime = System.currentTimeMillis();
        driver.get("https://mystore-testlab.coderslab.pl");
        long endTime = System.currentTimeMillis();
        long pageLoadTime = endTime - startTime;
        System.out.println("Page load time: "+pageLoadTime+" ms");

//        assertTrue("Page load time exceeds threshold", pageLoadTime <= PAGE_LOAD_THRESHOLD);
    }
    @When("User log in with walid credentials")
    public void loggIn(){

        System.out.println(signInButton);
        System.out.println(emailLoginInput);
        System.out.println(passwordLoginInput);
        signInButton.click();
        emailLoginInput.sendKeys(email);
        passwordLoginInput.sendKeys(password);
    }
}
