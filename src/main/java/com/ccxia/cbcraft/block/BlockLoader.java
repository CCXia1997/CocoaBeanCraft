package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.OreDictLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class BlockLoader {
	private static Block darkBrick = new BlockDarkBrick();
	private static Block dark = new BlockDarkChocolate();
	private static Block milkBrick = new BlockMilkBrick();
	private static Block milk = new BlockMilkChocolate();
	private static Block whiteBrick = new BlockWhiteBrick();
	private static Block white = new BlockWhiteChocolate();

	public static Block[] blocks = { new BlockFermentationBaker(false), new BlockFermentationBaker(true),
			new BlockCrushingGrindingMachine(), new BlockSeparator(false), new BlockSeparator(true), dark, milk, white,
			new BlockChocolateCake(), new BlockDarkMilk(), new BlockMilkWhite(), new BlockWhiteDark(),
			new BlockDarkCarved(), new BlockDarkPillar(), new BlockDarkSmooth(), new BlockMilkCarved(),
			new BlockMilkPillar(), new BlockMilkSmooth(), new BlockWhiteCarved(), new BlockWhitePillar(),
			new BlockWhiteSmooth(), new BlockAutoCrushing(),
			(new BlockDarkChocolateSlab.Half().setIndex(0)).setUnlocalizedName(CbCraft.MODID + ".darkChocolateSlab")
					.setRegistryName("dark_chocolate_slab").setCreativeTab(CreativeTabsCbCraft.tabCbCraft),
			(new BlockDarkChocolateSlab.Double().setIndex(1)).setUnlocalizedName(CbCraft.MODID + ".darkChocolateSlab")
					.setRegistryName("dark_chocolate_double_slab"),
			(new BlockDarkChocolateSlab.Half().setIndex(2)).setUnlocalizedName(CbCraft.MODID + ".milkChocolateSlab")
					.setRegistryName("milk_chocolate_slab").setCreativeTab(CreativeTabsCbCraft.tabCbCraft),
			(new BlockDarkChocolateSlab.Double().setIndex(3)).setUnlocalizedName(CbCraft.MODID + ".milkChocolateSlab")
					.setRegistryName("milk_chocolate_double_slab"),
			(new BlockDarkChocolateSlab.Half().setIndex(4)).setUnlocalizedName(CbCraft.MODID + ".whiteChocolateSlab")
					.setRegistryName("white_chocolate_slab").setCreativeTab(CreativeTabsCbCraft.tabCbCraft),
			(new BlockDarkChocolateSlab.Double().setIndex(5)).setUnlocalizedName(CbCraft.MODID + ".whiteChocolateSlab")
					.setRegistryName("white_chocolate_double_slab"),
			new BlockInjectionTable(), new BlockInjectedDark(), new BlockInjectedWhite(), new BlockInjectedMilk(),
			darkBrick,
			new BlockChocolateWall(darkBrick).setUnlocalizedName(CbCraft.MODID + ".darkChocolateWall")
					.setRegistryName("dark_chocolate_wall"),
			new BlockChocolateStairs(dark.getDefaultState()).setUnlocalizedName(CbCraft.MODID + ".darkChocolateStairs")
					.setRegistryName("dark_chocolate_stairs"),
			new BlockChocolateFence(darkBrick).setUnlocalizedName(CbCraft.MODID + ".darkChocolateFence")
					.setRegistryName("dark_chocolate_fence"),
			new BlockChocolateFenceGate(darkBrick).setUnlocalizedName(CbCraft.MODID + ".darkChocolateFenceGate")
					.setRegistryName("dark_chocolate_fence_gate"),
			milkBrick,
			new BlockChocolateWall(milkBrick).setUnlocalizedName(CbCraft.MODID + ".milkChocolateWall")
					.setRegistryName("milk_chocolate_wall"),
			new BlockChocolateStairs(milk.getDefaultState()).setUnlocalizedName(CbCraft.MODID + ".milkChocolateStairs")
					.setRegistryName("milk_chocolate_stairs"),
			new BlockChocolateFence(milkBrick).setUnlocalizedName(CbCraft.MODID + ".milkChocolateFence")
					.setRegistryName("milk_chocolate_fence"),
			new BlockChocolateFenceGate(milkBrick).setUnlocalizedName(CbCraft.MODID + ".milkChocolateFenceGate")
					.setRegistryName("milk_chocolate_fence_gate"),
			whiteBrick,
			new BlockChocolateWall(whiteBrick).setUnlocalizedName(CbCraft.MODID + ".whiteChocolateWall")
					.setRegistryName("white_chocolate_wall"),
			new BlockChocolateStairs(white.getDefaultState())
					.setUnlocalizedName(CbCraft.MODID + ".whiteChocolateStairs")
					.setRegistryName("white_chocolate_stairs"),
			new BlockChocolateFence(whiteBrick).setUnlocalizedName(CbCraft.MODID + ".whiteChocolateFence")
					.setRegistryName("white_chocolate_fence"),
			new BlockChocolateFenceGate(whiteBrick).setUnlocalizedName(CbCraft.MODID + ".whiteChocolateFenceGate")
					.setRegistryName("white_chocolate_fence_gate"),
			new BlockAutoPressing(), new BlockCocoaSparOre(),new BlockCocoaSparBlock() };

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		for (Block block : blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
					new ModelResourceLocation(block.getRegistryName(), "inventory"));
			event.getRegistry().register(block);
		}
	}

	public static Block getByName(String name) {
		for (Block block : blocks)
			if (block.getUnlocalizedName().equals(name))
				return block;
		return Blocks.AIR;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (Block block : blocks) {
			Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
			if (block instanceof BlockChocolateCake) {
				itemBlock.setMaxStackSize(1);
			}
			if (block.getRegistryName().toString().equals(CbCraft.MODID + ":dark_chocolate_slab")
					|| block.getRegistryName().toString().equals(CbCraft.MODID + ":dark_chocolate_double_slab")) {
				itemBlock = new ItemSlab(block, (BlockSlab) blocks[22], (BlockSlab) blocks[23])
						.setRegistryName(block.getRegistryName());
			}
			if (block.getRegistryName().toString().equals(CbCraft.MODID + ":milk_chocolate_slab")
					|| block.getRegistryName().toString().equals(CbCraft.MODID + ":milk_chocolate_double_slab")) {
				itemBlock = new ItemSlab(block, (BlockSlab) blocks[24], (BlockSlab) blocks[25])
						.setRegistryName(block.getRegistryName());
			}
			if (block.getRegistryName().toString().equals(CbCraft.MODID + ":white_chocolate_slab")
					|| block.getRegistryName().toString().equals(CbCraft.MODID + ":white_chocolate_double_slab")) {
				itemBlock = new ItemSlab(block, (BlockSlab) blocks[26], (BlockSlab) blocks[27])
						.setRegistryName(block.getRegistryName());
			}
			ModelLoader.setCustomModelResourceLocation(itemBlock, 0,
					new ModelResourceLocation(block.getRegistryName(), "inventory"));
			event.getRegistry().register(itemBlock);
		}

		new OreDictLoader();
	}

}
