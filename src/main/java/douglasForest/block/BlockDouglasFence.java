package douglasForest.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasFence extends BlockFence{

	public BlockDouglasFence(String name) {
		super(Material.WOOD, MapColor.WOOD);
		setSoundType(SoundType.WOOD);
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
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
