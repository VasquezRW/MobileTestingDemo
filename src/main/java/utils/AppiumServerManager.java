package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.util.HashMap;
import java.util.Map;

public class AppiumServerManager {

    private static final Map<String, AppiumDriverLocalService> services = new HashMap<>();
    private static final Map<String, Boolean> initialized = new HashMap<>();

    public static synchronized void startServer(String deviceProfile, int port, int systemPort) {
        if (initialized.getOrDefault(deviceProfile, false)) {
            return;
        }

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(port)
                .withArgument(GeneralServerFlag.BASEPATH, "/")
                .withEnvironment(Map.of(
                        "SYSTEM_PORT", String.valueOf(systemPort)
                ));

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();
        services.put(deviceProfile, service);
        initialized.put(deviceProfile, true);

        System.out.println("✅ Appium iniciado para " + deviceProfile + " en puerto " + port + ", systemPort: " + systemPort);

        // Agregar hook de apagado si no se ha hecho
        Runtime.getRuntime().addShutdownHook(new Thread(AppiumServerManager::stopAllServers));
    }

    public static synchronized void stopAllServers() {
        services.forEach((profile, service) -> {
            if (service != null && service.isRunning()) {
                service.stop();
                System.out.println("🛑 Appium detenido para " + profile);
            }
        });
        initialized.clear();
    }

    public static AppiumDriverLocalService getService(String profile) {
        return services.get(profile);
    }
}