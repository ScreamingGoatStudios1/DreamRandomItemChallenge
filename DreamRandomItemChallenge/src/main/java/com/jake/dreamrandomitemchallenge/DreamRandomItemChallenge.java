package com.jake.dreamrandomitemchallenge;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class DreamRandomItemChallenge extends JavaPlugin {
    public DreamRandomItemChallenge plugin;

    public static boolean isStarted = false;
    @Override
    public void onEnable() {
        getCommand("randomitem").setExecutor(new StartCommand());
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new PickupListener(), this);
        BukkitTask GiveItems = (new GiveItems()).runTaskTimer((Plugin) this, 0, 2400);
    }
}
