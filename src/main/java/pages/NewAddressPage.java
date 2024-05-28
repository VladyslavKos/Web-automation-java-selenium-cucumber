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
    private WebElement aliasInput;
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
    @FindBy(xpath = PageElements.NewAddressPageSaveButtonXpath)
    private WebElement NewAddressPageSaveButton;
    @FindBy(xpath = PageElements.NewAddressPageSuccessMessageXpath)
    private WebElement NewAddressPageSuccessMessage;
    public void inputAlias(String alias){
        aliasInput.sendKeys(alias);
    }
    public void inputFirstName(String name){
        firstNameInput.sendKeys(name);
    }
    public void inputLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }
    public void inputCompany(String company){
        companyInput.sendKeys(company);
    }
    public void inputVatNumber(String vat){
        vatNumberInput.sendKeys(vat);
    }
    public void inputAddress(String address){
        addressInput.sendKeys(address);
    }
    public void inputAddressCompany(String complementAddress){
        addressComplementInput.sendKeys(complementAddress);
    }
    public void inputCity(String city){
        cityInput.sendKeys(city);
    }
    public void inputZipCode(String zipCode){
        zipInput.sendKeys(zipCode);
    }
    public void inputPhone(String phone){
        phoneInput.sendKeys(phone);
    }
    public void clickSaveButton(){
        NewAddressPageSaveButton.click();
    }
    public String getSuccessMessage(){
       return NewAddressPageSuccessMessage.getText();
    }
}
