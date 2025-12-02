package com.seedclient.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.seedclient.SeedClient;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SeedConfig {
    public String savedSeed = "";
    public String serverOrWorld = "";

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static SeedConfig load() {
        try {
            File cfg = getConfigFile();
            if (cfg.exists()) {
                try (FileReader r = new FileReader(cfg)) {
                    return GSON.fromJson(r, SeedConfig.class);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SeedConfig();
    }

    public void save() {
        try {
            File cfg = getConfigFile();
            cfg.getParentFile().mkdirs();
            try (FileWriter w = new FileWriter(cfg)) {
                GSON.toJson(this, w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getConfigFile() {
        return FabricLoader.getInstance().getConfigDir().resolve("seedclient.json").toFile();
    }
}
