package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = PageElements.ProductPageTouchSpinUpCSS)
    private WebElement spinUp;
    @FindBy(css = PageElements.ProductPageTouchSpinDownCSS)
    private WebElement spinDown;
    @FindBy(css = PageElements.ProductPageNumberOfItemsCSS)
    private WebElement numberOfItems;
    public void clickSpinUp(){
        spinUp.click();
    }
    public void clickSpinDown(){
        spinDown.click();
    }
    public void inputNumberOfItems(String number){
        numberOfItems.clear();
        numberOfItems.sendKeys(number);
    }
}
