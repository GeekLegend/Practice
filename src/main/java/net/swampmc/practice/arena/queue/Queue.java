package net.swampmc.practice.arena.queue;

import lombok.Getter;
import net.swampmc.practice.ladder.Ladder;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class Queue
{

    @Getter
    private QueueType queueType;

    @Getter
    private Ladder ladder;

    @Getter
    private LinkedList<Player> players;

    public Queue(QueueType queueType, Ladder ladder)
    {
        this.queueType = queueType;
        this.ladder = ladder;
        this.players = new LinkedList<>();
    }

    public void add(Player player)
    {
        if (!isContains(player))
        {
            players.add(player);
        }
    }

    public void remove(Player player)
    {
        if (isContains(player))
        {
            players.remove(player);
        }
    }

    public boolean isContains(Player player)
    {
        return players.contains(player);
    }
}
