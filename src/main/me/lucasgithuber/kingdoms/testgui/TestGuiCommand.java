package me.lucasgithuber.kingdoms.testgui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TestGuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.BLUE + "Particles");

            //Menu Options(Items)
            ItemStack close = new ItemStack(Material.BARRIER); //Closes gui
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD); //Gives the player a weapon

            //Edit the items
            ItemMeta close_meta = close.getItemMeta();
            close_meta.setDisplayName(ChatColor.RED + "Close");
            ArrayList<String> close_lore = new ArrayList<>();
            close_lore.add(ChatColor.RED + "Closes the gui");
            close_meta.setLore(close_lore);
            close.setItemMeta(close_meta);

            ItemMeta sword_meta = sword.getItemMeta();
            sword_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Sword");
            ArrayList<String> sword_lore = new ArrayList<>();
            sword_lore.add(ChatColor.GOLD + "Get a sword.");
            sword_meta.setLore(sword_lore);
            sword.setItemMeta(sword_meta);

            //Put the items in the inventory
            ItemStack[] menu_items = {close, sword};
            gui.setContents(menu_items);
            player.openInventory(gui);


        }

        return true;
    }
}