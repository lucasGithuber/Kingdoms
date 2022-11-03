package me.lucasgithuber.kingdoms.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.PlayerJoinEvent;

import me.lucasgithuber.kingdoms.gui.*;

public class JoinListener implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerDataManager.setData(e.getPlayer());
    }

}