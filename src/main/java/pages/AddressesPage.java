package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageNavigation.PageElements;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddressesPage {
    private WebDriver driver;

    WebDriverWait wait;
    public AddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(css = "[data-link-action='add-address']")
    private WebElement createNewAddress;
    @FindBy(xpath = "//*[@data-link-action='your-action-value']")
    private WebElement editButton;

    public void createNewAddress(){
        wait.until(ExpectedConditions.visibilityOf(createNewAddress)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }

}
