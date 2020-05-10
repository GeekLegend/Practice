package net.swampmc.practice.inventory;

import lombok.Getter;
import net.swampmc.practice.Practice;
import net.swampmc.practice.ladder.LadderInventory;
import net.swampmc.practice.util.Constant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager
{

    private static Map<Player, ItemStack[]> armorContents = new HashMap<>();
    private static Map<Player, ItemStack[]> contents = new HashMap<>();

    @Getter
    private LadderInventory ladderInventory;

    public InventoryManager(Practice plugin)
    {
        this.armorContents = new HashMap<>();
        this.contents = new HashMap<>();
        this.ladderInventory = new LadderInventory(Constant.INVENTORY_LADDERS_SIZE, Constant.INVENTORY_LADDERS_NAME);

        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(ladderInventory, plugin);
    }

    public void load(Player player)
    {
        player.getInventory().setArmorContents(getArmorContents(player));
        player.getInventory().setContents(getContents(player));
        player.updateInventory();

        armorContents.remove(player);
        contents.remove(player);
    }

    public void save(Player player)
    {
        armorContents.put(player, player.getInventory().getArmorContents());
        contents.put(player, player.getInventory().getContents());
    }

    public ItemStack[] getArmorContents(Player player)
    {
        ItemStack[] ac = armorContents.get(player);

        if (ac != null)
        {
            return ac;
        }
        return null;
    }

    public ItemStack[] getContents(Player player)
    {
        ItemStack[] c = contents.get(player);

        if (c != null)
        {
            return c;
        }
        return null;
    }
}
