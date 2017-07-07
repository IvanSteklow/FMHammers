package ivansteklow.fmhammers.init;

import ivansteklow.fmhammers.tools.ItemHammer;
import ivansteklow.isdev.handlers.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTools {

	public static Item ironHammer;
	
	public static void init() {
		ironHammer = new ItemHammer();
		
		ItemHandler.regItem(ironHammer, CreativeTabs.TOOLS);
	}

	public static void regRenders() {
		ItemHandler.regRender(ironHammer, Refs.MOD_ID);
	}
	
}
