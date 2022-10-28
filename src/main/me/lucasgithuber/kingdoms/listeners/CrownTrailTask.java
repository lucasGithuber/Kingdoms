package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class CrownTrailTask extends BukkitRunnable {

    private final UUID playerID;
    private final int waves;
    private final double height;
    private final double radius;
    private int degree = 0;

    public CrownTrailTask(UUID playerID, int waves, double height, double radius) {
        this.playerID = playerID;
        this.waves = waves;
        this.height = height;
        this.radius = radius;
    }

    @Override
    public void run() {
        degree %= 360;
        Player player = Bukkit.getPlayer(playerID);
        if (player == null) {
            this.cancel();
            return;
        }
        double radians = Math.toRadians(degree);
        double x = Math.cos(radians) * radius;
        double y = Math.sin(radians * waves) * height;
        double z = Math.sin(radians) * radius;
        Location particleLoc = player.getLocation().add(x, y, z);
        player.getWorld().spawnParticle(Particle.END_ROD, particleLoc, 0);
        degree += 5;
    }

}