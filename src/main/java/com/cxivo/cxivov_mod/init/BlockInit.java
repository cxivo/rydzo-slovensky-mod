package com.cxivo.cxivov_mod.init;

import com.cxivo.cxivov_mod.CxivovMod;
import net.minecraft.core.Direction;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CxivovMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    // bryndza
    public static final RegistryObject<Block> BLOCK_OF_BRYNDZA = register("block_of_bryndza",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.TERRACOTTA_WHITE).strength(1.0f).sound(SoundType.HONEY_BLOCK)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(1.8f).build())));

    // logs
    public static final RegistryObject<Block> ORNAMENTAL_OAK_LOG = register("ornamental_oak_log",
            () ->  log(MaterialColor.WOOD, MaterialColor.WOOD),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_BIRCH_LOG = register("ornamental_birch_log",
            () ->  log(MaterialColor.SAND, MaterialColor.SAND),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_SPRUCE_LOG = register("ornamental_spruce_log",
            () ->  log(MaterialColor.PODZOL, MaterialColor.PODZOL),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_JUNGLE_LOG = register("ornamental_jungle_log",
            () ->  log(MaterialColor.DIRT, MaterialColor.DIRT),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_ACACIA_LOG = register("ornamental_acacia_log",
            () ->  log(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_DARK_OAK_LOG = register("ornamental_dark_oak_log",
            () ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_MANGROVE_LOG = register("ornamental_mangrove_log",
            () ->  log(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_WARPED_STEM = register("ornamental_warped_stem",
            () ->  netherStem(MaterialColor.WARPED_STEM),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_CRIMSON_STEM = register("ornamental_crimson_stem",
            () ->  netherStem(MaterialColor.CRIMSON_STEM),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    // woods
    public static final RegistryObject<Block> ORNAMENTAL_OAK_WOOD = register("ornamental_oak_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_BIRCH_WOOD = register("ornamental_birch_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_SPRUCE_WOOD = register("ornamental_spruce_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_JUNGLE_WOOD = register("ornamental_jungle_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_ACACIA_WOOD = register("ornamental_acacia_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_DARK_OAK_WOOD = register("ornamental_dark_oak_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_MANGROVE_WOOD = register("ornamental_mangrove_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_WARPED_HYPHAE = register("ornamental_warped_hyphae",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.WARPED_HYPHAE).strength(2.0F).sound(SoundType.STEM)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> ORNAMENTAL_CRIMSON_HYPHAE = register("ornamental_crimson_hyphae",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.CRIMSON_HYPHAE).strength(2.0F).sound(SoundType.STEM)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));



    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }

    private static RotatedPillarBlock log(MaterialColor color1, MaterialColor color2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? color1 : color2;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    private static Block netherStem(MaterialColor p_50784_) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, (p_152620_) -> {
            return p_50784_;
        }).strength(2.0F).sound(SoundType.STEM));
    }

}
