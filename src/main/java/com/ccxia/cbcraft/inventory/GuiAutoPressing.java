package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiAutoPressing extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(CbCraft.MODID,
			"textures/gui/container/auto_pressing_machine.png");

	public GuiAutoPressing(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		this.inventorySlots = inventorySlotsIn;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
		int k = ((ContainerAutoPressing) this.inventorySlots).getCocoaPower() * 50 / 1000;
		this.drawTexturedModalRect(offsetX + 15, offsetY + 69 - k, 176, 51 - k, 17, k + 1);
		int k1 = ((ContainerAutoPressing) this.inventorySlots).getPressTime();
		this.drawTexturedModalRect(offsetX + 103, offsetY + 53, 176, 52, 24 * k1 / 8, 17);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = I18n.format("container." + CbCraft.MODID + ".auto_pressing_machine");
		this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
}
