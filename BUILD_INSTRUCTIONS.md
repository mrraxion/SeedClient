# SeedClient Build & Installation Guide

## Quick Build (Using Gradle)

### Prerequisites
- Java 17+ (recommend JDK 17 or 21)
- Gradle 8.0+ (or use included wrapper)

### Build Steps
```bash
cd SeedClient
./gradlew clean build  # On Linux/Mac
gradlew.bat clean build  # On Windows
```

The compiled JAR will be created at:
```
build/libs/seedclient-1.0.0.jar
```

## Installation

### Method 1: Automatic (Recommended)
1. Download `seedclient-1.0.0.jar` from GitHub Releases
2. Copy to `.minecraft/mods/` folder
3. Ensure you have Fabric installed for Minecraft 1.21.1
4. Launch the game

### Method 2: Manual Build from Source
1. Clone the repository
2. Run build command (see Build Steps above)
3. Copy `build/libs/seedclient-1.0.0.jar` to `.minecraft/mods/`
4. Launch the game

## Troubleshooting

### Issue: "Could not find Gradle wrapper"
**Solution**: Download Gradle separately:
```bash
gradle clean build
```

### Issue: "Wrong Java version"
**Solution**: Ensure you have Java 17+ installed:
```bash
java -version  # Should show Java 17 or higher
```

Set JAVA_HOME environment variable:
- **Windows**: `set JAVA_HOME=C:\Program Files\Java\jdk-17`
- **Linux/Mac**: `export JAVA_HOME=/usr/libexec/java_home -v 17`

### Issue: Build fails with "Gradle download error"
**Solution**: Use system Gradle:
```bash
gradle --version  # Install if not found
gradle clean build
```

## Gradle Wrapper Setup (Optional)

If the wrapper isn't working, manually download and setup:
```bash
wget https://services.gradle.org/distributions/gradle-8.10-bin.zip
unzip gradle-8.10-bin.zip
export PATH=$PATH:$(pwd)/gradle-8.10/bin
gradle -v
gradle clean build
```

## Directory Structure

```
SeedClient/
├── src/main/
│   ├── java/com/seedclient/
│   │   ├── SeedClient.java
│   │   ├── config/SeedConfig.java
│   │   └── gui/SeedScreen.java
│   └── resources/
│       ├── fabric.mod.json
│       └── seedclient.accesswidener
├── build.gradle
├── gradle.properties
├── settings.gradle
├── gradle/wrapper/
│   ├── gradle-wrapper.jar
│   └── gradle-wrapper.properties
├── gradlew / gradlew.bat
├── README.md
└── LICENSE
```

## CI/CD

Automatic builds are triggered on push to `main` or `develop` branches via GitHub Actions.
Build artifacts are available in Actions tab.

---

**Questions?** Open an issue on GitHub or check the README.md for more details.
