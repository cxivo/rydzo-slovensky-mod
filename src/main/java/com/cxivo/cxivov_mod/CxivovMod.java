package com.cxivo.cxivov_mod;

import com.cxivo.cxivov_mod.init.BlockInit;
import com.cxivo.cxivov_mod.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cxivov_mod")
public class CxivovMod {

    public static final String MOD_ID = "cxivov_mod";

    public CxivovMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        ItemInit.POTIONS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModSoundEvents.SOUND_EVENTS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
