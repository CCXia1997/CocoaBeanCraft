package com.ccxia.cbcraft;

import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.common.CommonProxy;
import com.ccxia.cbcraft.item.ModItems;
import com.ccxia.cbcraft.world.WorldProviderCocoa;
import com.ccxia.cbcraft.world.WorldTypeCocoa;

import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = CbCraft.MODID, name = CbCraft.NAME, version = CbCraft.VERSION, acceptedMinecraftVersions = "1.12.2")
public class CbCraft {
	public static final String MODID = "cbcraft";
	public static final String NAME = "Cocoa Magic";
	public static final String VERSION = "1.0.8";
	// 新维度
	public static int dimID = 233;
	public static DimensionType myDim;
	@SidedProxy(clientSide = "com.ccxia.cbcraft.client.ClientProxy", serverSide = "com.ccxia.cbcraft.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance(CbCraft.MODID)
	public static CbCraft instance;

	/** 全局Logger测试用 **/
	public static final Logger LOGGER = LogManager.getLogger();

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		// 新维度配置
		myDim = DimensionType.register("cocoa_world", "cocoa_world", dimID, WorldProviderCocoa.class, false);
		DimensionManager.registerDimension(dimID, myDim);
		new WorldTypeCocoa();
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
		GameRegistry.addSmelting(new ItemStack(ModItems.COCOA_PASTE), new ItemStack(ModItems.COCOA_LIQUOR), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.COCOA_METAL_ORE), new ItemStack(ModItems.COCOA_METAL_INGOT),
				1.0F);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
