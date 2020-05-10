package net.swampmc.practice.ladder;

import lombok.Getter;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class LadderManager
{

    @Getter
    private List<Ladder> ladders;

    public LadderManager()
    {
        this.ladders = new ArrayList<>();

        loadAll();
    }

    public void loadAll()
    {
        ladders.add(new Ladder("§6NoDebuff", (short) 16453, Material.POTION));
        ladders.add(new Ladder("§6Soup", (byte) 0, Material.MUSHROOM_SOUP));
    }

}
