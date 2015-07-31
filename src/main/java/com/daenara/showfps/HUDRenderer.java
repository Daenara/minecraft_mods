package com.daenara.showfps;
import static com.daenara.showfps.UsefullThings.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class HUDRenderer 
{ 
    private static Minecraft mc = Minecraft.getMinecraft();
    private static FontRenderer fc = mc.fontRendererObj;
    
    @SubscribeEvent
    public void RenderGameOverlayEvent(RenderGameOverlayEvent event)
    {
    	if(event.type == RenderGameOverlayEvent.ElementType.TEXT)
    	{
            writeString(renderFPS(),1,1,0xffffff,0.72F);
    	}
    }
    
    private void writeString(String string, Integer pos_x, Integer pos_y, Integer color, float scale)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glScalef(scale, scale, scale);
        mc.ingameGUI.drawString(fc, string, pos_x, pos_y, color);
        GL11.glPopMatrix();
    }
    
    private void writeString(String string, Integer pos_x, Integer pos_y, Integer color)
    { 
        writeString(string, pos_x, pos_y, color, 1);
    }
    
    
    private String renderFPS()
    {
        String debugInfo = mc.debug;
        String fps = fillString(debugInfo.substring(0, debugInfo.indexOf(" ")), 3, '0') + " FPS";
        return fps;
    }
}
