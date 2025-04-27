package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features",
        glue = "stepDefinitions",
        dryRun = false,
        publish = true,
        monochrome = true,
        tags = "@smoke",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

 class Runner extends AbstractTestNGCucumberTests {

}
