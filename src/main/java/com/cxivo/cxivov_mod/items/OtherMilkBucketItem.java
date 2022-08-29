package com.cxivo.cxivov_mod.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;

public class OtherMilkBucketItem extends MilkBucketItem {
    public OtherMilkBucketItem(Properties properties) {
        super(properties);
    }

    // stolen from MilkBucketItem
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) entity.curePotionEffects(Items.MILK_BUCKET.getDefaultInstance()); // FORGE - move up so stack.shrink does not turn stack into air
        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }

}
