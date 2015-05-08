package org.fasttrackit.examples;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/ExamplesTest.json"},
        glue = {
                "org.fasttrackit.util",
                "org.fasttrackit.examples"
        },
        features = {
                "src/test/resources/feature/my-site/examples.feature"
        }
)
@RunWith(Cucumber.class)
public class ExamplesTest {
}
