package net.swampmc.practice.scorebord;

import net.swampmc.practice.Practice;
import net.swampmc.practice.arena.Arena;
import net.swampmc.practice.arena.ArenaManager;
import net.swampmc.practice.arena.queue.QueueManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PersonalScoreboard
{
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;
    private Player player;

    public PersonalScoreboard(Player player)
    {
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "DevPlugin");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData()
    {
    }

    public void setLines(String ip)
    {
        QueueManager queueManager = Practice.getPlugin().getQueueManager();
        ArenaManager arenaManager = Practice.getPlugin().getArenaManager();

        objectiveSign.setDisplayName("§6§lPRACTICE");
        objectiveSign.setLine(0, "§1§7§m---------------");
        objectiveSign.setLine(1, "§fOnline: §e" + Bukkit.getServer().getOnlinePlayers().size());
        objectiveSign.setLine(2, "§6 ");
        objectiveSign.setLine(3, "§fIn Queue: §e" + queueManager.getQueues().size());

        for (Arena arenas : arenaManager.getArenas())
        {
            objectiveSign.setLine(4, "§fIn Fight: §e" + arenas.getPlayers().size());
        }

        objectiveSign.setLine(5, "§2 ");
        objectiveSign.setLine(6, ip);
        objectiveSign.setLine(7, "§2§7§m---------------");
        objectiveSign.updateLines();
    }

    public void onLogout()
    {
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}