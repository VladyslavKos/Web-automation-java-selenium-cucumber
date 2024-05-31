package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

import java.util.ArrayList;
import java.util.List;

public class AddressesPage {
    private WebDriver driver;
    public AddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = PageElements.AddressesPageCreateNewAddressButtonCSS)
    private WebElement createNewAddress;
    @FindBy(xpath = PageElements.AddressPageEditButtonXpath)
    private WebElement editButton;

    public void createNewAddress(){
        createNewAddress.click();
    }
    public void clickEditButton(){
        editButton.click();
    }

}
