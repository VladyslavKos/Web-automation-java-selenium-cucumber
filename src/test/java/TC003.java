import Configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageNavigation.Messages;
import pages.*;
import testData.TestData;
import urls.Urls;
import utils.ScreenshotUtil;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC003 extends Main {

    @Given("TC003 logged in user on main page")
    public void loggIn() {
        setUp();
        driver.get(Urls.mainPageUrl);
        mainPage.clickSingInButton();
        loginPage.loginAs(TestData.email, TestData.password);
    }

    @When("TC003 user click logo and click product {int}")
    public void searchForProduct(int productIndex) {
        mainPage.ClickLogo();
        mainPage.clickOnProduct(productIndex);
    }

    @And("TC003 user provide number of products")
    public void provideNumberOfProducts() {
        productPage.clearNumberOfTimes();
        productPage.clickSpinUp();
        productPage.clickSpinUp();
    }

    @And("TC003 user click add to cart button")
    public void addToCart() {
        productPage.clickAddToCart();
    }

    @And("TC003 user click on proceed to checkout")
    public void proceedToCheckout() {
        productPage.clickAddToCart2();
    }

    @And("TC003 user click on PROCEED TO CHECKOUT")
    public void proceedToCheckoutCart() {
        shoppingCartPage.clickProceedToCheckout();
    }

    @And("TC003 user chose shipment address")
    public void choseShipmentAddress() {
        orderPage.clickDefaultAddress();
        orderPage.clickAddressContinue();
    }

    @And("TC003 user chose self pick up option")
    public void choseSelfPickUp() {
        orderPage.clickDefaultShipment();
        orderPage.clickShipmentContinue();
    }

    @And("TC003 user chose Pay by Bank option")
    public void payByBank() {
        orderPage.clickPayByBank();
    }

    @And("TC003 user finalize order")
    public void finalizeOrder() {
        orderPage.clickAgreeTermsAndConditions();
        orderPage.clickPlaceOrder();
    }

    @Then("TC003 user check success message")
    public void checkMessage() {
        assertEquals("Wrong message", Messages.CreateNewOrderSuccessMessage, orderConfirmationPage.getMessage());
    }

    @And("TC003 user take screenshot of confirmed order")
    public void takeScreenshot() {
        ScreenshotUtil.takeScreenshot(driver, "target/confirmed_order.png");
        tearDown();
    }
}
