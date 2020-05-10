package net.swampmc.practice.ladder;

import lombok.Getter;
import lombok.Setter;
import net.swampmc.practice.Practice;
import net.swampmc.practice.arena.queue.Queue;
import net.swampmc.practice.arena.queue.QueueManager;
import net.swampmc.practice.arena.queue.QueueType;
import net.swampmc.practice.inventory.IInventory;
import net.swampmc.practice.util.Constant;
import net.swampmc.practice.util.Debug;
import net.swampmc.practice.util.InventoryBuilder;
import net.swampmc.practice.util.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class LadderInventory implements Listener, IInventory
{

    @Getter
    @Setter
    private int size;

    @Getter
    @Setter
    private String name;

    private InventoryBuilder inventoryBuilder;

    private LadderManager ladderManager;
    private QueueManager queueManager;

    public LadderInventory(int size, String name)
    {
        this.size = size;
        this.name = name;
        this.inventoryBuilder = new InventoryBuilder(size, name);
    }

    @Override
    public Inventory create()
    {
        ladderManager = Practice.getPlugin().getLadderManager();
        queueManager = Practice.getPlugin().getQueueManager();

        inventoryBuilder.clear();

        for (Ladder ladder : ladderManager.getLadders())
        {
            if (ladder != null)
            {
                Queue queue = queueManager.getByLadder(ladder);
                int queueSize;

                if (queue != null)
                {
                    queueSize = queue.getPlayers().size();
                } else
                {
                    queueSize = 0;
                }

                inventoryBuilder.addItem(new ItemBuilder(ladder.getIcon()).setDurability(ladder.getData()).setName(ladder.getName()).setLore(Arrays.asList("§fIn Queue: §e" + queueSize)).removePotionLore().toItemStack());
            }
        }

        inventoryBuilder.setItem(size - 1, Constant.INVENTORY_ITEM_CLOSE);

        return inventoryBuilder.toInventory();
    }

    @Override
    public void update()
    {

    }

    @Override
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        ItemStack item = event.getCurrentItem();

        if (inventory != null && inventory.getName().equalsIgnoreCase(name))
        {
            if (item != null)
            {
                event.setCancelled(true);

                QueueManager queueManager = Practice.getPlugin().getQueueManager();

                if (!queueManager.isContains(player))
                {
                    ladderManager = Practice.getPlugin().getLadderManager();

                    for (Ladder ladder : ladderManager.getLadders())
                    {
                        if (ladder != null)
                        {
                            if (item.getType().equals(ladder.getIcon()) && item.getDurability() == ladder.getData())
                            {
                                ItemStack itemInHand = player.getInventory().getItemInHand();
                                QueueType queueType = null;

                                if (itemInHand.equals(Constant.ITEM_UNRANKED))
                                {
                                    queueType = QueueType.UNRANKED;
                                } else if (itemInHand.equals(Constant.ITEM_RANKED))
                                {
                                    queueType = QueueType.RANKED;
                                }

                                player.closeInventory();

                                queueManager.add(player, new Queue(queueType, ladder));
                            }
                        } else
                        {
                            Debug.err("Ladder does not exist.");
                        }
                    }
                }

                if (item.equals(Constant.INVENTORY_ITEM_CLOSE))
                {
                    player.closeInventory();
                }
            }
        }
    }

}
