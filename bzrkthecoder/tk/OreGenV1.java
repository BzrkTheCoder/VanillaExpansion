package vanillaexpansion.bzrkthecoder.tk;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class OreGenV1 extends Block {

	public OreGenV1(int id, Material material) {
		super(id, material);
	}
	
	public int idDropped(int metadata, Random random, int fortune) {
		return Main.copperOre.blockID;
	}
	public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7) {
		
		super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);
		
		if(this.idDropped(par5, world.rand, par7) != this.blockID) {
			
			int xp = 0;
			xp = MathHelper.getRandomIntegerInRange(world.rand, 2, 25);
			
			this.dropXpOnBlockBreak(world, par2, par3, par4, xp);
		}
	}
}
