package com.mrcrayfish.goblintraders.client.renderer.entity;

import com.jonnygrove.backports.MatrixStack;
import com.jonnygrove.backports.Quaternion;
import com.mrcrayfish.goblintraders.client.renderer.entity.model.GoblinTraderModel;
import com.mrcrayfish.goblintraders.entity.AbstractGoblinEntity;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;

/**
 * Author: MrCrayfish
 */
public class GoblinTraderRenderer extends MobRenderer<AbstractGoblinEntity, GoblinTraderModel>
{
	
    public GoblinTraderRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new GoblinTraderModel(), 0.5F);
        this.addLayer(new HeldItemLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(AbstractGoblinEntity entity)
    {
        return entity.getTexture();
    }
    
    public void doRender(AbstractGoblinEntity entity, float f1, float partialTicks, MatrixStack matrixStack, IRenderHandler renderTypeBuffer, int light)
    {
        matrixStack.push();
        if(entity.getDataManager().get(AbstractGoblinEntity.STUNNED))
        {
            float progress = Math.min(10F, entity.getFallCounter() + partialTicks) / 10F;
            matrixStack.rotate(func_229187_a_(90F * progress));
            matrixStack.translate(0, -0.5 * progress, 0);
        }
        //super.render(entity, f1, partialTicks, matrixStack, renderTypeBuffer, light);
        super.doRender(entity, 0, 0, 0, 0, partialTicks);
        matrixStack.pop();
    }
    public static Vector3f field_229179_b_ = new Vector3f(1.0F, 0.0F, 0.0F);
    public Quaternion func_229187_a_(float p_229187_1_) {
        return new Quaternion(field_229179_b_, p_229187_1_, true);
     }
}
