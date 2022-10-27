package me.lucasgithuber;

import org.bukkit.plugin.java.JavaPlugin;

public class Kingdoms extends JavaPlugin {
    @Override
    public void onEnable(){
        System.out.printLn("Enabling plugin...");
    }

    public void onDisable(){
        System.out.printLn("Disabling plugin...");
    }
}