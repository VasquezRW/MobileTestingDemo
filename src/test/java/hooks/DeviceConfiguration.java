package hooks;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DeviceConfiguration {

    public static DesiredCapabilities getCapabilities(String profile) {
//        String appDir = System.getProperty("user.dir") + "/src/test/resources/app.apk";
//        System.out.println("-------------------------- Ruta de la aplicación: " + appDir);
        DesiredCapabilities caps = new DesiredCapabilities();
        // Común para todos
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("disableIdLocatorAutocompletion", true);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("enforceAppInstall", true);
        caps.setCapability("autoLaunch",true);
        caps.setCapability("forceAppLaunch", true);
        caps.setCapability("app", "C:/Users/Vasqu/IdeaProjects/MobileTestingDemo/src/test/resources/demoApp.apk");
        caps.setCapability("platformVersion", "12.0");
//        caps.setCapability("avdLaunchTimeout", 120000); // opcional, tiempo de espera
//        caps.setCapability("avdArgs", "-no-boot-anim -wipe-data");
//        caps.setCapability("avdArgs", "-no-boot-anim -wipe-data -no-window -gpu swiftshader_indirect");
        switch (profile) {
            case "device1":
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("deviceName", "ANDROID12");
                caps.setCapability("systemPort", 8200); // clave para paralelismo
//                caps.setCapability("avd", "ANDROID12");
                break;
            case "device2":
                caps.setCapability("udid", "emulator-5556");
                caps.setCapability("deviceName", "ANDROID12A");
                caps.setCapability("systemPort", 8201);
//                caps.setCapability("avd", "ANDROID12A");

                break;
            default:
                throw new IllegalArgumentException("Dispositivo no reconocido: " + profile);
        }
        return caps;
    }

    public static URL getAppiumServerURL(String profile) throws MalformedURLException {
        switch (profile) {
            case "device1": return new URL("http://192.168.1.4:4444/");
            case "device2": return new URL("http://192.168.1.4:4444/");
            default: throw new IllegalArgumentException("Servidor Appium no configurado para perfil: " + profile);
        }
    }
}
