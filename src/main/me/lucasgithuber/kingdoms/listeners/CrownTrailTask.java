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

public class CrownTrailTask extends BukkitRunnable {

    private final int waves;
    private final double height;
    private final double radius;
    private int degree = 0;
    public CrownTrailTask(int waves, double height, double radius) {
        this.waves = waves;
        this.height = height;
        this.radius = radius;
    }
    @Override
    public void run() {
        makeWave(radius, waves, height);
    }

    public void makeWave(double radius, int waves, double height){
        Particle.DustOptions crownColors = new Particle.DustTransition(Color.YELLOW, Color.fromRGB(255, 208, 0), 1.0F);
        if(degree<360){
        for (Player player : Bukkit.getOnlinePlayers()) {
            double radians = Math.toRadians(degree);
            double x = Math.cos(radians) * radius;
            double y = (Math.cos(1.7*radians)-Math.cos((1.7/2)*radians))*height+3;
            double z = Math.sin(radians) * radius;
            Location particleLoc = player.getLocation().add(x, y, z);
            player.getWorld().spawnParticle(Particle.DUST_COLOR_TRANSITION, particleLoc, 1, crownColors);
            }
            degree+=5;
        }else{
            degree=0;
        }
    }
}