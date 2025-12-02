#!/bin/bash
# SeedClient Build Setup Script for Unix/Linux/Mac
# This script helps prepare the project for building

echo ""
echo "===== SeedClient Build Setup ====="
echo ""

# Check Java
echo "Checking Java installation..."
if ! command -v java &> /dev/null; then
    echo "[ERROR] Java not found!"
    echo "Please install Java 17 or higher from: https://adoptium.net/"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -1)
echo "[OK] $JAVA_VERSION"

echo ""
echo "Checking Gradle wrapper..."
if [ ! -f "gradlew" ]; then
    echo "[ERROR] gradlew not found!"
    echo "Make sure you are in the SeedClient directory"
    exit 1
fi
echo "[OK] Gradle wrapper found"

echo ""
echo "===== Starting Build ====="
echo ""

# Make gradlew executable
chmod +x gradlew

# Run Gradle clean build
./gradlew clean build

if [ $? -ne 0 ]; then
    echo ""
    echo "[ERROR] Build failed!"
    echo "Check the error messages above"
    exit 1
fi

echo ""
echo "===== Build Successful! ====="
echo ""
echo "JAR location: build/libs/seedclient-1.0.0.jar"
echo ""
echo "Next steps:"
echo "1. Copy the JAR to ~/.minecraft/mods/"
echo "2. Ensure Fabric is installed for Minecraft 1.21.1"
echo "3. Launch Minecraft"
echo "4. Press Insert in-game to open SeedClient"
echo ""
