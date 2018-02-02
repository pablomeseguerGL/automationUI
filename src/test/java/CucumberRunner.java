import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"cucumber.steps"},
        format={"pretty", "html:reports/test-report"},
        features = {"src/test/resources/"},
        tags= "@simple"
        )
public class CucumberRunner {

}
