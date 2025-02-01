package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import urls.Urls;

import java.time.Duration;

public class EditAddressPage {
    private WebDriver driver;

    WebDriverWait wait;
    public EditAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(css = "id='field-alias'")
    private WebElement alias;
    @FindBy(css = "id='field-address1'")
    private WebElement address;
    @FindBy(css = "id='field-city'")
    private WebElement city;
    @FindBy(css = "id='field-postcode'")
    private WebElement postcode;
    @FindBy(css = "id='field-phone'")
    private WebElement phone;
    @FindBy(xpath = "//*[@id=\"address-13051\"]/div[2]/a[1]/span")
    private WebElement editAddressButton;
    public void goToEdit(){
        wait.until(ExpectedConditions.visibilityOf(editAddressButton)).click();
    }
    public String getAlias(){
        return alias.getText();
    }
}
