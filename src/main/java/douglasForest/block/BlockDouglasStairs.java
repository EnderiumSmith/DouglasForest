package douglasForest.block;

import douglasForest.EventsHandler;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasStairs extends BlockStairs{

	public BlockDouglasStairs(String name) {
		super(EventsHandler.planks.getDefaultState());
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
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
