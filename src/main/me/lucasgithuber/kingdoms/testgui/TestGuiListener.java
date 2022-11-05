package me.lucasgithuber.kingdoms.testgui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TestGuiListener implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        //check if its the GUI menu
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Custom GUI")){
            Player player = (Player) e.getWhoClicked();
            //check what they click
            switch(e.getCurrentItem().getType()){
                case BARRIER:
                    player.closeInventory();
                    break;
                case DIAMOND_SWORD:
                    player.closeInventory();
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    break;
            }
            e.setCancelled(true); //dont take item
        }

    }

}