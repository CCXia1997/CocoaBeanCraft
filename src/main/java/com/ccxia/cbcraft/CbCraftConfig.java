package com.ccxia.cbcraft;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = CbCraft.MODID)
@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class CbCraftConfig {
    private final static String config = "cbcraft.config.";

    // �ɿɽ���������������
    @Config.LangKey(config + "cocoa_metal_ore_weight")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 1, max = 100)
    @Config.Comment("Changes generate rate of cocoa_metal_ore.Increase value to gen more ore")
    public static int cocoa_metal_ore_weight = 20;

    // �ɿɾ�ʯ������������
    @Config.LangKey(config + "cocoa_spar_ore_weight")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 1, max = 10)
    @Config.Comment("Changes generate rate of cocoa_spar_ore.Increase value to gen more ore")
    public static int cocoa_spar_ore_weight = 1;

    // ������ɽ��Ⱥϵ�пɿɾ�ʯ������������
    @Config.LangKey(config + "cocoa_spar_ore_weight_brownie")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 1, max = 20)
    @Config.Comment("Changes generate rate of cocoa_spar_ore in Brownie Hill.Increase value to gen more ore")
    public static int cocoa_spar_ore_weight_brownie = 4;

    // �����ɿ�����ľ������
    @Config.LangKey(config + "hollow_tree_amount")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 10)
    @Config.Comment("Changes generate rate of hollow_chocolate_tree")
    public static int hollow_tree_amount = 0;

    // �����ɿ�����ľ��������
    @Config.LangKey(config + "horizontal_tree_amount")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 10)
    @Config.Comment("Changes generate rate of horizontal_chocolate_tree")
    public static int horizontal_tree_amount = 0;

    // �����ɿ�����ľ��������
    @Config.LangKey(config + "vertical_tree_amount")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 10)
    @Config.Comment("Changes generate rate of vertical_chocolate_tree")
    public static int vertical_tree_amount = 0;

    // б���ɿ�����ľ��������
    @Config.LangKey(config + "twill_tree_amount")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 100)
    @Config.Comment("Changes generate rate of twill_chocolate_tree")
    public static int twill_tree_amount = 50;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(CbCraft.MODID)) {
            ConfigManager.sync(CbCraft.MODID, Config.Type.INSTANCE);
        }
    }

}
