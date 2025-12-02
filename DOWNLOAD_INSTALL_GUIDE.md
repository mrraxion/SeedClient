# SeedClient – Download & Installation Guide

**Developed by: MrRaxion**  
**Mod Name**: SeedClient 1.0.0  
**Minecraft Version**: 1.21.1  
**Mod Loader**: Fabric

---

## 📥 Download Options

### Option 1: GitHub Releases (Recommended) ⭐

**Direct Link**: https://github.com/MrRaxion/SeedClient/releases

**Steps:**
1. Visit the link above
2. Find version `v1.0.0`
3. Download `seedclient-1.0.0.jar`
4. Go to [Installation](#-installation) section below

---

### Option 2: Direct Download Link

**Fast Link**: https://github.com/MrRaxion/SeedClient/releases/download/v1.0.0/seedclient-1.0.0.jar

- Click link to download directly
- Save file to a folder
- Go to [Installation](#-installation) section below

---

### Option 3: CurseForge (Coming Soon)

- Visit https://www.curseforge.com/minecraft/mods
- Search "SeedClient"
- Download from mod page

---

### Option 4: Modrinth (Coming Soon)

- Visit https://modrinth.com/mods
- Search "SeedClient"
- Download from mod page

---

## ✅ System Requirements

Before installing, verify you have:

- ✅ **Minecraft 1.21.1** (exact version)
- ✅ **Fabric Mod Loader** installed for 1.21.1
- ✅ **Fabric API** mod installed (0.91.0+)
- ✅ `.minecraft` folder with `mods/` subfolder
- ✅ 200 MB free disk space

### Don't Have Fabric?

1. Download Fabric Installer: https://fabricmc.net/
2. Run the installer
3. Select Minecraft 1.21.1
4. Click "Install"
5. Select "Vanilla" (or Quilt if you prefer)
6. Click "Install"

### Don't Have Fabric API?

1. Download Fabric API: https://www.curseforge.com/minecraft/mods/fabric-api
2. Select version for 1.21.1
3. Download the JAR file
4. Place in `.minecraft/mods/` (same as SeedClient)

---

## 📂 Installation

### Step 1: Download

Download `seedclient-1.0.0.jar` using one of the options above.

### Step 2: Locate .minecraft Folder

**Windows:**
```
C:\Users\[YourUsername]\AppData\Roaming\.minecraft\
```

Or press `Win + R`, type:
```
%appdata%\.minecraft
```

**Mac:**
```
~/Library/Application Support/minecraft/
```

**Linux:**
```
~/.minecraft/
```

### Step 3: Navigate to mods Folder

Inside `.minecraft` folder, look for `mods/` folder.

**If it doesn't exist**, create it:
1. Right-click in `.minecraft` folder
2. New → Folder
3. Name it `mods`

### Step 4: Move JAR File

Drag and drop `seedclient-1.0.0.jar` into the `mods/` folder.

Result: `.minecraft/mods/seedclient-1.0.0.jar`

### Step 5: Launch Minecraft

1. Open Minecraft Launcher
2. Click "Installations"
3. Select "Fabric 1.21.1" profile
4. Click "Play"
5. Wait for game to load

### Step 6: Verify Installation

In-game:
1. Open main menu
2. Check bottom-left for "Fabric" message
3. Should show mod count (includes SeedClient)
4. If you see no errors, installation worked!

---

## 🎮 First Time Using SeedClient

### Open the Menu
- Press **Insert** key (on your keyboard)
- A menu should appear in the center of the screen

### First Steps
1. Type a world seed (optional)
2. Type server/world name (optional)
3. Click **Save**
4. Click **Overworld** tab
5. Click **Mark** next to any item
6. Marker should appear top-left with coordinates!

For detailed usage, see [QUICK_START.md](QUICK_START.md)

---

## 🔧 Troubleshooting

### "Mod won't load"

**Check 1: Is Fabric installed?**
- Launcher → Installations → Should show "Fabric" profile
- If not, install Fabric from https://fabricmc.net/

**Check 2: Is the JAR in the right place?**
- Location should be: `.minecraft/mods/seedclient-1.0.0.jar`
- Wrong: `.minecraft/mods/SeedClient/seedclient-1.0.0.jar`

**Check 3: Do you have Fabric API?**
- Need `fabric-api-*.jar` in `.minecraft/mods/` folder
- Download from https://www.curseforge.com/minecraft/mods/fabric-api

**Check 4: Is it the right Minecraft version?**
- Game must be 1.21.1 (exactly)
- Wrong versions (1.20.1, 1.21, etc.) won't work

**Check 5: Look at launcher log**
- Launcher → Installations → Select Fabric → Click folder icon
- Open `logs/latest.log`
- Search for "seedclient" errors

### "Insert key doesn't work"

**Solution 1**: Try pressing again (sometimes needs a moment)

**Solution 2**: Make sure you're not in chat mode
- Press ESC to exit any menu first

**Solution 3**: Rebind the key
- Singleplayer → Open to LAN → (close)
- Options → Controls → Search "seedclient"
- Click key next to "Open menu"
- Press new key (e.g., Tab, Right-Click, etc.)

**Solution 4**: Update/reinstall the mod
- Delete `seedclient-1.0.0.jar` from mods folder
- Download fresh copy from GitHub Releases
- Restart game

### "Marker doesn't appear"

**Solution**: Click the **Mark** button again
- Make sure menu is open (press Insert)
- Select a dimension (Overworld/Nether/End)
- Click **Mark** button next to any item
- Marker should appear top-left of screen

### "Config not saving"

**Solution 1**: Make sure `.minecraft/config/` exists
- If not, create it manually

**Solution 2**: Restart the game
- Close and reopen Minecraft

**Solution 3**: Check file permissions
- Windows: Right-click `.minecraft` → Properties → Security
- Make sure you have "Write" permission

### Game crashes on startup

**Solution 1**: Check Minecraft version
- Must be exactly 1.21.1 (not 1.20.1, not 1.21)

**Solution 2**: Look at crash report
- Launcher shows crash log
- Copy error message into Google search

**Solution 3**: Remove the mod temporarily
- Delete `seedclient-1.0.0.jar` from mods folder
- If game launches, problem is with the mod
- Reinstall fresh copy

**Solution 4**: Verify Fabric API version
- Need Fabric API for 1.21.1 (not 1.20.1)
- Download from CurseForge, filter by 1.21.1

---

## 📦 Uninstall

To remove SeedClient:

1. Navigate to `.minecraft/mods/` folder
2. Delete `seedclient-1.0.0.jar`
3. Restart Minecraft
4. Mod is removed (no leftover files)

---

## 📚 Resources

- **GitHub Repository**: https://github.com/MrRaxion/SeedClient
- **GitHub Issues** (Report bugs): https://github.com/MrRaxion/SeedClient/issues
- **GitHub Discussions** (Ask questions): https://github.com/MrRaxion/SeedClient/discussions
- **README** (Full documentation): See README.md
- **Quick Start** (5-minute guide): See QUICK_START.md

---

## 🎓 Learn More

### Fabric Installation
- Official: https://fabricmc.net/use/installer/
- Wiki: https://fabricmc.net/wiki/setup:guide

### Minecraft 1.21.1
- Download: https://launcher.mojang.com/download/Minecraft.exe
- Official launcher: https://www.minecraft.net/download

### Mod Sites
- CurseForge: https://www.curseforge.com/minecraft/mods
- Modrinth: https://modrinth.com/mods
- PlanetMC: https://www.planetminecraft.com/

---

## ✨ Support

Having issues? Here's where to get help:

1. **Check this page** for troubleshooting
2. **Read README.md** for features & details
3. **GitHub Issues**: Report bugs at https://github.com/MrRaxion/SeedClient/issues
4. **GitHub Discussions**: Ask questions at https://github.com/MrRaxion/SeedClient/discussions
5. **Fabric Forums**: Get help at https://discord.gg/v6v4pMv

---

## 📝 Version Information

- **Current Version**: 1.0.0
- **Minecraft**: 1.21.1
- **Mod Loader**: Fabric
- **Java**: 17+ (included with Minecraft)
- **License**: MIT (free to use)

---

**Happy exploring! 🎮 Press Insert in-game to get started!**
