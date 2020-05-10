package net.swampmc.practice.listener;

import net.swampmc.practice.Practice;
import net.swampmc.practice.arena.queue.Queue;
import net.swampmc.practice.arena.queue.QueueManager;
import net.swampmc.practice.inventory.InventoryManager;
import net.swampmc.practice.ladder.LadderInventory;
import net.swampmc.practice.util.Constant;
import net.swampmc.practice.util.Debug;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener
{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();
        InventoryManager inventoryManager = Practice.getPlugin().getInventoryManager();
        LadderInventory ladderInventory = inventoryManager.getLadderInventory();

        if (item != null)
        {
            QueueManager queueManager = Practice.getPlugin().getQueueManager();

            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))
            {
                if (queueManager.isContains(player))
                {
                    event.setCancelled(true);

                    Queue queue = queueManager.getQueue(player);

                    if (queue != null)
                    {
                        if (item.equals(Constant.ITEM_QUEUE_VIEW))
                        {
                            player.sendMessage(Constant.QUEUE_VIEW_MESSAGE.replace("%queuetype%", queue.getQueueType().getName()).replace("%ladder%", queue.getLadder().getName()));
                        } else if (item.equals(Constant.ITEM_QUEUE_LEAVE))
                        {
                            queueManager.remove(player);
                        }
                    } else
                    {
                        Debug.info("Player queue don't exist.");
                    }
                } else
                {
                    if (item.equals(Constant.ITEM_UNRANKED))
                    {
                        player.openInventory(ladderInventory.create());
                    }
                }
            }
        }
    }
}
