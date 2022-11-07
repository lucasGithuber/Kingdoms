package me.lucasgithuber.kingdoms.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import me.lucasgithuber.kingdoms.listeners.*;

public class ParticlesGuiListener implements Listener {
    public static final SpiralTrailsManager SPIRAL_TRAIL_MANAGER = new SpiralTrailsManager();
    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Particles")){
            e.setCancelled(true);
            switch(e.getCurrentItem()){
                case null:
                break;
                case Material.BARRIER:
                player.closeInventory();
                break;
                case Material.RED_STAINED_GLASS_PANE:
                SPIRAL_TRAIL_MANAGER.stopTask(player);
                player.closeInventory();
                break;
                case Material.STRING:
                SPIRAL_TRAIL_MANAGER.startTask(player);
                player.closeInventory();
                break;
            }
        }
    }
}