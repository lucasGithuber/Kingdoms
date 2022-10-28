package me.lucasgithuber.kingdoms;

import org.bukkit.plugin.java.JavaPlugin;
import me.lucasgithuber.kingdoms.listeners.*;
import java.io.*;

public class Kingdoms extends JavaPlugin {

    private final CrownTrailManager crownTrailManager = new CrownTrailManager();

    @Override
    public void onEnable(){
        JavaPlugin.getLogger("Enabling...");
        Bukkit.getScheduler().runTaskTimer(this, crownTrailManager, 1, 1);
    }

    public void onDisable(){
        JavaPlugin.getLogger("Disabling...");
    }
}