package me.lucasgithuber.kingdoms;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import me.lucasgithuber.kingdoms.listeners.CrownTrailTask;
import me.lucasgithuber.kingdoms.listeners.CrownTrailManager;
import me.lucasgithuber.kingdoms.commands.GiveCrown;
import me.lucasgithuber.kingdoms.items.Crown;
import java.io.*;
import java.util.*;

public class Kingdoms extends JavaPlugin {

    private final CrownTrailManager crownTrailManager = new CrownTrailManager();

    @Override
    public void onEnable(){
        Crown.init();
        Bukkit.getLogger().info("Enabling...");
        Bukkit.getScheduler().runTaskTimer(this, crownTrailManager, 1, 1);
        getCommand("givecrown").setExecutor(new GiveCrown());
    }
    
    @Override
    public void onDisable(){
        Bukkit.getLogger().info("Disabling...");
    }
}