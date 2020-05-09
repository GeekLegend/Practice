package net.swampmc.practice.listener;

import net.swampmc.practice.Practice;
import net.swampmc.practice.scorebord.ScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener
{
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        ScoreboardManager scoreboardManager = Practice.getPlugin().getScoreboardManager();

        scoreboardManager.onLogout(player);

        event.setQuitMessage(null);
    }
}
