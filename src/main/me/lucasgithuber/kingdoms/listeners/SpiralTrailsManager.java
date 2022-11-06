package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import me.lucasgithuber.kingdoms.listeners.SpiralTrailsTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SpiralTrailsManager implements Runnable {

    private final Map<Player, SpiralTrailsTask> runningTasks = new HashMap<>();

    public void startTask(Player player) {
    }

    public void stopTask(Player player) {
        Optional.ofNullable(runningTasks.get(player)).ifPresent(BukkitRunnable::cancel);
    }

    @Override
    public void run() {
            runningTasks.values().forEach(SpiralTrailsTask::run);
    }
}