package net.swampmc.practice.util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder
{

    private Inventory inventory;

    public InventoryBuilder(int size, String name)
    {
        this.inventory = Bukkit.createInventory(null, size, name);
    }

    public InventoryBuilder(InventoryHolder inventoryHolder, int size, String name)
    {
        this.inventory = Bukkit.createInventory(inventoryHolder, size, name);
    }

    public InventoryBuilder addItem(ItemStack item)
    {
        inventory.addItem(item);

        return this;
    }

    public InventoryBuilder setItem(int slot, ItemStack item)
    {
        inventory.setItem(slot, item);

        return this;
    }
    public InventoryBuilder clear()
    {
        inventory.clear();

        return this;
    }

    public Inventory toInventory()
    {
        return inventory;
    }
}