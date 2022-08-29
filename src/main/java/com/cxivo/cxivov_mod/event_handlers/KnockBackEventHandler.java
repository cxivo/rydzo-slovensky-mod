package com.cxivo.cxivov_mod.event_handlers;

import com.cxivo.cxivov_mod.init.ItemInit;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "cxivov_mod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KnockBackEventHandler {

    @SubscribeEvent
    public static void handleKnockBack(AttackEntityEvent event) {
        if (event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getItem() == ItemInit.EASTER_WHIP.get()) {
            if (event.getTarget() instanceof LivingEntity entity) {
                // shamelessly stolen from Player.attack(Entity)
                entity.knockback(1d, (double) Mth.sin(event.getEntity().getYRot() * ((float)Math.PI / 180F)), (double)(-Mth.cos(event.getEntity().getYRot() * ((float)Math.PI / 180F))));
                event.getTarget().hurt(new EntityDamageSource("whip", event.getEntity()), 1f);
                if (event.isCancelable()) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
