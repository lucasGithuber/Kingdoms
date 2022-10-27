package me.lucasgithuber.kingdoms;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.*;

public class Kingdoms extends JavaPlugin {
    @Override
    public void onEnable(){
        System.out.printLn("Enabling plugin...");
    }

    public void onDisable(){
        System.out.printLn("Disabling plugin...");
    }
}