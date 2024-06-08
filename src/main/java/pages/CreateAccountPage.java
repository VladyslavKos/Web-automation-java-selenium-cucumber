package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class CreateAccountPage {
    private WebDriver driver;
    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = PageElements.CreateAccountFirstNameInputXpath)
    private WebElement FirstNameInput;
    @FindBy(xpath = PageElements.CreateAccountLastNameInputXpath)
    private WebElement LastNameInput;
    @FindBy(xpath = PageElements.CreateAccountEmailInputXpath)
    private WebElement emailInput;
    @FindBy(xpath = PageElements.CreateAccountPasswordInputXpath)
    private WebElement passwordInput;

    public void firstNameFill(String firstName){
        FirstNameInput.clear();
        FirstNameInput.sendKeys(firstName);
    }
    public void lastNameFill(String lastName){
        LastNameInput.clear();
        LastNameInput.sendKeys(lastName);
    }
    public void emailFill(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void passwordFill(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

}
