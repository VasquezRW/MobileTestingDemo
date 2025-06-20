package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
public class Android2Test {
    @BeforeClass
    public static void setupProfile() {
        System.out.println("🟢 Ejecutando test suite para DEVICE2");
        System.setProperty("deviceProfile", "device2");
//        System.out.println("🟢 Iniciando Appium Server para DEVICE2");
//        AppiumServerManager.startServer("device2", 4733, 8201);
    }
//    @AfterClass
//    public static void tearDown() {
//        try {
//            Runtime.getRuntime().exec("adb -s emulator-5556 emu kill");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}