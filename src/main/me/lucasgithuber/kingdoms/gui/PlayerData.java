package me.lucasgithuber.kingdoms.gui;

import org.bukkit.entity.Player;

import me.lucasgithuber.kingdoms.gui.*;

public class PlayerData{

    private Player player;
    private ParticleGui openGui;

    public PlayerData(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public ParticleGui getOpenGui(){
        return openGui;
    }

    public void setOpenGui(ParticleGui openGui){
        this.openGui = openGui;
    }
}