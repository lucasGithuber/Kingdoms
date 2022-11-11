package me.lucasgithuber.kingdoms.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import me.lucasgithuber.kingdoms.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;

import java.io.*;
import java.util.*;

public class ParticlesGuiListener implements Listener {
    private int degree = 0;
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

                player.closeInventory();

            }else if (e.getCurrentItem().getType()==Material.STRING){

                BukkitRunnable spiralRunnable = new BukkitRunnable(){
                    @Override
                    public void run() {
                        makeSpiralTrail(2, 2);
                        Bukkit.getLogger().info("spiral task is running");
                    }

                    public void makeSpiralTrail(double radius,double height){
                        degree%=360;
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            double radians = Math.toRadians(degree);
                            double x = Math.cos(radians) * radius;
                            double y = height;
                            double z = Math.sin(radians) * radius;
                            Location particleLoc = player.getEyeLocation().add(x, y, z);
                            player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, particleLoc, 0, 0, 0, 0, 0.1);
                        }
                    degree+=5;
                }
                }.runTaskTimer(Kingdoms.getInstance(), 0, 5);
                player.closeInventory();
            
            }
        }
    }
}