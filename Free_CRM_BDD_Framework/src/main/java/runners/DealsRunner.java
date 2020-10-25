package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "D:\\WorkSpace\\Free_CRM_BDD_Framework\\src\\main\\java\\features\\deals\\deals.feature",
        glue = {"stepdefinitions.deals"},
        monochrome = true,
        plugin = {"pretty", "html:test-output"},
        strict = true,
        dryRun = false
)

public class DealsRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass()
    {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeatureWrapper)
    {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features()
    {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDown()
    {
        testNGCucumberRunner.finish();
    }
}
