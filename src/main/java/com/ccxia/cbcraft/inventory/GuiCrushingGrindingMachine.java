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
public class GuiCrushingGrindingMachine extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(CbCraft.MODID,
			"textures/gui/container/crushing_grinding_machine.png");

	public GuiCrushingGrindingMachine(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		this.inventorySlots = inventorySlotsIn;
		this.xSize = 176;
		this.ySize = 133;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
		int loadTime = ((ContainerCrushingGrindingMachine) this.inventorySlots).getLoadTime();
		this.drawTexturedModalRect(offsetX + 77, offsetY + 20, 176, 3, 24 * loadTime / 200, 17);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = I18n.format("container." + CbCraft.MODID + ".crushing_grinding_machine");
		this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
}
