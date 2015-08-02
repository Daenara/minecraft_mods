package com.daenara.showfps;

public class UsefulThings 
{  
    public static String fillString(String string, Integer lenght, char filling)
    {
        return String.format("%"+lenght+"s", string).replace(' ', filling);
    }
    
    public static String fillString(String string, Integer lenght)
    {
        return String.format("%"+lenght+"s", string);
    }
    
    public static void printDebugMessage(String modname, String string)
    {
        System.out.println("[" + modname + "] " + string);
    }
    
    public static Integer getColor(String color)
    {
	return Integer.parseInt(color, 16);
    }
}
