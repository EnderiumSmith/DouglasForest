package douglasForest;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Crafting {
	
	public static void registerRecipes(){
		ForgeRegistries.RECIPES.register(new ShapelessOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.planks_item, 4), new Object[]{
				EventsHandler.log_item
		}).setRegistryName("planks"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), Items.SPRUCE_BOAT, new Object[]{
				"P P",
				"PPP",
				'P', EventsHandler.planks_item
		}).setRegistryName("boat"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), EventsHandler.gate_item, new Object[]{
				"SPS",
				"SPS",
				'P', EventsHandler.planks_item, 'S', "stickWood"
		}).setRegistryName("gate"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.door_item, 3), new Object[]{
				"PP",
				"PP",
				"PP",
				'P', EventsHandler.planks_item
		}).setRegistryName("door"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.fence_item, 3), new Object[]{
				"PSP",
				"PSP",
				'P', EventsHandler.planks_item, 'S', "stickWood"
		}).setRegistryName("fence"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.slab_item, 6), new Object[]{
				"PPP",
				'P', EventsHandler.planks_item
		}).setRegistryName("slab"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.stairs_item, 4), new Object[]{
				"  P",
				" PP",
				"PPP",
				'P', EventsHandler.planks_item
		}).setRegistryName("stair"));
		GameRegistry.addSmelting(EventsHandler.log_item, new ItemStack(Items.COAL, 1, 1), 0.1F);
		
		ForgeRegistries.RECIPES.register(new ShapelessOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.maple_planks_item, 4), new Object[]{
				EventsHandler.maple_log_item
		}).setRegistryName("maple_planks"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), Items.BOAT, new Object[]{
				"P P",
				"PPP",
				'P', EventsHandler.maple_planks_item
		}).setRegistryName("maple_boat"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), EventsHandler.maple_gate_item, new Object[]{
				"SPS",
				"SPS",
				'P', EventsHandler.maple_planks_item, 'S', "stickWood"
		}).setRegistryName("maple_gate"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.maple_door_item, 3), new Object[]{
				"PP",
				"PP",
				"PP",
				'P', EventsHandler.maple_planks_item
		}).setRegistryName("maple_door"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.maple_fence_item, 3), new Object[]{
				"PSP",
				"PSP",
				'P', EventsHandler.maple_planks_item, 'S', "stickWood"
		}).setRegistryName("maple_fence"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.maple_slab_item, 6), new Object[]{
				"PPP",
				'P', EventsHandler.maple_planks_item
		}).setRegistryName("maple_slab"));
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(DouglasForest.MODID, DouglasForest.MODNAME), new ItemStack(EventsHandler.maple_stairs_item, 4), new Object[]{
				"  P",
				" PP",
				"PPP",
				'P', EventsHandler.maple_planks_item
		}).setRegistryName("maple_stair"));
		GameRegistry.addSmelting(EventsHandler.maple_log_item, new ItemStack(Items.COAL, 1, 1), 0.1F);
	}
	
}
