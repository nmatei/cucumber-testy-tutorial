package feature.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        format = {"pretty", "html:target/cucumber","json:target/jsonReports/LoginTest.json"},
        glue = {
                "feature.util",
                "feature.login"
        },
        features = {
                "src/test/resources/feature/login/login.feature"
        }
)
@RunWith(Cucumber.class)
public class LoginTest {
}