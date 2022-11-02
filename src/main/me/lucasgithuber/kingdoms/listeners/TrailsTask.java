package me.lucasgithuber.kingdoms.listeners;

import me.lucasgithuber.kingdoms.items.Crown;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.UUID;

public class TrailsTask extends BukkitRunnable {

    private final int waves;
    private final double height;
    private final double radius;
    public TrailsTask(int waves, double height, double radius) {
        this.waves = waves;
        this.height = height;
        this.radius = radius;
    }
    @Override
    public void run() {
        makeCrownWave(radius, waves, height);
    }

    public void makeCrownWave(double radius, int waves, double height){
        Particle.DustTransition crownColors = new Particle.DustTransition(Color.YELLOW, Color.fromRGB(255, 208, 0), 0.3F);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if(player.getInventory().getHelmet().getItemMeta()==Crown.crown.getItemMeta()){
                for(int degree=0; degree<=360; degree+=2){
                    double radians = Math.toRadians(degree);
                    double x = Math.cos(radians) * radius;
                    double y = (Math.cos(waves*radians)-Math.cos((waves/2)*radians))*height;
                    double z = Math.sin(radians) * radius;
                    Location particleLoc = player.getEyeLocation().add(x, y, z);
                    player.getWorld().spawnParticle(Particle.DUST_COLOR_TRANSITION, particleLoc, 1, crownColors);
                }
            }
        }
    }
}