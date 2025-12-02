@echo off
REM SeedClient Build Setup Script for Windows
REM This script helps prepare the project for building

echo.
echo ===== SeedClient Build Setup =====
echo.

REM Check Java
echo Checking Java installation...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java not found!
    echo Please install Java 17 or higher from: https://adoptium.net/
    pause
    exit /b 1
)

for /f "tokens=2" %%i in ('java -version 2^>^&1 ^| findstr /R "version"') do set JAVA_VERSION=%%i
echo [OK] Java version: %JAVA_VERSION%

echo.
echo Checking Gradle wrapper...
if not exist "gradlew.bat" (
    echo [ERROR] gradlew.bat not found!
    echo Make sure you are in the SeedClient directory
    pause
    exit /b 1
)
echo [OK] Gradle wrapper found

echo.
echo ===== Starting Build =====
echo.

REM Run Gradle clean build
gradlew.bat clean build

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Build failed!
    echo Check the error messages above
    pause
    exit /b 1
)

echo.
echo ===== Build Successful! =====
echo.
echo JAR location: build\libs\seedclient-1.0.0.jar
echo.
echo Next steps:
echo 1. Copy the JAR to %%appdata%%\.minecraft\mods\
echo 2. Ensure Fabric is installed for Minecraft 1.21.1
echo 3. Launch Minecraft
echo 4. Press Insert in-game to open SeedClient
echo.
pause
