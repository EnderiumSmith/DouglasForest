package douglasForest;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenDouglasFir extends WorldGenAbstractTree{

	public WorldGenDouglasFir() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int h=rand.nextInt(10)+10;
		if(rand.nextInt(20)==0)
			h+=rand.nextInt(10);
		if(pos.getY()<1||pos.getY()+h+1>256)
			return false;
		boolean ok=true;
		for(int i=pos.getY();i<=pos.getY()+h+1;i++){
			int aux=1;
			if(i==pos.getY())
				aux=0;
			if(i>=(pos.getY()+h+1)-2)
				aux=2;
			for(int j=pos.getX()-aux;j<=pos.getX()+aux&&ok;j++){
				for(int k=pos.getZ()-aux;k<=pos.getZ()+aux&&ok;k++){
					if(i>=0&&i<256){
						IBlockState block=world.getBlockState(new BlockPos(j, i, k));
						if(!block.getBlock().isAir(block, world, new BlockPos(j, i, k))&&
								!block.getBlock().isReplaceable(world, new BlockPos(j, i, k))){
							ok=false;
						}
					}else
						ok=false;
				}
			}
		}
		if(!ok)
			return false;
		if(!world.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock().canSustainPlant(world.getBlockState(pos.offset(EnumFacing.DOWN)), world, pos, EnumFacing.UP, EventsHandler.sapling))
			return false;
		for(int i=pos.getY()+(h/3)-1;i<=pos.getY()+h-1;i++){
			int aux1=i-(pos.getY()+h);
			int aux2=h;
			if(h>20)
				aux2=20;
			int aux3=aux2/10+1;
			if(i-pos.getY()>h/2||i-pos.getY()-(h/3)+2<3){
				aux3--;
			}
			if(pos.getY()+h-i<4){
				aux3=1;
			}
			for(int j=pos.getX()-aux3;j<=pos.getX()+aux3;j++){
				int aux4=j-pos.getX();
				for(int k=pos.getZ()-aux3;k<=pos.getZ()+aux3;k++){
					int aux5=aux4-pos.getZ();
					if((Math.abs(aux4)!=0||Math.abs(aux5)!=0&&aux1!=0)&&
							(Math.abs(aux4)+Math.abs(aux5)!=aux3*2||
							i-pos.getY()>h/2&&i-pos.getY()<(4*h/5)||
							i-pos.getY()-(h/3)+2==2)&&
							rand.nextInt(12)!=0&&world.isAirBlock(new BlockPos(j, i, k))){
						world.setBlockState(new BlockPos(j, i, k), EventsHandler.leaf.getDefaultState());
					}
				}
			}
		}
		world.setBlockState(pos.offset(EnumFacing.UP, h), EventsHandler.leaf.getDefaultState());
		for(int i=0;i<h;i++){
			world.setBlockState(pos.offset(EnumFacing.UP, i), EventsHandler.log.getDefaultState());
		}
		return true;
	}
	
}
