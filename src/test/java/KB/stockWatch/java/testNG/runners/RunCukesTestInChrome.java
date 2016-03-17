package KB.stockWatch.java.testNG.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Please notice that cucumber.examples.java.testNG.stepDefinitions.BeforeAfterHooks class
 * is in the same package as the steps definitions.
 * It has two methods that are executed before or after scenario.
 * I'm using it to delete cookies and take a screenshot if scenario fails.
 */
@CucumberOptions(
        features = "target/test-classes/features/niftyStockwatch",
        glue = {"KB.stockWatch.java.testNG.stepDefinitions"},
        format = {"pretty",
                "html:target/cucumber-report/chrome",
                "json:target/cucumber-report/chrome/cucumber.json",
                "junit:target/cucumber-report/chrome/cucumber.xml"})
public class RunCukesTestInChrome extends AbstractTestNGCucumberTests {
}