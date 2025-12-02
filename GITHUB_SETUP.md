# GitHub Repository Setup Instructions

After creating this repository on GitHub, follow these steps:

## 1. Initialize Git (First Time Only)

```bash
cd SeedClient
git init
git add .
git commit -m "Initial commit: SeedClient Fabric 1.21.1 mod"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/SeedClient.git
git push -u origin main
```

## 2. Update fabric.mod.json

Replace `https://github.com/yourusername/SeedClient` with your actual GitHub URL:

```json
"contact": {
  "homepage": "https://github.com/YOUR_USERNAME/SeedClient",
  "sources": "https://github.com/YOUR_USERNAME/SeedClient"
}
```

## 3. Create GitHub Releases

After pushing:
1. Go to your GitHub repository
2. Click "Releases" → "Create a new release"
3. Tag: `v1.0.0`
4. Title: `SeedClient 1.0.0`
5. Upload the JAR from `build/libs/seedclient-1.0.0.jar`
6. Add description:

```markdown
## SeedClient 1.0.0

Client-side Fabric mod for Minecraft 1.21.1

### Features
- Press Insert to open Seed Client GUI
- Save world seeds and server names
- Browse structures in Overworld, Nether, End
- Mark locations and display on-screen coordinates
- Persistent configuration

### Requirements
- Minecraft 1.21.1
- Fabric Loader 0.16.0+
- Fabric API 0.91.0+

### Installation
1. Download `seedclient-1.0.0.jar`
2. Place in `.minecraft/mods/`
3. Launch with Fabric profile

### Usage
- Press **Insert** in-game to open menu
- Click dimensions to browse items
- Click **Mark** to set location
- View coordinates on-screen

See [QUICK_START.md](QUICK_START.md) for detailed usage.
```

## 4. GitHub Actions (Automatic)

The build workflow (`.github/workflows/build.yml`) will:
- Automatically build on every push
- Create JAR artifacts
- Available in Actions tab

## 5. Optional: Add Topics

Go to repository settings and add topics:
- `minecraft`
- `fabric`
- `1-21-1`
- `mod`
- `client-side`

## 6. Optional: Update README

In your README.md, add these sections if desired:

### Download
[![Latest Release](https://img.shields.io/github/v/release/YOUR_USERNAME/SeedClient)](https://github.com/YOUR_USERNAME/SeedClient/releases/latest)

### Installation
Download from [Releases](https://github.com/YOUR_USERNAME/SeedClient/releases/latest)

## 7. Backup & Distribution

Your repository is now ready to:
- ✅ Accept GitHub stars
- ✅ Accept forks and pull requests
- ✅ Auto-build on push
- ✅ Share JAR downloads
- ✅ Track issues and suggestions

## File Checklist

- ✅ All Java source files in `src/main/java/`
- ✅ Resources in `src/main/resources/`
- ✅ build.gradle configured
- ✅ gradle.properties set
- ✅ Gradle wrapper included
- ✅ Documentation complete
- ✅ LICENSE file present
- ✅ .gitignore configured
- ✅ GitHub Actions workflow ready

---

**You're all set!** 🚀 Your SeedClient mod is ready to share with the Minecraft community.
