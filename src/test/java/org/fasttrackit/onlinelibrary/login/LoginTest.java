package org.fasttrackit.onlinelibrary.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/LoginTest.json"},
        glue = {
                "org.fasttrackit.util",
                "org.fasttrackit.onlinelibrary.login"
        },
        features = {
                "src/test/resources/feature/login/login.feature"
        }
)
@RunWith(Cucumber.class)
public class LoginTest {
}