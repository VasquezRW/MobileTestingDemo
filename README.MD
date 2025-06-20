# Mobile Testing Demo

## Requirements

Make sure you have the following components installed:
*The versions shown are recommended. If you have older versions and encounter issues, please update them.*

- Java (JDK) 21.0.2
- Gradle 8.12
- Node.js 22.12.0  
  - Recommended Node.js versions: ^14.17.0 \|\| ^16.13.0 \|\| >=18.0.0 (LTS recommended)
- Appium 2.15
- Android Studio 2024.1.1 (Koala)

## Appium Installation

**With Node.js installed:**
1. `npm install -g appium`
2. `appium driver install uiautomator2`

## Gradle and Android Studio Installation

1. Gradle: Go to the official site and follow the installation guide: https://gradle.org/install/
2. Android Studio: Download and install from https://developer.android.com/studio  
   Make sure to set the environment variable:  
   `ANDROID_HOME -> C:\Users\*your user*\AppData\Local\Android\Sdk`

## Execution Instructions

### 1. Start Android Emulators

Open Android Studio and start two Android emulators (e.g., `emulator-5554` and `emulator-5556`) from the AVD Manager with Android 15 (API 35).

### 2. Start Appium Servers

Open two terminals and run:

```sh
    appium --port 4723 --base-path / --config grid/appium1.yml
    appium --port 4733 --base-path / --config grid/appium2.yml
```

### 3. Start Selenium Grid Hub

In a new terminal, run:

```sh
    java -jar selenium-server-4.25.0.jar hub 
```

### 4. Register Grid Nodes

In two separate terminals, register each node with its config:

```sh
    selenium-server node --config grid/node1.toml
    selenium-server node --config grid/node2.toml
```

### 5. Verify Grid Status

Go to `http://localhost:4444/ui` and check that both nodes are `UP`.

### 6. Run Tests in Parallel

From the project directory, run:

```sh
    ./gradlew parallelTests
```

Or, from IntelliJ IDEA, run the desired test suite or class.

## Reports

After the tests finish, a report will be generated.  
Access it via the link shown in the console or at:

`/target/site/serenity/index.html`

## Capabilities

The implemented capabilities are:

- `webdriver.driver=appium`
- `appium.hub = http://localhost:4444/` (or `/wd/hub` if required by your Appium version)

####### Android CAPABILITIES ######
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

```

This version includes all steps for parallel execution with Selenium Grid and multiple Appium servers.