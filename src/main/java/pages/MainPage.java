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
    @FindBy(xpath = PageElements.MainPageCreateAccountButtonXpath)
    private WebElement CreateAccountButton;
    @FindBy(css = PageElements.MainPageProductsList)
    private List<WebElement> MainPageProducts;
    @FindBy(xpath = PageElements.SingOutButtonXpath)
    private WebElement SingOutButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSingInButton() {
        MainPageSignInButton.click();
    }

    public void ClickClothesButton() {
        ClothesButton.click();
    }

    public void ClickAccessoriesButton() {
        AccessoriesButton.click();
    }

    public void ClickArtButton() {
        ArtButton.click();
    }

    public void ClickLogo() {
        MyStoreLogoButton.click();
    }

    public List<WebElement> GetProducts() {
        return MainPageProducts;
    }

    public void clickOnProduct(int number) {
        GetProducts().get(number).click();
    }

    public void clickCreateAccountButton() {
        CreateAccountButton.click();
    }

    public void clickSingOutButton() {
        SingOutButton.click();
    }
}
