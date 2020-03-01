package com.mrcrayfish.goblintraders.entity;

import com.mrcrayfish.goblintraders.Reference;
import com.mrcrayfish.goblintraders.init.ModEntities;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffers;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish
 */
public class VeinGoblinTraderEntity extends AbstractGoblinEntity
{
    public VeinGoblinTraderEntity(World worldIn)
    {
        super(ModEntities.VEIN_GOBLIN_TRADER, worldIn);
    }

    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/vein_goblin_trader.png");
    }

    @Override
    protected void populateTradeData()
    {
        MerchantOffers offers = this.getOffers();
        this.addTrades(offers, GoblinTrades.VEIN_GOBLIN_TRADER.get(BASE_TRADES), Math.max(4, this.rand.nextInt(6) + 1));
        this.addTrades(offers, GoblinTrades.VEIN_GOBLIN_TRADER.get(RARE_TRADES), Math.max(2, this.rand.nextInt(3) + 1));
    }

    @Override
    public ItemStack getFavouriteFood()
    {
        return new ItemStack(Items.CARROT);
    }

    @Override
    public void livingTick()
    {
        super.livingTick();
        if(this.world.isRemote && this.ticksExisted % 2 == 0)
        {
            if(this.getPosition().getX() != this.prevPosX || this.getPosition().getY() != this.prevPosY || this.getPosition().getZ() != this.prevPosZ)
            {
                //this.world.addParticle(ParticleTypes.FLAME, this.getPosX() - 0.1 + 0.2 * this.rand.nextDouble(), this.getPosY() + 0.25 - 0.1 + 0.2 * this.rand.nextDouble(), this.getPosZ() - 0.1 + 0.2 * this.rand.nextDouble(), 0, 0, 0);
            }
            this.world.addParticle(ParticleTypes.FLAME, this.getPosition().getX() - 0.5 + 1.0 * this.rand.nextDouble(), this.getPosition().getY() + 0.5 - 0.5 + 1.0 * this.rand.nextDouble(), this.getPosition().getZ() - 0.5 + 1.0 * this.rand.nextDouble(), 0, 0, 0);
        }
        
    }

	@Override
	public void func_213703_a(MerchantOffers p_213703_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func_213702_q(int p_213702_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SoundEvent func_213714_ea() {
		// TODO Auto-generated method stub
		return null;
	}
}
