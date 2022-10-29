package me.lucasgithuber.kingdoms.listeners;

import me.lucasgithuber.kingdoms.items.Crown;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.UUID;

public class CrownTrailTask extends BukkitRunnable {

    private final UUID playerID;
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
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            makeWave(2, 8, 2);
        }
    }

    @Override
    public void makeWave(double radius, int waves, double height){
        degree %= 360;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.isValid() || player.isDead()) {
                continue;
            }
            double radians = Math.toRadians(degree);
            double x = Math.cos(radians) * radius;
            double y = (Math.cos(1.7*radians)-Math.cos((1.7/2)*radians))*height+3;
            double z = Math.sin(radians) * radius;
            Location particleLoc = player.getLocation().add(x, y+2, z);
            player.getWorld().spawnParticle(Particle.END_ROD, particleLoc, 0);
            degree += 5;
            }
    }
}