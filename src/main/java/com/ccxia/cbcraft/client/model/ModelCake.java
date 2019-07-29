package com.ccxia.cbcraft.client.model;
// Cubik Studio 2.9.480 Beta JAVA exporter
// Designed by XeKr with Cubik Studio - https://cubik.studio

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCake extends ModelBase {

    public ModelRenderer cake;

    public ModelCake() {

        cake = new ModelRenderer(this, 0, 0);
        cake.setRotationPoint(-8F, -4F, -8F);
        cake.addBox(0F, 0F, 0F, 16, 8, 16);
        cake.setTextureSize(64, 64);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        cake.render(f5);
    }
}