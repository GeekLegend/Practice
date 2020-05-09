package net.swampmc.practice.listener.manager;

import net.swampmc.practice.Practice;
import net.swampmc.practice.listener.PlayerInteractListener;
import net.swampmc.practice.listener.PlayerJoinListener;
import net.swampmc.practice.listener.PlayerQuitListener;
import net.swampmc.practice.listener.WeatherChangeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenerManager
{

    public ListenerManager(Practice plugin)
    {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), plugin);
        pluginManager.registerEvents(new PlayerQuitListener(), plugin);
        pluginManager.registerEvents(new PlayerInteractListener(), plugin);
        pluginManager.registerEvents(new WeatherChangeListener(), plugin);
    }
}
