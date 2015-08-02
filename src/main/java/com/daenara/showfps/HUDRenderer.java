package com.daenara.showfps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class HUDRenderer {

    private static Minecraft mc = Minecraft.getMinecraft();
    private static FontRenderer fc = mc.fontRendererObj;
    private static Configuration config;

    private static Integer fps_pos_x;
    private static Integer fps_pos_y;
    private static Integer fps_color;
    private static float fps_size;

    private void getConfig() {
	config = ConfigurationHandler.getConfig();
	if (config != null) {
	    fps_pos_x = config.get("FPS_Position", "pos_x", 1).getInt();
	    fps_pos_y = config.get("FPS_Position", "pos_y", 1).getInt();
	    String color_str = config.get("FPS_Appearance", "color", "ffffff").getString();
	    fps_color = UsefulThings.getColor(color_str);
	    fps_size = (float) config.get("FPS_Appearance", "size", 0.72).getDouble();
	    config.save();
	}
    }

    @SubscribeEvent
    public void RenderGameOverlayEvent(RenderGameOverlayEvent.Text event) {
	if (config == null) {
	    getConfig();
	}
	renderFPS();
    }

    private void writeString(String string, Integer pos_x, Integer pos_y, Integer color, float scale) {
	GL11.glPushMatrix();
	GL11.glDisable(GL11.GL_LIGHTING);
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glScalef(scale, scale, scale);
	mc.ingameGUI.drawString(fc, string, pos_x, pos_y, color);
	GL11.glPopMatrix();
    }

    private void renderFPS() {
	String debugInfo = mc.debug;
	String fps = UsefulThings.fillString(debugInfo.substring(0, debugInfo.indexOf(" ")), 3, '0') + " FPS";
	writeString(fps, fps_pos_x, fps_pos_y, fps_color, fps_size);
    }
}
