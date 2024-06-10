package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class IdentityPage {
    private WebDriver driver;

    public IdentityPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = PageElements.IdentityPageFirstNameInputXpath)
    private WebElement IdentityPageFirstNameInput;
    @FindBy(xpath = PageElements.IdentityPageLastNameInputXpath)
    private WebElement IdentityPageLastNameInput;
    @FindBy(xpath = PageElements.IdentityPagePasswordInputXpath)
    private WebElement IdentityPagePasswordInput;
    @FindBy(xpath = PageElements.IdentityPageDataPrivacyCheckBoxXpath)
    private WebElement IdentityPageDataPrivacyCheckBox;
    @FindBy(xpath = PageElements.IdentityPageTermsAndConditionsCheckBoxXpath)
    private WebElement IdentityPageTermsAndConditionsCheckBox;
    @FindBy(xpath = PageElements.IdentityPageSaveButtonXpath)
    private WebElement IdentityPageSaveButton;
    @FindBy(xpath = PageElements.IdentitySuccessMessageXpath)
    private WebElement IdentitySuccessMessage;
    @FindBy(xpath = PageElements.IdentityPageNewPasswordInputXpath)
    private WebElement IdentityPageNewPassword;
    public void changeData(String Firstname,String Lastname,String password){
        IdentityPageFirstNameInput.clear();
        IdentityPageFirstNameInput.sendKeys(Firstname);
        IdentityPageLastNameInput.clear();
        IdentityPageLastNameInput.sendKeys(Lastname);
        IdentityPagePasswordInput.clear();
        IdentityPagePasswordInput.sendKeys(password);
        IdentityPageDataPrivacyCheckBox.click();
        IdentityPageTermsAndConditionsCheckBox.click();
        IdentityPageSaveButton.click();
    }
    public void changePassword(String OldPassword,String newPassword){
        IdentityPagePasswordInput.clear();
        IdentityPagePasswordInput.sendKeys(OldPassword);
        IdentityPageNewPassword.clear();
        IdentityPageNewPassword.sendKeys(newPassword);
        IdentityPageDataPrivacyCheckBox.click();
        IdentityPageTermsAndConditionsCheckBox.click();
        IdentityPageSaveButton.click();
    }

    public void changeFirstName(String Firstname) {
        IdentityPageFirstNameInput.clear();
        IdentityPageFirstNameInput.sendKeys(Firstname);
    }

    public void changeLastName(String Lastname) {
        IdentityPageLastNameInput.clear();
        IdentityPageLastNameInput.sendKeys(Lastname);
    }

    public void inputPassword(String password) {
        IdentityPagePasswordInput.clear();
        IdentityPagePasswordInput.sendKeys(password);
    }

    public void agreeDataPrivacy() {
        IdentityPageDataPrivacyCheckBox.click();
    }

    public void agreeTermsAndConditions() {
        IdentityPageTermsAndConditionsCheckBox.click();
    }

    public void clickSaveButton() {
        IdentityPageSaveButton.click();
    }

    public String checkSuccessMessage() {
        return IdentitySuccessMessage.getText();
    }

    public void inputNewPassword(String password) {
        IdentityPageNewPassword.clear();
        IdentityPageNewPassword.sendKeys(password);
    }
}
