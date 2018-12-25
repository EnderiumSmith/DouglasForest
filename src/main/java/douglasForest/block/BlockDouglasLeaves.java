package douglasForest.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import douglasForest.EventsHandler;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasLeaves extends BlockLeaves{

	public String name;
	public BlockDouglasLeaves(String name) {
		super();
		this.name=name;
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 30;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 60;
	}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> list=new ArrayList<>();
		list.add(new ItemStack(Item.getItemFromBlock(this)));
		return list;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(name.equals("leaves_douglas"))
			return EventsHandler.sapling_item;
		else
			return EventsHandler.maple_sapling_item;
	}

	@Override
	public EnumType getWoodType(int meta) {
		return EnumType.SPRUCE;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{DECAYABLE, CHECK_DECAY});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, meta%2==1).withProperty(CHECK_DECAY, meta>=8);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(DECAYABLE)?1:0)+(state.getValue(CHECK_DECAY)?0:8);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return Blocks.LEAVES.isOpaqueCube(state);
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return Blocks.LEAVES.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

}
