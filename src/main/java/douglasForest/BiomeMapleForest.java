package douglasForest;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class BiomeMapleForest extends Biome{
	
	public static final WorldGenTrees MAPLE=new WorldGenTrees(false, 4, EventsHandler.maple_log.getDefaultState(), EventsHandler.maple_leaf.getDefaultState(), false); 
	
	public BiomeMapleForest() {
		super(new BiomeProperties("Maple Forest").setTemperature(0.5F).setRainfall(0.8F));
		setRegistryName("maple_forest");
		decorator.treesPerChunk=10;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return (WorldGenAbstractTree)(rand.nextBoolean() ? MAPLE: (rand.nextInt(10) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE));
	}

}
