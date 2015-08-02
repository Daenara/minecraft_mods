package com.daenara.showfps;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ShowFPS.MODID, name = ShowFPS.MODNAME, version = ShowFPS.VERSION)
public class ShowFPS {

    //Set the ID of the mod (Should be lower case).

    public static final String MODID = "showfps";
    //Set the "Name" of the mod.
    public static final String MODNAME = "ShowFPS";
    //Set the version of the mod.
    public static final String VERSION = "0.0.1";

    @Instance
    public static ShowFPS instance = new ShowFPS();

    @SidedProxy(clientSide = "com.daenara.showfps.ClientProxy", serverSide = "com.daenara.showfps.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	this.proxy.preInit(event);
	// DEBUG
	UsefulThings.printDebugMessage(MODNAME, "Starting PreInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
	this.proxy.init(event);
	// DEBUG
	UsefulThings.printDebugMessage(MODNAME, "Starting Init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
	this.proxy.postInit(event);
	// DEBUG
	UsefulThings.printDebugMessage(MODNAME, "Starting PostInit");
    }

    public void registerEventHandlers() {
	// DEBUG       
	UsefulThings.printDebugMessage(MODNAME, "Registering event handlers");

	MinecraftForge.EVENT_BUS.register(new HUDRenderer());
    }
}
