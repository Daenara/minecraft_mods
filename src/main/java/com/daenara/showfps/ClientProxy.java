package com.daenara.showfps;

import static com.daenara.showfps.ShowFPS.instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
	ConfigurationHandler.initConfiguration(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
	instance.registerEventHandlers();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    
}