package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;
import testData.TestData;

public class LoginPage {
    @FindBy(xpath = PageElements.LoginPageEmailLoginInputXpath)
    private WebElement LoginPageEmailInput;
    @FindBy(xpath = PageElements.LoginPagePasswordLoginInputXpath)
    private WebElement LoginPagePasswordInput;
    @FindBy(xpath = PageElements.LoginPageSingInButtonXpath)
    private WebElement LoginPageSingInButton;
    @FindBy(xpath = PageElements.DesktopUserInfoXpath)
    private WebElement DesktopUserInfo;
    @FindBy(xpath = PageElements.SingOutButtonXpath)
    private WebElement SingOutButton;
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        LoginPageEmailInput.click();
        LoginPageEmailInput.clear();
        LoginPageEmailInput.sendKeys(email);

        LoginPagePasswordInput.click();
        LoginPagePasswordInput.clear();
        LoginPagePasswordInput.sendKeys(password);

        LoginPageSingInButton.click();
    }

    public String getLoggedUserName() {
        return DesktopUserInfo.getText();
    }
    public void logOut(){
        SingOutButton.click();
    }
}
