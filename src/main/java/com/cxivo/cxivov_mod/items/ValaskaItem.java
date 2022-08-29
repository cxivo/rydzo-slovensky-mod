package com.cxivo.cxivov_mod.items;

import com.cxivo.cxivov_mod.init.BlockInit;
import com.google.common.collect.ImmutableMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import java.util.Map;


public class ValaskaItem extends AxeItem {
    protected static final Map<Block, Block> ORNAMENTABLES = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.STRIPPED_OAK_WOOD, BlockInit.ORNAMENTAL_OAK_WOOD.get()).put(Blocks.STRIPPED_OAK_LOG, BlockInit.ORNAMENTAL_OAK_LOG.get()).put(Blocks.STRIPPED_DARK_OAK_WOOD, BlockInit.ORNAMENTAL_DARK_OAK_WOOD.get()).put(Blocks.STRIPPED_DARK_OAK_LOG, BlockInit.ORNAMENTAL_DARK_OAK_LOG.get()).put(Blocks.STRIPPED_ACACIA_WOOD, BlockInit.ORNAMENTAL_ACACIA_WOOD.get()).put(Blocks.STRIPPED_ACACIA_LOG, BlockInit.ORNAMENTAL_ACACIA_LOG.get()).put(Blocks.STRIPPED_BIRCH_WOOD, BlockInit.ORNAMENTAL_BIRCH_WOOD.get()).put(Blocks.STRIPPED_BIRCH_LOG, BlockInit.ORNAMENTAL_BIRCH_LOG.get()).put(Blocks.STRIPPED_JUNGLE_WOOD, BlockInit.ORNAMENTAL_JUNGLE_WOOD.get()).put(Blocks.STRIPPED_JUNGLE_LOG, BlockInit.ORNAMENTAL_JUNGLE_LOG.get()).put(Blocks.STRIPPED_SPRUCE_WOOD, BlockInit.ORNAMENTAL_SPRUCE_WOOD.get()).put(Blocks.STRIPPED_SPRUCE_LOG, BlockInit.ORNAMENTAL_SPRUCE_LOG.get()).put(Blocks.STRIPPED_WARPED_STEM, BlockInit.ORNAMENTAL_WARPED_STEM.get()).put(Blocks.STRIPPED_WARPED_HYPHAE, BlockInit.ORNAMENTAL_WARPED_HYPHAE.get()).put(Blocks.STRIPPED_CRIMSON_STEM, BlockInit.ORNAMENTAL_CRIMSON_STEM.get()).put(Blocks.STRIPPED_CRIMSON_HYPHAE, BlockInit.ORNAMENTAL_CRIMSON_HYPHAE.get()).put(Blocks.STRIPPED_MANGROVE_WOOD, BlockInit.ORNAMENTAL_MANGROVE_WOOD.get()).put(Blocks.STRIPPED_MANGROVE_LOG, BlockInit.ORNAMENTAL_MANGROVE_LOG.get()).build();


    public ValaskaItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);

        Block block = null;
        if (ORNAMENTABLES.containsKey(blockstate.getBlock())) {
            block = ORNAMENTABLES.get(blockstate.getBlock());
        }

        ItemStack itemstack = context.getItemInHand();

        if (block != null) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }

            level.setBlock(blockpos, block.withPropertiesOf(blockstate), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, block.withPropertiesOf(blockstate)));
            if (player != null) {
                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(context.getHand());
                });
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useOn(context);
        }
    }
}
