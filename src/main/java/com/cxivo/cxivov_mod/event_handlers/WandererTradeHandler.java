package com.cxivo.cxivov_mod.event_handlers;

import com.cxivo.cxivov_mod.CxivovMod;
import com.cxivo.cxivov_mod.init.ItemInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CxivovMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WandererTradeHandler {

    @SubscribeEvent
    public static void handleTrade(WandererTradesEvent event) {
        //List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        // oriešky
        ItemStack stack = new ItemStack(ItemInit.THREE_HAZELNUTS.get(), 1);
        event.getGenericTrades().add(new BasicItemListing(22, stack, 12, 16, 0.2f));

        //frndžalica
        stack = PotionUtils.setPotion(Items.POTION.getDefaultInstance(), ItemInit.FRNDZALICA.get());
        event.getRareTrades().add(new BasicItemListing(4, stack, 8, 12, 0.2f));
    }
}
