package douglasForest.color;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import sereneseasons.api.season.ISeasonState;

public class SeasonalMapleColor implements IBlockColor{

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		if(state.getValue(BlockLeaves.DECAYABLE)==false)
			return 0xFF0000;
		else{
			ISeasonState season=sereneseasons.api.season.SeasonHelper.dataProvider.getClientSeasonState();
			if(season.getSeason()==sereneseasons.api.season.Season.AUTUMN||
					season.getSeason()==sereneseasons.api.season.Season.WINTER){
				return 0xFF0000;
			}else
				return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);
		}
	}

}
