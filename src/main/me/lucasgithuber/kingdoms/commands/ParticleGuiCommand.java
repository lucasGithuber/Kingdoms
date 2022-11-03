package me.lucasgithuber.kingdoms.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.Color;

import me.lucasgithuber.kingdoms.gui.*;

public class ParticleGuiCommand implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings){
        if(sender instanceof Player){
            Player player = (Player) sender;

            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = close.getItemMeta();
            closeMeta.setDisplayName(Color.RED, "Close");
            close.setItemMeta(closeMeta);

            ParticleGui testGui = new ParticleGui("Particle effects", 1);
            GuiButton closeButton = new GuiButton(close);
            closeButton.setAction(() -> {
                player.closeInventory();
            });

            testGui.setItem(closeButton, 4);

            testGui.show(player);
        }
    }
}