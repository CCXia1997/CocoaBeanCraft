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
public class GuiSeparator extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(CbCraft.MODID,
			"textures/gui/container/separator.png");

	public GuiSeparator(Container inventorySlotsIn) {
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
		int k = this.getBurnLeftScaled(13);// 管理火焰材质
		int l = this.getCookProgressScaled(24);// 管理进度条材质
		// 管理火焰材质，这段要加上燃烧判定，不然材质上会出现一丝火焰
		if (((ContainerSeparator) this.inventorySlots).getTime(0) > 0)
			this.drawTexturedModalRect(offsetX + 56, offsetY + 48 - k, 176, 12 - k, 14, k + 1);
		// 管理进度条材质
		this.drawTexturedModalRect(offsetX + 79, offsetY + 34, 176, 14, 1 + l, 16);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = I18n.format("container." + CbCraft.MODID + ".separator");
		this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	private int getCookProgressScaled(int pixels) {
		int i = ((ContainerSeparator) this.inventorySlots).getTime(2);
		int j = ((ContainerSeparator) this.inventorySlots).getTime(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}

	private int getBurnLeftScaled(int pixels) {
		int i = ((ContainerSeparator) this.inventorySlots).getTime(1);
		if (i == 0) {
			i = 200;
		}
		return ((ContainerSeparator) this.inventorySlots).getTime(0) * pixels / i;
	}
}
