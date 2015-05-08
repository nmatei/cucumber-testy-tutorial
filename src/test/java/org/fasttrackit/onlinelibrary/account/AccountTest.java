package org.fasttrackit.onlinelibrary.account;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber","json:target/jsonReports/AccountTest.json"},
        glue = {
                "org.fasttrackit.util",
                "org.fasttrackit.onlinelibrary.login",
                "org.fasttrackit.onlinelibrary.account"
        },
        features = {
                "src/test/resources/feature/account/billing.feature"
        }
)
@RunWith(Cucumber.class)
public class AccountTest {
}