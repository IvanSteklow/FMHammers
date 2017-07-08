package ivansteklow.fmhammers.init;

import ivansteklow.fmhammers.creativetabs.FMHTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Refs {

	public static final String MOD_ID = "fmhammers";
	public static final String NAME = "Fighty-Mine Hammers";
	public static final String VERSION = "1.0.0";
	public static final String ACCEPTED_VERSIONS = "[1.11.2]";
	public static final String MOD_DEPENDENCIES = "required-after:isdev@[2.0.0,);"
			+ "required-after:forge@[13.20.1.2386,);";

	public static final String CLIENT_PROXY_CLASS = "ivansteklow.fmhammers.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "ivansteklow.fmhammers.proxy.ServerProxy";

	public static final CreativeTabs HammersTab = new FMHTab();
	
	public static final ToolMaterial STARMETAL = EnumHelper.addToolMaterial(Refs.MOD_ID, 3, 2000, 5.0F, 2.0F, 30);

}
