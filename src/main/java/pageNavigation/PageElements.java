package pageNavigation;

import com.google.common.base.internal.Finalizer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElements {
    // for bigger project will be great to sort elements per pages for ex all elements from main page in MainPage.java and e.
    public static final String MainPageSignInButtonXpath = "//*[@id=\"_desktop_user_info\"]/div/a/span";
    public static final String SingOutButtonXpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]";
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
    public static final String IdentityPageNewPasswordInputXpath = "//*[@id=\"field-new_password\"]";
    public static final String IdentityPageDataPrivacyCheckBoxXpath = "//*[@id=\"customer-form\"]/div/div[9]/div[1]/span/label/input";
    public static final String IdentityPageTermsAndConditionsCheckBoxXpath = "//*[@id=\"customer-form\"]/div/div[11]/div[1]/span/label/input";
    public static final String IdentityPageSaveButtonXpath = "//*[@id=\"customer-form\"]/footer/button";
    public static final String IdentitySuccessMessageXpath = "//*[@id=\"notifications\"]/div/article/ul/li";
    public static final String MyAccountPageAddressesButtonXpath = "//*[@id=\"addresses-link\"]";
    public static final String AddressesPageCreateNewAddressButtonCSS = "[data-link-action='add-address']";
    public static final String AddressPageEditButtonXpath = "//*[@data-link-action='your-action-value']";
    public static final String NewAddressPageAliasInputXpath = "//*[@id=\"field-alias\"]";
    public static final String NewAddressPageFirstNameXpath = "//*[@id=\"field-firstname\"]";
    public static final String NewAddressPageLastNameXpath = "//*[@id=\"field-lastname\"]";
    public static final String NewAddressPageCompanyXpath = "//*[@id=\"field-company\"]";
    public static final String NewAddressPageVatNumberXpath = "//*[@id=\"field-vat_number\"]";
    public static final String NewAddressPageAddressXpath = "//*[@id=\"field-address1\"]";
    public static final String NewAddressPageAddressComplementXpath = "//*[@id=\"field-address2\"]";
    public static final String NewAddressPageCityXpath = "//*[@id=\"field-city\"]";
    public static final String NewAddressZipXpath = "//*[@id=\"field-postcode\"]";
    public static final String NewAddressPhoneXpath = "//*[@id=\"field-phone\"]";
    public static final String NewAddressPageSaveButtonXpath = "//*[@id=\"content\"]/div/div/form/footer/button";
    public static final String NewAddressPageSuccessMessageXpath = "//*[@id=\"notifications\"]/div/article/ul/li";
    public static final String DesktopUserInfoXpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span";
    public static final String MyStoreLogoButtonXpath = "//*[@id=\"_desktop_logo\"]/a/img";
    public static final String ProductViewAddToCartButtonXpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button";
    public static final String MainPageProductsList = "[class='thumbnail product-thumbnail']";
    public static final String ProductPageTouchSpinUpCSS = "[class='material-icons touchspin-up']";
    public static final String ProductPageTouchSpinDownCSS = "[class='material-icons touchspin-down']";
    public static final String ProductPageNumberOfItemsCSS = "[class='input-group form-control']";
    public static final String ProductPageAddToCartCSS = "[class='btn btn-primary add-to-cart']";
    public static final String ProductPageProceedToCheckoutCSS = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a";
    public static final String CartPageProceedToCheckoutCSS = "[class='btn btn-primary']";
    public static final String OrderPageDefaultAddressCSS = "[class='js-address-item address-item selected']";
    public static final String OrderPageAddressContinueCSS = "[class='btn btn-primary continue float-xs-right']";
    public static final String OrderPageShipmentContinueXpath = "//*[@id=\"js-delivery\"]/button";
    public static final String OrderPageDefaultShipmentCSS = "[class='custom-radio float-xs-left']";
    public static final String OrderPagePayByBankXpath = "[class='ps-shown-by-js ']";
    public static final String OrderPageAgreeTACXpath = "[class='ps-shown-by-js']";
    public static final String OrderPagePlaceOrderCSS = "[class='btn btn-primary center-block']";
    public static final String OrderConfirmationSuccessMessageCSS = "[class='h1 card-title']";


}
