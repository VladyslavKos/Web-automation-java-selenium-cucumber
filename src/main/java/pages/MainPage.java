package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.PageElements;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = PageElements.MainPageSignInButtonXpath)
    private WebElement MainPageSignInButton;
    @FindBy(xpath = PageElements.ClothesButtonXpath)
    private WebElement ClothesButton;
    @FindBy(xpath = PageElements.AccessoriesButtonXpath)
    private WebElement AccessoriesButton;
    @FindBy(xpath = PageElements.ArtButtonXpath)
    private WebElement ArtButton;
    @FindBy(xpath = PageElements.MyStoreLogoButtonXpath)
    private WebElement MyStoreLogoButton;
    @FindBy(css = ".product-miniature.js-product-miniature")
    private List<WebElement> MainPageProducts;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void ClickSingInButton(){
        MainPageSignInButton.click();
    }
    public void ClickClothesButton(){
        ClothesButton.click();
    }
    public void ClickAccessoriesButton(){
        AccessoriesButton.click();
    }
    public void ClickArtButton(){
        ArtButton.click();
    }
    public void ClickLogo(){
        MyStoreLogoButton.click();
    }
    public List<WebElement> GetProducts(){
        return MainPageProducts;
    }
    public void clickOnProduct(String cssSelector){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.click();
    }
//    @FindBy(xpath = PageElements.MainPageSignInButtonXpath)
//    private WebElement MainPageSignInButton;
//    @FindBy(xpath = PageElements.LoginPageEmailLoginInputXpath)
//    private WebElement LoginPageEmailInput;
//    @FindBy(xpath = PageElements.LoginPagePasswordLoginInputXpath)
//    private WebElement LoginPagePasswordInput;
//    @FindBy(xpath = PageElements.LoginPageSingInButtonXpath)
//    private WebElement LoginPageSingInButton;
//    @FindBy(xpath = PageElements.ClothesButtonXpath)
//    private WebElement ClothesButton;
//    @FindBy(xpath = PageElements.AccessoriesButtonXpath)
//    private WebElement AccessoriesButton;
//    @FindBy(xpath = PageElements.ArtButtonXpath)
//    private WebElement ArtButton;
//    @FindBy(xpath =  PageElements.MyAccountPageInformationButtonXpath)
//    private WebElement MyAccountPageInformationButton;

//    @FindBy(xpath = PageElements.DesktopUserInfoXpath)
//    private WebElement DesktopUserInfo;
}
