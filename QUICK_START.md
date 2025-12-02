# Quick Start Guide – SeedClient Minecraft Mod

**Developed by: MrRaxion**  
**GitHub**: https://github.com/MrRaxion/SeedClient

## 🚀 Installation (30 seconds)

### Prerequisites
- **Minecraft**: 1.21.1
- **Mod Loader**: Fabric installed
- **Java**: 17+

### Steps
1. Download `seedclient-1.0.0.jar` from [GitHub Releases](https://github.com/MrRaxion/SeedClient/releases)
2. Copy to `%appdata%\.minecraft\mods\` (Windows) or `~/.minecraft/mods/` (Linux/Mac)
3. Launch Minecraft with Fabric profile
4. Done! ✅

---

## 🎮 How to Use

### Opening the Menu
Press **Insert** key in-game → SeedClient GUI opens

### Main Menu Layout
```
┌─ Seed Client ──────────────────────────┐
│ [Server/World] [Seed]  [Save] [ReSeed] │
│ [Overworld] [Nether] [End] [Stop Mark] │
├────────────────────────────────────────┤
│ Plains: villages, horses          [Mark]│
│ Forest: oak/birch, apples         [Mark]│
│ Jungle: cocoa, melons, bamboo     [Mark]│
│ ...                                     │
│ [^ Scroll Up ^] [v Scroll Down v]      │
└────────────────────────────────────────┘
```

### Step-by-Step Usage

**1. Save Your Seed**
```
1. Enter server/world name (optional)
2. Enter your world seed
3. Click [Save] → Settings saved!
```

**2. Browse Structures**
```
1. Click [Overworld], [Nether], or [End]
2. Scroll through the list
3. Click [Mark] next to any location
```

**3. View Marker**
```
- Marker appears on-screen (top-left corner)
- Shows: location name | coordinates (x, y, z)
- Stays visible until you click [Stop Marking]
```

**4. Locate Structures**
```
- When you mark a location, /locate command is sent (if available)
- Server/world will display coordinates in chat
- Navigate to coordinates shown!
```

---

## 📋 Available Locations

### Overworld (10+ options)
- Plains, Forest, Jungle, Desert, Taiga
- Swamp, Mountains, Ocean/Beach
- Village, Mineshaft, Stronghold
- Temples (Desert & Jungle)
- Shipwreck, Buried Treasure, Ruins

### Nether (10+ options)
- Nether Wastes, Crimson Forest, Warped Forest
- Soul Sand Valley, Basalt Deltas
- Nether Fortress, Bastion Remnant
- Ancient Debris, Glowstone

### End (9+ options)
- Main Island, Midlands, Highlands, Barrens
- End City, End Ship, End Gateway
- Shulker Shells, Chorus Fruit

---

## ⚙️ Configuration

Settings are saved to:
```
.minecraft/config/seedclient.json
```

Example file:
```json
{
  "savedSeed": "12345678",
  "serverOrWorld": "My Survival World"
}
```

Edit manually to change settings.

---

## ❓ FAQ

**Q: Can I use this on a server?**
A: Yes! The mod is client-side only. It works on any Fabric 1.21.1 server (singleplayer or multiplayer).

**Q: Will this get me banned?**
A: No. SeedClient is a passive visualization tool – it doesn't modify blocks or send harmful commands.

**Q: Does it work on multiplayer servers?**
A: Yes, but `/locate` command depends on server permissions. Markers and lists work offline or on permissive servers.

**Q: Can I modify the item lists?**
A: Yes! Edit `SeedScreen.java` and rebuild, or request features on GitHub.

**Q: How do I uninstall?**
A: Delete `seedclient-1.0.0.jar` from your mods folder. No leftover files.

---

## 🐛 Troubleshooting

### Mod doesn't load
- ✅ Ensure Fabric is installed for 1.21.1
- ✅ Confirm JAR is in `.minecraft/mods/`
- ✅ Check launcher log for errors

### Insert key doesn't open menu
- ✅ Verify key isn't bound to another mod
- ✅ Try pressing Insert again (sometimes needs a moment)
- ✅ Check if you're in chat (ESC to exit)

### Marker doesn't appear
- ✅ Click [Mark] button next to an item
- ✅ Close and re-open GUI (ESC)
- ✅ Ensure you're not in a menu

### /locate command not working
- ✅ Works best in singleplayer
- ✅ Some servers disable the command – not mod's fault
- ✅ Marker position still displays regardless

---

## 📞 Support

- **GitHub Issues**: [Report bugs](https://github.com/yourusername/SeedClient/issues)
- **GitHub Discussions**: [Ask questions](https://github.com/yourusername/SeedClient/discussions)

---

## 📦 Building from Source

```bash
# Clone repository
git clone https://github.com/yourusername/SeedClient.git
cd SeedClient

# Build JAR
./gradlew clean build  # Linux/Mac
gradlew.bat clean build  # Windows

# Output: build/libs/seedclient-1.0.0.jar
```

See `BUILD_INSTRUCTIONS.md` for detailed setup.

---

**Enjoy exploring Minecraft with SeedClient! 🎮✨**
