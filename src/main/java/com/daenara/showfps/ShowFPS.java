package com.daenara.showfps;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ShowFPS.MODID, name=ShowFPS.MODNAME, version = ShowFPS.VERSION)
public class ShowFPS
{
    //Set the ID of the mod (Should be lower case).
    public static final String MODID = "showfps";
    //Set the "Name" of the mod.
    public static final String MODNAME = "ShowFPS";
    //Set the version of the mod.
    public static final String VERSION = "0.0.1";

    @Instance(value = ShowFPS.MODID) //Tell Forge what instance to use.
    public static ShowFPS instance;
        
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // DEBUG
        UsefullThings.printDebugMessage("Starting PreInit");
    }
        
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        // DEBUG
        UsefullThings.printDebugMessage("Starting Init");
        
        registerEventListeners();
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // DEBUG
        UsefullThings.printDebugMessage("Starting PostInit");
    }
    
    public void registerEventListeners() 
{
        // DEBUG       
        UsefullThings.printDebugMessage("Registering event listeners");
        
        MinecraftForge.EVENT_BUS.register(new HUDRenderer());
}
}
