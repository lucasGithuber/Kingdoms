package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import me.lucasgithuber.kingdoms.listeners.SpiralTrailsTask;

import java.io.*;
import java.util.*;

public class SpiralTrailsManager implements Runnable {
    private int id =-1;

    public static final Map<Player, SpiralTrailsTask> SPIRAL_RUNNING_TASKS = new HashMap<>();

    public void startTask(Player player) {
        SPIRAL_RUNNING_TASKS.put(player, new SpiralTrailsTask(2, 2));
    }

    public void stopTask(Player player) {
        Optional.ofNullable(SPIRAL_RUNNING_TASKS.get(player)).ifPresent(BukkitRunnable::cancel);
    }

    @Override
    public void run() { 
        SPIRAL_RUNNING_TASKS.values().forEach(SpiralTrailsTask::run);
        if(Bukkit.getServer().getScheduler().isCurrentlyRunning(this.id);){
            Bukkit.getLogger().info("spiral is running");
        }
    }
}