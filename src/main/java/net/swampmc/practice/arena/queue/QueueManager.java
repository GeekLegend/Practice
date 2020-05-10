package net.swampmc.practice.arena.queue;

import lombok.Getter;
import net.swampmc.practice.Practice;
import net.swampmc.practice.inventory.InventoryManager;
import net.swampmc.practice.ladder.Ladder;
import net.swampmc.practice.util.Constant;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueueManager
{

    private InventoryManager inventoryManager;

    @Getter
    private List<Queue> queues;

    private Map<Player, Queue> queue;

    public QueueManager()
    {
        this.inventoryManager = Practice.getPlugin().getInventoryManager();
        this.queues = new ArrayList<>();
        this.queue = new HashMap<>();
    }

    public void add(Player player, Queue q)
    {
        if (!isContains(player))
        {
            queues.add(q);
            queue.put(player, q);
            q.add(player);

            player.sendMessage(Constant.QUEUE_JOIN_MESSAGE.replace("%queuetype%", q.getQueueType().getName()).replace("%ladder%", q.getLadder().getName()));

            setup(player, true);
        }
    }

    public void remove(Player player)
    {
        Queue q = getQueue(player);

        queues.remove(q);
        queue.remove(player);
        q.remove(player);

        player.sendMessage(Constant.QUEUE_LEAVE_MESSAGE.replace("%queuetype%", q.getQueueType().getName()).replace("%ladder%", q.getLadder().getName()));

        setup(player, false);
    }

    public void check(Queue q)
    {
        if (q.getPlayers().size() >= 2)
        {
            Player firstPlayer = q.getPlayers().getFirst();
            Player secondPlayer = q.getPlayers().getLast();
        }
    }

    public void setup(Player player, boolean isInQueue)
    {
        InventoryManager inventoryManager = Practice.getPlugin().getInventoryManager();

        if (isInQueue)
        {
            inventoryManager.save(player);

            player.getInventory().clear();
            player.getInventory().setItem(Constant.ITEM_QUEUE_VIEW_SLOT, Constant.ITEM_QUEUE_VIEW);
            player.getInventory().setItem(Constant.ITEM_QUEUE_LEAVE_SLOT, Constant.ITEM_QUEUE_LEAVE);
        } else
        {
            player.getInventory().clear();

            inventoryManager.load(player);
        }
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

    public Queue getByLadder(Ladder ladder)
    {
        for (Queue queue : queues)
        {
            if (queue != null)
            {
                if (queue.getLadder().equals(ladder))
                {
                    return queue;
                }
            }
        }
        return null;
    }
}
