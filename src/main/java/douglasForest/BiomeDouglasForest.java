package douglasForest;

import java.util.Random;

import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDouglasForest extends Biome{
	
	public static final WorldGenDouglasFir DOUGLAS_FIR=new WorldGenDouglasFir();
	public static final WorldGenTaiga1 PINE_TREE=new WorldGenTaiga1();
	
	public BiomeDouglasForest() {
		super(new BiomeProperties("Douglas Forest").setRainfall(0.8F).setTemperature(0.7F));
		setRegistryName("douglas_forest");
		decorator.treesPerChunk=6;
		decorator.grassPerChunk=2;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return (WorldGenAbstractTree)(rand.nextInt(5) == 0 ? PINE_TREE : DOUGLAS_FIR);
	}
	
	public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return rand.nextInt(5) > 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
	
	
	
}
