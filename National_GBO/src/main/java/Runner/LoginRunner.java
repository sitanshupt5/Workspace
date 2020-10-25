package Runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features= "D:\\WorkSpace\\National_GBO\\src\\main\\java\\Features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:test-output"},
        monochrome = true,
        strict = true,
        dryRun = false
        )



public class LoginRunner {
}
