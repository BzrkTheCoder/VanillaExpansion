package vanillaexpansion.bzrkthecoder.tk;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="VanillaExpansion", name="Vanilla Expansion", version="0.0.5.2", dependencies="required-after:Forge@[9.11.1.953]")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Main {	
	
        @Instance("Main")
        public static Main instance;
        
        //Ore Manager
        EventManager oreManager  = new EventManager();
        
        //Limestone
        public final static Block limestone = new Block(798, Material.rock).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("limestone").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:limestone");
        public final static Item limestoneFragment = new Item(799).setUnlocalizedName("limestoneFragment").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:limestoneFragment");
        
        //Copper
        public final static Block copperOre = new Block(800, Material.rock).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("copperOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:copperOre");
        public final static Block copperBlock = new Block(801, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("copperBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:copperBlock");
        public final static Item copperIngot = new Item(802).setUnlocalizedName("copperIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:copperIngot");
        
        //Tin
        
        public final static Block tinOre = new Block(803, Material.rock).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("tinOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:tinOre");
        public final static Block tinBlock = new Block(804, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("tinBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:tinBlock");
        public final static Item tinIngot = new Item(805).setUnlocalizedName("tinIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:tinIngot");
        
        //Bronze
        public final static Block bronzeBlock = new Block(806, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("bronzeBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:bronzeBlock");
        public final static Item bronzeIngot = new Item(807).setUnlocalizedName("bronzeIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:bronzeIngot");   
        
        //Silver
        public final static Block silverOre = new Block(808, Material.rock).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("silverOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:silverOre");
        public final static Block silverBlock = new Block(809, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("silverBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:bronzeBlock");
        public final static Item silverIngot = new Item(810).setUnlocalizedName("silverIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:silverIngot");
        
        //Manganese
        public final static Block manganeseOre = new Block(811, Material.rock).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("manganeseOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:manganeseOre");
        public final static Block manganeseBlock = new Block(812, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("manganeseBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:manganeseBlock");
        public final static Item manganeseIngot = new Item(813).setUnlocalizedName("manganeseIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:manganeseIngot");
        
        //Lead
        public final static Block leadOre = new Block(814, Material.rock).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("leadOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:leadOre");
        public final static Block leadBlock = new Block(815, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("leadBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:leadBlock");
        public final static Item leadIngot = new Item(816).setUnlocalizedName("leadIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:leadIngot");
        
        //Platinum
        public final static Block platinumOre = new Block(817, Material.rock).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("platinumOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:platinumOre");
        public final static Block platinumBlock = new Block(818, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("platinumBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:platinumBlock");
        public final static Item platinumIngot = new Item(819).setUnlocalizedName("platinumIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:platinumIngot");
        
        //Reforce
        public final static Block reforceOre = new Block(820, Material.rock).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("reforceOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:reforceOre");
        public final static Block reforceBlock = new Block(821, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("reforceBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("main:reforceBlock");
        public final static Item reforceIngot = new Item(822).setUnlocalizedName("reforceIngot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("main:reforceIngot");
        
        @SidedProxy(clientSide="vanillaexpansion.bzrkthecoder.tk.client.ClientProxy", serverSide="vanillaexpansion.bzrkthecoder.tk.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //Item Stacks             
                ItemStack ciStack = new ItemStack(Main.copperIngot);
                ItemStack tiStack = new ItemStack(Main.tinIngot);
                ItemStack biStack = new ItemStack(Main.bronzeIngot);
                ItemStack siStack = new ItemStack(Main.silverIngot);
                ItemStack miStack = new ItemStack(Main.manganeseIngot);
                ItemStack liStack = new ItemStack(Main.leadIngot);
                ItemStack piStack = new ItemStack(Main.platinumIngot);
                ItemStack li2Stack = new ItemStack(Main.limestoneFragment, 4);
                ItemStack li3Stack = new ItemStack(Main.limestone);
                
                //Crafting
                GameRegistry.addRecipe(biStack, "yy ", "yx ",'y', tiStack, 'x', ciStack);
                GameRegistry.addRecipe(li3Stack, "yy ", "yy ",'y', li2Stack);
                
                //Registry
                
                //Ores
                GameRegistry.registerBlock(copperOre, "copperOre");
                LanguageRegistry.addName(copperOre, "Copper Ore");
                MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", 1);
                
                GameRegistry.registerBlock(tinOre, "tinOre");
                LanguageRegistry.addName(tinOre, "Tin Ore");
                MinecraftForge.setBlockHarvestLevel(tinOre, "pickaxe", 2);
                
                GameRegistry.registerBlock(silverOre, "silverOre");
                LanguageRegistry.addName(silverOre, "Silver Ore");
                MinecraftForge.setBlockHarvestLevel(silverOre, "pickaxe", 2);
                
                GameRegistry.registerBlock(manganeseOre, "manganeseOre");
                LanguageRegistry.addName(manganeseOre, "Manganese Ore");
                MinecraftForge.setBlockHarvestLevel(manganeseOre, "pickaxe", 2);
                
                GameRegistry.registerBlock(leadOre, "leadOre");
                LanguageRegistry.addName(leadOre, "Lead Ore");
                MinecraftForge.setBlockHarvestLevel(leadOre, "pickaxe", 2);
                
                GameRegistry.registerBlock(platinumOre, "platinumOre");
                LanguageRegistry.addName(platinumOre, "Platinum Ore");
                MinecraftForge.setBlockHarvestLevel(platinumOre, "pickaxe", 3);
                
                GameRegistry.registerBlock(reforceOre, "reforceOre");
                LanguageRegistry.addName(reforceOre, "Reforce Ore");
                MinecraftForge.setBlockHarvestLevel(reforceOre, "pickaxe", 2);
                
                //Ingots
                GameRegistry.registerItem(copperIngot, "copperIngot");
                LanguageRegistry.addName(copperIngot, "Copper Ingot");
                
                GameRegistry.registerItem(tinIngot, "tinIngot");
                LanguageRegistry.addName(tinIngot, "Tin Ingot");

                GameRegistry.registerItem(bronzeIngot, "bronzeIngot");
                LanguageRegistry.addName(bronzeIngot, "Bronze Ingot");
                
                GameRegistry.registerItem(silverIngot, "silverIngot");
                LanguageRegistry.addName(silverIngot, "Silver Ingot");
                
                GameRegistry.registerItem(manganeseIngot, "manganeseIngot");
                LanguageRegistry.addName(manganeseIngot, "Manganese Ingot");
               
                GameRegistry.registerItem(leadIngot, "leadIngot");
                LanguageRegistry.addName(leadIngot, "Lead Ingot");
                
                GameRegistry.registerItem(platinumIngot, "platinumIngot");
                LanguageRegistry.addName(platinumIngot, "Platinum Ingot");
                
                GameRegistry.registerItem(reforceIngot, "reforceIngot");
                LanguageRegistry.addName(reforceIngot, "Reforce Ingot");
                
                GameRegistry.registerItem(limestoneFragment, "limestoneFragment");
                LanguageRegistry.addName(limestoneFragment, "Limestone Fragment");
                
                //Blocks
                GameRegistry.registerBlock(copperBlock, "copperBlock");
                LanguageRegistry.addName(copperBlock, "Block Of Copper");
                MinecraftForge.setBlockHarvestLevel(copperBlock, "pickaxe", 2);
                
                GameRegistry.registerBlock(tinBlock, "tinBlock");
                LanguageRegistry.addName(tinBlock, "Block Of Tin");
                MinecraftForge.setBlockHarvestLevel(tinBlock, "pickaxe", 2);
                
                GameRegistry.registerBlock(bronzeBlock, "bronzeBlock");
                LanguageRegistry.addName(bronzeBlock, "Block of Bronze");
                MinecraftForge.setBlockHarvestLevel(bronzeBlock, "pickaxe", 2);
                
                GameRegistry.registerBlock(silverBlock, "silverBlock");
                LanguageRegistry.addName(silverBlock, "Block of Silver");
                MinecraftForge.setBlockHarvestLevel(silverBlock, "pickaxe", 2);
                
                GameRegistry.registerBlock(manganeseBlock, "manganeseBlock");
                LanguageRegistry.addName(manganeseBlock, "Block of Manganese");
                MinecraftForge.setBlockHarvestLevel(manganeseBlock, "pickaxe", 2);
                
                GameRegistry.registerBlock(leadBlock, "leadBlock");
                LanguageRegistry.addName(leadBlock, "Block of Lead");
                MinecraftForge.setBlockHarvestLevel(leadBlock, "pickaxe", 2);

                GameRegistry.registerBlock(platinumBlock, "platinumBlock");
                LanguageRegistry.addName(platinumBlock, "Block of Platinum");
                MinecraftForge.setBlockHarvestLevel(platinumBlock, "pickaxe", 3);
                
                GameRegistry.registerBlock(reforceBlock, "reforceBlock");
                LanguageRegistry.addName(reforceBlock, "Block of reforce");
                MinecraftForge.setBlockHarvestLevel(reforceBlock, "pickaxe", 2);
                
                GameRegistry.registerBlock(limestone, "limestone");
                LanguageRegistry.addName(limestone, "Limestone");
                MinecraftForge.setBlockHarvestLevel(limestone, "pickaxe", 1);
                
                //Smelting
                GameRegistry.addSmelting(Main.copperOre.blockID, ciStack, 1.0F);
                GameRegistry.addSmelting(Main.tinOre.blockID, tiStack, 1.5F);
                GameRegistry.addSmelting(Main.silverOre.blockID, siStack, 2.0F);
                GameRegistry.addSmelting(Main.manganeseOre.blockID, miStack, 1.5F);
                GameRegistry.addSmelting(Main.leadOre.blockID, liStack, 1.5F);
                GameRegistry.addSmelting(Main.platinumOre.blockID, piStack, 2.5F);
                GameRegistry.addSmelting(Main.limestone.blockID, li2Stack, 0.5F);
                
                //Generation
                GameRegistry.registerWorldGenerator(oreManager);
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
       
}
