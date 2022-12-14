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

    private final Map<Player, CrownTrailsTask> crownRunningTasks = new HashMap<>();

    public void startTask(Player player) {
    }

    public void stopTask(Player player) {
        Optional.ofNullable(crownRunningTasks.get(player)).ifPresent(CrownTrailsTask::cancel);
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){
            crownRunningTasks.put(player, new CrownTrailsTask(12, 0.3, 0.6));
            crownRunningTasks.values().forEach(CrownTrailsTask::run);
        }
    }
}