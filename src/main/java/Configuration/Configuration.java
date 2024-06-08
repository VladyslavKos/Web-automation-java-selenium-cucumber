package Configuration;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Configuration {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");

            //Proxy server, uncomment to enable
//            Proxy proxy = new Proxy();
//            proxy.setAutodetect(false);
//            proxy.setHttpProxy("127.0.0.1:8080");
//            proxy.setSslProxy("127.0.0.1:8080");
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.setCapability("proxy", proxy);
//            chromeOptions.setAcceptInsecureCerts(true);

            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(chromeOptions);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
