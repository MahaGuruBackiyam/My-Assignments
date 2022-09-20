package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/feature/MultipleTestData.feature",glue="steps")
public class RunMultipleTestData extends AbstractTestNGCucumberTests {
}

