package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import me.lucasgithuber.kingdoms.listeners.CrownTrailsTask;
import me.lucasgithuber.kingdoms.items.Crown;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CrownTrailsManager implements Runnable {

    private final Map<Player, CrownTrailsTask> runningTasks = new HashMap<>();

    public void startTask(Player player) {
    }

    public void stopTask(Player player) {
        Optional.ofNullable(runningTasks.get(player)).ifPresent(BukkitRunnable::cancel);
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){
            runningTasks.put(player, new CrownTrailsTask(12, 0.3, 0.6));
            runningTasks.values().forEach(CrownTrailsTask::run);
        }
    }
}