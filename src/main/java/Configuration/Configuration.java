package Configuration;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Configuration {
    private WebDriver driver;
    public WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            String proxy = "127.0.0.1:8080"; // Proxy server and port
            options.addArguments("--proxy-server=http://" + proxy);
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
            WebDriverManager.chromedriver().setup();
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
