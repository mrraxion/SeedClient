package com.seedclient;

import com.seedclient.config.SeedConfig;
import com.seedclient.gui.SeedScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class SeedClient implements ClientModInitializer {

    public static KeyBinding openMenuKey;
    public static SeedConfig config;

    @Override
    public void onInitializeClient() {
        // load config
        config = SeedConfig.load();

        // register key binding (Insert)
        openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.seedclient.open_menu", GLFW.GLFW_KEY_INSERT, "category.seedclient.controls"));

        // tick event to open menu when pressed
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenuKey.wasPressed()) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.player != null) {
                    mc.setScreen(new SeedScreen(Text.of("Seed Client")));
                }
            }
        });

        // HUD renderer using 1.21.1 API
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            // render marker display when screen is closed
            if (MinecraftClient.getInstance().currentScreen == null) {
                SeedScreen.renderHud(context);
            }
        });
    }
}
