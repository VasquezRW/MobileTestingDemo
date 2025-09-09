@echo off
REM === Stop Appium servers ===
echo Stopping Appium servers (node.exe)...
taskkill /IM node.exe /F

REM === Stop Selenium Grid hub and nodes ===
echo Stopping Selenium Grid hub and nodes (java.exe)...
taskkill /IM java.exe /F

echo All Appium and Selenium services have been stopped.
pause

