package net.daenara.simplefps;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigurationHandler 
{
    private static Configuration config;
    public static void initConfiguration(FMLPreInitializationEvent event)
    {
	config = new Configuration(event.getSuggestedConfigurationFile());
	config.load();
    }
    
    public static Configuration getConfig()
    {
	if (config != null)
	{
	    return config;
	}
	System.err.println("What config?");
	return config;
    }
}