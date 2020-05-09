package net.swampmc.practice.listener;

import net.swampmc.practice.Practice;
import net.swampmc.practice.inventory.InventoryManager;
import net.swampmc.practice.ladder.LadderInventory;
import net.swampmc.practice.util.Constant;
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
            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))
            {
                if (item.equals(Constant.ITEM_UNRANKED))
                {
                    player.openInventory(ladderInventory.create());
                }
            }
        }
    }
}
