package me.lucasgithuber.kingdoms.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import java.util.*;

import me.lucasgithuber.kingdoms.gui.*;

public class ParticleGui {

    private int rows;
    private Inventory inventory;
    private List<GuiButton> buttons = new ArrayList<>();

    public ParticleGui(String title, int rows){
        this.rows=rows;

        this.inventory = Bukkit.createInventory(null, rows*9);
    }

    public void setItem(GuiButton button, int slot){
        buttons.add(button);
        inventory.setItem(slot, button.getStack());
    }
    public void setItemBulk(GuiButton button, int[] slots){
        buttons.add(button);
        inventory.setItem(slots, button.getStack());
    }

    public void handleButton(ItemStack stack){
        GuiButton button = buttons.stream().filter(p -> p.getStack().isSimilar(stack)).findAny().orElse(null);

        if(button != null){
            button.getAction().run();
        }
    }

    public void show(Player player){
        PlayerDataManager.getData(player).setOpenGui(this);
        player.openInventory(inventory);
    }
}