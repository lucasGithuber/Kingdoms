package me.lucasgithuber.kingdoms;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import me.lucasgithuber.kingdoms.listeners.TrailsTask;
import me.lucasgithuber.kingdoms.listeners.TrailsManager;
import me.lucasgithuber.kingdoms.commands.GiveCrown;
import me.lucasgithuber.kingdoms.items.Crown;
import me.lucasgithuber.kingdoms.gui.*;
import java.io.*;
import java.util.*;

public class Kingdoms extends JavaPlugin {

    FileConfiguration config = getConfig();
    private final TrailsManager crownTrailManager = new TrailsManager();
    private static Kingdoms i;

    @Override
    public void onEnable(){
        //init
        i=this;
        Crown.init();
        Bukkit.getLogger().info("Enabling...");

        //crown things
        Bukkit.getScheduler().runTaskTimer(this, crownTrailManager, 3, 1);
        for(Player player : Bukkit.getOnlinePlayers()){
        crownTrailManager.startTask(player);
        }
        getCommand("givecrown").setExecutor(new GiveCrown());

        //config
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getLogger().info(config.getString("test")+"is enabling");

        //gui
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getCommand("particles").setExecutor(new ParticleGuiCommand());
    }
    
    @Override
    public void onDisable(){
        Bukkit.getLogger().info("Disabling...");
    }

    public FileConfiguration getConfigFile(){
        return config;
    }

    public static Kingdoms getInstance(){
        return i;
    }
}