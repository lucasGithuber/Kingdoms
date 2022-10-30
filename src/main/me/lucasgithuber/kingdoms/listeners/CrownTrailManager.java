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
    }

    public void stopTask(Player player) {
        Optional.ofNullable(runningTasks.get(player)).ifPresent(BukkitRunnable::cancel);
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getServer().getOnlinePlayers()){
        runningTasks.put(player, new CrownTrailTask(4, 0.1, 2));
        runningTasks.values().forEach(CrownTrailTask::run);
        }
    }
}