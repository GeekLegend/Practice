package net.swampmc.practice.util;

public class Debug
{

    private static final String INFO_PREFIX = "[INFO]";
    private static final String ERR_PREFIX = "[ERROR]";

    private static boolean isDebug = true;

    public static void info(String info)
    {
        if (isDebug)
        {
            System.out.println(INFO_PREFIX + " " + info);
        }
    }

    public static void err(String err)
    {
        if (isDebug)
        {
            System.err.println(ERR_PREFIX + " " + err);
        }
    }
}
