package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"stepDefinitions"},
monochrome=true,plugin = {"json:target/cucumber-report/cucumber.json"})
public class TestRunner {

}
