package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class ItemLoader {

	public static Item[] items = { new ItemFlour(), new ItemDough(), new ItemEggMilkDough(), new ItemCookedCocoa(),
			new ItemCocoaPaste(), new ItemSkimMilk(), new ItemCheese(), new ItemYogurt(), new ItemCocoaBread(),
			new ItemCookieDough(), new ItemCocoaPowder(), new ItemCocoaLiquor(), new ItemCocoaButter(), new ItemCream(),
			new ItemDarkChocolate(), new ItemMilkChocolate(), new ItemWhiteChocolate(), new ItemCocoaCream(),
			new ItemHotChocolate(), new ItemPressingMachineCore(), new ItemPurpleGem(), new ItemPackedMilk(),
			new ItemInjectedIronIngot(), new ItemCocoaSpar(), new ItemInjectedGoldIngot(), new ItemInjectedCocoaSpar(),
			new ItemCocoaMetalIngot(), new ItemCocoaAllovIngot(), new ItemCocoaMetalSword(), new ItemCocoaMetalAxe(),
			new ItemCocoaMetalPickaxe(), new ItemCocoaMetalShovel(), new ItemCocoaMetalHoe(),
			new ItemCocoaMetalHelmet(), new ItemCocoaMetalChestplate(), new ItemCocoaMetalLeggings(),
			new ItemCocoaMetalBoots() };

	public static Item getByName(String name) {
		for (Item item : items)
			if (item.getUnlocalizedName().equals(name))
				return item;
		return Items.AIR;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (Item item : items) {
			ModelLoader.setCustomModelResourceLocation(item, 0,
					new ModelResourceLocation(item.getRegistryName(), "inventory"));
			event.getRegistry().register(item);
		}
	}
}
