package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.CbCraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

public class GuiInjectionTable extends GuiContainer {
    private final ResourceLocation TEXTURE = new ResourceLocation(CbCraft.MODID,
            "textures/gui/container/injection_table.png");
    private final ContainerInjectionTable container;

    public GuiInjectionTable(ContainerInjectionTable container) {
        super(container);
        this.container = container;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String title = I18n.format("container." + CbCraft.MODID + ".injection_table");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
        if (container.cost > -1) {
            String costInfo = I18n.format("container." + CbCraft.MODID + ".injection_table.cost", container.cost);
            this.fontRenderer.drawString(costInfo, (this.xSize - this.fontRenderer.getStringWidth(costInfo)) / 2, 44,
                        (container.notEnoughPowder || container.notEnoughLevels) ? 0xFF6060 : 0x80FF20);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    private void draw3dString(String str, int x, int y, int colorBack, int colorFore) {
        this.fontRenderer.drawString(str, x, y + 1, colorBack);
        this.fontRenderer.drawString(str, x + 1, y, colorBack);
        this.fontRenderer.drawString(str, x + 1, y + 1, colorBack);
        this.fontRenderer.drawString(str, x, y, colorFore);
    }
}
