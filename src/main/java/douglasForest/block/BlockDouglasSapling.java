package douglasForest.block;

import java.util.Random;

import douglasForest.EventsHandler;
import douglasForest.WorldGenDouglasFir;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockDouglasSapling extends BlockSapling{
	
	String name;
	public BlockDouglasSapling(String name) {
		super();
		setRegistryName(name);
		this.name=name;
		setUnlocalizedName(getRegistryName().toString());
		setSoundType(SoundType.PLANT);
	}
	
	@Override
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator;
        if(name.equals("sapling_douglas"))
        	worldgenerator = new WorldGenDouglasFir();
        else
        	worldgenerator = new WorldGenTrees(false, 4, EventsHandler.maple_log.getDefaultState(), EventsHandler.maple_leaf.getDefaultState(), false);
        int i = 0;
        int j = 0;
        boolean flag = false;

        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();

        if (flag)
        {
            worldIn.setBlockState(pos.add(i, 0, j), iblockstate2, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j), iblockstate2, 4);
            worldIn.setBlockState(pos.add(i, 0, j + 1), iblockstate2, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate2, 4);
        }
        else
        {
            worldIn.setBlockState(pos, iblockstate2, 4);
        }

        if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j)))
        {
            if (flag)
            {
                worldIn.setBlockState(pos.add(i, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i, 0, j + 1), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
            }
            else
            {
                worldIn.setBlockState(pos, state, 4);
            }
        }
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		items.add(new ItemStack(this));
	}
	
}
