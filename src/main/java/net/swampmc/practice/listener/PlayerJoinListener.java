package net.swampmc.practice.listener;

import net.swampmc.practice.Practice;
import net.swampmc.practice.scorebord.ScoreboardManager;
import net.swampmc.practice.util.Constant;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        ScoreboardManager scoreboardManager = Practice.getPlugin().getScoreboardManager();

        scoreboardManager.onLogin(player);

        setup(player);

        event.setJoinMessage(null);
    }

    private void setup(Player player)
    {
        player.setHealth(20.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.teleport(Constant.LOCATION_SPAWN);
        player.getInventory().clear();
        player.getInventory().setItem(Constant.ITEM_UNRANKED_SLOT, Constant.ITEM_UNRANKED);
        player.getInventory().setItem(Constant.ITEM_RANKED_SLOT, Constant.ITEM_RANKED);
        player.getInventory().setItem(Constant.ITEM_EDIT_KIT_SLOT, Constant.ITEM_EDIT_KIT);
    }
}
