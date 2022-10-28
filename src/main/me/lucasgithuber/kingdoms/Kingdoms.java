package me.lucasgithuber.kingdoms;

import org.bukkit.plugin.java.JavaPlugin;
import me.lucasgithuber.kingdoms.listeners.CrownTrailTask;
import me.lucasgithuber.kingdoms.listeners.CrownTrailManager;
import java.io.*;

public class Kingdoms extends JavaPlugin {

    private final CrownTrailManager crownTrailManager = new CrownTrailManager();

    @Override
    public void onEnable(){
        JavaPlugin.getLogger().log(Level.INFO, "Enabling...");
        Bukkit.getScheduler().runTaskTimer(this, crownTrailManager, 1, 1);
    }

    public void onDisable(){
        JavaPlugin.getLogger().log(Level.INFO, "Disabling...");
    }
}