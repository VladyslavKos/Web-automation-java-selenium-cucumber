package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class NewAddressPage {
    private WebDriver driver;
    public NewAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = PageElements.NewAddressPageAliasInputXpath)
    private WebElement AliasInput;
    @FindBy(xpath = PageElements.NewAddressPageFirstNameXpath)
    private WebElement firstNameInput;
    @FindBy(xpath = PageElements.NewAddressPageLastNameXpath)
    private WebElement lastNameInput;
    @FindBy(xpath = PageElements.NewAddressPageCompanyXpath)
    private WebElement companyInput;
    @FindBy(xpath = PageElements.NewAddressPageVatNumberXpath)
    private WebElement vatNumberInput;
    @FindBy(xpath = PageElements.NewAddressPageAddressXpath)
    private WebElement addressInput;
    @FindBy(xpath = PageElements.NewAddressPageAddressComplementXpath)
    private WebElement addressComplementInput;
    @FindBy(xpath = PageElements.NewAddressPageCityXpath)
    private WebElement cityInput;
    @FindBy(xpath = PageElements.NewAddressZipXpath)
    private WebElement zipInput;
    @FindBy(xpath = PageElements.NewAddressPhoneXpath)
    private WebElement phoneInput;

}
