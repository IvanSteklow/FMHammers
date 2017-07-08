package ivansteklow.fmhammers.creativetabs;

import ivansteklow.fmhammers.init.ModTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FMHTab extends CreativeTabs {

	public FMHTab() {
		super("fmhammers");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModTools.woodenHammer);
	}

}
