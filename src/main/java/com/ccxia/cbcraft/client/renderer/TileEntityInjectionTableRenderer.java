package com.ccxia.cbcraft.client.renderer;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.client.model.ModelCake;
import com.ccxia.cbcraft.tileentity.TileEntityInjectionTable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class TileEntityInjectionTableRenderer extends TileEntitySpecialRenderer<TileEntityInjectionTable> {
    private static final ResourceLocation TEXTURE_CAKE = new ResourceLocation(
            CbCraft.MODID + ":textures/entity/injection_table_cake.png");
    private final ModelCake modelCake = new ModelCake();


    public void render(TileEntityInjectionTable te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();

        //��ת�����¸���Ч��
        GlStateManager.translate((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
        GlStateManager.translate(0.0F, 0.2F + MathHelper.sin((te.tickCount + partialTicks) / 7) / 10, 0.0F);
        GlStateManager.rotate(te.tickCount + partialTicks, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);

        this.bindTexture(TEXTURE_CAKE);
        GlStateManager.enableCull();
        //��������
        this.modelCake.render(null, 0, 0, 0, 0, 0, 0.03125F);

        GlStateManager.popMatrix();
    }
}
