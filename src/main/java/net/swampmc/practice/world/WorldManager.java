package net.swampmc.practice.world;

import net.swampmc.practice.util.Constant;
import org.bukkit.World;

public class WorldManager
{

    public WorldManager()
    {
        World world = Constant.WORLD;
        world.setTime(1000);
        world.setWeatherDuration(0);
        world.setThunderDuration(0);
        world.setThundering(false);
        world.setGameRuleValue("doDaylightCycle", "false");
    }
}
