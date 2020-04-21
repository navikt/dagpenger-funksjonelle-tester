import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    plugin = [
        "pretty",
        "json:build/cucumber.json"
    ],
    features = ["src/test/resources/features"],
    tags = ["not @ignored"]
)
class RunCucumber
