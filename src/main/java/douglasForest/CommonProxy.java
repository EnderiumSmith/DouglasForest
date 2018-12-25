package douglasForest;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new EventsHandler());
	}
	public void init(FMLInitializationEvent event){
		OreDictionary.registerOre("logWood", EventsHandler.log);
		OreDictionary.registerOre("treeLeaves", EventsHandler.leaf);
		OreDictionary.registerOre("treeSapling", EventsHandler.sapling);
		OreDictionary.registerOre("plankWood", EventsHandler.planks);
		OreDictionary.registerOre("slabWood", EventsHandler.slab);
		OreDictionary.registerOre("stairWood", EventsHandler.stairs);
		OreDictionary.registerOre("fenceWood", EventsHandler.fence);
		OreDictionary.registerOre("fenceGateWood", EventsHandler.gate);
		OreDictionary.registerOre("logWood", EventsHandler.maple_log);
		OreDictionary.registerOre("treeLeaves", EventsHandler.maple_leaf);
		OreDictionary.registerOre("treeSapling", EventsHandler.maple_sapling);
		OreDictionary.registerOre("plankWood", EventsHandler.maple_planks);
		OreDictionary.registerOre("slabWood", EventsHandler.maple_slab);
		OreDictionary.registerOre("stairWood", EventsHandler.maple_stairs);
		OreDictionary.registerOre("fenceWood", EventsHandler.maple_fence);
		OreDictionary.registerOre("fenceGateWood", EventsHandler.maple_gate);
		Crafting.registerRecipes();
	}
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
