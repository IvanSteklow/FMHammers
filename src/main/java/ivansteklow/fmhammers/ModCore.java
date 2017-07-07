package ivansteklow.fmhammers;

import ivansteklow.fmhammers.init.ModTools;
import ivansteklow.fmhammers.init.Refs;
import ivansteklow.fmhammers.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Refs.MOD_ID, name = Refs.NAME, version = Refs.VERSION, acceptedMinecraftVersions = Refs.ACCEPTED_VERSIONS, dependencies = Refs.MOD_DEPENDENCIES)
public class ModCore {
	
	public static SimpleNetworkWrapper network;

	@Instance
	public static ModCore instance;

	@SidedProxy(clientSide = Refs.CLIENT_PROXY_CLASS, serverSide = Refs.SERVER_PROXY_CLASS)
	public static ServerProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		NetworkRegistry.INSTANCE.newSimpleChannel("fmhammersprivatenetworkchannel");
		ModTools.init();
		proxy.preInit(e);

	}

	@EventHandler
	public void Init(FMLInitializationEvent e) {
		proxy.Init(e);
		proxy.registerModelBakeryVariants();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

	}

}
