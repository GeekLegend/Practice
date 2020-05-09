package net.swampmc.practice.arena;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Arena
{

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Location spawn1, spawn2;

    @Getter
    private List<Player> players;

    public Arena(String name, Location spawn1, Location spawn2)
    {
        this.name = name;
        this.spawn1 = spawn1;
        this.spawn2 = spawn2;
        this.players = new ArrayList<>();
    }

    public void add(Player player)
    {
        if (!isContains(player))
        {
            players.add(player);
        }
    }

    public void remove(Player player)
    {
        if (isContains(player))
        {
            players.remove(player);
        }
    }

    public boolean isContains(Player player)
    {
        return players.contains(player);
    }

}
