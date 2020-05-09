package net.swampmc.practice;

import lombok.Getter;
import net.swampmc.practice.arena.ArenaManager;
import net.swampmc.practice.arena.queue.QueueManager;
import net.swampmc.practice.inventory.InventoryManager;
import net.swampmc.practice.ladder.LadderManager;
import net.swampmc.practice.listener.manager.ListenerManager;
import net.swampmc.practice.scorebord.ScoreboardManager;
import net.swampmc.practice.world.WorldManager;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Practice extends JavaPlugin
{

    @Getter
    private static Practice plugin;

    @Getter
    private LadderManager ladderManager;

    @Getter
    private QueueManager queueManager;

    @Getter
    private ArenaManager arenaManager;

    private ListenerManager listenerManager;

    @Getter
    private InventoryManager inventoryManager;

    @Getter
    private WorldManager worldManager;

    @Getter
    private ScheduledExecutorService executorMonoThread;

    @Getter
    private ScheduledExecutorService scheduledExecutorService;

    @Getter
    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable()
    {
        plugin = this;

        worldManager = new WorldManager();
        ladderManager = new LadderManager();
        queueManager = new QueueManager();
        arenaManager = new ArenaManager();
        listenerManager = new ListenerManager(this);
        inventoryManager = new InventoryManager(this);

        executorMonoThread = Executors.newScheduledThreadPool(16);
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();
    }

    @Override
    public void onDisable()
    {
        plugin = null;

        scoreboardManager.onDisable();
    }
}
