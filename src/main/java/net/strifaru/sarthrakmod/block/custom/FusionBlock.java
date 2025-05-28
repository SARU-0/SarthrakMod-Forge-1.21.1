package net.strifaru.sarthrakmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.ModBlocks;
import net.strifaru.sarthrakmod.item.ModItems;

import java.util.List;

public class FusionBlock extends Block {
    public FusionBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {

        pLevel.playSound(pPlayer, pPos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == Items.RAW_IRON) {
                itemEntity.setItem(new ItemStack(Items.IRON_INGOT, itemEntity.getItem().getCount()));

            }
            if(itemEntity.getItem().getItem() == Items.RAW_GOLD) {
                itemEntity.setItem(new ItemStack(Items.GOLD_INGOT, itemEntity.getItem().getCount()));

            }
            if(itemEntity.getItem().getItem() == Items.RAW_COPPER) {
                itemEntity.setItem(new ItemStack(Items.COPPER_INGOT, itemEntity.getItem().getCount()));

            }
            if(itemEntity.getItem().getItem() == Items.RAW_IRON_BLOCK) {
                itemEntity.setItem(new ItemStack(Items.IRON_BLOCK, itemEntity.getItem().getCount()));

            }
            if(itemEntity.getItem().getItem() == Items.RAW_GOLD_BLOCK) {
                itemEntity.setItem(new ItemStack(Items.GOLD_BLOCK, itemEntity.getItem().getCount()));

            }
            if(itemEntity.getItem().getItem() == Items.RAW_COPPER_BLOCK) {
                itemEntity.setItem(new ItemStack(Items.COPPER_BLOCK, itemEntity.getItem().getCount()));

            }
            if(itemEntity.getItem().getItem() == ModBlocks.REMNANT_CORE.get().asItem()) {
                itemEntity.setItem(new ItemStack(ModItems.BROKEN_SARTHERION.get(), itemEntity.getItem().getCount()));

            }

        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.sarthrakmod.arcane_catalyst.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
