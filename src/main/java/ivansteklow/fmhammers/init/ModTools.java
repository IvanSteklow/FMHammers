package ivansteklow.fmhammers.init;

import ivansteklow.fmhammers.tools.ItemDrill;
import ivansteklow.fmhammers.tools.ItemHammer;
import ivansteklow.isdev.handlers.ItemHandler;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ModTools {

	public static Item woodenHammer, stoneHammer, ironHammer, goldenHammer, diamondHammer, starmetalHammer, stoneDrill,
			ironDrill, goldenDrill, diamondDrill, starmetalDrill;

	public static void init() {
		woodenHammer = new ItemHammer(ToolMaterial.WOOD, 1, 0);
		stoneHammer = new ItemHammer(ToolMaterial.STONE, 1, 0);
		ironHammer = new ItemHammer(ToolMaterial.IRON, 1, 0);
		goldenHammer = new ItemHammer(ToolMaterial.GOLD, 1, 0);
		diamondHammer = new ItemHammer(ToolMaterial.DIAMOND, 1, 0);
		starmetalHammer = new ItemHammer(Refs.STARMETAL, 1, 2);

		stoneDrill = new ItemDrill(ToolMaterial.STONE, 1, 9, 5);
		ironDrill = new ItemDrill(ToolMaterial.IRON, 1, 9, 10);
		goldenDrill = new ItemDrill(ToolMaterial.GOLD, 1, 10, 5);
		diamondDrill = new ItemDrill(ToolMaterial.DIAMOND, 9, 9, 25);
		starmetalDrill = new ItemDrill(Refs.STARMETAL, 1, 20, 25);

		ItemHandler.regItem(woodenHammer, Refs.HammersTab);
		ItemHandler.regItem(stoneHammer, Refs.HammersTab);
		ItemHandler.regItem(ironHammer, Refs.HammersTab);
		ItemHandler.regItem(goldenHammer, Refs.HammersTab);
		ItemHandler.regItem(diamondHammer, Refs.HammersTab);
		ItemHandler.regItem(starmetalHammer, Refs.HammersTab);

		ItemHandler.regItem(stoneDrill, Refs.HammersTab);
		ItemHandler.regItem(ironDrill, Refs.HammersTab);
		ItemHandler.regItem(goldenDrill, Refs.HammersTab);
		ItemHandler.regItem(diamondDrill, Refs.HammersTab);
		ItemHandler.regItem(starmetalDrill, Refs.HammersTab);
	}

	public static void regRenders() {
		ItemHandler.regRender(woodenHammer, Refs.MOD_ID);
		ItemHandler.regRender(stoneHammer, Refs.MOD_ID);
		ItemHandler.regRender(ironHammer, Refs.MOD_ID);
		ItemHandler.regRender(goldenHammer, Refs.MOD_ID);
		ItemHandler.regRender(diamondHammer, Refs.MOD_ID);
		ItemHandler.regRender(starmetalHammer, Refs.MOD_ID);

		ItemHandler.regRender(stoneDrill, Refs.MOD_ID);
		ItemHandler.regRender(ironDrill, Refs.MOD_ID);
		ItemHandler.regRender(goldenDrill, Refs.MOD_ID);
		ItemHandler.regRender(diamondDrill, Refs.MOD_ID);
		ItemHandler.regRender(starmetalDrill, Refs.MOD_ID);
	}

}
