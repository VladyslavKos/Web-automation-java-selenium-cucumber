package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class ShoppingCartPage {
    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = PageElements.CartPageProceedToCheckoutCSS)
    private WebElement proceedToCheckout;
    public void clickProceedToCheckout(){
        proceedToCheckout.click();
    }
}
