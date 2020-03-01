package com.mrcrayfish.goblintraders.entity;

import com.mrcrayfish.goblintraders.Reference;
import com.mrcrayfish.goblintraders.init.ModEntities;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffers;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish
 */
public class GoblinTraderEntity extends AbstractGoblinEntity
{
    public GoblinTraderEntity(World worldIn)
    {
        super(ModEntities.GOBLIN_TRADER, worldIn);
    }

    @Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/goblin_trader.png");
    }

    @Override
    protected void populateTradeData()
    {
        MerchantOffers offers = this.getOffers();
        this.addTrades(offers, GoblinTrades.GOBLIN_TRADER.get(BASE_TRADES), Math.max(4, this.rand.nextInt(6) + 1));
        this.addTrades(offers, GoblinTrades.GOBLIN_TRADER.get(RARE_TRADES), Math.max(2, this.rand.nextInt(3) + 1));
    }

    @Override
    public ItemStack getFavouriteFood()
    {
        return new ItemStack(Items.APPLE);
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
