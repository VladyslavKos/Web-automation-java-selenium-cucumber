import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features/",
        glue = "",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@TC001"
)
public class TestRunner {
}
