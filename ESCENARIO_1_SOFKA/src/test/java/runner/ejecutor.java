package runner;

import com.sofka.test.utils.BeforeSuite;
import com.sofka.test.utils.RunnerPersonalizado;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.loadProperties;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/",
        glue = "com.sofka.test.stepdefinitions"
)

public class ejecutor {
    @BeforeSuite
    public static void setup() {
        loadProperties();
    }
}