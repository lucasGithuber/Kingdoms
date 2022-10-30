package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CrownTrailManager implements Runnable {

    private final Map<Player, CrownTrailTask> runningTasks = new HashMap<>();

    public void startTask(Player player) {
        Bukkit.getLogger().info("started task");
    }

    public void stopTask(Player player) {
        Optional.ofNullable(runningTasks.get(player)).ifPresent(BukkitRunnable::cancel);
        Bukkit.getLogger().info("stopped task");
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getServer().getOnlinePlayers()){
        runningTasks.put(player, new CrownTrailTask(4, 0.1, 2));
        runningTasks.values().forEach(CrownTrailTask::run);
        Bukkit.getLogger().info("running manager");
        }
    }
}