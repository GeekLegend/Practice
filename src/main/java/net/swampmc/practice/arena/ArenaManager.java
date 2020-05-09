package net.swampmc.practice.arena;

import lombok.Getter;
import net.swampmc.practice.util.Constant;
import net.swampmc.practice.util.Debug;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArenaManager
{

    @Getter
    private List<Arena> arenas;

    private Map<Player, Arena> arena;

    public ArenaManager()
    {
        this.arenas = new ArrayList<>();
        this.arena = new HashMap<>();

        loadAll();
    }

    private void loadAll()
    {
        arenas.add(new Arena("Arena #1", new Location(Constant.WORLD, 49.5, 65.0, 249.5, 134, 0),
                new Location(Constant.WORLD, 45.5, 65.0, 245.5, -44, 0)));
        arenas.add(new Arena("Arena #2", new Location(Constant.WORLD, 49.5, 65.0, 240.5, 134, 0),
                new Location(Constant.WORLD, 45.5, 65.0, 236.5, -44, 0)));
    }

    public void add(Player player, Arena a)
    {
        if (a != null)
        {
            arena.put(player, a);
            a.add(player);
        } else
        {
            Debug.err("Arena does not exist.");
        }
    }

    public void remove(Player player)
    {
        Arena a = getArena(player);

        arena.remove(player);
        a.remove(player);
    }

    public boolean isContains(Player player)
    {
        return arena.containsKey(player);
    }

    public Arena getArena(Player player)
    {
        Arena a = arena.get(player);

        if (a != null)
        {
            return a;
        } else
        {
            Debug.err("This player has no arena to assign.");
        }
        return null;
    }


}
