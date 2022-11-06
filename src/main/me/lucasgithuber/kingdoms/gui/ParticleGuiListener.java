package me.lucasgithuber.kingdoms.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
package me.lucasgithuber.kingdoms.listeners.*;

public class ParticlesGuiListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Particles")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType()==Material.BARRIER){
                player.closeInventory();
            }else if (e.getCurrentItem().getType()==Material.STRING){
                SpiralTrailsManager.runningTasks.put(player, new SpiralTrailsTask(2, 2));
                player.closeInventory();
            }
        }
    }
}