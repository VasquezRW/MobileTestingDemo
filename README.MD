# Mobile Testing Demo

## ESPAÑOL

### Requisitos

Asegúrate de tener instalados los siguientes componentes:
*Las versiones mostradas son recomendadas. Si tienes versiones anteriores y encuentras problemas, actualízalas a las versiones usadas en este proyecto.*

- Java (JDK) 21.0.2
- Gradle 8.12
- Node.js 22.12.0  
  - Versiones recomendadas de Node.js: ^14.17.0 | ^16.13.0 | >=18.0.0 (LTS recomendado)
- Appium 2.15
- Android Studio 2024.1.1 (Koala)

### Instalación de Appium

**Con Node.js instalado:**
1. `npm install -g appium`
2. `appium driver install uiautomator2`

### Instalación de Gradle y Android Studio

1. Gradle: Ve al sitio oficial y sigue la guía de instalación: https://gradle.org/install/
2. Android Studio: Descarga e instala desde https://developer.android.com/studio  
   Asegúrate de configurar la variable de entorno:  
   `ANDROID_HOME -> C:\Users\*tu usuario*\AppData\Local\Android\Sdk`

### Instrucciones de Ejecución

#### 1. Iniciar Emuladores Android

Abre Android Studio y ejecuta dos emuladores Android (por ejemplo, `emulator-5554` y `emulator-5556`) desde el AVD Manager con Android 15 (API 35).

#### 2. Iniciar los servidores Appium

Ejecuta el siguiente script para iniciar todos los servidores en el orden correcto:

```bat
start_servers.bat
```

Esto abrirá varias ventanas de terminal, una por cada servicio.

#### 3. Verificar el estado del Grid

Accede a `http://localhost:4444/ui` y verifica que ambos nodos estén `UP`.

#### 4. Ejecutar pruebas en paralelo

Desde el directorio del proyecto, ejecuta:

```bat
./gradlew clean parallelTests -i
```

O, desde IntelliJ IDEA, ejecuta el suite o clase de prueba deseada.

#### 5. Detener todos los servicios

Para detener todos los servicios iniciados por el script, ejecuta:

```bat
stop_servers.bat
```

Esto cerrará todas las ventanas y procesos relacionados con Appium y Selenium Grid.

### Reportes

Después de finalizar las pruebas, se generará un reporte.  
Accede a él mediante el enlace mostrado en la consola o en:

`/target/site/serenity/index.html`

### Capacidades

Las capacidades implementadas son:

- `webdriver.driver=appium`
- `appium.hub = http://localhost:4444/` (o `/wd/hub` si tu versión de Appium lo requiere)

####### CAPACIDADES ANDROID ######
- `appium.automationName=UiAutomator2`
- `appium.platformName=Android`
- `appium.platformVersion=15.0`
- `appium.deviceName=Pixel8API35`
- `appium.udid=emulator-5554`
- `appium.app=${user.dir}/src/test/resources/demoApp.apk`
- `appium.autoGrantPermissions=true`
- `appium.disableIdLocatorAutocompletion=true`

Para cambiar cualquier valor, edita el archivo `serenity.properties`.  
No cambies: `appium.hub`, `appium.app` o `appium.automationName`.

---
## ENGLISH
### Requirements

Make sure you have the following components installed:
*The versions shown are recommended. If you have older versions and encounter issues, please update them to the versions used in this project.*

- Java (JDK) 21.0.2
- Gradle 8.12
- Node.js 22.12.0  
  - Recommended Node.js versions: ^14.17.0 | ^16.13.0 | >=18.0.0 (LTS recommended)
- Appium 2.15
- Android Studio 2024.1.1 (Koala)

### Appium Installation

**With Node.js installed:**
1. `npm install -g appium`
2. `appium driver install uiautomator2`

### Gradle and Android Studio Installation

1. Gradle: Go to the official site and follow the installation guide: https://gradle.org/install/
2. Android Studio: Download and install from https://developer.android.com/studio  
   Make sure to set the environment variable:  
   `ANDROID_HOME -> C:\Users\*your user*\AppData\Local\Android\Sdk`

### Execution Instructions

#### 1. Start Android Emulators

Open Android Studio and start two Android emulators (e.g., `emulator-5554` and `emulator-5556`) from the AVD Manager with Android 15 (API 35).

#### 2. Start Appium Servers

Run the following script to start all servers in the correct order:

```bat
start_servers.bat
```

This will open several terminal windows, one for each service.

#### 3. Verify Grid Status

Go to `http://localhost:4444/ui` and check that both nodes are `UP`.

#### 4. Run Tests in Parallel

From the project directory, run:

```bat
./gradlew clean parallelTests -i
```

Or, from IntelliJ IDEA, run the desired test suite or class.

#### 5. Stop all services

To stop all services started by the script, run:

```bat
stop_servers.bat
```

This will close all windows and processes related to Appium and Selenium Grid.

### Reports

After the tests finish, a report will be generated.  
Access it via the link shown in the console or at:

`/target/site/serenity/index.html`

### Capabilities

The implemented capabilities are:

- `webdriver.driver=appium`
- `appium.hub = http://localhost:4444/` (or `/wd/hub` if required by your Appium version)

####### ANDROID CAPABILITIES ######
- `appium.automationName=UiAutomator2`
- `appium.platformName=Android`
- `appium.platformVersion=15.0`
- `appium.deviceName=Pixel8API35`
- `appium.udid=emulator-5554`
- `appium.app=${user.dir}/src/test/resources/demoApp.apk`
- `appium.autoGrantPermissions=true`
- `appium.disableIdLocatorAutocompletion=true`

To change any value, edit the `serenity.properties` file.  
Do not change: `appium.hub`, `appium.app`, or `appium.automationName`.

---

Este README incluye todos los pasos para la ejecución paralela con Selenium Grid y múltiples servidores Appium, y ahora está disponible en español e inglés.
