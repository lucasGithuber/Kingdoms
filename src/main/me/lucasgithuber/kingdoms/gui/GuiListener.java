package me.lucasgithuber.kingdoms.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import java.io.*;
import java.util.*;

import me.lucasgithuber.kingdoms.gui.*;

public class GuiListener implements Listener{

    @EventHandler
    public void onClick(InventoryClickEvent e){

        PlayerData data = PlayerDataManager.getData((Player)e.getWhoClicked());
        if(data != null){
            if(data.getOpenGui() != null){
                if(e.getCurrentItem()!=null){
                    data.getOpenGui().handleButton(e.getCurrentItem());
                    e.setCancelled(true);
                }else{
                    Bukkit.getLogger().info("current item is null");
                }
            }else{
                Bukkit.getLogger().info("openGui is null");
            }
        }else{
            Bukkit.getLogger().info("data is null");
        }
    }
}