package net.swampmc.practice.ladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;

@AllArgsConstructor
public class Ladder
{

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private short data;

    @Getter
    @Setter
    private Material icon;

}
