package me.lucasgithuber.kingdoms.listeners;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CrownTrailManager implements Runnable {

    private final Map<Player, CrownTrailTask> runningTasks = new HashMap<>();

    public void startTask(Player player) {
        runningTasks.put(player, new CrownTrailTask(player.getUniqueId(), 5, 0.66, 2.5));
    }

    public void stopTask(Player player) {
        Optional.ofNullable(runningTasks.get(player)).ifPresent(BukkitRunnable::cancel);
    }

    @Override
    public void run() {
        runningTasks.values().forEach(CrownTrailTask::run);
    }

}