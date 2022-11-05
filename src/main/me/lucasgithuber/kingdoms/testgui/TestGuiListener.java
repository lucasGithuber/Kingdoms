package me.lucasgithuber.kingdoms.testgui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class TestGuiListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Particles")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.CHIPPED_ANVIL)){
                player.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.CYAN_CARPET)){
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                player.closeInventory();
            }
        }
    }
}