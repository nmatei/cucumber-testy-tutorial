package org.fasttrackit.workshop.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/jsonReports/LoginTest.json"},
        glue = {
                "org.fasttrackit.workshop.login"
        },
        features = {
                "src/test/resources/feature/workshop/login.feature"
        }
)
@RunWith(Cucumber.class)
public class LoginTest {
}