package net.daenara.simplefps;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimpleFPS.MODID, version = SimpleFPS.VERSION)
public class SimpleFPS {

    public static final String MODID = "simplefps";
    public static final String VERSION = "1.0";
    public static final String MODNAME = "SimpleFPS";

    @Instance
    public static SimpleFPS instance = new SimpleFPS();

    @SidedProxy(clientSide = "net.daenara.simplefps.ClientProxy", serverSide = "net.daenara.simplefps.ServerProxy")
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
