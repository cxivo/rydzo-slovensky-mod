package com.cxivo.cxivov_mod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CxivovMod.MOD_ID);

    public static final RegistryObject<SoundEvent> PACHO_THEME = registerSound("pacho_theme");
    public static final RegistryObject<SoundEvent> JA_SOM_BACA_VELMO_STARY = registerSound("ja_som_baca_velmo_stary");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(CxivovMod.MOD_ID, name)));
    }
}
