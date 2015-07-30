package com.daenara.showfps;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUDRenderer 
{
    public static int infoLineLocX = 1;
    public static int infoLineLocY = 1;
    
    private static Minecraft mc = Minecraft.getMinecraft();
    @SubscribeEvent
    public void RenderGameOverlayEvent(RenderGameOverlayEvent event)
    {
        
    	//render everything onto the screen
    	if(event.type == RenderGameOverlayEvent.ElementType.TEXT)
    	{
            //Integer fps = mc.debug;
            String debugInfo = mc.debug;
            String fps = String.format("%3s", debugInfo.substring(0, debugInfo.indexOf(" "))).replace(' ', '0') + " FPS";
            mc.fontRendererObj.drawString(fps, infoLineLocX, infoLineLocY, 0xffffff);
    	}
    }
}
