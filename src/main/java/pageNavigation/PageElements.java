package pageNavigation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElements {
    // for bigger project will be great to sort elements per pages for ex all elements from main page in MainPage.java and e.
    public static final String MainPageSignInButtonXpath = "//*[@id=\"_desktop_user_info\"]/div/a/span";
    public static final String LoginPageEmailLoginInputXpath = "//*[@id=\"field-email\"]";
    public static final String LoginPagePasswordLoginInputXpath = "//*[@id=\"field-password\"]";
    public static final String LoginPageSingInButtonXpath = "//*[@id=\"submit-login\"]";
    public static final String ClothesButtonXpath = "//*[@id=\"category-3\"]/a";
    public static final String AccessoriesButtonXpath = "//*[@id=\"category-6\"]/a";
    public static final String ArtButtonXpath = "//*[@id=\"category-9\"]/a";
    public static final String MyAccountPageInformationButtonXpath = "//*[@id=\"identity-link\"]/span";
    public static final String IdentityPageFirstNameInputXpath = "//*[@id=\"field-firstname\"]";
    public static final String IdentityPageLastNameInputXpath = "//*[@id=\"field-lastname\"]";
    public static final String IdentityPagePasswordInputXpath = "//*[@id=\"field-password\"]";
    public static final String IdentityPageDataPrivacyCheckBoxXpath = "//*[@id=\"customer-form\"]/div/div[9]/div[1]/span/label/input";
    public static final String IdentityPageTermsAndConditionsCheckBoxXpath = "//*[@id=\"customer-form\"]/div/div[11]/div[1]/span/label/input";
    public static final String IdentityPageSaveButtonXpath = "//*[@id=\"customer-form\"]/footer/button";
    public static final String IdentitySuccessMessageXpath = "//*[@id=\"notifications\"]/div/article/ul/li";
    public static final String DesktopUserInfoXpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span";
}
