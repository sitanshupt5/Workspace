package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\WorkSpace\\Free_CRM_BDD_Framework\\src\\main\\java\\features\\login.feature",
        glue = {"stepdefinitions"},
        monochrome = true,
        strict = true,
        plugin = {"pretty", "html:test-output"},
        dryRun = false
)

public class LoginRunner {
}
