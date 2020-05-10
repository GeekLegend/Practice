package net.swampmc.practice.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class Constant
{

    /*
    * Messages constants
     */
    public static final String QUEUE_JOIN_MESSAGE = "§eYou were added to %queuetype% %ladder%.";
    public static final String QUEUE_LEAVE_MESSAGE = "§eYou were removed from %queuetype% %ladder%.";
    public static final String QUEUE_VIEW_MESSAGE = "§eYou are in queue %queuetype% %ladder%.";

    /*
    * Join constants
     */
    public static final World WORLD = Bukkit.getWorlds().get(0);
    public static final Location LOCATION_SPAWN = new Location(WORLD, 51.5, 66.0, 231.5, 90, 0);

    public static final int ITEM_UNRANKED_SLOT = 0;
    public static final int ITEM_RANKED_SLOT = 1;
    public static final int ITEM_EDIT_KIT_SLOT = 8;

    public static final ItemStack ITEM_UNRANKED = new ItemBuilder(Material.IRON_SWORD).setName("§aJoin Unranked Queue").toItemStack();
    public static final ItemStack ITEM_RANKED = new ItemBuilder(Material.DIAMOND_SWORD).setName("§eJoin Ranked Queue").toItemStack();
    public static final ItemStack ITEM_EDIT_KIT = new ItemBuilder(Material.BOOK).setName("§2Edit kits").toItemStack();

    /*
    * Queue constants
     */
    public static final int ITEM_QUEUE_VIEW_SLOT = 0;
    public static final int ITEM_QUEUE_LEAVE_SLOT = 8;

    public static final ItemStack ITEM_QUEUE_VIEW = new ItemBuilder(Material.EYE_OF_ENDER).setName("§eView queue").toItemStack();
    public static final ItemStack ITEM_QUEUE_LEAVE = new ItemBuilder(Material.REDSTONE).setName("§cLeave queue").toItemStack();

    /*
    * Inventories constants
     */
    public static final int INVENTORY_LADDERS_SIZE = 2 * 9;
    public static final String INVENTORY_LADDERS_NAME = "Ladders";

    public static final ItemStack INVENTORY_ITEM_CLOSE = new ItemBuilder(Material.REDSTONE).setName("§cClose").toItemStack();
}
