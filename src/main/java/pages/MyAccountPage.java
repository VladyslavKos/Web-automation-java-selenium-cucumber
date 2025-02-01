package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = PageElements.MyAccountPageInformationButtonXpath)
    private WebElement MyAccountPageInformationButton;
    @FindBy(xpath = PageElements.MyAccountPageAddressesButtonXpath)
    private WebElement MyAccountPageAddressesButton;

    public void ClickMyAccountInformation() {
        MyAccountPageInformationButton.click();
    }

    public void clickAddressesButton() {
        MyAccountPageAddressesButton.click();
    }

}
