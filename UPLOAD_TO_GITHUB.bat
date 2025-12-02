@echo off
REM ====================================================================
REM SeedClient - GitHub Upload Setup Script
REM Developed by: MrRaxion
REM ====================================================================

echo.
echo ====================================================================
echo   SEEDCLIENT - GitHub Upload Assistant
echo   Developed by: MrRaxion
echo   Repository: https://github.com/MrRaxion/SeedClient
echo ====================================================================
echo.

REM Check Git
echo Checking Git installation...
git --version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Git not found!
    echo Please install Git from: https://git-scm.com/
    pause
    exit /b 1
)
echo [OK] Git is installed

echo.
echo ====================================================================
echo  STEP 1: Initialize Local Git Repository
echo ====================================================================
echo.

if exist ".git" (
    echo [INFO] Git repository already initialized
) else (
    echo Initializing git repository...
    git init
    git add .
    git commit -m "Initial commit: SeedClient 1.0.0 - Fabric 1.21.1 mod by MrRaxion"
    git branch -M main
    echo [OK] Local repository initialized
)

echo.
echo ====================================================================
echo  STEP 2: Remote Repository Setup
echo ====================================================================
echo.

echo You need to create a GitHub repository first:
echo.
echo 1. Go to: https://github.com/new
echo 2. Repository name: SeedClient
echo 3. Description: Client-side Fabric mod for Minecraft 1.21.1
echo 4. Visibility: Public
echo 5. DO NOT initialize with README
echo 6. Create repository
echo.
echo Then, run these commands in this folder:
echo.
echo   git remote add origin https://github.com/MrRaxion/SeedClient.git
echo   git push -u origin main
echo.
echo.

set /p continue="Press Enter to continue or Ctrl+C to exit..."

echo.
echo ====================================================================
echo  STEP 3: Add GitHub Remote
echo ====================================================================
echo.

git remote remove origin 2>nul
git remote add origin https://github.com/MrRaxion/SeedClient.git

echo [OK] GitHub remote added: https://github.com/MrRaxion/SeedClient

echo.
echo ====================================================================
echo  STEP 4: Build JAR for Release
echo ====================================================================
echo.

echo Building JAR file...
call gradlew.bat clean build

if %errorlevel% neq 0 (
    echo [ERROR] Build failed!
    pause
    exit /b 1
)

echo [OK] JAR built successfully at: build\libs\seedclient-1.0.0.jar

echo.
echo ====================================================================
echo  STEP 5: Push to GitHub
echo ====================================================================
echo.

echo Pushing code to GitHub...
git push -u origin main

if %errorlevel% neq 0 (
    echo [ERROR] Push failed! Check your credentials
    pause
    exit /b 1
)

echo [OK] Code pushed to: https://github.com/MrRaxion/SeedClient

echo.
echo ====================================================================
echo  STEP 6: Create Release on GitHub
echo ====================================================================
echo.

echo To create a release:
echo.
echo 1. Visit: https://github.com/MrRaxion/SeedClient/releases
echo 2. Click "Create a new release"
echo 3. Tag version: v1.0.0
echo 4. Release title: SeedClient 1.0.0
echo 5. Upload JAR: build\libs\seedclient-1.0.0.jar
echo 6. Publish release
echo.

set /p open_github="Open GitHub releases page now? (Y/N): "
if /i "%open_github%"=="Y" (
    start https://github.com/MrRaxion/SeedClient/releases
)

echo.
echo ====================================================================
echo  UPLOAD COMPLETE!
echo ====================================================================
echo.
echo Your mod is now ready for distribution!
echo.
echo Next steps:
echo   1. Create release on GitHub
echo   2. Upload JAR file
echo   3. Share release link with community
echo.
echo Repository: https://github.com/MrRaxion/SeedClient
echo Releases:   https://github.com/MrRaxion/SeedClient/releases
echo.
echo For more info, see: GITHUB_UPLOAD_GUIDE.md
echo.

pause
