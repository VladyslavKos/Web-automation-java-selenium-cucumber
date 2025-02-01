package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageNavigation.PageElements;

import java.time.Duration;

public class CreateAccountPage {
    private WebDriver driver;

    WebDriverWait wait;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = PageElements.CreateAccountFirstNameInputXpath)
    private WebElement FirstNameInput;
    @FindBy(xpath = PageElements.CreateAccountLastNameInputXpath)
    private WebElement LastNameInput;
    @FindBy(xpath = PageElements.CreateAccountEmailInputXpath)
    private WebElement emailInput;
    @FindBy(xpath = PageElements.CreateAccountPasswordInputXpath)
    private WebElement passwordInput;
    @FindBy(css = PageElements.AgreePrivacyPolicyCSS)
    private WebElement agreePP;
    @FindBy(css = PageElements.CustomerDataPrivacyCSS)
    private WebElement agreeCDP;
    @FindBy(css = PageElements.SaveButtonCSS)
    private WebElement saveButton;

    public void firstNameFill(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(FirstNameInput)).clear();
        FirstNameInput.sendKeys(firstName);
    }

    public void lastNameFill(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(LastNameInput)).clear();
        LastNameInput.sendKeys(lastName);
    }

    public void emailFill(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).clear();
        emailInput.sendKeys(email);
    }

    public void passwordFill(String password) {

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickAgreePrivacyPolicy() {
        agreePP.click();
    }

    public void clickCustomerDataPrivacy() {
        agreeCDP.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void registerAs(String firstName, String lastName, String email, String password) {
        FirstNameInput.clear();
        FirstNameInput.sendKeys(firstName);
        LastNameInput.clear();
        LastNameInput.sendKeys(lastName);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        agreePP.click();
        agreeCDP.click();
        saveButton.click();
    }

}
