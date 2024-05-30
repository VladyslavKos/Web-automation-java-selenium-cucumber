package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.ProductPageTouchSpinUpCSS)
    private WebElement spinUp;
    @FindBy(css = PageElements.ProductPageTouchSpinDownCSS)
    private WebElement spinDown;
    @FindBy(css = PageElements.ProductPageNumberOfItemsCSS)
    private WebElement numberOfItems;
    @FindBy(css = PageElements.ProductPageAddToCartCSS)
    private WebElement addToCart;
    @FindBy(xpath = PageElements.ProductPageProceedToCheckoutCSS)
    private WebElement proceedToCheckout;

    public void clickSpinUp() {
        spinUp.click();
    }

    public void clickSpinDown() {
        spinDown.click();
    }

    public String getNumberOfChosenItems() {
        return numberOfItems.getText();
    }
    public void clearNumberOfTimes(){
        numberOfItems.clear();
    }

    public void inputNumberOfItems(String number) {
        numberOfItems.sendKeys(number);
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void clickAddToCart2() {
        proceedToCheckout.click();
    }

}
