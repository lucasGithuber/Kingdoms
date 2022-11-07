package me.lucasgithuber.kingdoms.gui;

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
import me.lucasgithuber.kingdoms.utils.GuiElements;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class ParticlesGuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 27, ChatColor.BLUE + "Particles");

            //options
            ItemStack close = GuiElements.CLOSE_BUTTON; //Closes gui
            ItemStack spiral = GuiElements.STRING_OPTION; //Spiral

            //Put the items in the inventory
            ItemStack[] menu_items = {close, strin};
            gui.setContents(menu_items);
            player.openInventory(gui);


        }else{
            Bukkit.getLogger().info("Command can only be ran by player");
        }

        return true;
    }
}