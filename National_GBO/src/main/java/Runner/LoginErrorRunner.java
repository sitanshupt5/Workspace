package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features= "D:\\WorkSpace\\National_GBO\\src\\main\\java\\Features\\loginerror.feature",
        glue = {"errorStepDefinitions"},
        plugin = {"pretty", "html:test-output"},
        monochrome = true,
        strict = true,
        dryRun = false
        )



public class LoginErrorRunner {
}
