package douglasForest;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=DouglasForest.MODID, name=DouglasForest.MODNAME, version=DouglasForest.VERSION)
public class DouglasForest {
	
	public static final String MODID="douglas_forest";
	public static final String MODNAME="Douglas Forest";
	public static final String VERSION="1.2";
	
	@SidedProxy(serverSide="douglasForest.CommonProxy", clientSide="douglasForest.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit(event);
	}
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
	
}
