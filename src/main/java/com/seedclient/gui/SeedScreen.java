package com.seedclient.gui;

import com.seedclient.SeedClient;
import com.seedclient.config.SeedConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class SeedScreen extends Screen {

    private TextFieldWidget seedField;
    private TextFieldWidget serverField;
    private ButtonWidget saveButton;
    private ButtonWidget reSeedButton;
    private ButtonWidget stopMarkingButton;

    public static String activeMarkerName = null;
    public static double activeMarkerX = Double.NaN;
    public static double activeMarkerY = Double.NaN;
    public static double activeMarkerZ = Double.NaN;
    public static boolean markerActive = false;

    private enum Dimension { OVERWORLD, NETHER, END }
    private Dimension currentDimension = Dimension.OVERWORLD;

    private final List<String> overworldItems = new ArrayList<>();
    private final List<String> netherItems = new ArrayList<>();
    private final List<String> endItems = new ArrayList<>();

    private int scrollOffset = 0;
    private static final int ITEMS_PER_PAGE = 8;

    protected SeedScreen(Text title) {
        super(title);
        populateItemLists();
    }

    private void populateItemLists() {
        // Overworld Biomes & Resources
        overworldItems.add("Plains: villages, horses, hay bales");
        overworldItems.add("Forest: oak/birch wood, apples, wolves");
        overworldItems.add("Jungle: cocoa beans, melons, bamboo");
        overworldItems.add("Desert: sand, cactus, desert temples");
        overworldItems.add("Taiga: spruce wood, sweet berries, foxes");
        overworldItems.add("Snowy Tundra: snow, ice, igloos");
        overworldItems.add("Swamp: slimes, clay, blue orchids");
        overworldItems.add("Mountains: emerald ore, goats, snow");
        overworldItems.add("Ocean/Beach: shipwrecks, coral reefs");

        // Overworld Structures & Loot
        overworldItems.add("Village: emeralds, food, armor, books");
        overworldItems.add("Mineshaft: rails, enchanted books");
        overworldItems.add("Stronghold: ender pearls, books");
        overworldItems.add("Desert Temple: diamonds, TNT, books");
        overworldItems.add("Jungle Temple: diamonds, emeralds");
        overworldItems.add("Shipwreck: treasure maps, iron, gold");
        overworldItems.add("Buried Treasure: heart of the sea");
        overworldItems.add("Ruined Portal: gold, obsidian, gear");
        overworldItems.add("Pillager Outpost: crossbows, iron");
        overworldItems.add("Woodland Mansion: totem of undying");

        // Nether Biomes & Resources
        netherItems.add("Nether Wastes: quartz, gold ore");
        netherItems.add("Crimson Forest: crimson wood, hoglins");
        netherItems.add("Warped Forest: warped wood, endermen");
        netherItems.add("Soul Sand Valley: soul sand, fossils");
        netherItems.add("Basalt Deltas: basalt, blackstone");

        // Nether Structures & Loot
        netherItems.add("Nether Fortress: blaze rods, wart");
        netherItems.add("Bastion Remnant: gold, netherite");
        netherItems.add("Ruined Portal (Nether): gold, obsidian");
        netherItems.add("Ancient Debris: netherite crafting");
        netherItems.add("Glowstone: light source blocks");

        // End Biomes & Resources
        endItems.add("Main Island: ender dragon, endermen");
        endItems.add("End Midlands: chorus plants, end stone");
        endItems.add("End Highlands: chorus forests");
        endItems.add("End Barrens: outer edges, endermen");

        // End Structures & Loot
        endItems.add("End City: shulkers, loot");
        endItems.add("End Ship: elytra, dragon head");
        endItems.add("End Gateway: teleport to islands");
        endItems.add("Shulker Shells: from shulkers");
        endItems.add("Chorus Fruit: crafting materials");
    }

    @Override
    protected void init() {
        super.init();
        scrollOffset = 0;

        int centerX = this.width / 2;
        int y = 15;

        // Server/World field
        this.serverField = new TextFieldWidget(this.textRenderer, centerX - 120, y, 240, 20, Text.of("Server/World"));
        this.serverField.setText(SeedClient.config.serverOrWorld == null ? "" : SeedClient.config.serverOrWorld);
        this.addSelectableChild(this.serverField);
        this.setInitialFocus(this.serverField);

        y += 26;

        // Seed field
        this.seedField = new TextFieldWidget(this.textRenderer, centerX - 120, y, 150, 20, Text.of("Seed"));
        this.seedField.setText(SeedClient.config.savedSeed == null ? "" : SeedClient.config.savedSeed);
        this.addSelectableChild(this.seedField);

        // Save button
        this.saveButton = this.addDrawableChild(ButtonWidget.builder(Text.of("Save"), button -> {
            SeedClient.config.serverOrWorld = this.serverField.getText();
            SeedClient.config.savedSeed = this.seedField.getText();
            SeedClient.config.save();
        }).dimensions(centerX + 54, y, 60, 20).build());

        // ReSeed button
        this.reSeedButton = this.addDrawableChild(ButtonWidget.builder(Text.of("ReSeed"), b -> {
            this.seedField.setText("");
        }).dimensions(centerX + 118, y, 56, 20).build());

        y += 26;

        // Dimension buttons
        this.addDrawableChild(ButtonWidget.builder(Text.of("Overworld"), b -> {
            this.currentDimension = Dimension.OVERWORLD;
            this.scrollOffset = 0;
            this.init();
        }).dimensions(centerX - 120, y, 70, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.of("Nether"), b -> {
            this.currentDimension = Dimension.NETHER;
            this.scrollOffset = 0;
            this.init();
        }).dimensions(centerX - 45, y, 70, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.of("End"), b -> {
            this.currentDimension = Dimension.END;
            this.scrollOffset = 0;
            this.init();
        }).dimensions(centerX + 30, y, 70, 20).build());

        // Stop Marking button
        this.stopMarkingButton = this.addDrawableChild(ButtonWidget.builder(Text.of("Stop Marking"), b -> {
            markerActive = false;
            activeMarkerName = null;
        }).dimensions(centerX + 105, y, 70, 20).build());

        y += 26;

        // Add item buttons
        List<String> list = getCurrentItemList();
        int itemsToShow = Math.min(ITEMS_PER_PAGE, list.size());

        for (int i = 0; i < itemsToShow; i++) {
            int idx = this.scrollOffset + i;
            if (idx >= list.size()) break;
            
            String item = list.get(idx);
            int by = y + i * 22;
            final int itemIndex = idx;
            
            this.addDrawableChild(ButtonWidget.builder(Text.of(item), btn -> {
                onSelectItem(item);
            }).dimensions(centerX - 120, by, 190, 20).build());

            this.addDrawableChild(ButtonWidget.builder(Text.of("Mark"), btn -> {
                onSelectItem(item);
            }).dimensions(centerX + 74, by, 50, 20).build());
        }

        // Scroll buttons if needed
        if (list.size() > ITEMS_PER_PAGE) {
            int scrollY = y + ITEMS_PER_PAGE * 22 + 10;
            if (this.scrollOffset > 0) {
                this.addDrawableChild(ButtonWidget.builder(Text.of("^ Scroll Up ^"), b -> {
                    this.scrollOffset = Math.max(0, this.scrollOffset - 1);
                    this.init();
                }).dimensions(centerX - 120, scrollY, 190, 20).build());
            }
            if (this.scrollOffset < list.size() - ITEMS_PER_PAGE) {
                this.addDrawableChild(ButtonWidget.builder(Text.of("v Scroll Down v"), b -> {
                    this.scrollOffset = Math.min(list.size() - ITEMS_PER_PAGE, this.scrollOffset + 1);
                    this.init();
                }).dimensions(centerX - 120, scrollY, 190, 20).build());
            }
        }
    }

    private List<String> getCurrentItemList() {
        switch (this.currentDimension) {
            case NETHER: return this.netherItems;
            case END: return this.endItems;
            default: return this.overworldItems;
        }
    }

    private void onSelectItem(String item) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) {
            activeMarkerName = item;
            activeMarkerX = mc.player.getX();
            activeMarkerY = mc.player.getY();
            activeMarkerZ = mc.player.getZ();
            markerActive = true;

            // Try to run /locate command for structures
            try {
                String[] parts = item.toLowerCase().split(":");
                if (parts.length > 0) {
                    String structName = parts[0].trim().split(" ")[0];
                    if (mc.getNetworkHandler() != null) {
                        mc.getNetworkHandler().sendChatCommand("locate " + structName);
                    }
                }
            } catch (Throwable t) {
                // best effort
            }
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);

        int centerX = this.width / 2;
        context.drawCenteredTextWithShadow(this.textRenderer, 
            Text.of("Dimension: " + this.currentDimension.name()), 
            centerX, 5, 0xFFDD00);
    }

    @Override
    public boolean shouldPause() { 
        return false; 
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    public static void renderHud(DrawContext context) {
        if (!markerActive || activeMarkerName == null) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        String text = String.format("%s | x:%.0f y:%.0f z:%.0f", 
            activeMarkerName, activeMarkerX, activeMarkerY, activeMarkerZ);
        context.drawTextWithShadow(mc.textRenderer, Text.of(text), 10, 10, 0xFFDD55);
    }
}
