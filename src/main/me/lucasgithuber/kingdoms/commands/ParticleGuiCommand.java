package me.lucasgithuber.kingdoms.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.Color;

import me.lucasgithuber.kingdoms.gui.*;
import me.lucasgithuber.kingdoms.utils.GuiElements;

public class ParticleGuiCommand implements CommandExecutor{
    public static final int[] BACKGROUND ={
        0,1,2,3,4,5,6,7,8,
        
        18,19,20,21,22,23,24,25,26};
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings){
        if(sender instanceof Player){
            Player player = (Player) sender;

            ParticleGui testGui = new ParticleGui("Particle effects", 3);
            GuiButton closeButton = new GuiButton(GuiElements.CLOSE_BUTTON);
            GuiButton borderButton = new GuiButton(GuiElements.GUI_BACKGROUND);
            closeButton.setAction(() -> {
                player.closeInventory();
            });

            testGui.setItem(closeButton, 4);

            for(int i = 0; i <= BACKGROUND.length; i++){
                testGui.setItem(borderButton, BACKGROUND[i]);
            }
            testGui.show(player);
        }else{
            sender.sendMessage("Only players can use that command!");
        }
        return true;
    }
}