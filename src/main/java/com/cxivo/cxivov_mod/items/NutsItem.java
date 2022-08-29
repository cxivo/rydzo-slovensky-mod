package com.cxivo.cxivov_mod.items;

import com.cxivo.cxivov_mod.init.ItemInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import java.util.Collections;

public class NutsItem extends Item {

    private final int nuts;

    public NutsItem(Item.Properties properties, int nuts) {
        super(properties);
        if (nuts > 3) {
            nuts = 3;
        } else if (nuts < 0) {
            nuts = 0;
        }
        this.nuts = nuts;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack newItem, toDrop = null;
        switch (nuts) {
            case 3:
                player.getItemInHand(hand).shrink(1);
                newItem = ItemInit.TWO_HAZELNUTS.get().getDefaultInstance();
                player.setItemInHand(hand, newItem);

                toDrop = DyeableLeatherItem.dyeArmor(Items.LEATHER_BOOTS.getDefaultInstance(), Collections.singletonList((DyeItem) Items.WHITE_DYE));
                player.drop(toDrop, false);
                toDrop = DyeableLeatherItem.dyeArmor(Items.LEATHER_LEGGINGS.getDefaultInstance(), Collections.singletonList((DyeItem) Items.WHITE_DYE));
                player.drop(toDrop, false);
                toDrop = DyeableLeatherItem.dyeArmor(Items.LEATHER_CHESTPLATE.getDefaultInstance(), Collections.singletonList((DyeItem) Items.WHITE_DYE));
                player.drop(toDrop, false);
                toDrop = DyeableLeatherItem.dyeArmor(Items.LEATHER_HELMET.getDefaultInstance(), Collections.singletonList((DyeItem) Items.WHITE_DYE));
                player.drop(toDrop, false);

                return InteractionResultHolder.success(newItem);
            case 2:
                player.getItemInHand(hand).shrink(1);
                newItem = ItemInit.ONE_HAZELNUT.get().getDefaultInstance();
                player.setItemInHand(hand, newItem);

                player.drop(Items.CHAINMAIL_BOOTS.getDefaultInstance(), false);
                player.drop(Items.CHAINMAIL_LEGGINGS.getDefaultInstance(), false);
                player.drop(Items.CHAINMAIL_CHESTPLATE.getDefaultInstance(), false);
                player.drop(Items.CHAINMAIL_HELMET.getDefaultInstance(), false);

                return InteractionResultHolder.success(newItem);
            case 1:
                player.getItemInHand(hand).shrink(1);
                newItem = ItemInit.ZERO_HAZELNUTS.get().getDefaultInstance();
                player.setItemInHand(hand, newItem);

                player.drop(Items.IRON_BOOTS.getDefaultInstance(), false);
                player.drop(Items.IRON_LEGGINGS.getDefaultInstance(), false);
                player.drop(Items.IRON_CHESTPLATE.getDefaultInstance(), false);
                player.drop(Items.IRON_HELMET.getDefaultInstance(), false);

                return InteractionResultHolder.success(newItem);
            default:
                return super.use(level, player, hand);
        }
    }
}
