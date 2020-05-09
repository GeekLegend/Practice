package net.swampmc.practice.arena.queue;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueueManager
{

    @Getter
    private List<Queue> queues;

    private Map<Player, Queue> queue;

    public QueueManager()
    {
        this.queues = new ArrayList<>();
        this.queue = new HashMap<>();
    }

    public void add(Player player, Queue q)
    {
        if (!isContains(player))
        {
            queues.add(q);
            queue.put(player, q);
        }
    }

    public void remove(Player player)
    {
        Queue q = getQueue(player);

        queues.remove(q);
        queue.remove(player);
    }

    public boolean isContains(Player player)
    {
        return queue.containsKey(player);
    }

    public Queue getQueue(Player player)
    {
        Queue q = queue.get(player);

        if (q != null)
        {
            return q;
        }
        return null;
    }
}
