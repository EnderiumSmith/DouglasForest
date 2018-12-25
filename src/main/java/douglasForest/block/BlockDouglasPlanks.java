package douglasForest.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasPlanks extends Block{

	public BlockDouglasPlanks(String name) {
		super(Material.WOOD);
		setSoundType(SoundType.WOOD);
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setHardness(2F);
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 20;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}

}
