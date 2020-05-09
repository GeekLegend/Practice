package net.swampmc.practice.arena.queue;

import lombok.Getter;
import net.swampmc.practice.ladder.Ladder;

public class Queue
{

    @Getter
    private QueueType queueType;

    @Getter
    private Ladder ladder;

    public Queue(QueueType queueType, Ladder ladder)
    {
        this.queueType = queueType;
        this.ladder = ladder;
    }
}
