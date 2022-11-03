package me.lucasgithuber.kingdoms.gui;

import org.bukkit.inventory.ItemStack;
import me.lucasgithuber.kingdoms.gui.*;

public class GuiButton {

    private ItemStack stack;
    private Runnable action;

    public GuiButton(ItemStack stack){
        this.stack = stack;
    }

    public void setAction(Runnable runnable){
        this.action=runnable;
    }

    public Runnable getAction(){
        return action;
    }

    public ItemStack getStack(){
        return this.stack;
    }
}