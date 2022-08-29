package com.cxivo.cxivov_mod.init;

import com.cxivo.cxivov_mod.CxivovMod;
import com.cxivo.cxivov_mod.ModSoundEvents;
import com.cxivo.cxivov_mod.items.NutsItem;
import com.cxivo.cxivov_mod.items.OtherMilkBucketItem;
import com.cxivo.cxivov_mod.items.ValaskaItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CxivovMod.MOD_ID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, CxivovMod.MOD_ID);


    // valaška
    public static final RegistryObject<Item> VALASKA = register("valaska",
            () -> new ValaskaItem(Tiers.IRON,2.0F, -2.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    // bryndza
    public static final RegistryObject<Item> BRYNDZA = register("bryndza",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6f).build())));

    // mlieka
    public static final RegistryObject<Item> SHEEP_MILK_BUCKET = register("sheep_milk_bucket",
            () -> new OtherMilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GOAT_MILK_BUCKET = register("goat_milk_bucket",
            () -> new OtherMilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    // syry
    public static final RegistryObject<Item> COW_CHEESE = register("cow_cheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build())));
    public static final RegistryObject<Item> SHEEP_CHEESE = register("sheep_cheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build())));
    public static final RegistryObject<Item> GOAT_CHEESE = register("goat_cheese",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build())));

    // žalúdok
    public static final RegistryObject<Item> STOMACH = register("stomach",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // srvátka
    public static final RegistryObject<Item> WHEY_BOTTLE = register("whey_bottle",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));

    // syridlo
    public static final RegistryObject<Item> RENNET_BOTTLE = register("rennet_bottle",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(WHEY_BOTTLE.get()).stacksTo(16)));

    // žinčica
    public static final RegistryObject<Item> ZINCICA_BOTTLE = register("zincica_bottle",
            () -> new HoneyBottleItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.1f).build())));
    // slanina
    public static final RegistryObject<Item> BACON = register("bacon",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6f).meat().build())));

    // halušky
    public static final RegistryObject<Item> HALUSKY = register("halusky",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).build())));

    // halušky s vajíčkom
    public static final RegistryObject<Item> HALUSKY_WITH_EGG = register("halusky_with_egg",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.6f).build())));

    // bryndzové halušky
    public static final RegistryObject<Item> BRYNDZOVE_HALUSKY = register("bryndzove_halusky",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).rarity(Rarity.RARE)
                    .food(new FoodProperties.Builder().nutrition(12).saturationMod(1.2f).build())));

    // 3 oriešky
    public static final RegistryObject<Item> THREE_HAZELNUTS = register("three_hazelnuts",
            () -> new NutsItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.RARE), 3));
    public static final RegistryObject<Item> TWO_HAZELNUTS = register("two_hazelnuts",
            () -> new NutsItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2));
    public static final RegistryObject<Item> ONE_HAZELNUT = register("one_hazelnut",
            () -> new NutsItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1));
    public static final RegistryObject<Item> ZERO_HAZELNUTS = register("zero_hazelnuts",
            () -> new NutsItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 0));

    // frndžalica
    public static final RegistryObject<Potion> FRNDZALICA = POTIONS.register("frndzalica",
            () -> new Potion("frndzalica",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2440, 0),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2440, 1),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2440, 0),
                    new MobEffectInstance(MobEffects.CONFUSION, 2440, 0)
            )); // new MobEffectInstance(MobEffects.HARM, 1)

    // korbáč
    public static final RegistryObject<Item> EASTER_WHIP = register("easter_whip",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1)));

    // platne
    public static final RegistryObject<Item> MUSIC_DISC_BACA = register("music_disc_baca",
            () -> new RecordItem(1, ModSoundEvents.JA_SOM_BACA_VELMO_STARY,
                    new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).rarity(Rarity.RARE), 8220)
    );


    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }

}
