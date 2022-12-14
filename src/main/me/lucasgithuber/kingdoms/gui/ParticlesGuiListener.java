package me.lucasgithuber.kingdoms.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import me.lucasgithuber.kingdoms.Kingdoms;
import me.lucasgithuber.kingdoms.listeners.*;

import java.io.*;
import java.util.*;

public class ParticlesGuiListener implements Listener {
    BukkitScheduler scheduler = Bukkit.getScheduler();
    private int degree = 0;
    private final Kingdoms kings;
    private int id = -1;

    public ParticlesGuiListener(Kingdoms kings){
        this.kings = kings;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Particles")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;

            }else if (e.getCurrentItem().getType()==Material.BARRIER){

                player.closeInventory();

            }else if (e.getCurrentItem().getType()==Material.RED_STAINED_GLASS_PANE){
                if(id!=-1){
                    scheduler.cancelTask(id);
                    id=-1;
                    player.closeInventory();
                    Bukkit.getLogger().info("id now is -1");
                }
            }else if (e.getCurrentItem().getType()==Material.STRING){
                if(id!=0){
                    id = 0;
                    scheduler.runTaskTimer(kings, () -> {
                        Bukkit.getLogger().info("id now is 0");
                        makeSpiralTrail(2, 2, player);
                        Bukkit.getLogger().info("spiral task running");
                    }, 0L, 5L);
                player.closeInventory();
                }else{
                    player.sendMessage("Already Running!");
                }
            }
        }
    }

    public void makeSpiralTrail(double radius,double height, Player player){
    degree%=360;
    double radians = Math.toRadians(degree);
    double x = Math.cos(radians) * radius;
    double y = height;
    double z = Math.sin(radians) * radius;
    Location particleLoc = player.getEyeLocation().add(x, y, z);
    player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, particleLoc, 0, 0, 0, 0, 0.1);

    degree+=5;
    }
}