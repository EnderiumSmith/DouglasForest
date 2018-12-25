package douglasForest.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;

public class ItemDouglasSlab extends ItemSlab{

	public ItemDouglasSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab) {
		super(block, singleSlab, doubleSlab);
		setRegistryName(block.getRegistryName());
	}
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
