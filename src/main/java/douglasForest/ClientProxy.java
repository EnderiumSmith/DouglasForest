package douglasForest;

import douglasForest.color.MapleColor;
import douglasForest.color.SeasonalMapleColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {
			
			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
					return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);
			}
		}, EventsHandler.leaf);
		if(Loader.isModLoaded("sereneseasons")){
			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new SeasonalMapleColor(), EventsHandler.maple_leaf);
		}else
			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new MapleColor(), EventsHandler.maple_leaf);
		
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return 0xFF0000;
			}
		}, EventsHandler.maple_leaf_item);
		
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return 0x00aa00;
			}
		}, EventsHandler.leaf_item);
	}
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
}
