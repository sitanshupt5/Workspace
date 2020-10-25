package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\WorkSpace\\FreeCRMAutomation\\src\\main\\java\\features\\loginerror.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:test-output"},
        strict = false,
        dryRun = false
)

public class LoginRunner {

}
