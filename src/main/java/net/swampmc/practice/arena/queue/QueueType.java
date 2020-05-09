package net.swampmc.practice.arena.queue;

import lombok.Getter;

public enum QueueType
{

    UNRANKED("§aUnranked"),
    RANKED("§eRanked");

    @Getter
    private String name;

    QueueType(String name)
    {
        this.name = name;
    }

}
