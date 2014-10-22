package vanillaexpansion.bzrkthecoder.tk;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class EventManager implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
		
		}

		
	}
	private void generateEnd(World world, Random random, int x, int z) {
			
	}
    private void generateSurface(World world, Random random, int x, int z) {
    	this.addOreSpawn(Main.copperOre, world, random, x, z, 16, 16, 4+random.nextInt(12), 8, 40, 80);
    	this.addOreSpawn(Main.tinOre, world, random, x, z, 16, 16, 4+random.nextInt(10), 2, 15, 50);
    	this.addOreSpawn(Main.silverOre, world, random, x, z, 16, 16, 4+random.nextInt(8), 3, 10, 45);
    	this.addOreSpawn(Main.manganeseOre, world, random, x, z, 16, 16, 4+random.nextInt(10), 7, 7, 60);
    	this.addOreSpawn(Main.leadOre, world, random, x, z, 16, 16, 4+random.nextInt(11), 5, 15, 75);
    	this.addOreSpawn(Main.platinumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 5, 8, 35);
    	this.addOreSpawn(Main.limestone, world, random, x, z, 16, 16, 4+random.nextInt(20), 19, 16, 96);
		
	}
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(20);
		int Ycoord = 10 + random.nextInt(128);
		int Zcoord = z + random.nextInt(20);
		//(new WorldGenNetherMineable(Main.compoundOreN.blockID, 30, 1)).generate(world, random, Xcoord, Ycoord, Zcoord);
		
	}
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
          int maxPossY = minY + (maxY - 1);
          assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
          assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
          assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
          assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
          assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
         
          int diffBtwnMinMaxY = maxY - minY;
          for(int x = 0; x < chancesToSpawn; x++)
          {
                 int posX = blockXPos + random.nextInt(maxX);
                 int posY = minY + random.nextInt(diffBtwnMinMaxY);
                 int posZ = blockZPos + random.nextInt(maxZ);
                 (new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
          }
    }
}
