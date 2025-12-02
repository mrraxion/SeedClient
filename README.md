# SeedClient – Minecraft Fabric Mod 1.21.1

**Developed by: MrRaxion**  
**GitHub**: https://github.com/MrRaxion/SeedClient

A lightweight **client-side** Fabric mod for Minecraft 1.21.1 that provides an interactive GUI for locating and marking Minecraft structures and biomes in Overworld, Nether, and End dimensions.

## Features

- **Press Insert** to open the Seed Client GUI
- **Save Server/World seed** with persistent JSON configuration
- **ReSeed button** to quickly clear the current seed
- **Dimension toggle** (Overworld, Nether, End)
- **Scrollable item lists** showing all structures and resources per dimension
- **Mark locations** to display persistent on-screen marker with coordinates
- **Stop Marking** button to hide the active marker
- **/locate command** integration (works in singleplayer/integrated server)

## Included Items

### Overworld
- **Biomes**: Plains, Forest, Jungle, Desert, Taiga, Snowy Tundra, Swamp, Mountains, Ocean/Beach
- **Structures**: Village, Mineshaft, Stronghold, Desert Temple, Jungle Temple, Shipwreck, Buried Treasure, Ruined Portal, Pillager Outpost, Woodland Mansion

### Nether
- **Biomes**: Nether Wastes, Crimson Forest, Warped Forest, Soul Sand Valley, Basalt Deltas
- **Structures**: Nether Fortress, Bastion Remnant, Ruined Portal (Nether), Ancient Debris, Glowstone

### End
- **Biomes**: Main Island, End Midlands, End Highlands, End Barrens
- **Structures**: End City, End Ship, End Gateway, Shulker Shells, Chorus Fruit

## Downloads

### Latest Release
Download the latest `seedclient-1.0.0.jar` from:
- **GitHub Releases**: https://github.com/MrRaxion/SeedClient/releases
- **CurseForge** (coming soon)
- **Modrinth** (coming soon)

## Installation

### Requirements
- **Minecraft 1.21.1**
- **Fabric Loader** (0.16.0+)
- **Fabric API** (0.91.0+)

### Installation Steps
1. Ensure you have Fabric installed for Minecraft 1.21.1
2. Download `seedclient-1.0.0.jar` from **[GitHub Releases](https://github.com/MrRaxion/SeedClient/releases)**
3. Place it in your `.minecraft/mods/` folder:
   - **Windows**: `%appdata%\.minecraft\mods\`
   - **Linux/Mac**: `~/.minecraft/mods/`
4. Launch Minecraft with the Fabric profile
5. Press **Insert** to open the Seed Client GUI

## Building from Source

### Prerequisites
- JDK 17+
- Gradle (or use the included wrapper)

### Build
```bash
cd SeedClient
./gradlew build
```

The compiled JAR will be in `build/libs/seedclient-1.0.0.jar`.

### Development
1. Clone the repository
2. Run `./gradlew genSources` to download and process Minecraft sources
3. Import the project into your IDE
4. Run `./gradlew runClient` to test in-game

## How to Use

1. **Open GUI**: Press **Insert** key in-game
2. **Enter seed**: Type or paste your world seed in the "Seed" field
3. **Enter server/world name**: (optional) Identify the world
4. **Save**: Click **Save** to persist settings
5. **Select dimension**: Click **Overworld**, **Nether**, or **End**
6. **Browse items**: Scroll through the list of structures/biomes
7. **Mark location**: Click **Mark** button next to any item to:
   - Set marker at your current position
   - Display on-screen coordinates
   - (Optionally) trigger `/locate` command if on a server/world that permits it
8. **Stop marking**: Click **Stop Marking** to hide the marker

## GUI Layout

```
[Server/World Field] | [Seed Field] [Save] [ReSeed]
[Overworld] [Nether] [End] [Stop Marking]

[Item 1]              [Mark]
[Item 2]              [Mark]
...
[^ Scroll Up ^]
[v Scroll Down v]
```

## Configuration

Settings are saved to:
```
.minecraft/config/seedclient.json
```

Example:
```json
{
  "savedSeed": "1234567890",
  "serverOrWorld": "My World"
}
```

## Links

- **GitHub Repository**: https://github.com/MrRaxion/SeedClient
- **Issue Tracker**: https://github.com/MrRaxion/SeedClient/issues
- **Discussions**: https://github.com/MrRaxion/SeedClient/discussions
- **Developer**: MrRaxion

## License

MIT License – See LICENSE file for details

## Support

For issues or feature requests, please create an issue on GitHub.

---

**Version**: 1.0.0  
**Minecraft**: 1.21.1  
**Mod Loader**: Fabric
