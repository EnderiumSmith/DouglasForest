package douglasForest.block;

import java.util.Random;

import douglasForest.EventsHandler;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockDouglasDoor extends BlockDoor{

	public String name;
	public BlockDouglasDoor(String name) {
		super(Material.WOOD);
		this.name=name;
		setSoundType(SoundType.WOOD);
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(2F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(state.getValue(BlockDoor.HALF)==BlockDoor.EnumDoorHalf.UPPER)
			return Items.AIR;
		if(name.equals("door_douglas"))
			return EventsHandler.door_item;
		else
			return EventsHandler.maple_door_item;
	}

}
