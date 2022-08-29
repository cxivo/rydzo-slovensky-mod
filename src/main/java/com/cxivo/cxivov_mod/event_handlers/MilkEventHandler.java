package com.cxivo.cxivov_mod.event_handlers;

import com.cxivo.cxivov_mod.init.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "cxivov_mod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MilkEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void milkAnimal(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack itemstack = player.getItemInHand(hand);

        // milking sheep
        if (event.getTarget() instanceof Sheep sheep) {
            if (itemstack.is(Items.BUCKET) && !sheep.isBaby()) {
                player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                if (!event.getLevel().isClientSide()) {
                    ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, ItemInit.SHEEP_MILK_BUCKET.get().getDefaultInstance());
                    player.setItemInHand(hand, itemstack1);
                }
                //event.setResult(Event.Result.DENY);
                if (event.isCancelable()) {
                    event.setCanceled(true);
                }
                event.setCancellationResult(InteractionResult.sidedSuccess(event.getLevel().isClientSide()));
            }
        }

        // milking goats
        if (event.getTarget() instanceof Goat goat) {
            if (itemstack.is(Items.BUCKET) && !goat.isBaby()) {
                player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                if (!event.getLevel().isClientSide()) {
                    ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, ItemInit.GOAT_MILK_BUCKET.get().getDefaultInstance());
                    player.setItemInHand(hand, itemstack1);
                }
                //event.setResult(Event.Result.DENY);
                if (event.isCancelable()) {
                    event.setCanceled(true);
                }
                event.setCancellationResult(InteractionResult.sidedSuccess(event.getLevel().isClientSide()));
            }
        }
    }
}
