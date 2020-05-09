package net.swampmc.practice.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public interface IInventory
{

    Inventory create();

    void update();

    void onInventoryClick(InventoryClickEvent event);

}
