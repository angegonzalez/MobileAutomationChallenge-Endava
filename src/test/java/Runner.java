import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"/stepdefs", "/common"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        tags = ""
)
public class Runner extends AbstractTestNGCucumberTests {
}
