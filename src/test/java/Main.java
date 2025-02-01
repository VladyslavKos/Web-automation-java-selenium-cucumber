import Configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import utils.GenerateTestData;

import java.util.concurrent.TimeUnit;

public class Main {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected IdentityPage identityPage;
    protected ProductPage productPage;
    protected MyAccountPage myAccountPage;
    protected ShoppingCartPage shoppingCartPage;
    protected OrderPage orderPage;
    protected OrderConfirmationPage orderConfirmationPage;
    protected NewAddressPage newAddressPage;
    protected EditAddressPage editAddressPage;
    protected AddressesPage addressesPage;
    protected GenerateTestData generateTestData;
    protected CreateAccountPage createAccountPage;

    void setUp() {
        Configuration configuration = new Configuration();
        driver = configuration.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        identityPage = new IdentityPage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        orderPage = new OrderPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        newAddressPage = new NewAddressPage(driver);
        editAddressPage = new EditAddressPage(driver);
        addressesPage = new AddressesPage(driver);
        generateTestData = new GenerateTestData();
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    void tearDown() {
        driver.quit();
    }
}
