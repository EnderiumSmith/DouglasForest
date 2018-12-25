package douglasForest.block;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasLog extends BlockLog{
	
	public BlockDouglasLog(String name) {
		super();
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
		setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LOG_AXIS);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch(meta%4){
		case 0:return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.X);
		case 1:return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y);
		case 2:return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Z);
		case 3:return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE);
		default:return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		switch(state.getValue(LOG_AXIS)){
		case NONE:return 3;
		case X:return 0;
		case Y:return 1;
		case Z:return 2;
		default:return 3;
		
		}
	}
	
}
