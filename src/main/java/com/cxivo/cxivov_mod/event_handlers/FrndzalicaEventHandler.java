package com.cxivo.cxivov_mod.event_handlers;

import com.cxivo.cxivov_mod.ModSoundEvents;
import com.cxivo.cxivov_mod.init.ItemInit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "cxivov_mod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FrndzalicaEventHandler {

    @SubscribeEvent
    public static void handleFrndzalica(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player) {
            if (player.getLevel().isClientSide() && PotionUtils.getPotion(event.getItem()) == ItemInit.FRNDZALICA.get()) {
                player.playSound(ModSoundEvents.PACHO_THEME.get(), 1f, 1f);  // volume & pitch
            }
        }
    }
}
