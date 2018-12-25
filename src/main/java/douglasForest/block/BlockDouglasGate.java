package douglasForest.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasGate extends BlockFenceGate{

	public BlockDouglasGate(String name) {
		super(BlockPlanks.EnumType.SPRUCE);
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
