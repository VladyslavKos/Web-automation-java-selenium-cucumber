package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

public class OrderConfirmationPage {
    private WebDriver driver;
    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = PageElements.OrderConfirmationSuccessMessageCSS)
    private WebElement successMessage;
    public String getMessage(){
        return successMessage.getText();
    }
}
