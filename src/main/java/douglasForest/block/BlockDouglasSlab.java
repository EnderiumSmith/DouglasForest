package douglasForest.block;

import java.util.Random;

import douglasForest.EventsHandler;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDouglasSlab extends BlockSlab{

	public boolean isDouble;
	public static final PropertyEnum<EnumNone> TYPE=PropertyEnum.create("type", EnumNone.class);
	
	public BlockDouglasSlab(boolean isDouble, String name) {
		super(Material.WOOD);
		this.isDouble=isDouble;
		setRegistryName(name+(isDouble?"_double":""));
		setUnlocalizedName(getRegistryName().toString());
		setSoundType(SoundType.WOOD);
		IBlockState state=this.blockState.getBaseState();
		if(!this.isDouble()){
			state=state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		setDefaultState(state);
		this.useNeighborBrightness=true;
		setHardness(2F);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName();
	}

	@Override
	public boolean isDouble() {
		return this.isDouble;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		return TYPE;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return EnumNone.NONE;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		if(!isDouble()){
			return state.getValue(HALF)==EnumBlockHalf.BOTTOM?0:1;
		}
		return 0;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(!isDouble()){
			return this.getDefaultState().withProperty(HALF, meta>0?EnumBlockHalf.TOP:EnumBlockHalf.BOTTOM);
		}
		return super.getStateFromMeta(meta);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{HALF, TYPE});
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 20;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(Random random) {
		return isDouble?2:1;
	}
	
	enum EnumNone implements IStringSerializable{
		NONE;

		@Override
		public String getName() {
			return "none";
		}
	}

}
