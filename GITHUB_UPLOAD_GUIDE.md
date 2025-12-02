# SeedClient – GitHub Upload & Distribution Guide

**Developed by: MrRaxion**  
**Repository**: https://github.com/MrRaxion/SeedClient

---

## 📤 GitHub Upload Instructions

### Step 1: Create GitHub Repository

1. Go to https://github.com/new
2. Repository name: `SeedClient`
3. Description: `Client-side Fabric mod for Minecraft 1.21.1 – locate structures and items`
4. Visibility: **Public**
5. **Do NOT initialize with README** (we have one already)
6. Click "Create repository"

### Step 2: Push Local Repository to GitHub

On your computer (in SeedClient folder):

```bash
git init
git add .
git commit -m "Initial commit: SeedClient 1.0.0 - Fabric 1.21.1 mod"
git branch -M main
git remote add origin https://github.com/MrRaxion/SeedClient.git
git push -u origin main
```

### Step 3: Verify on GitHub

- Visit https://github.com/MrRaxion/SeedClient
- Should see all files and folders
- README should display properly

---

## 📦 Creating a Release on GitHub

### Step 1: Build the JAR

```bash
# Windows
BUILD.bat

# Linux/Mac
chmod +x BUILD.sh && ./BUILD.sh
```

Output: `build/libs/seedclient-1.0.0.jar`

### Step 2: Create GitHub Release

1. Go to https://github.com/MrRaxion/SeedClient
2. Click "Releases" (right sidebar)
3. Click "Create a new release"
4. Fill in the form:

**Tag version**: `v1.0.0`

**Release title**: `SeedClient 1.0.0`

**Description**:
```markdown
# SeedClient 1.0.0

## Features
- Press Insert to open interactive GUI
- Save world seeds and server names
- Browse 40+ structures in Overworld, Nether, End
- Mark locations with on-screen coordinates
- Persistent JSON configuration
- /locate command integration

## Requirements
- Minecraft 1.21.1
- Fabric Loader 0.16.0+
- Fabric API 0.91.0+

## Installation
1. Download `seedclient-1.0.0.jar` from Assets below
2. Place in `.minecraft/mods/` folder
3. Launch Minecraft 1.21.1 with Fabric profile
4. Press Insert in-game to open SeedClient

## Usage
- **Open Menu**: Press Insert
- **Save Seed**: Enter seed and click Save
- **Browse**: Click dimension tabs (Overworld/Nether/End)
- **Mark**: Click Mark button next to any item
- **View**: See coordinates on-screen
- **Clear**: Click Stop Marking

## Changelog
- Initial release v1.0.0
- Full GUI implementation
- All Overworld/Nether/End locations
- Persistent configuration
- GitHub Actions CI/CD

## Support
- GitHub Issues: Report bugs
- GitHub Discussions: Ask questions
- See README.md for full documentation
```

### Step 3: Upload JAR File

1. In "Attach binaries by dropping them here" section
2. Click or drag `build/libs/seedclient-1.0.0.jar`
3. Wait for upload to complete

### Step 4: Publish Release

- Uncheck "This is a pre-release" (if checked)
- Click "Publish release"

---

## 📥 Download System for Users

### Option 1: Direct GitHub Downloads (Recommended)

Users visit: https://github.com/MrRaxion/SeedClient/releases

They see:
- Version `v1.0.0`
- Download `seedclient-1.0.0.jar`
- Installation instructions

**Steps for users:**
1. Download JAR from release page
2. Copy to `.minecraft/mods/`
3. Launch game
4. Press Insert

### Option 2: Add to Popular Mod Sites

#### CurseForge
1. Go to https://www.curseforge.com/minecraft/mods/create
2. Upload project
3. Upload JAR file
4. Link to GitHub repo
5. Users can download from CurseForge

#### Modrinth
1. Go to https://modrinth.com/mods/create
2. Create project
3. Upload JAR
4. Link to GitHub repo
5. Users can download from Modrinth

#### Planet Minecraft
1. Go to https://www.planetminecraft.com/
2. Submit mod
3. Users download from PMC

---

## 🔄 Update Process

### When Publishing Updates (v1.0.1+)

1. **Make code changes** in your local repo
2. **Increment version** in `gradle.properties`:
   ```properties
   mod_version=1.0.1
   ```
3. **Rebuild JAR**:
   ```bash
   BUILD.bat
   ```
