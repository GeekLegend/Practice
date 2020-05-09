package net.swampmc.practice.ladder;

import lombok.Getter;
import lombok.Setter;
import net.swampmc.practice.Practice;
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

        inventoryBuilder.clear();

        for (Ladder ladder : ladderManager.getLadders())
        {
            if (ladder != null)
            {
                inventoryBuilder.addItem(new ItemBuilder(ladder.getIcon()).setDurability(ladder.getData()).setName(ladder.getName()).toItemStack());
            }
        }

        inventoryBuilder.setItem(Constant.INVENTORY_LADDERS_ITEM_CLOSE_SLOT, Constant.INVENTORY_LADDERS_ITEM_CLOSE);

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
                ladderManager = Practice.getPlugin().getLadderManager();

                for (Ladder ladder : ladderManager.getLadders())
                {
                    if (ladder != null)
                    {
                        if (item.getType().equals(ladder.getIcon()) && item.getDurability() == ladder.getData())
                        {

                        }
                    } else
                    {
                        Debug.err("Ladder does not exist.");
                    }
                }

                if (item.equals(Constant.INVENTORY_LADDERS_ITEM_CLOSE))
                {
                    player.closeInventory();
                }
            }
        }
    }

}
