package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import me.lucasgithuber.kingdoms.listeners.TrailsTask;
import me.lucasgithuber.kingdoms.items.Crown;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TrailsManager implements Runnable {

    private final Map<Player, TrailsTask> runningTasks = new HashMap<>();

    public void startTask(Player player) {
    }

    public void stopTask(Player player) {
        Optional.ofNullable(runningTasks.get(player)).ifPresent(BukkitRunnable::cancel);
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){
            runningTasks.put(player, new TrailsTask(12, 0.3, 1));
            runningTasks.values().forEach(TrailsTask::run);
        }
    }
}