@echo off
REM === Start Appium Servers ===
start "Appium Server 1" cmd /k appium --port 4723 --base-path / --config grid/appium1.yml
start "Appium Server 2" cmd /k appium --port 4733 --base-path / --config grid/appium2.yml

REM === Wait for Appium servers to initialize ===
timeout /t 5 /nobreak >nul

REM === Start Selenium Grid Hub ===
start "Selenium Grid Hub" cmd /k java -jar grid/selenium-server-4.33.0.jar hub

REM === Wait for Hub to initialize ===
timeout /t 5 /nobreak >nul

REM === Start Selenium Grid Nodes ===
start "Grid Node 1" cmd /k java -jar grid/selenium-server-4.33.0.jar node --config grid/node1.toml
start "Grid Node 2" cmd /k java -jar grid/selenium-server-4.33.0.jar node --config grid/node2.toml

REM === Done ===
echo All servers started. Check each window for status.
pause

