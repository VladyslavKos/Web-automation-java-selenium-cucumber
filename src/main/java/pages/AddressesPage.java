package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class AddressesPage {
    private WebDriver driver;
    public AddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = PageElements.AddressesPageCreateNewAddressButtonXpath)
    private WebElement createNewAddress;
    public void createNewAddress(){
        createNewAddress.click();
    }
}
