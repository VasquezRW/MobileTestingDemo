package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/compraMochila.feature",
        glue = {
                "StepDefinitions",
                "hooks"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CompraMochilaTest {
}
