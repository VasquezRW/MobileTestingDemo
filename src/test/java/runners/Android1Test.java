package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.AppiumServerManager;

import java.io.IOException;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/compraProducto.feature",
        glue = {
                "StepDefinitions",
                "hooks"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Android1Test {
    @BeforeClass
    public static void setupProfile() {
        System.out.println("🟢 Ejecutando test suite para DEVICE1");
        System.setProperty("deviceProfile", "device1");
//        System.out.println("🟢 Iniciando Appium Server para DEVICE1");
//        AppiumServerManager.startServer("device1", 4723, 8200);
    }
//    @AfterClass
//    public static void tearDown() {
//        try {
//            Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}