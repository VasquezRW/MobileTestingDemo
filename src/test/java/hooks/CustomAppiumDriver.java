package hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomAppiumDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        System.out.println("🟢 CustomAppiumDriver.newDriver() ejecutado");
        String profile = System.getProperty("deviceProfile");

        try {
            DesiredCapabilities caps = DeviceConfiguration.getCapabilities(profile);
            URL serverURL = DeviceConfiguration.getAppiumServerURL(profile);
            return new AndroidDriver(serverURL, caps);
//            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}