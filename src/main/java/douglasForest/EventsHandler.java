package douglasForest;

import douglasForest.block.BlockDouglasDoor;
import douglasForest.block.BlockDouglasFence;
import douglasForest.block.BlockDouglasGate;
import douglasForest.block.BlockDouglasLeaves;
import douglasForest.block.BlockDouglasLog;
import douglasForest.block.BlockDouglasPlanks;
import douglasForest.block.BlockDouglasSapling;
import douglasForest.block.BlockDouglasSlab;
import douglasForest.block.BlockDouglasStairs;
import douglasForest.block.ItemBlockBase;
import douglasForest.block.ItemDoorDouglas;
import douglasForest.block.ItemDouglasSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventsHandler {
	
	public static BlockDouglasLog log=new BlockDouglasLog("log_douglas");
	public static BlockDouglasLeaves leaf=new BlockDouglasLeaves("leaves_douglas");
	public static BlockDouglasSapling sapling=new BlockDouglasSapling("sapling_douglas");
	public static BlockDouglasPlanks planks=new BlockDouglasPlanks("planks_douglas");
	public static BlockDouglasFence fence=new BlockDouglasFence("fence_douglas");
	public static BlockDouglasGate gate=new BlockDouglasGate("gate_douglas");
	public static BlockDouglasDoor door=new BlockDouglasDoor("door_douglas");
	public static BlockDouglasStairs stairs=new BlockDouglasStairs("stairs_douglas");
	public static BlockDouglasSlab slab=new BlockDouglasSlab(false, "slab_douglas");
	public static BlockDouglasSlab slab_double=new BlockDouglasSlab(true, "slab_douglas");
	
	public static BlockDouglasLog maple_log=new BlockDouglasLog("log_maple");
	public static BlockDouglasLeaves maple_leaf=new BlockDouglasLeaves("leaves_maple");
	public static BlockDouglasSapling maple_sapling=new BlockDouglasSapling("sapling_maple");
	public static BlockDouglasPlanks maple_planks=new BlockDouglasPlanks("planks_maple");
	public static BlockDouglasFence maple_fence=new BlockDouglasFence("fence_maple");
	public static BlockDouglasGate maple_gate=new BlockDouglasGate("gate_maple");
	public static BlockDouglasDoor maple_door=new BlockDouglasDoor("door_maple");
	public static BlockDouglasStairs maple_stairs=new BlockDouglasStairs("stairs_maple");
	public static BlockDouglasSlab maple_slab=new BlockDouglasSlab(false, "slab_maple");
	public static BlockDouglasSlab maple_slab_double=new BlockDouglasSlab(true, "slab_maple");
	
	public static ItemBlockBase log_item=new ItemBlockBase(log);
	public static ItemBlockBase leaf_item=new ItemBlockBase(leaf);
	public static ItemBlockBase sapling_item=new ItemBlockBase(sapling);
	public static ItemBlockBase planks_item=new ItemBlockBase(planks);
	public static ItemBlockBase fence_item=new ItemBlockBase(fence);
	public static ItemBlockBase gate_item=new ItemBlockBase(gate);
	public static ItemDoorDouglas door_item=new ItemDoorDouglas(door);
	public static ItemBlockBase stairs_item=new ItemBlockBase(stairs);
	public static ItemDouglasSlab slab_item=new ItemDouglasSlab(slab, slab, slab_double);
	
	public static ItemBlockBase maple_log_item=new ItemBlockBase(maple_log);
	public static ItemBlockBase maple_leaf_item=new ItemBlockBase(maple_leaf);
	public static ItemBlockBase maple_sapling_item=new ItemBlockBase(maple_sapling);
	public static ItemBlockBase maple_planks_item=new ItemBlockBase(maple_planks);
	public static ItemBlockBase maple_fence_item=new ItemBlockBase(maple_fence);
	public static ItemBlockBase maple_gate_item=new ItemBlockBase(maple_gate);
	public static ItemDoorDouglas maple_door_item=new ItemDoorDouglas(maple_door);
	public static ItemBlockBase maple_stairs_item=new ItemBlockBase(maple_stairs);
	public static ItemDouglasSlab maple_slab_item=new ItemDouglasSlab(maple_slab, maple_slab, maple_slab_double);
	
	public static BiomeDouglasForest douglas=new BiomeDouglasForest();
	public static BiomeMapleForest maple=new BiomeMapleForest();
	
	@SubscribeEvent
	public void registerBiome(RegistryEvent.Register<Biome> event){
		event.getRegistry().register(douglas);
		BiomeDictionary.addTypes(douglas, Type.CONIFEROUS, Type.LUSH, Type.FOREST);
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(douglas, 10));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(douglas, 10));
		BiomeManager.addSpawnBiome(douglas);
		event.getRegistry().register(maple);
		BiomeDictionary.addTypes(maple, Type.FOREST);
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(maple, 10));
		BiomeManager.addSpawnBiome(maple);
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event){
		event.getRegistry().registerAll(log, leaf, sapling, planks, fence, gate, door, stairs, slab, slab_double,
				maple_log, maple_leaf, maple_sapling, maple_planks, maple_fence, maple_gate, maple_stairs,
				maple_slab, maple_slab_double, maple_door);
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().registerAll(log_item, leaf_item, sapling_item, planks_item, fence_item,
				gate_item, door_item, stairs_item, slab_item,
				maple_log_item, maple_leaf_item, maple_sapling_item, maple_planks_item, maple_fence_item,
				maple_gate_item, maple_door_item, maple_stairs_item, maple_slab_item);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModel(ModelRegistryEvent event){
		log_item.initModel();
		leaf_item.initModel();
		sapling_item.initModel();
		planks_item.initModel();
		fence_item.initModel();
		gate_item.initModel();
		door_item.initModel();
		stairs_item.initModel();
		slab_item.initModel();
		maple_log_item.initModel();
		maple_leaf_item.initModel();
		maple_sapling_item.initModel();
		maple_planks_item.initModel();
		maple_fence_item.initModel();
		maple_gate_item.initModel();
		maple_door_item.initModel();
		maple_stairs_item.initModel();
		maple_slab_item.initModel();
	}
	
}