4. **Commit & push** to GitHub:
   ```bash
   git add .
   git commit -m "Update: v1.0.1 - bug fixes"
   git push origin main
   ```
5. **Create new release** on GitHub with updated JAR
6. **Announce on social media** if desired

---

## 🌐 Direct Download Links

After creating GitHub releases, users can download directly:

```
https://github.com/MrRaxion/SeedClient/releases/download/v1.0.0/seedclient-1.0.0.jar
```

### Share these links:

**For users**: "Download from [GitHub Releases](https://github.com/MrRaxion/SeedClient/releases)"

**In website/forum**: 
```html
<a href="https://github.com/MrRaxion/SeedClient/releases/download/v1.0.0/seedclient-1.0.0.jar">
  Download SeedClient 1.0.0
</a>
```

---

## 📋 GitHub Repository Settings

### Recommended Settings

**GitHub → Settings → General**
- ✅ Add topics:
  - `minecraft`
  - `fabric`
  - `mod`
  - `1-21-1`
  - `client-side`

**GitHub → Settings → Options**
- ✅ Allow discussions (for user questions)
- ✅ Allow issues (for bug reports)
- ✅ Allow sponsorships (optional)

**GitHub → Insights → Community**
- Check community health score

---

## 🚀 Promote Your Mod

### Social Media

**Post Template:**
```
🎮 SeedClient 1.0.0 Released!

A new Fabric mod for Minecraft 1.21.1

✨ Features:
- Interactive location browser
- Save world seeds
- On-screen coordinate markers
- 40+ structures & biomes

📥 Download: [GitHub Link]
📚 Docs: README in repo
📍 Platform: Minecraft 1.21.1 (Fabric)

#Minecraft #FabricMod #Gaming
```

### Communities to Share

- Reddit: r/MinecraftMods, r/fabricmc
- Discord: Fabric server, Minecraft modding communities
- Forums: MinecraftForum, CurseForge forums
- YouTube: Minecraft modding channels

---

## ✅ GitHub Pre-Launch Checklist

Before pushing to GitHub:

- [ ] All code compiled without errors
- [ ] JAR file built successfully
- [ ] README.md present and complete
- [ ] QUICK_START.md written
- [ ] BUILD_INSTRUCTIONS.md present
- [ ] LICENSE file included
- [ ] .gitignore configured
- [ ] fabric.mod.json has correct author (MrRaxion)
- [ ] GitHub URLs updated in files
- [ ] No sensitive information in files
- [ ] .gradle and build/ in .gitignore

---

## 📞 GitHub Usage for Community

### Handling Issues
- User reports bug → GitHub Issues
- You fix → Close issue with commit reference
- User sees fix in next release

### Handling Questions
- User asks question → GitHub Discussions
- You answer
- Community can search & find answer

### Handling Contributions
- User wants to contribute → Fork & PR
- You review
- Merge if approved

---

## 🎯 Distribution Summary

**SeedClient is now:**

✅ On GitHub (searchable, discoverable)  
✅ Has releases with JAR downloads  
✅ Has complete documentation  
✅ Has CI/CD automation  
✅ Ready for community contributions  
✅ Ready to add to mod sites (CurseForge, Modrinth)  
✅ Shareable via direct links  

**Users can find and download from:**
- GitHub Releases (primary)
- CurseForge (secondary)
- Modrinth (secondary)
- Direct download link (fastest)

---

## 📝 Repository URLs

**Repository**: https://github.com/MrRaxion/SeedClient  
**Releases**: https://github.com/MrRaxion/SeedClient/releases  
**Issues**: https://github.com/MrRaxion/SeedClient/issues  
**Discussions**: https://github.com/MrRaxion/SeedClient/discussions  

**Direct Download (v1.0.0)**:  
https://github.com/MrRaxion/SeedClient/releases/download/v1.0.0/seedclient-1.0.0.jar

---

## 🎉 Final Steps

1. ✅ Create GitHub repository
2. ✅ Push code with `git push`
3. ✅ Build JAR with `BUILD.bat`
4. ✅ Create release on GitHub
5. ✅ Upload JAR file to release
6. ✅ Share links with community
7. ✅ (Optional) Add to CurseForge/Modrinth

**Your mod is now live and available for download! 🚀**

---

**Version**: 1.0.0  
**Developer**: MrRaxion  
**Status**: Ready for GitHub & Distribution
