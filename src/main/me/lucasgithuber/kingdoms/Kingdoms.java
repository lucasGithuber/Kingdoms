package me.lucasgithuber.kingdoms;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.*;

public class Kingdoms extends JavaPlugin {
    @Override
    public void onEnable(){
        System.out.println("Enabling plugin...");
    }

    public void onDisable(){
        System.out.println("Disabling plugin...");
    }
}