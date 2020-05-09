package net.swampmc.practice.inventory;

import lombok.Getter;
import net.swampmc.practice.Practice;
import net.swampmc.practice.ladder.LadderInventory;
import net.swampmc.practice.util.Constant;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class InventoryManager
{

    @Getter
    private LadderInventory ladderInventory;

    public InventoryManager(Practice plugin)
    {
        this.ladderInventory = new LadderInventory(Constant.INVENTORY_LADDERS_SIZE, Constant.INVENTORY_LADDERS_NAME);

        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(ladderInventory, plugin);
    }
}
