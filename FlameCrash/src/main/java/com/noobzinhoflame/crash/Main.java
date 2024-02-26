package com.noobzinhoflame.crash;

import com.noobzinhoflame.crash.Commands.CrashCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[FLAME-CRASH]: Plugin ligado com sucesso!");

        getCommand("crash").setExecutor(new CrashCommand());
    }

    @Override
    public void onDisable() {
    }
}
