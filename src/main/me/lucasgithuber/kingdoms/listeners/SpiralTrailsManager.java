package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import me.lucasgithuber.kingdoms.listeners.SpiralTrailsTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SpiralTrailsManager implements Runnable {

    public static final Map<Player, SpiralTrailsTask> RUNNING_TASKS = new HashMap<>();

    public void startTask(Player player) {
    }

    public void stopTask(Player player) {
        Optional.ofNullable(RUNNING_TASKS.get(player)).ifPresent(SpiralTrailsTask::cancel);
    }

    @Override
    public void run() {
            RUNNING_TASKS.values().forEach(SpiralTrailsTask::run);
    }
}