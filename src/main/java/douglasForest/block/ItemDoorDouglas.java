package douglasForest.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.client.model.ModelLoader;

public class ItemDoorDouglas extends ItemDoor{

	public ItemDoorDouglas(Block block) {
		super(block);
		setRegistryName(block.getRegistryName());
		setUnlocalizedName(getRegistryName().toString());
	}
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
}
