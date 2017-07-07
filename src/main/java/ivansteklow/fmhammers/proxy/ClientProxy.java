package ivansteklow.fmhammers.proxy;

import ivansteklow.fmhammers.init.ModTools;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		ModTools.regRenders();
		super.preInit(e);
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		super.Init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

	@Override
	public void registerModelBakeryVariants() {

	}

}
