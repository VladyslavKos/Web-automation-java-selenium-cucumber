package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.OrderPageDefaultAddressCSS)
    private WebElement defaultAddress;
    @FindBy(css = PageElements.OrderPageAddressContinueCSS)
    private WebElement addressContinue;
    @FindBy(css = PageElements.OrderPageDefaultShipmentCSS)
    private WebElement defaultShipment;
    @FindBy(xpath = PageElements.OrderPageShipmentContinueXpath)
    private WebElement shipmentContinue;
    @FindBy(css = PageElements.OrderPagePayByBankXpath)
    private WebElement payByBank;
    @FindBy(css = PageElements.OrderPageAgreeTACXpath)
    private WebElement agreeTermsAndConditions;
    @FindBy(css = PageElements.OrderPagePlaceOrderCSS)
    private WebElement placeOrder;

    public void clickDefaultAddress() {
        defaultAddress.click();
    }

    public void clickAddressContinue() {
        addressContinue.click();
    }

    public void clickDefaultShipment() {
        defaultShipment.click();
    }

    public void clickShipmentContinue() {
        shipmentContinue.click();
    }

    public void clickPayByBank() {
        payByBank.click();
    }

    public void clickAgreeTermsAndConditions() {
        agreeTermsAndConditions.click();
    }

    public void clickPlaceOrder() {
        placeOrder.click();
    }

}
