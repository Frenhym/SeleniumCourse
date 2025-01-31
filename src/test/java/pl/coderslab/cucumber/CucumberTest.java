package pl.coderslab.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber",
        plugin = {"pretty", "html:test_report.html"}
)
public class CucumberTest {
}