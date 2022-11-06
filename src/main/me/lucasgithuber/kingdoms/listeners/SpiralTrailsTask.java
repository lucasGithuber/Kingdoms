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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpiralTrailsTask extends BukkitRunnable {

    private final double height;
    private final double radius;
    public SpiralTrailsTask(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }
    @Override
    public void run() {
        makeSpiralTrail(radius, height);
    }

    public void makeSpiralTrail(double radius,double height){
        Particle.DustTransition crownColors = new Particle.DustTransition(Color.YELLOW, Color.fromRGB(255, 208, 0), 0.3F);
        Particle.DustTransition gemColors = new Particle.DustTransition(Color.RED, Color.fromRGB(89, 0, 255), 0.6F);
        for (Player player : Bukkit.getOnlinePlayers()) {
            for(int degree=0; degree<=360; degree+=2){
                double radians = Math.toRadians(degree);
                double x = Math.cos(radians) * radius;
                double y = height;
                double z = Math.sin(radians) * radius;
                Location particleLoc = player.getEyeLocation().add(x, y, z);
                player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, particleLoc, 0, 0 ,-2 ,0);
            }
        }
    }
}